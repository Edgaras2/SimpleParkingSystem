package inout;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;

import parking.Car;

public class InOut {

	private static Gson jsonFormatter = new Gson();
	private static File file = new File("resources/cars.txt");
	private static Pattern p = Pattern.compile("\\{.*?\"\\}");

	private static List<String> cars = new ArrayList<>();

	public static File getFile() {
		return file;
	}

	public static void output(Car car) throws IOException {
		try (FileWriter writer = new FileWriter(file, true)) {
			String jCar = jsonFormatter.toJson(car);
			writer.append(jCar + String.format("%n"));
		}
	}

	public static List<Car> input() throws IOException {
		List<Car> carList = new ArrayList<>();

		if (file.exists() && file.isFile()) {

			try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(file))) {
//				System.out.println(input);
				byte[] testas = input.readAllBytes();
				String testas2 = new String(testas);
				Matcher m = p.matcher(testas2);
				while (m.find()) {
					cars.add(m.group());
				}
			}
			for (String str : cars) {
//				System.out.println(str);

				carList.add(jsonFormatter.fromJson(str, Car.class));

			}

		}

		return carList;
	}

}
