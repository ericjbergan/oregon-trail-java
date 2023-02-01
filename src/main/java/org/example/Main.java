package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rng = new Random();
        Traveler traveler = new Traveler();
        String[] dateArray = new String[] { "April 12th", "April 26th", "May 10th", "May 24th", "June 7th",
                "June 21st", "July 5th", "July 19th", "August 2nd", "August 16th", "August 31st", "September 13", "September 27th",
                "October 11", "October 25th", "November 8th", "November 22nd", "December 6th", "December 20th"};

        String instructions = "";

        while (!instructions.equalsIgnoreCase("y") && !instructions.equalsIgnoreCase("n")) {
            System.out.println("Do you need instructions  (y/n)");
            instructions = sc.nextLine();
        }

        if (instructions.equalsIgnoreCase("y")) printInstructions();

        int marksmanship = traveler.setMarksmanship();

        traveler.buyInitialSupplies();
        System.out.println("After all your purchases, you now have " +
                traveler.getCashBalance() +  " dollars left");
        System.out.println("\nJourney begins: Monday, March 29, 1847");

        pressEnterToContinue();

        System.out.println("Good luck!");

        while (traveler.getMilesTraveled() < 2040) {
            boolean hasVisitedFort = false;
            boolean hasHunted = false;
            int choice = 0;

            if (traveler.getTotalTurns() > 0) {
                try {
                    System.out.println("Today's date: Monday, " + dateArray[traveler.getTotalTurns()] + ", 1847");
                } catch (NullPointerException e) {
                    System.out.println("Happy Holidays! You took too long getting to your destination and died in the" +
                            "first blizzard of winter.");
                }
            }

            if (traveler.getFood() < 13) {
                System.out.println("You'd better do some hunting or buy food and soon!!!");
            }

            if (traveler.isSick()) traveler.visitDoctor("illness");
            if (traveler.isInjured()) traveler.visitDoctor("injuries");

            System.out.println("\nTotal mileage is " + traveler.getMilesTraveled());
            System.out.println("Your current supplies:");
            System.out.println("food - " + traveler.getFood());
            System.out.println("ammunition - " + traveler.getAmmunition());
            System.out.println("clothing - " + traveler.getClothing());
            System.out.println("misc supplies - " + traveler.getMisc());

            while (choice != 3) {
                if (!hasVisitedFort && !hasHunted) {
                    System.out.println("\nDo you want to (1) stop at the next fort, (2) hunt, (3) continue traveling, " +
                            "or (4) exit game?");
                    while (choice < 1 || choice > 4) {
                        try {
                            String input = sc.nextLine();
                            choice = Integer.parseInt(input);
                            if (choice < 1 || choice > 4) throw new IllegalArgumentException();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    switch (choice) {
                        case 1 -> {
                            hasVisitedFort = true;
                            traveler.buyFortSupplies();
                        }
                        case 2 -> {
                            hasHunted = true;
                            traveler.hunt();
                        }
                        case 4 -> {
                            exitGame();
                        }
                    }
                } else if (!hasVisitedFort) {
                    System.out.println("\nDo you want to (1) stop at the next fort, (2) exit game, " +
                            "or (3) continue traveling?");
                    String input = sc.nextLine();
                    choice = Integer.parseInt(input);
                    while (choice < 1 || choice > 3) {
                        try {
                            input = sc.nextLine();
                            choice = Integer.parseInt(input);
                            if (choice < 1 || choice > 3) {
                                throw new IllegalArgumentException("Please enter a number between 1 and 2");
                            }
                        } catch (Exception e) {
                            System.out.println("Please enter a number between 1 and 2");
                        }
                    }

                    switch (choice) {
                        case 1 -> {
                            hasVisitedFort = true;
                            traveler.buyFortSupplies();
                        }
                        case 3 -> {
                            exitGame();
                        }
                    }
                } else if (!hasHunted) {
                    System.out.println("\nDo you want to (1) hunt, (2) exit game, or (3) continue traveling?");
                    String input = sc.nextLine();
                    choice = Integer.parseInt(input);
                    while (choice < 1 || choice > 3) {
                        try {
                            input = sc.nextLine();
                            choice = Integer.parseInt(input);
                            if (choice < 1 || choice > 3) {
                                throw new IllegalArgumentException("Please enter a number between 1 and 3");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    switch (choice) {
                        case 1 -> {
                            hasHunted = true;
                            traveler.hunt();
                        }
                        case 3 -> {
                            exitGame();
                        }
                    }
                }
                traveler.eat();
                traveler.dailyTravel();
                traveler.meetRiders();
                traveler.setTotalTurns(traveler.getTotalTurns() + 1);
                if (traveler.getOxen() < 0) traveler.setOxen(0);
                if (traveler.getFood() < 0) traveler.setFood(0);
                if (traveler.getAmmunition() < 0) traveler.setAmmunition(0);
                if (traveler.getClothing() < 0) traveler.setClothing(0);
                if (traveler.getMisc() < 0) traveler.setMisc(0);
            }

        }
    }

    public static void printInstructions() {
        System.out.println("""
                This program simulates a trip over the Oregon Trail from Independence, Missouri to Oregon\s
                City, Oregon in 1847. Your family of five will cover the 2040 mile Oregon Trail in 5-6 months ---\s
                if you make it alive.""");

        pressEnterToContinue();

        System.out.println("""
                You had saved $900 to spend for the trip, and you've just paid $200 for a wagon. You will
                need to spend the rest of your money on the following items:""");
        System.out.println("\nOxen - You can spend $200-$300 on your team. the more you spend, the faster you'll go " +
                "because you have better animals");
        System.out.println("\nFood - The more you have, the less chance there is of getting sick");
        System.out.println("\nAmmunition - $1 buys a belt of 50 bullets. You will need bullets for attacks by animals" +
                "and bandits, and for hunting food");
        System.out.println("\nClothing - This is especially important for the cold weather you will encounter when " +
                "crossing the mountains");
        System.out.println("\nMiscellaneous supplies - This includes medicine and other things you will need for " +
                "sickness and emergency repairs");

        pressEnterToContinue();

        System.out.println("""
                You can spend all your money before you start your trip - or you can save some of your\s
                cash to spend at forts along the way when you run low. However, items cost more at the forts. You \s
                can also go hunting along the way to get more food.""");
        System.out.println("""
                Whenever you have to use your trusty rifle along the way, you will be told to type in \s
                a word (one that sounds like a gun shot). The faster you type in that word and hit the 'enter' \s
                key, the better luck you'll have with your gun.""");
        System.out.println("\nAt each turn, all items are shown in dollar amounts except bullets. When asked to enter \n" +
                "money amounts, don't use a '$'");

        pressEnterToContinue();
    }

    public static void pressEnterToContinue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press enter to continue...");
        sc.nextLine();
        System.out.println("___________________________________________________________________________________________");
    }

    public static void exitGame() {
        System.out.println("Thanks for playing!");
        System.exit(0);
    }

}