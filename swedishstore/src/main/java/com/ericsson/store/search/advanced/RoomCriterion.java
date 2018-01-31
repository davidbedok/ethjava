package com.ericsson.store.search.advanced;

import com.ericsson.store.api.Furniture;
import com.ericsson.store.common.Room;

public class RoomCriterion extends EnumCriterion<Room> implements FurnitureCriterion {

	public RoomCriterion(Room... values) {
		super(values);
	}

	@Override
	public boolean isValid(Furniture furniture) {
		return super.isValid(furniture.getRoom());
	}

}
