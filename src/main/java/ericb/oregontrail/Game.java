package ericb.oregontrail;

import java.io.PrintStream;
import java.util.*;

public class Game {
    private static final String[] DATES = { "April 12th", "April 26th", "May 10th", "May 24th", "June 7th",
            "June 21st", "July 5th", "July 19th", "August 2nd", "August 16th", "August 31st", "September 13",
            "September 27th", "October 11", "October 25th", "November 8th", "November 22nd", "December 6th",
            "December 20th"};

    private static final int[] EVENTS = {6, 11, 13, 15, 17, 22, 32, 35, 37, 42, 44, 54, 64, 69, 80, 95};
    private final Random rng = new Random();
    private final Scanner sc = new Scanner(System.in);
    private static final PrintStream out = System.out;
    private Traveler traveler = new Traveler(sc);
    private GameInputOutput inputOutput = new GameInputOutput(out);

    public Game() {}

    public void buyInitialSupplies() {
        Resource[] resources = traveler.getResources();

        for (Resource resource : resources) {
            int min = 0;
            int max = traveler.cashBalance.getAmount();
            if (resource.getName().equals("oxen")) {
                min = 200;
                max = 300;
            }

            out.println("\nCurrent cash balance: " + max);
            out.printf(
                    "\nHow much do you want to spend on %s? Enter between %d-%d.%n", resource.getName(), min, max);
            while (true) {
                try {
                    int cashSpent = sc.nextInt();
                    if (cashSpent < min || cashSpent > max) {
                        throw new IllegalArgumentException("Please enter a number between %d and %d".formatted(min, max));
                    }

                    traveler.cashBalance.setAmount(-cashSpent);
                    if (traveler.isVisitingFort()) {
                        cashSpent = (int) Math.round(cashSpent * 0.667);
                    }
                    resource.setAmount(cashSpent);

                    break;
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
            }
        }

//        out.println("\nCurrent cash balance: " + cash);
//        out.println("\nHow much do you want to spend on your oxen team? Enter between 200-300.");
//
//        cashSpent = nextBoundedInt(200, 300);
//        resources.oxen.setAmount(cashSpent);
//        cash -= cashSpent;
//
//        out.println("\nCurrent cash balance: " + cash);
//        out.println("\nHow much do you want to spend on your food? Enter between 0-" + cash);
//
//        cashSpent = nextBoundedInt(0, cash);
//        resources.food.setAmount(cashSpent);
//        cash -= cashSpent;
//
//        out.println("\nCurrent cash balance: " + cash);
//        out.println("How much do you want to spend on ammunition? Enter between 0-" + cash
//                + ". Remember, each dollar spent buys 50 bullets.");
//
//        cashSpent = nextBoundedInt(0, cash);
//        resources.ammunition.setAmount(cashSpent * 50);
//        cash -= cashSpent;
//
//        out.println("\nCurrent cash balance: " + cash);
//        out.println("How much do you want to spend on clothing? Enter between 0-" + cash);
//
//        cashSpent = nextBoundedInt(0, cash);
//        resources.clothing.setAmount(cashSpent);
//        cash -= cashSpent;
//
//        out.println("\nCurrent cash balance: " + cash);
//        out.println("How much do you want to spend on miscellaneous supplies? Enter between 0-" + cash);
//
//        cashSpent = nextBoundedInt(0, cash);
//        resources.misc.setAmount(cashSpent);
//        cash -= cashSpent;
//
//        resources.cashBalance.setAmount(cash);
    }

    public void buyFortSupplies() {
//        int cash = traveler.cashBalance.getAmount();
//        int cashSpent;
//        Resource[] resources = traveler.getResources();
//
//        out.println("\nCurrent cash balance: " + cash);
//        out.println("\nHow much do you want to spend on your food? Enter between 0-" + cash);
//
//        cashSpent = nextBoundedInt(0, cash);
//        resources.food.setAmount((int) Math.round(0.667 * cashSpent));
//        cash -= cashSpent;
//
//        out.println("\nCurrent cash balance: " + cash);
//        out.println("How much do you want to spend on ammunition? Enter between 0-" + cash
//                + ". Remember, each dollar spent buys 50 bullets.");
//
//        cashSpent = nextBoundedInt(0, cash);
//        resources.ammunition.setAmount((int) Math.round(0.667 * cashSpent) * 50);
//        cash -= cashSpent;
//
//        out.println("\nCurrent cash balance: " + cash);
//        out.println("How much do you want to spend on clothing? Enter between 0-" + cash);
//
//        cashSpent = nextBoundedInt(0, cash);
//        resources.clothing.setAmount((int) Math.round(0.667 * cashSpent));
//        cash -= cashSpent;
//
//        out.println("\nCurrent cash balance: " + cash);
//        out.println("How much do you want to spend on miscellaneous supplies? Enter between 0-" + cash);
//
//        cashSpent = nextBoundedInt(0, cash);
//        resources.misc.setAmount((int) Math.round(0.667 * cashSpent));
//        cash -= cashSpent;
//
//        resources.cashBalance.setAmount(cash);
//        if (traveler.getTotalTurns() > 0) traveler.setMilesTraveled(-45);
    }

//    private int nextBoundedInt(int min, int max) {
//        while (true) {
//            try {
//                int value = sc.nextInt();
//                if (value < min || value > max) {
//                    throw new IllegalArgumentException("Please enter a number between %d and %d".formatted(min, max));
//                }
//
//                return value;
//            } catch (Exception e) {
//                out.println(e.getMessage());
//            }
//        }
//    }

    public void playGame() {
        String instructions = "";

        while (!instructions.equalsIgnoreCase("y") && !instructions.equalsIgnoreCase("n")) {
            out.println("Do you need instructions  (y/n)");
            instructions = sc.nextLine();
        }

        if (instructions.equalsIgnoreCase("y")) inputOutput.printInstructions();

        traveler.setMarksmanship();

        buyInitialSupplies();
        out.println("After all your purchases, you now have " +
                traveler.cashBalance.getAmount() + " dollars left");
        out.println("\nJourney begins: Monday, March 29, 1847");

        pressEnterToContinue();

        out.println("Good luck!");

        while (traveler.getMilesTraveled() < 2040) {
            boolean hasVisitedFort = false;
            boolean hasHunted = false;
            int choice = 0;

            
            try {
                out.println("Today's date: Monday, " + DATES[traveler.getTotalTurns()] + ", 1847");
            } catch (NullPointerException e) {
                youDied("Happy Holidays! You took too long getting to your destination and " +
                        "died in the first blizzard of winter.");
            }

            if (traveler.food.getAmount() < 13) {
                out.println("You'd better do some hunting or buy food and soon!!!");
            }

            if (traveler.isSick()) visitDoctor("illness");
            if (traveler.isInjured()) visitDoctor("injuries");

            out.println("\nTotal mileage is " + traveler.getMilesTraveled());
            out.println("Your current supplies:");
            out.println("food - " + traveler.food.getAmount());
            out.println("ammunition - " + traveler.ammunition.getAmount());
            out.println("clothing - " + traveler.clothing.getAmount());
            out.println("misc supplies - " + traveler.misc.getAmount());

            while (choice != 3) {
                if (!hasVisitedFort && !hasHunted) {
                    out.println("\nDo you want to (1) stop at the next fort, (2) hunt, (3) continue traveling, " +
                            "or (4) exit game?");
                    while (choice < 1 || choice > 4) {
                        try {
                            String input = sc.nextLine();
                            choice = Integer.parseInt(input);
                            if (choice < 1 || choice > 4) throw new IllegalArgumentException();
                        } catch (Exception e) {
                            out.println(e.getMessage());
                        }
                    }

                    switch (choice) {
                        case 1 -> {
                            hasVisitedFort = true;
                            traveler.setVisitingFort(true);
                            buyFortSupplies();
                            traveler.setVisitingFort(false);
                        }
                        case 2 -> {
                            hasHunted = true;
                            hunt();
                        }
                        case 4 -> {
                            exitGame();
                        }
                    }
                } else if (!hasVisitedFort) {
                    out.println("\nDo you want to (1) stop at the next fort, (2) exit game, " +
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
                            out.println("Please enter a number between 1 and 2");
                        }
                    }

                    switch (choice) {
                        case 1 -> {
                            hasVisitedFort = true;
                            traveler.setVisitingFort(true);
                            buyFortSupplies();
                            traveler.setVisitingFort(false);
                        }
                        case 3 -> {
                            exitGame();
                        }
                    }
                } else if (!hasHunted) {
                    out.println("\nDo you want to (1) hunt, (2) exit game, or (3) continue traveling?");
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
                            out.println(e.getMessage());
                        }
                    }

                    switch (choice) {
                        case 1 -> {
                            hasHunted = true;
                            hunt();
                        }
                        case 2 -> {
                            exitGame();
                        }
                    }
                }

                eat();
                dailyTravel();
                meetRiders();
                traveler.setTotalTurns(traveler.getTotalTurns() + 1);
                if (traveler.oxen.getAmount() < 0) traveler.oxen.setAmount(0);
                if (traveler.food.getAmount() < 0) traveler.food.setAmount(0);
                if (traveler.ammunition.getAmount() < 0) traveler.ammunition.setAmount(0);
                if (traveler.clothing.getAmount() < 0) traveler.clothing.setAmount(0);
                if (traveler.misc.getAmount() < 0) traveler.misc.setAmount(0);
                finalTurn(200 + (traveler.oxen.getAmount() - 220) / 5 + rng.nextInt(10));
            }
        }
    }

    public void selectEvent() {
        int eventCounter = 0;
        int index = 0;
        int eventRnd = rng.nextInt(100);

        while (eventCounter < 16) {
            eventCounter++;
            int event = EVENTS[index];
            if (eventRnd > event) {
                index++;
            } else {
                switch (eventCounter) {
                    case 1 -> {
                        out.println("Event 1");
                        out.println("Wagon breaks down--lose time and supplies fixing it");
                        traveler.setMilesTraveled(-(15 + rng.nextInt(5)));
                        traveler.misc.setAmount(-8);
                    }
                    case 2 -> {
                        out.println("Event 2");
                        out.println("Ox injures leg--slows you down rest of trip");
                        traveler.setMilesTraveled(-25);
                        traveler.oxen.setAmount(-20);
                    }
                    case 3 -> {
                        out.println("Event 3");
                        out.println("Bad luck--your daughter broke her arm");
                        out.println("You had to stop and use supplies to make a sling");
                        traveler.setMilesTraveled(-(5 + rng.nextInt(4)));
                        traveler.misc.setAmount(-(rng.nextInt(3)+2));
                    }
                    case 4 -> {
                        out.println("Event 4");
                        out.println("Ox wanders off-spend time looking for it");
                        traveler.setMilesTraveled(-17);
                    }
                    case 5 -> {
                        out.println("Event 5");
                        out.println("Your son gets lost--spend half the day looking for him");
                        traveler.setMilesTraveled(-20);
                    }
                    case 6 -> {
                        out.println("Event 6");
                        out.println("Unsafe water--lose time looking for clean spring");
                        traveler.setMilesTraveled(-(2 + rng.nextInt(10)));
                    }
                    case 7 -> {
                        out.println("Event 7");
                        out.println("Heavy rains---time and supplies lost");
                        traveler.food.setAmount(-10);
                        traveler.ammunition.setAmount(-500);
                        traveler.misc.setAmount(-15);
                        traveler.setMilesTraveled(-(5 + rng.nextInt(10)));
                    }
                    case 8 -> {
                        out.println("Event 8");
                        int elapsedSeconds = fireWeapon().entrySet().iterator().next().getValue();
                        traveler.ammunition.setAmount(-elapsedSeconds * 20);
                        if (traveler.ammunition.getAmount() >= 0) {
                            if (elapsedSeconds <= 1) {
                                out.println("Quickest draw outside of Dodge City!!!");
                                out.println("You got 'em!");
                                checkMountains();
                            } else {
                                out.println("You got shot in the leg and they took one of your oxen");
                                traveler.setInjured(true);
                                out.println("Better have a doc look at your wound");
                                traveler.misc.setAmount(-5);
                                traveler.oxen.setAmount(-20);
                            }
                        } else {
                            out.println("You ran out of bullets---they get lots of cash");
                            traveler.cashBalance.setAmount(traveler.cashBalance.getAmount()/3);
                        }
                    }
                    case 9 -> {
                        out.println("Event 9");
                        out.println("There was a fire in your wagon--food and supplies damaged");
                        traveler.food.setAmount(-40);
                        traveler.ammunition.setAmount(-400);
                        traveler.setMilesTraveled(-(3 + rng.nextInt(8)));
                        traveler.misc.setAmount(-15);
                    }
                    case 10 -> {
                        out.println("Event 10");
                        out.println("Lose your way in heavy fog---time is lost");
                        traveler.setMilesTraveled(-(10 + rng.nextInt(5)));
                    }
                    case 11 -> {
                        out.println("Event 11");
                        out.println("You killed a venomous snake after it bit you");
                        traveler.ammunition.setAmount(-10);
                        traveler.misc.setAmount(-5);
                        if (traveler.misc.getAmount() <= 0) {
                            youDied("You die of snakebite since you have no medicine");
                        }
                    }
                    case 12 -> {
                        out.println("Event 12");
                        out.println("Wagon gets swamped fording river---lose food and clothes");
                        traveler.food.setAmount(-30);
                        traveler.clothing.setAmount(-20);
                        traveler.setMilesTraveled(-(20 + rng.nextInt(20)));
                    }
                    case 13 -> {
                        out.println("Event 13");
                        out.println("Wild animals attack!");
                        int elapsedSeconds = fireWeapon().entrySet().iterator().next().getValue();
                        if (traveler.ammunition.getAmount() > 39) {
                            if (elapsedSeconds > 2) {
                                out.println("Slow on the draw---they got at your food and clothes");
                            } else {
                                out.println("Nice shootin' pardner---they didn't get much");
                            }
                            traveler.ammunition.setAmount(-elapsedSeconds * 20);
                            traveler.clothing.setAmount(-elapsedSeconds * 4);
                            traveler.food.setAmount(-elapsedSeconds * 8);
                        } else {
                            traveler.setInjured(true);
                            youDied("You were too low on bullets--the wolves overpowered you and you died from your injuries");
                        }
                    }
                    case 14 -> {
                        out.println("Event 14");
                        String doOrDoNot = "";
                        if (traveler.clothing.getAmount() >= 22 + rng.nextInt(4)) {
                            doOrDoNot = "have enough";
                        } else {
                            doOrDoNot = "don't have enough";
                            traveler.setInsuffClothing(true);
                        }
                        out.println("Cold weather---BRRRRRRR!---you " + doOrDoNot + " clothing to keep you warm");
                        if (traveler.hasInsuffClothing()) illness();
                    }
                    case 15 -> {
                        out.println("Event 15");
                        illness();
                    }
                    case 16 -> {
                        out.println("Event 16");
                        out.println("Helpful Indians show you where to find more food");
                        traveler.food.setAmount(14);
                    }
                    default -> throw new IllegalArgumentException();
                }
                ;

                checkMountains();
                eventCounter = 16;
                printSupplies();
            }
        }
    }

    public void meetRiders() {
        double hostileRng = Math.random();
        int tacticsChoice = 0;
        String doOrDoNot = hostileRng < 0.8 ? "They do" : "They don't";
        double milesConverted = Math.pow(((double) traveler.getMilesTraveled()/100-4), 2);

        if (rng.nextInt(10) > (milesConverted+72)/(milesConverted+12)-1) {
            selectEvent();
        }

        out.println("\nRiders ahead. " + doOrDoNot + " look hostile");
        out.println("""
                Tactics:\s
                (1) run - gain miles but punishes the oxen with permanent penalty\s
                (2) attack - but they could be friendly\s
                (3) continue - but they could be unfriendly\s
                (4) circle wagons - good defense, but takes time and maybe not necessary""");
        if (Math.random() <= 0.2) traveler.setRidersAreHostile(!traveler.ridersAreHostile());

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

        switch (tacticsChoice) {
            case 1 -> {   // run
                if (traveler.ridersAreHostile()) {
                    traveler.setMilesTraveled(20);
                    traveler.misc.setAmount(-15);
                    traveler.ammunition.setAmount(-150);
                    traveler.oxen.setAmount(-40);
                    out.println("Riders were hostile--check for losses.");
                    if (traveler.ammunition.getAmount() >= 0) selectEvent();
                    youDied("You ran out of bullets and got massacred by the riders.");
                } else {
                    traveler.setMilesTraveled(15);
                    traveler.oxen.setAmount(-10);
                    out.println("Riders were friendly, but check for possible losses.");
                    checkForLosses();
                }
            }
            case 2 -> {   // attack
                if (traveler.ridersAreHostile()) {
                    int elapsedSeconds = fireWeapon().entrySet().iterator().next().getValue();
                    traveler.ammunition.setAmount(-(elapsedSeconds * 40 + 80));
                    fightRiders(elapsedSeconds);
                } else {
                    traveler.setMilesTraveled(-5);
                    traveler.ammunition.setAmount(-100);
                    out.println("Riders were friendly, but check for possible losses.");
                    checkForLosses();
                }
            }
            case 3 -> {   // continue
                if (traveler.ridersAreHostile()) {
                    if (Math.random() > 0.8) {
                        out.println("They did not attack, but check for possible losses.");
                        checkForLosses();
                    } else {
                        traveler.ammunition.setAmount(-150);
                        traveler.misc.setAmount(-15);
                        out.println("They did attack.");
                        fireWeapon();
                        out.println("Check for possible losses.");
                        checkForLosses();
                    }
                } else {
                    out.println("Riders were friendly, but check for possible losses.");
                    checkForLosses();
                }
            }
            case 4 -> {   // circle wagons
                if (traveler.ridersAreHostile()) {
                    int elapsedSeconds = fireWeapon().entrySet().iterator().next().getValue();
                    traveler.ammunition.setAmount(-(elapsedSeconds * 30 + 80));
                    traveler.setMilesTraveled(-25);
                    fightRiders(elapsedSeconds);
                } else {
                    traveler.setMilesTraveled(-20);
                    out.println("Riders were friendly, but check for possible losses.");
                    checkForLosses();
                }
            }
        }
    }

    public void fightRiders(int elapsedSeconds) {
        if (traveler.ammunition.getAmount() < 0) {
            youDied("You ran out of bullets and got massacred by the riders.");
        } else {
            if (elapsedSeconds <= 1) {
                out.println("Nice shooting---you drove them off");
                out.println("Riders were hostile. Check for losses.");
                checkForLosses();
            } else if (elapsedSeconds <= 4) {
                out.println("Kinda slow with your colt .45");
                out.println("Riders were hostile. Check for losses.");
                checkForLosses();
            } else {
                out.println("Lousy shot---you got knifed");
                traveler.setInjured(true);
                out.println("You'll have to see ol' doc Blanchard.");
                out.println("Riders were hostile. Check for losses.");
                checkForLosses();
            }
        }
    }

    public void checkForLosses() {
        pressEnterToContinue();
        selectEvent();
        pressEnterToContinue();
    }

    public void hunt() {
        int newFood = 0;
        int usedAmmo;

        if (traveler.ammunition.getAmount() < 40) {
            out.println("Tough---you need more bullets to go hunting");
            return;
        }

        Map<String, Integer> useWeapon = fireWeapon();
        String input = useWeapon.entrySet().iterator().next().getKey();
        int elapsedSeconds = useWeapon.entrySet().iterator().next().getValue();
        String wordToType = useWeapon.entrySet().iterator().next().getKey();
        out.println("elapsedSeconds: " + elapsedSeconds);

        if (elapsedSeconds <= 1 && input.equals(wordToType)) {
            out.println("Right between the eyes---you got a big one!!! Full bellies tonight!");
            newFood = 52 + rng.nextInt(6);
            usedAmmo = 10 + rng.nextInt(4);
        } else if (rng.nextInt(100) > 13 * elapsedSeconds) {
            out.println("Nice shot--right on target--good eatin' tonight!!");
            newFood = 48 - 2 * elapsedSeconds;
            usedAmmo = 10 + 3 * elapsedSeconds;
        } else {
            out.println("You missed---and your dinner got away.....");
            usedAmmo = 10 + 3 * elapsedSeconds;
            if (traveler.food.getAmount() < 13) {
                youDied("You ran out of food and starved to death");
            }
        }

        traveler.food.setAmount(newFood);
        traveler.ammunition.setAmount(-usedAmmo);
        traveler.setMilesTraveled(-45);
    }

    public Map<String, Integer> fireWeapon() {
        out.println("Get ready to fire!");
        pressEnterToContinue();
        int index = rng.nextInt(4);
        String[] typeChoiceArray = new String[] {"bang", "blam", "pow", "wham"};
        String wordToType = typeChoiceArray[index];
        Map<String, Integer> useWeapon = new HashMap<>();
        out.println("Type '" + wordToType + "' and hit enter");
        long start = System.currentTimeMillis();
        String input = sc.nextLine();
        long end = System.currentTimeMillis();
        int elapsedSeconds = (int) Math.round(((end - start) / 1000F) * 1.2) - (traveler.getMarksmanship() - 1);
        useWeapon.put(input, elapsedSeconds);

        return useWeapon;
    }

    public void checkMountains() {
        if (traveler.getMilesTraveled() <= 950) {   // line 4710
            return;
        } else {
            double milesConverted = Math.pow(((double) traveler.getMilesTraveled() / 100 - 4), 2);
            if (rng.nextInt(10) <= 9 - (milesConverted + 72) / (milesConverted + 12)) {   // line 4720
                out.println("Rugged mountains");   // line 4730
                if (Math.random() > 0.1) {   // line 4740
                    if (Math.random() > 0.11) {   // line 4780
                        out.println("The going gets slow");   // line 4840
                        traveler.setMilesTraveled(-(45 + (int) (rng.nextDouble() / 0.02)));
                        checkPassesCleared();
                    } else {
                        out.println("Wagon damaged!-lost time and supplies");   // line 4790
                        traveler.misc.setAmount(-5);   // line 4800
                        traveler.ammunition.setAmount(-200);   // line 4810
                        traveler.setMilesTraveled(-(20 + rng.nextInt(30)));   // line 4820
                    }
                } else {
                    out.println("You got lost--lost valuable time trying to find trail!");   // line 4750
                    traveler.setMilesTraveled(-60);   // line 4760
                    checkPassesCleared();
                }
            } else {
                checkPassesCleared();
            }
        }
    }

    public void checkPassesCleared() {
        if (traveler.hasClearedSouthPass() && traveler.getMilesTraveled() >= 1700
                && !traveler.hasClearedBlueMountains()) {   // line 4860
            traveler.setClearedBlueMountains(true);   // line 4920
            if (Math.random() < 0.7) {   // line 4930
                blizzardInMountains();
            }
        } else {
            traveler.setClearedSouthPass(true);  // line 4870
            if (Math.random() < 0.8) {   // line 4880
                blizzardInMountains();
            }
        }
    }

    public void checkMiscAndBlizzard() {
        if (traveler.misc.getAmount() < 0) {   // line 6440
            youDied("You ran out of medical supplies and died from pneumonia.");
        } else if (traveler.inBlizzard() || traveler.getMilesTraveled() <=950) {   // line 6450
            traveler.setSouthPassSettingMileage(true);   // line 4950
        }
    }

    public void blizzardInMountains() {
        out.println("Blizzard in mountain pass--time and supplies lost");   // line 4970
        traveler.setBlizzard(true);   // line 4980
        traveler.food.setAmount(-25);   // line 4990
        traveler.misc.setAmount(-10);   // line 5000
        traveler.ammunition.setAmount(-300);   // line 5010
        traveler.setMilesTraveled(-(30 + rng.nextInt(40)));   // line 5020
        if (traveler.clothing.getAmount() < 18 + rng.nextInt(2)) {   // line 5030
            illness();
        }
    }

    public void illness() {
        if (rng.nextInt(100) < 10+35*(traveler.getEatingChoice()-1)) {   // line 6300
            out.println("Mild illness---medicine used");   // line 6370
            traveler.setMilesTraveled(-5);   // line 6380
            traveler.misc.setAmount(-2);   // line 6390
            checkMiscAndBlizzard();
        } else if (rng.nextInt(100) < 100-Math.pow((double) 40/4, traveler.getEatingChoice()-1)) {   // line 6310
            out.println("Bad illness---medicine used");   // line 6410
            traveler.setMilesTraveled(-5);   // line 6420
            traveler.misc.setAmount(-5);   // line 6430
            checkMiscAndBlizzard();
        } else {
            out.println("Serious illness---you mush stop for medical attention");   // lines 6320-6330
            traveler.misc.setAmount(-10);   // line 6340
            traveler.setSick(true);   // line 6350
            checkMiscAndBlizzard();
        }
    }

    public void visitDoctor(String reason) {
        int currentCash = traveler.cashBalance.getAmount();
        if (reason.equals("illness")) {
            out.println("You are sick.");
            traveler.setSick(false);
        } else {
            out.println("You are injured.");
            traveler.setInjured(false);
        }

        currentCash -= 20;
        out.println("The doctor bill will be $20.");

        if (currentCash < 0) {
            youDied("You can't afford a doctor. You died from your " + reason + ".");
        }

        traveler.cashBalance.setAmount(currentCash);
    }

    public void finalTurn(int travelThisTurn) {
        int avgTravelPerTurn = 200 + (traveler.oxen.getAmount() - 220)/5 + rng.nextInt(10);
        double fractionOfTurn = ((double) travelThisTurn / avgTravelPerTurn);
        out.println("fractionOfTurn: " + fractionOfTurn);
        out.println("food before: " + traveler.food.getAmount());
        traveler.food.setAmount((int) -((1 - fractionOfTurn) * ( 8 * 5 * traveler.getEatingChoice())));
        out.println("food after: " + traveler.food.getAmount());
        out.println("You finally arrived at Oregon City after 2040 long miles---Hooray!!!!!" +
                " A real pioneer.");
        int dayOfTheYear = 88 + traveler.getTotalTurns() * 14 + (int) fractionOfTurn * 14;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, dayOfTheYear);
        out.println("Day of year " + dayOfTheYear + " = " + calendar.getTime());
        exitGame();
    }

    public void youDied(String causeOfDeath) {
        out.println(causeOfDeath);
        pressEnterToContinue();
        out.println("Due to your unfortunate situation, there a few formalities we must go through.");
        out.println("Would you like a minister?");
        String input = sc.nextLine();
        out.println("Would you like a fancy funeral?");
        input = sc.nextLine();
        out.println("Would you like us to inform your next of kin?");
        input = sc.nextLine();
        if (input.equalsIgnoreCase("n")) {
            out.println("But your Aunt Sadie in St. Louis is really worried about you.");
        } else {
            out.println("That will be $4.50 for th telegraph charge.");
        }
        out.println("""
                We thank you for this information and we are sorry you didn't make it to the great territory of Oregon.
                Better luck next time.\s
                Sincerely,\s
                The Oregon Chamber of Commerce""");
    }

    public void eat() {
        int choice = 0;
        int food = traveler.food.getAmount();

        out.println("You have " + food + " food left.");
        out.println("Do you want to eat (1) poorly, (2) moderately, or (3) well?");

        while (choice < 1 || choice > 3) {
            try {
                String newInput = sc.nextLine();
                choice = Integer.parseInt(newInput);
            } catch (Exception e) {
                out.println("Please enter a number between 1 and 3");
            }
        }

        if (8 + 5 * choice > food) {
            out.println("You can't eat that well");
            eat();
        } else {
            traveler.food.setAmount(-(8 + 5 * choice));
        }
        traveler.setEatingChoice(choice);
    }

    public void dailyTravel() {
        traveler.setMilesPreviousTurn(traveler.getMilesTraveled());
        int travelThisTurn = 200 + (traveler.oxen.getAmount() - 220)/5 + rng.nextInt(10);
        traveler.setMilesTraveled(travelThisTurn);
        if (traveler.getMilesTraveled() >= 2040) finalTurn(travelThisTurn);
    }

    public void printSupplies() {
        out.println("Current supplies:");
        out.println("Food - " + traveler.food.getAmount());
        out.println("Ammunition - " + traveler.ammunition.getAmount());
        out.println("Clothing - " + traveler.clothing.getAmount());
        out.println("Miscellaneous - " + traveler.misc.getAmount());
    }

    public static void pressEnterToContinue() {
        Scanner sc = new Scanner(System.in);
        out.println("Press enter to continue...");
        sc.nextLine();
        out.println("___________________________________________________________________________________________");
    }

    public void exitGame() {
        out.println("Thanks for playing!");
        System.exit(0);
    }

}
