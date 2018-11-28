package payment;

import parking.Car;

public class TollBooth implements Payment {

	@Override
	public double sum(Car car) {
		int time = getTime(car);
		double sum = time * 2.23;
		return sum;
	}

}
