package com.ericsson.store.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ericsson.store.common.CsvFurnitureType;
import com.ericsson.store.common.DoorType;
import com.ericsson.store.common.Material;
import com.ericsson.store.common.Mattress;
import com.ericsson.store.common.Room;
import com.ericsson.store.common.Size;
import com.ericsson.store.engine.Store;
import com.ericsson.store.furniture.Bed;
import com.ericsson.store.furniture.Table;
import com.ericsson.store.furniture.Wardrobe;

public class FurnitureIntegratonTest {

	private static final Logger LOGGER = Logger.getLogger(FurnitureIntegratonTest.class);

	private Store store;

	@BeforeClass
	public void setup() {
		final InputStream inputStream = this.getClass().getResourceAsStream("/furniture.csv");
		this.store = loadStore(inputStream);
	}

	@Test
	public void showStore() {
		LOGGER.info(this.store);
	}

	private static Store loadStore(InputStream inputStream) {
		final Store result = new Store();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(inputStream));
			String line = reader.readLine(); // first line --> header
			while ((line = reader.readLine()) != null) {
				final String[] values = line.split(";");
				final CsvFurnitureType furnitureType = CsvFurnitureType.valueOf(values[0].trim());
				final Room room = Room.valueOf(values[1].trim());
				final Material material = Material.valueOf(values[2].trim());
				final Size size = Size.fromString(values[3], values[4], values[5].trim());
				final double price = Double.parseDouble(values[6].trim());
				final boolean compactSize = Boolean.valueOf(values[9].trim());
				final boolean builtInLamp = Boolean.valueOf(values[10].trim());
				final int count = Integer.valueOf(values[16].trim());
				final String fancyName = values[17].trim();
				switch (furnitureType) {
					case BED:
						final Mattress mattress = Mattress.valueOf(values[7].trim());
						final boolean doubleSize = Boolean.valueOf(values[8].trim());
						final Bed bed = new Bed(fancyName, room, material, size, price, mattress, doubleSize, compactSize, builtInLamp);
						result.updateStock(bed, count);
						break;
					case TABLE:
						final int numberOfChairs = Integer.valueOf(values[11].trim());
						final boolean scratchResistant = Boolean.valueOf(values[12].trim());
						final Table table = new Table(fancyName, room, material, size, price, numberOfChairs, scratchResistant, compactSize);
						result.updateStock(table, count);
						break;
					case WARDROBE:
						final int numberOfShelves = Integer.valueOf(values[13].trim());
						final DoorType typeOfDoor = DoorType.valueOf(values[14].trim());
						final boolean mirror = Boolean.valueOf(values[15].trim());
						final Wardrobe wardrobe = new Wardrobe(fancyName, room, material, size, price, numberOfShelves, typeOfDoor, mirror, builtInLamp);
						result.updateStock(wardrobe, count);
						break;
				}
			}
		} catch (final Exception e) {
			LOGGER.error(e, e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (final IOException e) {
					LOGGER.error(e, e);
				}
			}
		}
		return result;
	}

}
