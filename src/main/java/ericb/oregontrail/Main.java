package ericb.oregontrail;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rng = new Random();
        PrintStream ps = System.out;
        Game game = new Game(rng, sc, ps);
        Traveler traveler = Game.getTraveler();
        String instructions = "";

        while (!instructions.equalsIgnoreCase("y") && !instructions.equalsIgnoreCase("n")) {
            System.out.println("Do you need instructions  (y/n)");
            instructions = sc.nextLine();
        }

        if (instructions.equalsIgnoreCase("y")) game.printInstructions();

        traveler.setMarksmanship();

        game.buyInitialSupplies();
        System.out.println("After all your purchases, you now have " +
                traveler.cashBalance.getAmount() + " dollars left");
        System.out.println("\nJourney begins: Monday, March 29, 1847");

        Game.pressEnterToContinue();

        System.out.println("Good luck!");

        game.playGame();
    }

}