package com.ericsson.store.search;

import java.util.EnumSet;

import com.ericsson.store.api.CompactSizeCapable;
import com.ericsson.store.api.Furniture;
import com.ericsson.store.common.Material;
import com.ericsson.store.common.Room;

public class FurnitureSearchCriteria {

	private final EnumSet<Material> materials;
	private Boolean compactSizeCapable;
	private final EnumSet<Room> rooms;

	public FurnitureSearchCriteria() {
		this.materials = EnumSet.noneOf(Material.class);
		this.rooms = EnumSet.noneOf(Room.class);
		this.compactSizeCapable = null;
	}

	public FurnitureSearchCriteria material(Material material) {
		this.materials.add(material);
		return this;
	}

	public FurnitureSearchCriteria compactSize(boolean value) {
		this.compactSizeCapable = value;
		return this;
	}

	public FurnitureSearchCriteria room(Room room) {
		this.rooms.add(room);
		return this;
	}

	public boolean isValid(Furniture furniture) {
		boolean valid = true;
		if (furniture != null) {
			valid = this.isValidMaterial(furniture.getMaterial()) && this.isValidCompactSizeCapable(furniture) && this.isValidRoom(furniture.getRoom());
		}
		return valid;
	}

	private boolean isValidMaterial(Material material) {
		return (this.materials.size() == 0 || this.materials.contains(material));
	}

	private boolean isValidCompactSizeCapable(Furniture furniture) {
		return this.compactSizeCapable == null
				|| (this.compactSizeCapable && furniture instanceof CompactSizeCapable && CompactSizeCapable.class.cast(furniture).isCompactSizeMode())
				|| (!this.compactSizeCapable && furniture instanceof CompactSizeCapable && !CompactSizeCapable.class.cast(furniture).isCompactSizeMode());
	}

	private boolean isValidRoom(Room room) {
		return (this.rooms.size() == 0 || this.rooms.contains(room));
	}

}
