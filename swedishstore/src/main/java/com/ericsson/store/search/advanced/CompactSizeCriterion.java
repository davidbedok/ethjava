package com.ericsson.store.search.advanced;

import com.ericsson.store.api.CompactSizeCapable;
import com.ericsson.store.api.Furniture;

public class CompactSizeCriterion implements FurnitureCriterion {

	private final boolean compactSizeCapable;

	public CompactSizeCriterion(boolean compactSizeCapable) {
		this.compactSizeCapable = compactSizeCapable;
	}

	@Override
	public boolean isValid(Furniture furniture) {
		return (this.compactSizeCapable && furniture instanceof CompactSizeCapable && CompactSizeCapable.class.cast(furniture).isCompactSizeMode())
				|| (!this.compactSizeCapable && furniture instanceof CompactSizeCapable && !CompactSizeCapable.class.cast(furniture).isCompactSizeMode());
	}

}
