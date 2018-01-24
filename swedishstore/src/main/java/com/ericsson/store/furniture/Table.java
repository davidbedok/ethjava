package com.ericsson.store.furniture;

import com.ericsson.store.api.CompactSizeCapable;
import com.ericsson.store.api.Furniture;
import com.ericsson.store.common.CsvFurnitureType;
import com.ericsson.store.common.Material;
import com.ericsson.store.common.Room;
import com.ericsson.store.common.Size;

public class Table extends Furniture implements CompactSizeCapable {

	private final int numberOfChairs;
	private final boolean scratchResistant;

	private final boolean compactSize;

	public Table(String fancyName, Room room, Material material, Size size, double price, int numberOfChairs, boolean scratchResistant, boolean compactSize) {
		super(fancyName, room, material, size, price);
		this.numberOfChairs = numberOfChairs;
		this.scratchResistant = scratchResistant;
		this.compactSize = compactSize;
	}

	@Override
	public boolean isCompactSizeMode() {
		return this.compactSize;
	}

	public int getNumberOfChairs() {
		return this.numberOfChairs;
	}

	public boolean isScratchResistant() {
		return this.scratchResistant;
	}

	@Override
	public int hashCode() {
		return super.hashCode() * Integer.valueOf(this.numberOfChairs).hashCode() * Boolean.valueOf(this.scratchResistant).hashCode()
				* Boolean.valueOf(this.compactSize).hashCode();
	}

	@Override
	public boolean equals(Object othat) {
		if (this == othat) {
			return true;
		}
		if ((othat != null) && (!(othat.getClass() == this.getClass()))) {
			return false;
		}
		if (super.equals(othat)) {
			final Table that = (Table) othat;
			if (this.numberOfChairs == that.numberOfChairs && this.scratchResistant == that.scratchResistant && this.compactSize == that.compactSize) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + this.numberOfChairs + " chair(s) " + (this.scratchResistant ? "[ScratchResistant] " : "")
				+ (this.compactSize ? "[CompactSize] " : "");
	}

	@Override
	protected String printType() {
		return CsvFurnitureType.TABLE.toString();
	}

	@Override
	protected String sellDetails() {
		return "The table and the attached " + this.numberOfChairs + " chair(s) have to get from warehouse by customer.";
	}

}
