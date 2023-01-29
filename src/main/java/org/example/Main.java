package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String instructions = "";

        while (!instructions.equalsIgnoreCase("y") && !instructions.equalsIgnoreCase("n")) {
            System.out.println("DO YOU NEED INSTRUCTIONS  (y/n)");
            instructions = sc.nextLine();
        }

        if (instructions.equalsIgnoreCase("y")) printInstructions();

        int marksmanship = getMarksmanship(sc);

        Map<String, Integer> buyOxen = buyOxen(sc);
        Map<String, Integer> supplyBalances = buyInitialSupplies(buyOxen, sc);
        System.out.println("AFTER ALL YOUR PURCHASES, YOU NOW HAVE " + supplyBalances.get("cashBalance") +
                " DOLLARS LEFT");
        System.out.println("\nJOURNEY BEGINS: MONDAY, MARCH 29, 1847");

        pressEnterToContinue();

        travel(supplyBalances, sc, marksmanship, 2040);
    }

    public static void printInstructions() {
        System.out.println("""
                THIS PROGRAM SIMULATES A TRIP OVER THE OREGON TRAIL FROM INDEPENDENCE, MISSOURI TO OREGON\s
                CITY, OREGON IN 1847. YOUR FAMILY OF FIVE WILL COVER THE 2040 MILE OREGON TRAIL IN 5-6 MONTHS ---\s
                IF YOU MAKE IT ALIVE.""");

        pressEnterToContinue();

        System.out.println("""
                YOU HAD SAVED $900 TO SPEND FOR THE TRIP, AND YOU'VE JUST PAID $200 FOR A WAGON. YOU WILL
                NEED TO SPEND THE REST OF YOUR MONEY ON THE FOLLOWING ITEMS:""");
        System.out.println("\nOXEN - YOU CAN SPEND $200-$300 ON YOUR TEAM. THE MORE YOU SPEND, THE FASTER YOU'LL GO " +
                "BECAUSE YOU'LL HAVE BETTER ANIMALS");
        System.out.println("\nFOOD - THE MORE YOU HAVE, THE LESS CHANCE THERE IS OF GETTING SICK");
        System.out.println("\nAMMUNITION - $1 BUYS A BELT OF 50 BULLETS YOU WILL NEED BULLETS FOR ATTACKS BY ANIMALS" +
                "AND BANDITS, AND FOR HUNTING FOOD");
        System.out.println("\nCLOTHING - THIS IS ESPECIALLY IMPORTANT FOR THE COLD WEATHER YOU WILL ENCOUNTER WHEN " +
                "CROSSING THE MOUNTAINS");
        System.out.println("\nMISCELLANEOUS SUPPLIES - THIS INCLUDES MEDICINE AND OTHER THINGS YOU WILL NEED FOR " +
                "SICKNESS AND EMERGENCY REPAIRS");

        pressEnterToContinue();

        System.out.println("""
                YOU CAN SPEND ALL YOUR MONEY BEFORE YOU START YOUR TRIP OR YOU CAN SAVE SOME OF YOUR\s
                CASH TO SPEND AT FORTS ALONG THE WAY WHEN YOU RUN LOW. HOWEVER, ITEMS COST MORE AT THE FORTS. YOU\s
                CAN ALSO GO HUNTING ALONG THE WAY TO GET MORE FOOD.""");
        System.out.println("""
                WHENEVER YOU HAVE TO USE YOUR TRUSTY RIFLE ALONG THE WAY, YOU WILL BE TOLD TO TYPE IN\s
                A WORD (ONE THAT SOUNDS LIKE A GUN SHOT). THE FASTER YOU TYPE IN THAT WORD AND HIT THE 'ENTER'\s
                KEY, THE BETTER LUCK YOU'LL HAVE WITH YOUR GUN.""");
        System.out.println("\nAT EACH TURN, ALL ITEMS ARE SHOWN IN DOLLAR AMOUNTS EXCEPT BULLETS. WHEN ASKED TO ENTER \n" +
                "MONEY AMOUNTS, DON'T USE A '$'");

        pressEnterToContinue();
    }

    public static void pressEnterToContinue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press enter to continue...");
        sc.nextLine();
    }

    public static int getMarksmanship(Scanner sc) {
        sc = new Scanner(System.in);
        int marksmanship = 0;

        System.out.println("HOW GOOD A SHOT ARE YOU WITH YOUR RIFLE?");
        System.out.println("(1) ACE MARKSMAN");
        System.out.println("(2) GOOD SHOT");
        System.out.println("(3) FAIR TO MIDDLIN'");
        System.out.println("(4) NEED MORE PRACTICE");
        System.out.println("(5) SHAKY KNEES");
        System.out.println("ENTER ONE OF THE ABOVE -- THE BETTER YOU CLAIM YOU ARE, THE FASTER YOU'LL HAVE TO BE " +
                "WITH YOUR GUN TO BE SUCCESSFUL.");

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

    public static Map<String, Integer> buyOxen(Scanner sc) {
        Map<String, Integer> supplyBalances = new HashMap<>();
        supplyBalances.put("cashBalance", 700);
        int oxen = -1;

        while (oxen < 200 || oxen > 300) {
            System.out.println("\nCURRENT CASH BALANCE: " + supplyBalances.get("cashBalance"));
            System.out.println("\nHOW MUCH DO YOU WANT TO SPEND ON YOUR OXEN TEAM? ENTER BETWEEN 200-300.");

            try {
                String newInput = sc.nextLine();
                oxen = Integer.parseInt(newInput);
                if (oxen < 200 || oxen > 300) throw new IllegalArgumentException();
                supplyBalances.put("oxen", oxen);
                supplyBalances.put("cashBalance", supplyBalances.get("cashBalance") - oxen);
            } catch (Exception e) {
                System.out.println("Please enter a number between 200 and 300...");
            }
        }

        return supplyBalances;
    }

    public static Map<String, Integer> buyInitialSupplies(Map<String, Integer> supplyBalances, Scanner sc) {
        Map<String, Integer> newSupplyBalances = new HashMap<>(supplyBalances);
        int food = -1;
        int ammunition = -1;
        int clothing = -1;
        int misc = -1;

        try {
            food = newSupplyBalances.get("food");
        } catch (Exception ignored) {

        }

        try {
            ammunition = newSupplyBalances.get("ammunition");
        } catch (Exception ignored) {

        }

        try {
            clothing = newSupplyBalances.get("clothing");
        } catch (Exception ignored) {

        }

        try {
            misc = newSupplyBalances.get("misc");
        } catch (Exception ignored) {

        }

        System.out.println("\nCURRENT CASH BALANCE: " + supplyBalances.get("cashBalance"));
        System.out.println("HOW MUCH DO YOU WANT TO SPEND ON FOOD? ENTER BETWEEN 0-" +
                supplyBalances.get("cashBalance"));

        while (food < 0 || food > supplyBalances.get("cashBalance")) {
            try {
                String newInput = sc.nextLine();
                food = Integer.parseInt(newInput);
            } catch (Exception e) {
                System.out.println("Please enter a number between 0 and " + supplyBalances.get("cashBalance"));
            }

            supplyBalances.put("food", food);
        }

        while (ammunition < 0 || ammunition > supplyBalances.get("cashBalance")) {
            System.out.println("\nCURRENT CASH BALANCE: " + supplyBalances.get("cashBalance"));
            System.out.println("HOW MUCH DO YOU WANT TO SPEND ON AMMUNITION? ENTER BETWEEN 0-" +
                    supplyBalances.get("cashBalance"));
            try {
                String newInput = sc.nextLine();
                ammunition = Integer.parseInt(newInput);
            } catch (Exception e) {
                System.out.println("Please enter a number between 0 and " + supplyBalances.get("cashBalance"));
            }

            supplyBalances.put("ammunition", ammunition);
        }

        while (clothing < 0 || clothing > supplyBalances.get("cashBalance")) {
            System.out.println("\nCURRENT CASH BALANCE: " + supplyBalances.get("cashBalance"));
            System.out.println("HOW MUCH DO YOU WANT TO SPEND ON CLOTHING? ENTER BETWEEN 0-" +
                    supplyBalances.get("cashBalance"));
            try {
                String newInput = sc.nextLine();
                clothing = Integer.parseInt(newInput);
            } catch (Exception e) {
                System.out.println("Please enter a number between 0 and " + supplyBalances.get("cashBalance"));
            }

            supplyBalances.put("clothing", clothing);
        }

        while (misc < 0 || misc > supplyBalances.get("cashBalance")) {
            System.out.println("\nCURRENT CASH BALANCE: " + supplyBalances.get("cashBalance"));
            System.out.println("HOW MUCH DO YOU WANT TO SPEND ON MISCELLANEOUS SUPPLIES? ENTER BETWEEN 0-" +
                    supplyBalances.get("cashBalance"));
            try {
                String newInput = sc.nextLine();
                misc = Integer.parseInt(newInput);
            } catch (Exception e) {
                System.out.println("Please enter a number between 0 and " + supplyBalances.get("cashBalance"));
            }

            supplyBalances.put("misc", misc);
        }

        return supplyBalances;
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

    public static void travel(Map<String, Integer> supplyBalances, Scanner sc, int marksmanship, int milesToGo) {
        Map<String, Integer> newSupplyBalances = new HashMap<>(supplyBalances);
        boolean illness = false;
        boolean injury = false;
        boolean blizzard = false;
        boolean insufficientClothing = false;
        int currentMilesToGo = 2040;
        int choice = 0;

        if (newSupplyBalances.get("food") < 13) {
            System.out.println("\nYOU'D BETTER DO SOME HUNTING OR BUY FOOD AND SOON!!!!");
        }

        System.out.println("DO YOU WANT TO (1) STOP AT THE NEXT FORT, (2) HUNT, OR (3) CONTINUE TRAVELING?");

        while (choice < 1 || choice > 3) {
            try {
                String input = sc.nextLine();
                choice = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Please enter a number between 1 and 3");
            }
        }

        switch (choice) {
            case 1 -> newSupplyBalances = new HashMap<>(buyFortSupplies(newSupplyBalances, sc));
            case 2 -> {
                newSupplyBalances = new HashMap<>(hunt(newSupplyBalances, sc));
                newSupplyBalances = new HashMap<>(eat(newSupplyBalances, sc));
                milesToGo = dailyTravel(milesToGo, newSupplyBalances);

            }
        }

    }

}