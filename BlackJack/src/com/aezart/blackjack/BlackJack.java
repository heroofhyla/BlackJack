package com.aezart.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlackJack {
	public static void main(String args[]){
		System.out.println("BLACKJACK");
		char playerInput;
		Scanner userIn = new Scanner(System.in);
		do{
			System.out.println("Creating a deck of cards...");
			ArrayList<Integer> deck = new ArrayList<Integer>();
			for (int i = 1; i <= 10; i++){ //populate deck with 1-10 cards
				for (int k = 0; k < 4; k++){
					deck.add(new Integer(i));
				}
			}
			for (int i = 0; i < 12; i++){ //add face cards
				deck.add(new Integer(10));
			}
			System.out.println("Done.");
			System.out.println("Shuffling.");
			Collections.shuffle(deck);
			System.out.println("Done.");
			
			ArrayList<Integer> playerHand = new ArrayList<Integer>();
			playerHand.add(deck.remove(0));
			System.out.println("Player dealt " + playerHand.get(playerHand.size()-1));
			playerHand.add(deck.remove(0));
			System.out.println("Player dealt " + playerHand.get(playerHand.size()-1));
			ArrayList<Integer> dealerHand = new ArrayList<Integer>();
			dealerHand.add(deck.remove(0));
			dealerHand.add(deck.remove(0));
			
			boolean isPlayerTurn = true;
			do {
				System.out.printf("You have %d cards for a total of %d points. \n",playerHand.size(),calcScore(playerHand));
				System.out.printf("Dealer's revealed card is %d.\n", dealerHand.get(0));
				System.out.println("Will you [s]tay or [h]it?");
				
				playerInput = userIn.nextLine().charAt(0);
				
				while (playerInput != 'h' && playerInput != 'H'
						&& playerInput != 's' && playerInput != 'S'){
					System.out.println("I didn't catch that, [h]it or [s]tay?");
					playerInput = userIn.nextLine().charAt(0);
				}
				
				switch (playerInput){
				case 's':
				case 'S':
					isPlayerTurn = false;
					break;
				case 'h':
				case 'H':
					playerHand.add(deck.remove(0));
					System.out.println("Player dealt " + playerHand.get(playerHand.size()-1));
					if (calcScore(playerHand) >= 21){
						isPlayerTurn = false;
					}
				}
			} while (isPlayerTurn);
			System.out.println("Player's final score: " + calcScore(playerHand));
			if (calcScore(playerHand) == 21 && playerHand.size() == 2){
				System.out.println("Blackjack!");
			}
			if (calcScore(playerHand) > 21){
				System.out.println("Bust!");
			}
			System.out.println("The dealer reveals his other card, for a total score of " + calcScore(dealerHand));
			while (calcScore(dealerHand) < 17){
				dealerHand.add(deck.remove(0));
				System.out.println("Dealer hits: " + dealerHand.get(dealerHand.size() - 1));
				System.out.println("Dealer's score: " + calcScore(dealerHand));
			}
			if (calcScore (dealerHand) == 21 && dealerHand.size() == 2){
				System.out.println("Blackjack!");
			}
			if (calcScore (dealerHand) > 21){
				System.out.println("Bust!");
			}
			
			if (calcScore(dealerHand) > 21){
				if (calcScore(playerHand) > 21){
					System.out.println("Draw.");
				}else if (calcScore(playerHand) == 21 && playerHand.size() == 2){
					System.out.println("Player wins with a blackjack.");
				}else{
					System.out.println("Player wins.");
				}
			}else if (calcScore(dealerHand) == 21 && dealerHand.size() == 2){
				if ((playerHand.size() > 2 || calcScore(playerHand) != 21)){
					System.out.println("Dealer wins with a blackjack.");
				}else if (playerHand.size() == 2 && calcScore(playerHand) == 21){
					System.out.println("Draw (double blackjack).");
				}
			}else{
				if (calcScore(playerHand) == 21 && playerHand.size() == 2){
					System.out.println("Player wins with a blackjack.");
				}else if (calcScore(playerHand) > 21){
					System.out.println("Dealer wins.");
				}else{
					if (calcScore(playerHand) > calcScore(dealerHand)){
						System.out.println("Player wins.");
					}else if (calcScore(playerHand) == calcScore(dealerHand)){
						System.out.println("Draw.");
					}else{
						System.out.println("Dealer wins.");
					}
				}
			}
			System.out.println("Play again?");
			playerInput = userIn.nextLine().charAt(0);
			while (playerInput != 'y' && playerInput != 'Y' && playerInput != 'n' && playerInput != 'N'){
				System.out.println("I didn't catch that. Play again?");
				playerInput = userIn.nextLine().charAt(0);
			}
			
		}while (playerInput == 'y' || playerInput == 'Y');
		userIn.close();
	}
	
	public static int calcScore(ArrayList<Integer> hand){
		Collections.sort(hand);
		Collections.reverse(hand);//we want 1s at the end, they are a special case
		int score = 0;
		for (int i = 0; i < hand.size(); i++){
			if (hand.get(i).intValue() == 1){
				if (score <= 10 && i == hand.size() - 1){
					score += 11;
				}else{
					score += 1;
				}
			}else{
				score += hand.get(i).intValue();
			}
		}
		
		return score;
	}
}
