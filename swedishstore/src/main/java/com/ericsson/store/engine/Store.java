package com.ericsson.store.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ericsson.store.api.CompactSizeCapable;
import com.ericsson.store.api.Furniture;
import com.ericsson.store.common.Material;
import com.ericsson.store.common.Mattress;
import com.ericsson.store.furniture.Bed;
import com.ericsson.store.search.FurnitureSearchCriteria;

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
		final String fancyNameTmp = fancyName.toUpperCase();
		return this.items.keySet().stream().filter(furniture -> furniture.getFancyName().toUpperCase().equals(fancyNameTmp)).findFirst().orElse(null);
	}

	public List<Furniture> ssss(Mattress mattress) {

		return this.items.keySet().stream().filter(f -> f instanceof Bed && Bed.class.cast(f).getMattress() == mattress).collect(Collectors.toList());

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

	public List<Furniture> searchAny(Material material) {
		return this.items.keySet().stream().filter(furniture -> furniture.getMaterial() == material).collect(Collectors.toList());
	}

	public List<Furniture> search(Material material) {
		final Map<Furniture, Integer> items = this.items.entrySet().stream().filter(item -> item.getKey().getMaterial() == material && item.getValue() > 0)
				.collect(Collectors.toMap(item -> item.getKey(), item -> item.getValue()));
		return items.keySet().stream().collect(Collectors.toList());
	}

	public List<Furniture> searchCompactSizeCapable() {
		return this.items.keySet().stream().filter(furniture -> furniture instanceof CompactSizeCapable).collect(Collectors.toList());
	}

	public List<Furniture> searchByPrice(double minimumPrice, double maximumPrice) {
		return this.items.keySet().stream().filter(furniture -> furniture.getPrice() >= minimumPrice && furniture.getPrice() <= maximumPrice)
				.collect(Collectors.toList());
	}

	public List<Furniture> search(Mattress mattress) {
		return this.items.keySet().stream().filter(furniture -> furniture instanceof Bed && Bed.class.cast(furniture).getMattress() == mattress)
				.collect(Collectors.toList());
	}

	public List<Furniture> search(FurnitureSearchCriteria criteria) {
		return this.items.keySet().stream().filter(criteria::isValid).collect(Collectors.toList());
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
