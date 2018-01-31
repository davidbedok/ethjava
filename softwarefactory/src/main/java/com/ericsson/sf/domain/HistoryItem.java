package com.ericsson.sf.domain;

import com.ericsson.sf.thread.Developer;

public class HistoryItem {

	private final Developer developer;
	private final int amountOfWork;

	public HistoryItem(Developer developer, int amountOfWork) {
		this.developer = developer;
		this.amountOfWork = amountOfWork;
	}

	@Override
	public String toString() {
		return String.format("%0" + this.amountOfWork + "d", 0).replace("0", this.developer.getAbbrevation());
	}

}
