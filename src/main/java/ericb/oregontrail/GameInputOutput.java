package ericb.oregontrail;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameInputOutput {
    private final Scanner sc;
    private final PrintStream out;

    public GameInputOutput(Scanner sc, PrintStream out) {
        this.sc = sc;
        this.out = out;
    }

    public void needInstructionsPrompt() {
        String instructions = "";

        while (!instructions.equalsIgnoreCase("y") && !instructions.equalsIgnoreCase("n")) {
            out.println("Do you need instructions  (y/n)");
            instructions = sc.nextLine();
        }

        if (instructions.equalsIgnoreCase("y")) printInstructions();
    }

    public void printInstructions() {
        out.println("""
                This program simulates a trip over the Oregon Trail from Independence, Missouri to Oregon\s
                City, Oregon in 1847. Your family of five will cover the 2040 mile Oregon Trail in 5-6 months ---\s
                if you make it alive.""");
        Game.pressEnterToContinue();
        out.println("""
                \nYou had saved $900 to spend for the trip, and you've just paid $200 for a wagon. You will
                need to spend the rest of your money on the following items:""");
        out.println("""
                \nOxen - You can spend $200-$300 on your team. the more you spend, the faster you'll go because you
                have better animals""");
        out.println("""
                \nFood - The more you have, the less chance there is of getting sick""");
        out.println("""
                \nAmmunition - $1 buys a belt of 50 bullets. You will need bullets for attacks by animals and
                bandits, and for hunting food""");
        out.println("""
                \nClothing - This is especially important for the cold weather you will encounter when crossing
                the mountains""");
        out.println("""
                \nMiscellaneous supplies - This includes medicine and other things you will need for sickness
                and emergency repairs""");

        Game.pressEnterToContinue();

        out.println("""
                You can spend all your money before you start your trip - or you can save some of your\s
                cash to spend at forts along the way when you run low. However, items cost more at the forts. You \s
                can also go hunting along the way to get more food.""");
        out.println("""
                \nWhenever you have to use your trusty rifle along the way, you will be told to type in \s
                a word (one that sounds like a gun shot). The faster you type in that word and hit the 'enter' \s
                key, the better luck you'll have with your gun.""");
        out.println("""
                \nAt each turn, all items are shown in dollar amounts except bullets. When asked to enter\s
                money amounts, don't use a '$'""");

        Game.pressEnterToContinue();
    }

    public int marksmanshipPrompt() {
        int marksmanship = 0;

        System.out.println("How good a shot are you with your rifle?");
        System.out.println("(1) Ace marksman");
        System.out.println("(2) Good shot");
        System.out.println("(3) Fair to middlin'");
        System.out.println("(4) Need more practice");
        System.out.println("(5) Shaky knees");
        System.out.println("Enter one of the above -- the better you claim you are, the faster you'll have to be " +
                "with your gun to be successful.");

        while (marksmanship < 1 || marksmanship > 5) {
            try {
                String newInput = sc.nextLine();
                marksmanship = Integer.parseInt(newInput);
                if (marksmanship < 1 || marksmanship > 5) throw new IllegalArgumentException();
            } catch (Exception e) {
                System.out.println("Please enter a number between 1 and 5...");
            }
        }

        return marksmanship;

    }

    public int turnInitialPrompt() {
        int choice = 0;

        while (choice < 1 || choice > 4) {
            try {
                String input = sc.nextLine();
                choice = Integer.parseInt(input);
                if (choice < 1 || choice > 4) throw new IllegalArgumentException();
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        }

        return choice;
    }

    public int turn3ChoicesPrompt() {
        int choice = 0;

        while (choice < 1 || choice > 3) {
            String input = sc.nextLine();
            choice = Integer.parseInt(input);
            try {
                input = sc.nextLine();
                choice = Integer.parseInt(input);
                if (choice < 1 || choice > 3) {
                    throw new IllegalArgumentException("Please enter a number between 1 and 3");
                }
            } catch (Exception e) {
                out.println("Please enter a number between 1 and 3");
            }
        }

        return choice;
    }

    public int tacticsChoice() {
        int tacticsChoice = 0;

        while (tacticsChoice < 1 || tacticsChoice > 4) {
            try {
                String input = sc.nextLine();
                tacticsChoice = Integer.parseInt(input);
                if (tacticsChoice < 1 || tacticsChoice > 4) throw new IllegalArgumentException("Please enter a" +
                        "number between 1 and 4.");
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        }

        return tacticsChoice;
    }

    public Map<String, Integer> fireWeapon(String word, int marksmanship) {
        Map<String, Integer> useWeapon = new HashMap<>();

        out.println("Type '" + word + "' and hit enter");
        long start = System.currentTimeMillis();
        String input = sc.nextLine();
        long end = System.currentTimeMillis();
        int elapsedSeconds = (int) Math.round(((end - start) / 1000F) * 1.2) - (marksmanship - 1);
        useWeapon.put(input, elapsedSeconds);

        return useWeapon;
    }

    public String deathPrompt() {
        out.println("Due to your unfortunate situation, there a few formalities we must go through.");
        out.println("Would you like a minister?");
        String input = sc.nextLine();
        out.println("Would you like a fancy funeral?");
        input = sc.nextLine();
        out.println("Would you like us to inform your next of kin?");
        input = sc.nextLine();

        return input;
    }

}
