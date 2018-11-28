package comparing;

import java.time.LocalDateTime;
import java.util.Comparator;

import parking.Car;

public class CarComparator<T extends Car, U> {

	public Comparator<Car> getComparator(int sw, U type) {
		Comparator<Car> cmp = null;
		switch (sw) {
		case 1:
			cmp = Comparator.comparing(Car::getPlateNumber, Comparator(type));
			break;
		case 2:
			cmp = Comparator.comparing(Car::getParkingStart, Comparator(type));
			break;
		case 3:
			cmp = Comparator.comparing(Car::getParkingEnd, Comparator(type));
			break;
		case 4:
			cmp = Comparator.comparing(Car::getCountry, Comparator(type));
			break;
		default:
			break;
		}
		return cmp;
	}

	private Comparator Comparator(U type) {
		if (type instanceof String) {
			return String.CASE_INSENSITIVE_ORDER;
		} else if (type instanceof LocalDateTime) {
			Comparator<U> cm = null;
			return cm;
		} else {
			return null;
		}
	}

}
