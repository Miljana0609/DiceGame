package se.jensen.miljana.dicegame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Dice Game");
        boolean start = true;

        Game game = new Game(scanner);

        while (start) {
            System.out.println("\nEnter 'play' to play or 'quit' to quit the game: ");
            String enter = scanner.nextLine().toLowerCase();


            if (enter.equals("play")) {
                game.startGame();
            } else if (enter.equals("quit")) {
                System.out.println("Thank you for playing Dice Game. See you! 👋🏻");
                start = false;
                scanner.close();
            } else {
                System.out.println("Invalid input! Please enter Play or Quit:");
            }
        }
    }
}



