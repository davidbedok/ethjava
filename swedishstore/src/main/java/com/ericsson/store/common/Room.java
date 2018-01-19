package com.ericsson.store.common;

public enum Room {

	Kitchen("Kitchen"),
	Bathroom("Bathroom"),
	LivingRoom("Living room"),
	Bedroom("Bedroom"),
	Chamber("Chamber"),
	Garage("Garage"),
	Hall("Hall");

	private final String label;

	private Room(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "[" + String.format("%-12s", this.label) + "]";
	}

}
