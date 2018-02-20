package com.ericsson.huncard;

public enum CardRank implements CardRankValuable {

	r7("7", 7),
	r8("8", 8),
	r9("9", 9),
	r10("10", 10),
	rUnder("Also", 15),
	rUp("Felso", 20),
	rKing("Kiraly", 30),
	rAce("Asz", 50);

	private final String label;
	private final int value;

	private CardRank(String label, int value) {
		this.label = label;
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.label;
	}

}
