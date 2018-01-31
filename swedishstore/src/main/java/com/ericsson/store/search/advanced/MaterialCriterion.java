package com.ericsson.store.search.advanced;

import com.ericsson.store.api.Furniture;
import com.ericsson.store.common.Material;

public class MaterialCriterion extends EnumCriterion<Material> implements FurnitureCriterion {

	public MaterialCriterion(Material... values) {
		super(values);
	}

	@Override
	public boolean isValid(Furniture furniture) {
		return super.isValid(furniture.getMaterial());
	}

}
