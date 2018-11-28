package payment;

import java.time.Duration;
import java.time.format.DateTimeFormatter;

import parking.Car;

public interface Payment {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");

	public double sum(Car car);

	default public int getTime(Car car) {
		Duration time = Duration.between(car.getParkingStart(), car.getParkingEnd());
		return (int) time.toSeconds();
	};

}
