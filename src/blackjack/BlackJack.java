package blackjack;


import java.util.Scanner;

public class BlackJack {
    static Game game = new Game();

    public static void main(String[] args) {
        GUI gui = new GUI();

        game.generateDeck();
        game.setInfo();

        gui.runGUI(game.deck,
                game.player[0].getHand(),
                game.player[1].getHand(),
                game.player[2].getHand(),
                game.player[3].getHand());
        takingTurns(gui);
        game.updateGameScore();
        dealerTurn(gui);
        game.updateGameScore();
        decideWinner();


    }

    public static void takingTurns(GUI gui) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < game.player.length - 1; i++) {
            String input = "";
            while (!input.equals("stand")) {
                System.out.println("Player no. " + (i + 1) + " Hit or Stand");
                input = scanner.next();
                if (input.equals("hit")) {
                    Card card = game.drawCard();
                    game.player[i].addCard(card);
                    gui.updatePlayerHand(card, i);
                }
                if (game.player[i].score > 21) {
                    System.out.println("BUSTED");
                    break;
                }


            }

        }
    }

    public static void dealerTurn(GUI gui) {
        boolean dealerWins = true;
        int hiScore = 0;
        for (int i = 0; i < game.player.length - 1; i++) {
            if (game.highScore[i] > game.player[3].score)
                dealerWins = false;
            if (game.highScore[i] > hiScore)
                hiScore = game.highScore[i];
            if (!dealerWins) {
                while (game.player[3].score < hiScore) {
                    Card card = game.drawCard();
                    game.player[3].addCard(card);
                    gui.updateDealerHand(card, game.deck);
                }
            } else
                return;
        }

    }


    public static boolean isTied(int max_score, int[] highScore) {
        for (int i = 0; i < highScore.length - 1; i++) {
            for (int j = i + 1; j < highScore.length; j++) {
                if (max_score == highScore[i] && max_score == highScore[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void decideWinner() {
        int max_score = 0;
        int winner = -1;


        for (int i = 0; i < game.player.length; i++) {
            if (game.highScore[i] > max_score) {
                max_score = game.highScore[i];
                winner = i;


            }


        }

        if (isTied(max_score, game.highScore)) {
            System.out.println("PUSH");
        } else if (winner >= 0) {
            System.out.println("PLAYER " + game.player[winner].name + " WON! with score " + max_score);
        }


    }
}




