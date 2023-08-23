package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public Card[] deck = new Card[52];
    public Player[] player = new Player[4];
    public int[] highScore = new int[4];



    public void generateDeck(){
        int counter = 0;
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 13; j++)
            {
                int value;

                if (j >= 10)
                    value = 10;
                else
                    value = j+1;

                Card card = new Card (i, j, value);

                deck[counter] = card;
                counter++;

            }
        }


    }

    public Card drawCard(){
        Random rng = new Random();
        Card card = null;

        while (card == null){
            int randNo = rng.nextInt(51);
            card = deck[randNo];
            deck[randNo] = null;

        }
        return card;
    }

    public void setInfo(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < player.length - 1; i++){
            System.out.println("Enter name of Player " + (i+1) + " :");
            player[i] = new Player();
            player[i].name = scanner.next();
            player[i].addCard(this.drawCard());
            player[i].addCard(this.drawCard());

        }
        player[3] = new Player();
        player[3].name = "Dealer";
        player[3].addCard(this.drawCard());
        player[3].addCard(this.drawCard());
    }

    public void updateGameScore() {
        for (int i = 0; i < highScore.length; i++) {
            if (player[i].score <= 21)
                highScore[i] = player[i].score;
            else
                highScore[i] = 0;



        }

    }
}
