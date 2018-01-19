package com.ericsson.store.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ericsson.store.api.Furniture;
import com.ericsson.store.common.Material;
import com.ericsson.store.common.Room;
import com.ericsson.store.common.Size;

public class FurnitureTest {

	private class TestA extends Furniture {

		private final String	fieldA;

		public TestA(String fancyName, Room room, Material material, Size size, double price, String fieldA) {
			super(fancyName, room, material, size, price);
			this.fieldA = fieldA;
		}

		@Override
		protected String printType() {
			return null;
		}

		@Override
		protected String sellDetails() {
			return null;
		}

	}

	private class TestB extends Furniture {

		private final Integer	fieldB;

		public TestB(String fancyName, Room room, Material material, Size size, double price, Integer fieldB) {
			super(fancyName, room, material, size, price);
			this.fieldB = fieldB;
		}

		@Override
		protected String printType() {
			return null;
		}

		@Override
		protected String sellDetails() {
			return null;
		}

	}

	@Test(groups = "unit")
	public void The_beds_equal_when_all_fields_are_the_same() {
		Size size = new Size(10, 10, 10);
		TestA testA = new TestA("fancyName1", Room.Bedroom, Material.Metal, size, 100, "fieldA");
		TestB testb = new TestB("fancyName1", Room.Bedroom, Material.Metal, size, 100, 42);
		TestA testC = new TestA("fancyName2", Room.Bedroom, Material.Metal, size, 100, "fieldA");

		Assert.assertEquals(testA, testb);
		Assert.assertEquals(testb, testA);
		Assert.assertEquals(testA, testA);
		Assert.assertNotEquals(testC, testb);
		Assert.assertNotEquals(testb, testC);
	}

}
