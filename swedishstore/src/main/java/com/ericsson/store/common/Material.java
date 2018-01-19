package com.ericsson.store.common;

public enum Material {

	Oak("Oak material"),
	Beech("Beech material"),
	Pine("Pine material"),
	CherryTree("CherryTree material"),
	Plastic("Plastic material"),
	Metal("Metal material");

	private final String label;

	private Material(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "[" + String.format("%-20s", this.label) + "]";
	}

}
