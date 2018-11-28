package parking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import inout.InOut;
import payment.CurrencyFormatter;
import payment.Phone;
import payment.TollBooth;
import run.Start;
import comparing.CarComparator;

public class ParkingLot {

	static {
		try (InputStream fs = new FileInputStream(new File("resources/logging.properties"))) {
			LogManager.getLogManager().readConfiguration(fs);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Logger log = Logger.getLogger(Start.class.getName());

	final TollBar tollBar = new TollBar(false);
	final TollBooth tollBooth = new TollBooth();
	final InOut inOut = new InOut();
	Map<String, Car> carRegister = new HashMap<>();
	static String lpScanner = "";
	static String text = "";

	public void carPlateScanner() throws DublicateCarException, IOException { // Metodas, kuris is konsoles nuskaito ar
																				// masina
		// ivaziuoja, ar isvaziuoja ir nuskaito jos numeri
		// bei leidzia sumoketi uz stovejima isvaziuojant

		Scanner scan = tollBar.createScanner();

		while (!(input(scan, "Entry(e) or Exit(f)")).equals("x")) {

			if (lpScanner.equals("e")) {
				input(scan, "Enter your carplate number (entering)");

				try {
					if (carRegister.containsKey(lpScanner.split(" ")[1])) {
						throw new DublicateCarException(DublicateCarException.ERROR1, new IllegalArgumentException());
					} else {
						carRegister.put(lpScanner.split(" ")[1], new Car(lpScanner.split(" "), LocalDateTime.now()));
					}
				} catch (DublicateCarException | ArrayIndexOutOfBoundsException e) {
//					System.err.println(e);
					log.log(Level.FINEST, DublicateCarException.ERROR1, e);
				}

			}

			if (lpScanner.equals("f")) {
				input(scan, "Enter your carplate number (exiting)");
				try {

					if (!carRegister.containsKey(lpScanner.split(" ")[1])) {
						throw new DublicateCarException(DublicateCarException.ERROR2, new IllegalArgumentException());
					} else {
						carRegister.get(lpScanner.split(" ")[1]).setParkingEnd(LocalDateTime.now());
						Car outCar = carRegister.get(lpScanner.split(" ")[1]);
						input(scan, "Choose payment method (p or t)");
						if (lpScanner.equals("p")) {
							Phone phone = new Phone();
							System.out.println(
									CurrencyFormatter.CurrencyFormatter(outCar.getCountry(), phone.sum(outCar)));
						}
						if (lpScanner.equals("t")) {
							System.out.printf("%.2f \u20AC", tollBooth.sum(outCar));
						}
						InOut.output(carRegister.get(outCar.getPlateNumber()));
						carRegister.remove(outCar.getPlateNumber());
					}
				} catch (DublicateCarException | ArrayIndexOutOfBoundsException e) {
					log.log(Level.FINEST, DublicateCarException.ERROR2, e);
				}

			}

		}
		scan.close();

		CarComparator<Car, String> carCmp = new CarComparator<>();
//		CarComparator<Car, LocalDateTime> carCmp = new CarComparator<>();
		List<Car> testas = InOut.input();
		Collections.sort(testas, carCmp.getComparator(1, "p"));
//		Collections.sort(testas, carCmp.getComparator(2, LocalDateTime.now()));
		for (Car car : testas) {
			System.out.println(car);
		}

	}

	public String input(Scanner scan, String text) {
		ParkingLot.text = text;
		System.out.println(text);
		lpScanner = scan.nextLine();
		return lpScanner;
	}
}
