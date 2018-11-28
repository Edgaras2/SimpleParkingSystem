package parking;

import java.util.Scanner;

public class TollBar {

	private boolean status;

	public TollBar(boolean status) {
		this.status = status;
	}

	public Scanner createScanner() {
		Scanner scan = new Scanner(System.in);
		return scan;
	}

	public void setStatus(TollBarEvents status) {
		this.status = status.isEvent();
	}

	public boolean isStatus() {
		return status;
	}

}
