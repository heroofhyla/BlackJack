package com.aezart.blackjack;
enum CardNumber{
	ACE(1,11,"ace"),
	TWO(2,2,"two"),
	THREE(3,3,"three"),
	FOUR(4,4,"four"),
	FIVE(5,5,"five"),
	SIX(6,6,"six"),
	SEVEN(7,7,"seven"),
	EIGHT(8,8,"eight"),
	NINE(9,9,"nine"),
	TEN(10,10,"ten"),
	JACK(10,10,"jack"),
	QUEEN(10,10,"queen"),
	KING(10,10,"king");
	
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
public class Card {
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
}
