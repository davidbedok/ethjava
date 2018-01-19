package com.ericsson.store.api;

import com.ericsson.store.common.Material;
import com.ericsson.store.common.Room;
import com.ericsson.store.common.Size;

public abstract class Furniture {

	private static final String CURRENCY = "EUR";

	protected final String fancyName;
	protected final Room room;
	protected final Material material;
	protected final Size size;

	protected final double price;

	public Furniture(final String fancyName, final Room room, final Material material, final Size size, double price) {
		this.fancyName = fancyName;
		this.room = room;
		this.material = material;
		this.size = size;
		this.price = price;
	}

	public Material getMaterial() {
		return this.material;
	}

	public double getPrice() {
		return this.price;
	}

	public Room getRoom() {
		return this.room;
	}

	public Size getSize() {
		return this.size;
	}

	public String getFancyName() {
		return this.fancyName;
	}

	@Override
	public int hashCode() {
		return this.room.hashCode() * this.material.hashCode() * this.size.hashCode();
	}

	public String sell(int pieces) {
		return pieces + " piece(s) " + this.printFancyName() + " " + this.printType() + " was sold. " + this.sellDetails();
	}

	protected abstract String printType();

	protected abstract String sellDetails();

	@Override
	public boolean equals(Object othat) {
		if (!(othat instanceof Furniture)) {
			return false;
		}
		Furniture that = (Furniture) othat;
		if ((this.fancyName.equals(that.fancyName) && this.room.equals(that.room)) && this.material.equals(that.material) && this.size.equals(that.size)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return this.printType() + this.printFancyName() + this.room + " " + this.material + " " + this.size + " " + String.format("%3s", Math.round(this.price))
				+ " " + Furniture.CURRENCY;
	}

	private String printFancyName() {
		return String.format("%-10s", this.fancyName.toUpperCase());
	}

}
