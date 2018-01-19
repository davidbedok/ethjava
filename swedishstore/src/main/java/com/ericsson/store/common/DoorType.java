package com.ericsson.store.common;

public enum DoorType {

	Double("Double door"),
	Sliding("Sliding door"),
	Shutter("Shutter door");

	private final String label;

	private DoorType(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "[" + String.format("%-13s", this.label) + "]";
	}

}
