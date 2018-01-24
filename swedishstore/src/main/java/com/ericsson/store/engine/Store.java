package com.ericsson.store.engine;

import java.util.HashMap;
import java.util.Map;

import com.ericsson.store.api.Furniture;

public class Store {

	private final Map<Furniture, Integer> items;

	public Store() {
		this.items = new HashMap<Furniture, Integer>();
	}

	public void updateStock(Furniture furniture, Integer count) {
		Integer newCount = count;
		if (this.items.containsKey(furniture)) {
			newCount += this.items.get(furniture);
		}
		this.items.put(furniture, newCount);
	}

	public Integer getCount(Furniture furniture) {
		return this.items.get(furniture);
	}

	public Furniture getFurnitureByFancyName(String fancyName) {
		Furniture ret = null;
		for (final Furniture furniture : this.items.keySet()) {
			if (fancyName.equals(furniture.getFancyName())) {
				ret = furniture;
				break;
			}
		}
		return ret;
	}

	public String buy(Furniture furniture, int count) {
		String info = null;
		if (this.items.containsKey(furniture)) {
			final Integer pieces = this.items.get(furniture);
			if (count > 0 && (pieces - count) >= 0) {
				info = furniture.sell(count);
				this.updateStock(furniture, new Integer(count * -1));
			}
		}
		return info;
	}

	@Override
	public String toString() {
		final StringBuilder info = new StringBuilder(100);
		info.append("---[ STORE ]---\n");
		for (final Furniture furniture : this.items.keySet()) {
			final Integer count = this.items.get(furniture);
			info.append(String.format("%2s piece(s) - ", Math.round(count))).append(furniture).append("\n");
		}
		return info.toString();
	}

}
