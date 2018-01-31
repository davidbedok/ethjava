package com.ericsson.store.search.advanced;

import com.ericsson.store.api.Furniture;

public interface FurnitureCriterion {

	boolean isValid(Furniture furniture);

}
