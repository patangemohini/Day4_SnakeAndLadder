package snakeandladder;

public class SnakeAndLadder {

    public static void main(String[] args) {
        System.out.println("Welcome to snake and ladder program!!");

        int playerPosition = 0;
        int startPosition = 0;
        int endPosition = 100;

        while (playerPosition < endPosition) {
            int dieNumber = (int) Math.floor(Math.random() * 10) % 6 + 1;
            System.out.println("DieNumber :" + dieNumber);
            int choice = (int) Math.floor(Math.random() * 10) % 3;

            switch (choice) {
                case 0:
                    System.out.println("No play : Player stays in the same position");
                    playerPosition = playerPosition;
                    System.out.println("Player position : " + playerPosition);
                    break;
                case 1:
                    System.out.println("Ladder : player moves ahead by the position");
                    playerPosition += dieNumber;
                    System.out.println("Player position : " + playerPosition);
                    break;
                case 2:
                    System.out.println("Snake : player moves behind by the position");
                    if (dieNumber > playerPosition) {
                        playerPosition = startPosition;
                    } else {
                        playerPosition -= dieNumber;
                    }
                    System.out.println("Player position : " + playerPosition);
                    break;
            }
        }
    }
}
