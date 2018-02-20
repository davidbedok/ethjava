package com.ericsson.huncard;

public class Card {

	private final CardRankValuable rank;
	private final CardSuitValuable suit;

	public Card(CardSuitValuable suit, CardRankValuable rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public int getValue() {
		return this.rank.getValue() * this.suit.getValue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.rank == null) ? 0 : this.rank.hashCode());
		result = prime * result + ((this.suit == null) ? 0 : this.suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Card other = (Card) obj;
		if (this.rank != other.rank) {
			return false;
		}
		if (this.suit != other.suit) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Card [" + this.suit + "-" + this.rank + "]";
	}

}
