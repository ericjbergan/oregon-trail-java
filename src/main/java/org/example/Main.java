package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Traveler traveler = new Traveler();
        String instructions = "";

        while (!instructions.equalsIgnoreCase("y") && !instructions.equalsIgnoreCase("n")) {
            System.out.println("Do you need instructions  (y/n)");
            instructions = sc.nextLine();
        }

        if (instructions.equalsIgnoreCase("y")) printInstructions();

        int marksmanship = traveler.setMarksmanship();

        traveler.buyInitialSupplies();
        System.out.println("After all your purchases, you now have " +
                traveler.getSupplyBalances().get("cashBalance") +  " dollars left");
        System.out.println("\nJourney begins: Monday, March 29, 1847");

        pressEnterToContinue();

        System.out.println("Good luck!");

        traveler = travel(traveler, sc);
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
                Whenever you have to use your trusy rifle along the way, yo uwill be told to type in \s
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
    }

    public static void buyInitialSupplies(Scanner sc) {
        Map<String, Integer> newSupplyBalances = new HashMap<>();
        newSupplyBalances.put("cashBalance", 700);
        int oxen = -1;
        int food = -1;
        int ammunition = -1;
        int clothing = -1;
        int misc = -1;

//        try {
//            food = newSupplyBalances.get("food");
//        } catch (Exception ignored) {
//
//        }
//
//        try {
//            ammunition = newSupplyBalances.get("ammunition");
//        } catch (Exception ignored) {
//
//        }
//
//        try {
//            clothing = newSupplyBalances.get("clothing");
//        } catch (Exception ignored) {
//
//        }
//
//        try {
//            misc = newSupplyBalances.get("misc");
//        } catch (Exception ignored) {
//
//        }

    }

    // todo implement this
    public static Map<String, Integer> buyFortSupplies(Map<String, Integer> supplyBalances, Scanner sc) {
        Map<String, Integer> newSupplyBalances = new HashMap<>(supplyBalances);



        return newSupplyBalances;
    }

    // todo implement this
    public static Map<String, Integer> hunt(Map<String, Integer> supplyBalances, Scanner sc) {
        Map<String, Integer> newSupplyBalances = new HashMap<>(supplyBalances);



        return newSupplyBalances;
    }

    // todo implement this
    public static int dailyTravel(int milesToGo, Map<String, Integer> newSupplyBalances) {
        Random random = new Random();
        int oxen = newSupplyBalances.get("oxen");
        int newMilesToGo = milesToGo;

        int milesTraveled = 200 + (oxen - 220)/5 + random.nextInt(10);

        return newMilesToGo - milesTraveled;
    }

    public static Map<String, Integer> eat(Map<String, Integer> supplyBalances, Scanner sc) {
        Map<String, Integer> newSupplyBalances = new HashMap<>(supplyBalances);
        int food = newSupplyBalances.get("food");
        int choice = 0;

        System.out.println("You have " + food + " food left.");
        System.out.println("Do you want to eat (1) poorly, (2) moderately, or (3) well?");

        while (choice < 1 || choice > 3) {
            try {
                String newInput = sc.nextLine();
                choice = Integer.parseInt(newInput);
            } catch (Exception e) {
                System.out.println("Please enter a number between 1 and 3");
                eat(supplyBalances, sc);
            }
        }

        if (8 + 5 * choice > food) {
            System.out.println("You can't eat that well");
            eat(supplyBalances, sc);
        }

        newSupplyBalances.put("food", food - 8 - 5 * choice);

        return newSupplyBalances;
    }

    public static Traveler travel(Traveler traveler, Scanner sc) {
        boolean hasVisitedFort = false;
        boolean hasHunted = false;
        int choice = 0;

        if (traveler.getSupplyBalances().get("food") < 13) {
            System.out.println("You'd better do some hunting or buy food and soon!!!");
        }

        System.out.println("\nDo you want to (1) stop at the next fort, (2) hunt, or (3) continue traveling?");

        while (choice != 3) {
            while (choice < 1 || choice > 3) {
                try {
                    String input = sc.nextLine();
                    choice = Integer.parseInt(input);
                } catch (Exception e) {
                    System.out.println("Please enter a number between 1 and 3");
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
            }
        }

        return traveler;
    }

}