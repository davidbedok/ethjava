package com.ericsson.store.common;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SizeTest {

	@Test(groups = "unit")
	public void Two_sizes_are_equal_when_all_fields_are_the_same() {
		final Size sizeOne = new Size(10, 10, 10);
		final Size sizeTwo = new Size(10, 20, 10);
		final Size sizeThree = new Size(10, 10, 10);

		Assert.assertEquals(sizeOne, sizeThree);
		Assert.assertEquals(sizeThree, sizeOne);
		Assert.assertNotEquals(sizeOne, sizeTwo);
		Assert.assertNotEquals(sizeTwo, sizeThree);
		Assert.assertEquals(sizeOne, sizeOne);
	}

}
