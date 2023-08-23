package blackjack;

public class Player {
    public String name;
    public int score = 0;
    private Card[]hand = new Card[11];
    private int Counter = 0;

    public void addCard (Card card){
        if (Counter < 11){
            hand[Counter] = card;
            Counter++;
            score += card.getValue();
        }
    }

    public Card[] getHand() {
        return hand;
    }
}
