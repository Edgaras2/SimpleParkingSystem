package parking;

import java.time.LocalDateTime;

public class Car {

	private String plateNumber;
	private LocalDateTime parkingStart;
	private LocalDateTime parkingEnd;
	private String country;

	public Car(String[] plateNumberInfo, LocalDateTime parkingStart) {
		this.plateNumber = plateNumberInfo[1];
		this.country = plateNumberInfo[0];
		this.parkingStart = parkingStart;
	}
	

	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPlateNumber() {
		return plateNumber;
	}

	public LocalDateTime getParkingStart() {
		return parkingStart;
	}

	public void setParkingEnd(LocalDateTime parkingEnd) {
		this.parkingEnd = parkingEnd;
	}

	public LocalDateTime getParkingEnd() {
		return parkingEnd;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public void setParkingStart(LocalDateTime parkingStart) {
		this.parkingStart = parkingStart;
	}

	@Override
	public String toString() {
		return "Car [plateNumber=" + plateNumber + ", parkingStart=" + parkingStart + ", parkingEnd=" + parkingEnd
				+ ", country=" + country + "]";
	}


}
