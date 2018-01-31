package com.ericsson.store.search.advanced;

import java.util.ArrayList;
import java.util.List;

import com.ericsson.store.api.Furniture;
import com.ericsson.store.common.Material;

public class FurnitureSearch implements FurnitureCriterion {

	private final List<FurnitureCriterion> criteria;

	public FurnitureSearch() {
		this.criteria = new ArrayList<FurnitureCriterion>();
	}

	public FurnitureSearch add(FurnitureCriterion criterion) {
		if (!this.criteria.contains(criterion)) {
			this.criteria.add(criterion);
		}
		return this;
	}

	public FurnitureSearch material(Material... material) {
		return this.add(new MaterialCriterion(material));
	}

	public FurnitureSearch compactSize(boolean compactSizeCapable) {
		return this.add(new CompactSizeCriterion(compactSizeCapable));
	}

	@Override
	public boolean isValid(Furniture furniture) {
		boolean valid = true;
		for (final FurnitureCriterion criterion : this.criteria) {
			if (!criterion.isValid(furniture)) {
				valid = false;
				break;
			}
		}
		return valid;
	}

	public static FurnitureSearch create(FurnitureCriterion... criteria) {
		final FurnitureSearch search = new FurnitureSearch();
		for (final FurnitureCriterion criterion : criteria) {
			search.add(criterion);
		}
		return search;
	}

}
