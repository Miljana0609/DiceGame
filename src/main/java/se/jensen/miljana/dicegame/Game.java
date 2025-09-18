package se.jensen.miljana.dicegame;

import java.util.Scanner;

public class Game {
    private Scanner scanner;
    private Dice dice;

    //Konstruktor
    public Game(Scanner scanner) {
        this.scanner = scanner;
        this.dice = new Dice();
    }

    //startGame - metoden
    public void startGame() {

        Player playerTwo = new Player();
        Player playerOne = new Player();

        // Namn - spelare 1
        System.out.println("\nPlayer one -  enter your first name: ");
        while (true) {
            try {
                playerOne.setFirstName(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a valid first name");
            }
        }
        System.out.println("Enter your last name: ");
        while (true) {
            try {
                playerOne.setLastName(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a valid last name");
            }
        }

        //Namn - spelare 2

        System.out.println("\nPlayer two -  enter your first name: ");
        while (true) {
            try {
                playerTwo.setFirstName(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a valid first name");
            }
        }
        System.out.println("Enter your last name: ");
        while (true) {
            try {
                playerTwo.setLastName(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a valid last name");
            }
        }

        //Spelare 1 tärningskast

        System.out.println("\nYour turn " + playerOne.getFullName());

        int rollOnePlayer1 = dice.roll();
        int rollTwoPlayer1 = dice.roll();

        System.out.println("Roll one: " + rollOnePlayer1);
        System.out.println("Roll two: " + rollTwoPlayer1);

        playerOne.addToScore(rollOnePlayer1);
        playerOne.addToScore(rollTwoPlayer1);

        System.out.println("The total score for " + playerOne.getFullName() +
                " is " + playerOne.getScore());

        //SPelare 2 tärningskast

        System.out.println("\nYour turn " + playerTwo.getFullName());

        int rollOnePlayer2 = dice.roll();
        int rollTwoPlayer2 = dice.roll();

        System.out.println("Roll one: " + rollOnePlayer2);
        System.out.println("Roll two: " + rollTwoPlayer2);

        playerTwo.addToScore(rollOnePlayer2);
        playerTwo.addToScore(rollTwoPlayer2);

        System.out.println("Your total score for " + playerTwo.getFullName() +
                " is " + playerTwo.getScore());

        //Jämför poäng och skriv ut vinnaren

        if (playerOne.getScore() > playerTwo.getScore()) {
            System.out.println("\nThe winner is " + playerOne.getFullName() + "! Congratulation🎉");
        } else if (playerOne.getScore() < playerTwo.getScore()) {
            System.out.println("\nThe winner is " + playerTwo.getFullName() + "! Congratulation🎉");
        } else {
            System.out.println("\nDRAW");
        }
    }
}
