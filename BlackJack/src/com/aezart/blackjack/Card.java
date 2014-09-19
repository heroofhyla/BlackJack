package com.aezart.blackjack;
enum CardNumber{
	ACE(1,11,"A"),
	TWO(2,2,"2"),
	THREE(3,3,"3"),
	FOUR(4,4,"4"),
	FIVE(5,5,"5"),
	SIX(6,6,"6"),
	SEVEN(7,7,"7"),
	EIGHT(8,8,"8"),
	NINE(9,9,"9"),
	TEN(10,10,"10"),
	JACK(10,10,"J"),
	QUEEN(10,10,"Q"),
	KING(10,10,"K");
	
	private int lowVal;
	private int highVal;
	String name;
	private CardNumber(int lowVal, int highVal, String name){
		this.lowVal = lowVal;
		this.highVal = highVal;
		this.name = name;
	}
	public int lowVal(){
		return lowVal;
	}
	public int highVal(){
		return highVal;
	}
	public String toString(){
		return name;
	}
}
enum CardSuit{
	HEARTS("hearts"),
	SPADES("spades"),
	CLUBS("clubs"),
	DIAMONDS("diamonds");
	
	private String name;
	private CardSuit(String name){
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
}
public class Card implements Comparable<Card> {
	private CardNumber cardNumber;
	private CardSuit cardSuit;
	
	public Card(CardNumber number, CardSuit suit){
		this.cardNumber = number;
		this.cardSuit = suit;
	}
	
	public int lowValue(){
		return cardNumber.lowVal();
	}
	public int highValue(){
		return cardNumber.highVal();
	}
	public String toString(){
		return cardNumber.toString() + " of " + cardSuit.toString();
	}
	public CardNumber number(){
		return cardNumber;
	}

	@Override
	public int compareTo(Card o) {
		if (o.lowValue() == lowValue()){
			return 0;
		}
		if (o.lowValue() > lowValue()){
			return -1;
		}
		return 1;
	}
}
