package deck;
import java.lang.Object;
import java.util.ArrayList;

public class Card implements Comparable{
	private int rank;
	private int suit;
	public Card(int r, int s){
		rank = r;
		suit = s;
	}
	public int getRank(){
		return rank;
	}
	public int getSuit(){
		return suit;
	}
	@Override
	public int compareTo(Object ob){
		Card other = (Card)ob;
		int thisRank = this.getRank();
		int otherRank = other.getRank();
		if(thisRank ==1) thisRank =14;
		if(otherRank == 1) otherRank =14;
		return thisRank - otherRank;
	}
	public boolean equals(Object ob){
		if(ob instanceof Card){
			Card other = (Card)ob;
			return rank == other.rank && suit == other.suit;
		}
		else return false;
	}
}
package deck;

public class Deckcard{
	private Card[] deckcard;
	private int numCards;
	public Deckcard(){
		deckcard = new Card[52];
		fill();
	}
	private void fill(){
		int index =0;
		for(int i =1; i<=13; i++){
			for(int s =1; s<=4; s++){
				deckcard[index++] =new Card(i,s);
			}
		}
		numCards = 52;
	}
	
	public void shuffle(){
		for(int i =0; i< numCards-1; i++){
			int r = myRandom(i,numCards-1);
			Card temp = deckcard[i];
			deckcard[i] = deckcard[r];
			deckcard[r] = temp;
		}
	}
	
	public static int myRandom(int low, int high){
		return (int)((high+1-low) * Math.random()+low );
	}
}


public class Hand{
	protected ArrayList<Card> cards = new ArrayList<Card>();
	public int score(){
		int socre =0;
		for(Card card: cards){
			socre+= card.getRank();
		}
		return socre;
	}
	public void addCard(Card card){
		cards.add(card);
	}
	
	public void removeCard(Card card){
		cards.remove(card);
	}
}




