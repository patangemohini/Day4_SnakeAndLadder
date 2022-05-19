package snakeandladder;

public class SnakeAndLadder {
    static final int END_POSITION = 100;
    static final int NO_PLAY = 0;
    static final int LADDER = 1;
    static final int SNAKE = 2;

    public static void main(String[] args) {
        System.out.println("Welcome to snake and ladder program!!");

        int playerPosition1 = 0;
        int playerPosition2 = 0;
        int numberOfDiePlayer1 = 0;
        int numberOfDiePlayer2 = 0;
        boolean playTurnPlayer1 = false;
        boolean playTurnPlayer2 = false;

        // Which player will start the game this will decide in condition
        int startPlay = (int) Math.floor(Math.random() * 10) % 2;
        if (startPlay == 0) {
            System.out.println("Player 1 starts the game.");
            playTurnPlayer1 = true;
        } else {
            System.out.println("Player 2 starts the game.");
            playTurnPlayer2 = true;
        }

        while (playerPosition1 < END_POSITION && playerPosition2 < END_POSITION) {
            int dieNumber = (int) Math.floor(Math.random() * 10) % 6 + 1;
            System.out.println("DieNumber :" + dieNumber);
            int choice = (int) Math.floor(Math.random() * 10) % 3;

            switch (choice) {
                case NO_PLAY:
                    if (playTurnPlayer1) {
                        System.out.println("No play : Player 1 stays in the same position");
                        playTurnPlayer1 = false;
                        playTurnPlayer2 = true;
                        numberOfDiePlayer1++;
                        System.out.println("Player 1 position : " + playerPosition1);
                    } else {
                        System.out.println("No play : Player 2 stays in the same position");
                        playTurnPlayer1 = true;
                        playTurnPlayer2 = false;
                        numberOfDiePlayer2++;
                        System.out.println("Player 2 position : " + playerPosition2);
                    }
                    break;
                case LADDER:
                    if (playTurnPlayer1) {
                        if (playerPosition1 + dieNumber > END_POSITION) {
                            System.out.println(
                                    "Player 1 stays in the same position if playerPosition is greater than end-position");
                            playTurnPlayer1 = true;
                            playTurnPlayer2 = false;
                            numberOfDiePlayer1++;
                            System.out.println("Player 1 position : " + playerPosition1);
                        } else {
                            System.out.println("Ladder : Player 1 moves ahead by the position");
                            playerPosition1 += dieNumber;
                            playTurnPlayer1 = true;
                            playTurnPlayer2 = false;
                            numberOfDiePlayer1++;
                            System.out.println("Player 1 position : " + playerPosition1);
                        }
                    } else {
                        if (playerPosition2 + dieNumber > END_POSITION) {
                            System.out.println("Player 2 stays in the same position if playerPosition is greater than end-position");
                            playTurnPlayer1 = false;
                            playTurnPlayer2 = true;
                            numberOfDiePlayer2++;
                            System.out.println("Player 2 position : " + playerPosition2);
                        } else {
                            System.out.println("Ladder : Player 2 moves ahead by the position");
                            playerPosition2 += dieNumber;
                            playTurnPlayer1 = false;
                            playTurnPlayer2 = true;
                            numberOfDiePlayer2++;
                            System.out.println("Player 2 position : " + playerPosition2);
                        }
                    }
                    break;
                case SNAKE:
                    if (playTurnPlayer1) {
                        if (dieNumber > playerPosition1) {
                            System.out.println("Player 1 stays in the same position if playerPosition is negative");
                            playTurnPlayer1 = false;
                            playTurnPlayer2 = true;
                            numberOfDiePlayer1++;
                            System.out.println("Player 1 position : " + playerPosition1);
                        } else {
                            System.out.println("Snake : Player 1 moves behind by the position");
                            playerPosition1 -= dieNumber;
                            playTurnPlayer1 = false;
                            playTurnPlayer2 = true;
                            numberOfDiePlayer1++;
                            System.out.println("Player 1 position : " + playerPosition1);
                        }
                    } else {
                        if (dieNumber > playerPosition2) {
                            System.out.println("Player 2 stays in the same position if playerPosition is negative");
                            playTurnPlayer1 = true;
                            playTurnPlayer2 = false;
                            numberOfDiePlayer2++;
                            System.out.println("Player 2 position : " + playerPosition2);
                        } else {
                            System.out.println("Snake : Player 2 moves behind by the position");
                            playerPosition2 -= dieNumber;
                            playTurnPlayer1 = true;
                            playTurnPlayer2 = false;
                            numberOfDiePlayer2++;
                            System.out.println("Player 2 position : " + playerPosition2);
                        }
                    }
                    break;
            }
        }

        System.out.println("Player 1 die roll : " + numberOfDiePlayer1);
        System.out.println("Player 2 die roll : " + numberOfDiePlayer2);
        if (playerPosition1 == END_POSITION) {
            System.out.println("Player 1 wins the game by throwing " + numberOfDiePlayer1 + " numbers of die roll");
        } else if (playerPosition2 == END_POSITION) {
            System.out.println("Player 2 wins the game by throwing " + numberOfDiePlayer2 + " numbers of die roll");
        }
    }
}