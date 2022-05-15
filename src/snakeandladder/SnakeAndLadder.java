package snakeandladder;

public class SnakeAndLadder {
    public static void main(String[] args) {
        System.out.println("Welcome to snake and ladder program!!");
        int playerPosition = 0;
        int number = (int) Math.floor(Math.random() * 10) % 6 + 1;
        System.out.println("Number after rolling the dice by the player : " + number);
    }
}
