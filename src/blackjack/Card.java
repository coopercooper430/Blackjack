package blackjack;

public class Card {
    private int rank;
    private int suit;
    private int value;


    Card(int suit,int rank,int value){
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }


    public int getRank() {

        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getValue() {

        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Card(Card c){
        this.suit = c.suit;
        this.rank = c.rank;
        this.value = c.value;
    }
}
