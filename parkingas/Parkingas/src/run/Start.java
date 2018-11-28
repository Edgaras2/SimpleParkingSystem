package run;

import java.io.IOException;
import parking.DublicateCarException;
import parking.ParkingLot;


public class Start {
	
	public static void main(String...args) throws DublicateCarException, IOException {

		new ParkingLot().carPlateScanner();
		
	}

	
}
