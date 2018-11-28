package parking;

public enum TollBarEvents {
	OPEN(true), CLOSE(false);
	private boolean event;

	TollBarEvents(boolean event) {
		this.event = event;
	}

	public boolean isEvent() {
		return event;
	}

}
