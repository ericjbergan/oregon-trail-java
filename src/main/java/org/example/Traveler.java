package org.example;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Traveler {
    private int cashBalance = 700;
    private int oxen = -1;
    private int food = -1;
    private int ammunition = -1;
    private int clothing = -1;
    private int misc = -1;
    boolean insuffClothing = false;
    boolean clearedSouthPass = false;
    boolean southPassSettingMileage = false;
    boolean clearedBlueMountains = false;
    boolean isInjured = false;
    boolean isSick = false;
    boolean inBlizzard = false;
    boolean ridersAreHostile = false;
    private int marksmanship;
    private int totalTurns = 0;
    private int milesTraveled = 0;
    private int travelHandicap = 0;
    private int eatingChoice = 0;
    private Scanner sc = new Scanner(System.in);
    private Random rng = new Random();

    public Traveler() {}

    public int getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(int cashBalance) {
        this.cashBalance = cashBalance;
    }

    public int getOxen() {
        return oxen;
    }

    public void setOxen(int oxen) {
        this.oxen = oxen;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    public int getClothing() {
        return clothing;
    }

    public void setClothing(int clothing) {
        this.clothing = clothing;
    }

    public int getMisc() {
        return misc;
    }

    public void setMisc(int misc) {
        this.misc = misc;
    }

    public boolean hasInsuffClothing() {
        return insuffClothing;
    }

    public void setInsuffClothing(boolean insuffClothing) {
        this.insuffClothing = insuffClothing;
    }

    public boolean hasClearedSouthPass() {
        return clearedSouthPass;
    }

    public void setClearedSouthPass(boolean clearedSouthPass) {
        this.clearedSouthPass = clearedSouthPass;
    }

    public boolean hasClearedBlueMountains() {
        return clearedBlueMountains;
    }

    public void setClearedBlueMountains(boolean clearedBlueMountains) {
        this.clearedBlueMountains = clearedBlueMountains;
    }

    public boolean isInjured() {
        return isInjured;
    }

    public void setInjured(boolean injured) {
        isInjured = injured;
    }

    public boolean isSick() {
        return isSick;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }

    public boolean isInBlizzard() {
        return inBlizzard;
    }

    public void setInBlizzard(boolean inBlizzard) {
        this.inBlizzard = inBlizzard;
    }

    public boolean ridersAreHostile() {
        return ridersAreHostile;
    }

    public void setRidersAreHostile(boolean ridersAreHostile) {
        this.ridersAreHostile = ridersAreHostile;
    }

    public int getMarksmanship() {
        return marksmanship;
    }

    public int setMarksmanship() {
        marksmanship = 0;

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

    public int getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(int milesTraveled) {
        this.milesTraveled = milesTraveled;
    }

    public void setMarksmanship(int marksmanship) {
        this.marksmanship = marksmanship;
    }

    public int getTotalTurns() {
        return totalTurns;
    }

    public void setTotalTurns(int daysTraveled) {
        this.totalTurns = daysTraveled;
    }

    public int getTravelHandicap() {
        return travelHandicap;
    }

    public void setTravelHandicap(int travelHandicap) {
        this.travelHandicap = travelHandicap;
    }

    public void buyInitialSupplies() {
        int cash = cashBalance;
        int oxen = -1;
        int food = -1;
        int ammunition = -1;
        int clothing = -1;
        int misc = -1;

        System.out.println("\nCurrent cash balance: " + cash);
        System.out.println("\nHow much do you want to spend on your oxen team? Enter between 200-300.");
        while (oxen < 200 || oxen > 300) {

            try {
                String newInput = sc.nextLine();
                oxen = Integer.parseInt(newInput);
                if (oxen < 200 || oxen > 300) {
                    throw new IllegalArgumentException("Please enter a number between 200 and 300...");
                }
                cash -= oxen;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            this.oxen = oxen;
        }

        System.out.println("\nCurrent cash balance: " + cash);
        System.out.println("\nHow much do you want to spend on your food? Enter between 0-" + cash);
        while (food < 0 || food > cash) {

            try {
                String newInput = sc.nextLine();
                food = Integer.parseInt(newInput);
                if (food < 0 || food > cash) {
                    throw new IllegalArgumentException("Please enter a number between 0 and " + cash);
                }
                cash -= food;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            this.food = food;
        }

        System.out.println("\nCurrent cash balance: " + cash);
        System.out.println("How much do you want to spend on ammunition? Enter between 0-" + cash
                + ". Remember, each dollar spent buys 50 bullets.");
        while (ammunition < 0 || ammunition > cash) {

            try {
                String newInput = sc.nextLine();
                ammunition = Integer.parseInt(newInput);
                if (ammunition < 0 || ammunition > cash) {
                    throw new IllegalArgumentException("Please enter a number between 0 and " + cash);
                }
                cash -= ammunition;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            this.ammunition = ammunition * 50;
        }

        System.out.println("\nCurrent cash balance: " + cash);
        System.out.println("How much do you want to spend on clothing? Enter between 0-" + cash);
        while (clothing < 0 || clothing > cash) {

            try {
                String newInput = sc.nextLine();
                clothing = Integer.parseInt(newInput);
                if (clothing < 0 || clothing > cash) {
                    throw new IllegalArgumentException("Please enter a number between 0 and " + cash);
                }
                cash -= clothing;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            this.clothing = clothing;
        }

        System.out.println("\nCurrent cash balance: " + cash);
        System.out.println("How much do you want to spend on miscellaneous supplies? Enter between 0-" + cash);
        while (misc < 0 || misc > cash) {

            try {
                String newInput = sc.nextLine();
                misc = Integer.parseInt(newInput);
                if (misc < 0 || misc > cash) {
                    throw new IllegalArgumentException("Please enter a number between 0 and " + cash);
                }
                cash -= misc;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            this.misc = misc;
        }

        cashBalance = cash;
    }

    public void buyFortSupplies() {
        int cash = cashBalance;
        int newFood = -1;
        int newAmmunition = -1;
        int newClothing = -1;
        int newMisc = -1;

        System.out.println("\nCurrent cash balance: " + cash);
        System.out.println("\nHow much do you want to spend on your food? Enter between 0-" + cash);
        while (newFood < 0 || newFood > cash) {

            try {
                String newInput = sc.nextLine();
                newFood = Integer.parseInt(newInput);
                if (newFood < 0 || newFood > cash) {
                    throw new IllegalArgumentException("Please enter a number between 0 and " + cash);
                }
                cash -= newFood;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            this.food = (int) (this.food + Math.round(0.667 * newFood));
        }

        System.out.println("\nCurrent cash balance: " + cash);
        System.out.println("How much do you want to spend on ammunition? Enter between 0-" + cash
                + ". Remember, each dollar spent buys 50 bullets.");
        while (newAmmunition < 0 || newAmmunition > cash) {

            try {
                String newInput = sc.nextLine();
                newAmmunition = Integer.parseInt(newInput);
                if (newAmmunition < 0 || newAmmunition > cash) {
                    throw new IllegalArgumentException("Please enter a number between 0 and " + cash);
                }
                cash -= newAmmunition;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            this.ammunition = (int) (this.ammunition + Math.round(0.667 * newAmmunition) * 50);
        }

        System.out.println("\nCurrent cash balance: " + cash);
        System.out.println("How much do you want to spend on clothing? Enter between 0-" + cash);
        while (newClothing < 0 || newClothing > cash) {

            try {
                String newInput = sc.nextLine();
                newClothing = Integer.parseInt(newInput);
                if (newClothing < 0 || newClothing > cash) {
                    throw new IllegalArgumentException("Please enter a number between 0 and " + cash);
                }
                cash -= newClothing;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            this.clothing = (int) (this.clothing + Math.round(0.667 * newClothing));
        }

        System.out.println("\nCurrent cash balance: " + cash);
        System.out.println("How much do you want to spend on miscellaneous supplies? Enter between 0-" + cash);
        while (newMisc < 0 || newMisc > cash) {

            try {
                String newInput = sc.nextLine();
                newMisc = Integer.parseInt(newInput);
                if (newMisc < 0 || newMisc > cash) {
                    throw new IllegalArgumentException("Please enter a number between 0 and " + cash);
                }
                cash -= newMisc;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            this.misc = (int) (this.misc + Math.round(0.667 * newMisc));
        }

        this.cashBalance = cash;
        if (totalTurns > 0) milesTraveled -= 45;
    }

    public void hunt() {

        int newFood = 0;
        int usedAmmo;

        if (this.ammunition < 40) {
            System.out.println("Tough---you need more bullets to go hunting");
            return;
        }

        Map<String, Integer> useWeapon = fireWeapon();
        String input = useWeapon.entrySet().iterator().next().getKey();
        int elapsedSeconds = useWeapon.entrySet().iterator().next().getValue();
        String wordToType = useWeapon.entrySet().iterator().next().getKey();
        System.out.println("elapsedSeconds: " + elapsedSeconds);

        if (elapsedSeconds <= 1 && input.equals(wordToType)) {
            System.out.println("Right between the eyes---you got a big one!!! Full bellies tonight!");
            newFood = 52 + rng.nextInt(6);
            usedAmmo = 10 + rng.nextInt(4);
        } else if (rng.nextInt(100) > 13 * elapsedSeconds) {
            System.out.println("Nice shot--right on target--good eatin' tonight!!");
            newFood = 48 - 2 * elapsedSeconds;
            usedAmmo = 10 + 3 * elapsedSeconds;
        } else {
            System.out.println("You missed---and your dinner got away.....");
            usedAmmo = 10 + 3 * elapsedSeconds;
        }

        this.food += newFood;
        this.ammunition -= usedAmmo;
        milesTraveled -= 45;
    }

    public Map<String, Integer> fireWeapon() {
        int index = rng.nextInt(4);
        String[] typeChoiceArray = new String[] {"bang", "blam", "pow", "wham"};
        String wordToType = typeChoiceArray[index];
        Map<String, Integer> useWeapon = new HashMap<>();
        System.out.println("Type '" + wordToType + "' and hit enter");
        long start = System.currentTimeMillis();
        String input = sc.nextLine();
        long end = System.currentTimeMillis();
        int elapsedSeconds = (int) Math.round(((end - start) / 1000F) * 1.2) - (marksmanship - 1);
        useWeapon.put(input, elapsedSeconds);

        return useWeapon;
    }

    public void eat() {
        System.out.println("inside eat()");
        int choice = 0;
        int food = this.food;

        System.out.println("You have " + food + " food left.");
        System.out.println("Do you want to eat (1) poorly, (2) moderately, or (3) well?");

        while (choice < 1 || choice > 3) {
            try {
                String newInput = sc.nextLine();
                choice = Integer.parseInt(newInput);
            } catch (Exception e) {
                System.out.println("Please enter a number between 1 and 3");
            }
        }

        if (8 + 5 * choice > food) {
            System.out.println("You can't eat that well");
            eat();
        } else {
            this.food = food - 8 - 5 * choice;
        }
        eatingChoice = choice;
    }

    public void visitDoctor(String reason) {
        if (reason.equals("illness")) {
            System.out.println("You are sick.");
            isSick = false;
        } else {
            System.out.println("You are injured.");
            isInjured = false;
        }

        this.cashBalance -= 20;
        System.out.println("The doctor bill will be $20.");

        if (this.cashBalance < 0) {
            System.out.println("You can't afford a doctor. You died from your " + reason + ".");
        }
    }

    public void dailyTravel() {
        milesTraveled += 200 + (this.oxen - 220)/5 + rng.nextInt(10);
    }

    public void meetRiders() {
        System.out.println("inside meetRiders()");
        double hostileRng = Math.random();
        int tacticsChoice = 0;
        String doOrDoNot = hostileRng < 0.8 ? "They do" : "They don't";
        double milesConverted = Math.pow(((double) milesTraveled/100-4), 2);

        if (rng.nextInt(10) > (milesConverted+72)/(milesConverted+12)-1) {
            selectEvent();
        }

        System.out.println("\nRiders ahead. " + doOrDoNot + " look hostile");
        System.out.println("Tactics: " +
                "(1) run - gain miles but punishes the oxen with permanent penalty " +
                "(2) attack - but they could be friendly " +
                "(3) continue - but they could be unfriendly " +
                "(4) circle wagons - ");
        if (Math.random() <= 0.2) ridersAreHostile = !ridersAreHostile;

        while (tacticsChoice < 1 || tacticsChoice > 4) {
            try {
                String input = sc.nextLine();
                tacticsChoice = Integer.parseInt(input);
                if (tacticsChoice < 1 || tacticsChoice > 4) throw new IllegalArgumentException("Please enter a" +
                        "number between 1 and 4");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        switch (tacticsChoice) {
            case 1 -> {   // run
                if (ridersAreHostile) {
                    milesTraveled += 20;
                    misc -= 15;
                    ammunition -= 150;
                    oxen -= 40;
                    System.out.println("Riders were hostile--check for losses");
                    if (ammunition >= 0) selectEvent();
                    System.out.println("You ran out of bullets and got massacred by the riders");
                    youDied();
                } else {
                    milesTraveled += 15;
                    oxen -= 10;
                    System.out.println("Riders were friendly, but check for possible losses");
                    checkForLosses();
                }
            }
            case 2 -> {   // attack
                if (ridersAreHostile) {
                    int elapsedSeconds = fireWeapon().entrySet().iterator().next().getValue();
                    ammunition -= (elapsedSeconds * 40 + 80);
                    fightRiders(elapsedSeconds);
                } else {
                    milesTraveled -= 5;
                    ammunition -= 100;
                    System.out.println("Riders were friendly, but check for possible losses");
                    checkForLosses();
                }
            }
            case 3 -> {   // continue
                if (ridersAreHostile) {
                    if (Math.random() > 0.8) {
                        System.out.println("They did not attack, but check for possible losses");
                        checkForLosses();
                    } else {
                        ammunition -= 150;
                        misc -= 15;
                        System.out.println("Check for possible losses");
                        checkForLosses();
                    }
                } else {
                    System.out.println("Riders were friendly, but check for possible losses");
                    checkForLosses();
                }
            }
            case 4 -> {   // circle wagons
                if (ridersAreHostile) {
                    int elapsedSeconds = fireWeapon().entrySet().iterator().next().getValue();
                    ammunition -= (elapsedSeconds * 30 + 80);
                    milesTraveled -= 25;
                    fightRiders(elapsedSeconds);
                } else {
                    milesTraveled -= 20;
                    System.out.println("Riders were friendly, but check for possible losses");
                    checkForLosses();
                }
            }
        }
    }

    public void fightRiders(int elapsedSeconds) {
        if (this.ammunition < 0) {
            System.out.println("You ran out of bullets and got massacred by the riders");
            youDied();
        } else {
            if (elapsedSeconds <= 1) {
                System.out.println("Nice shooting---you drove them off");
                System.out.println("Riders were hostile. Check for losses");
                checkForLosses();
            } else if (elapsedSeconds <= 4) {
                System.out.println("Kinda slow with your colt .45");
                System.out.println("Riders were hostile. Check for losses");
                checkForLosses();
            } else {
                System.out.println("Lousy shot---you got knifed");
                isInjured = true;
                System.out.println("You'll have to see ol' doc Blanchard");
                System.out.println("Riders were hostile. Check for losses");
                checkForLosses();
            }
        }
    }

    public void checkForLosses() {
        Main.pressEnterToContinue();
        selectEvent();
        Main.pressEnterToContinue();
    }

    public void selectEvent() {
        System.out.println("inside selectEvent()");
        int[] eventArray = new int[] {6, 11, 13, 15, 17, 22, 32, 35, 37, 42, 44, 54, 64, 69, 95};
        int eventCounter = 0;
        int index = 0;
        int eventRnd = rng.nextInt(100);

        while (eventCounter < 16) {
            eventCounter++;
            int event = eventArray[index];
            if (eventRnd > event) {
                index++;
            } else {
                switch (eventCounter) {
                    case 1 -> {
                        System.out.println("Wagon breaks down--lose time and supplies fixing it");
                        milesTraveled -= 15 + rng.nextInt(5);
                        misc -= 8;
                        checkMountains();
                    }
                    case 2 -> {
                        System.out.println("Ox injures leg--slows you down rest of trip");
                        milesTraveled -= 25;
                        oxen -= 20;
                        checkMountains();
                    }
                    case 3 -> {
                        System.out.println("Bad luck--your daughter broke her arm");
                        System.out.println("You had to stop and use supplies to make a sling");
                        milesTraveled -= 5 + rng.nextInt(4);
                        misc -= 2 + rng.nextInt(3);
                        checkMountains();
                    }
                    case 4 -> {
                        System.out.println("Ox wanders off-spend time looking for it");
                        milesTraveled -= 17;
                        checkMountains();
                    }
                    case 5 -> {
                        System.out.println("Your son gets lost--spend half the day looking for him");
                        milesTraveled -= 20;
                        checkMountains();
                    }
                    case 6 -> {
                        System.out.println("Unsafe water--lose time looking for clean spring");
                        milesTraveled -= rng.nextInt(10) + 2;
                        checkMountains();
                    }
                    case 7 -> {
                        System.out.println("Heavy rains---time and supplies lost");
                        food -= 10;
                        ammunition -= 500;
                        misc -= 15;
                        milesTraveled -= rng.nextInt(10) + 5;
                        checkMountains();
                    }
                    case 8 -> {
                        int elapsedSeconds = fireWeapon().entrySet().iterator().next().getValue();
                        ammunition -= elapsedSeconds * 20;
                        if (ammunition >= 0) {
                            if (elapsedSeconds <= 1) {
                                System.out.println("Quickest draw outside of Dodge City!!!");
                                System.out.println("You got 'em!");
                                checkMountains();
                            } else {
                                System.out.println("You got shot in the leg and they took one of your oxen");
                                isInjured = true;
                                System.out.println("Better have a doc look at your wound");
                                misc -= 5;
                                oxen -= 20;
                            }
                        } else {
                            System.out.println("You ran out of bullets---they get lots of cash");
                            cashBalance /= 3;
                        }
                        checkMountains();
                    }
                    case 9 -> {
                        System.out.println("There was a fire in your wagon--food and supplies damaged");
                        food -= 40;
                        ammunition -= 400;
                        milesTraveled -= rng.nextInt(8) + 3;
                        misc -= 15;
                        checkMountains();
                    }
                    case 10 -> {
                        System.out.println("Lose your way in heavy fog---time is lost");
                        milesTraveled -= 10 + rng.nextInt(5);
                        checkMountains();
                    }
                    case 11 -> {
                        System.out.println("You killed a venomous snake after it bit you");
                        ammunition -= 10;
                        misc -= 5;
                        if (misc <= 0) {
                            System.out.println("You die of snakebite since you have no medicine");
                            youDied();
                        }
                        checkMountains();
                    }
                    case 12 -> {
                        System.out.println("Wagon gets swamped fording river---lose food and clothes");
                        food -= 30;
                        clothing -= 20;
                        milesTraveled -= 20 + rng.nextInt(20);
                        checkMountains();
                    }
                    case 13 -> {
                        System.out.println("Wild animals attack!");
                        int elapsedSeconds = fireWeapon().entrySet().iterator().next().getValue();
                        if (ammunition > 39) {
                            if (elapsedSeconds > 2) {
                                System.out.println("Slow on the draw---they got at your food and clothes");
                                ammunition -= elapsedSeconds * 20;
                                clothing -= elapsedSeconds * 4;
                                food -= elapsedSeconds * 8;
                            } else {
                                System.out.println("Nice shootin' pardner---they didn't get much");
                                ammunition -= elapsedSeconds * 20;
                                clothing -= elapsedSeconds * 4;
                                food -= elapsedSeconds * 8;
                            }
                        } else {
                            System.out.println("You were too low on bullets--the wolves overpowered you");
                            isInjured = true;
                            System.out.println("You died from your injuries");
                            youDied();
                        }
                        checkMountains();
                    }
                    case 14 -> {
                        String doOrDoNot = "";
                        if (clothing >= 22 + rng.nextInt(4)) {
                            doOrDoNot = "have enough";
                        } else {
                            doOrDoNot = "don't have enough";
                            insuffClothing = true;
                        }
                        System.out.println("Cold weather---BRRRRRRR!---you " + doOrDoNot + " clothing to keep you warm");
                        if (insuffClothing) illness();
                        checkMountains();
                    }
                    case 15 -> {
                        illness();
                        checkMountains();
                    }
                    case 16 -> {
                        System.out.println("Helpful Indians show you where to find more food");
                        food += 14;
                        checkMountains();
                    }
                    default -> throw new IllegalArgumentException();
                };
            }
        }

    }

    public void checkMountains() {
        if (milesTraveled <= 950) {   // line 4710
            return;
        } else {
            double milesConverted = Math.pow(((double) milesTraveled/100-4), 2);
            if (rng.nextInt(10) <= 9-(milesConverted+72) / (milesConverted+12)) {   // line 4720
                System.out.println("Rugged mountains");   // line 4730
                if (Math.random() > 0.1) {   // line 4740
                    if (Math.random() > 0.11) {   // line 4780
                        System.out.println("The going gets slow");   // line 4840
                        milesTraveled -= 45 + Math.random() / 0.02;   // line 4850
                        line4860();
                    } else {
                        System.out.println("Wagon damaged!-lost time and supplies");   // line 4790
                        misc -= 5;   // line 4800
                        ammunition -= 200;   // line 4810
                        milesTraveled -= 20 + rng.nextInt(30);   // line 4820
                    }
                } else {
                    System.out.println("You got lost--lost valuable time trying to find trail!");   // line 4750
                    milesTraveled -= 60;   // line 4760
                    line4860();
                }
            } else {
                line4860();
            }
        }
    }

    public void line4860() {
        if (clearedSouthPass) {   // line 4860
            if (milesTraveled < 1700) {   // line 4900
                return;
            } else {
                if (clearedBlueMountains) {   // line 4910
                    return;
                } else {
                    clearedBlueMountains = true;   // line 4920
                    if (Math.random() < 0.7) {   // line 4930
                        blizzardInMountains();
                    } else {
                        return;
                    }
                }
            }
        } else {
            clearedSouthPass = true;   // line 4870
            if (Math.random() < 0.8) {   // line 4880
                blizzardInMountains();
            } else {
                return;
            }
        }
    }

    public void blizzardInMountains() {
        System.out.println("Blizzard in mountain pass--time and supplies lost");   // line 4970
        inBlizzard = true;   // line 4980
        food -= 25;   // line 4990
        misc -= 10;   // line 5000
        ammunition -= 300;   // line 5010
        milesTraveled -= 30 + rng.nextInt(40);   // line 5020
        if (clothing < 18 + rng.nextInt(2)) {   // line 5030
            illness();
        }
    }

    public void youDied() {

    }

    public void illness() {
        if (rng.nextInt(100) < 10+35*(eatingChoice-1)) {   // line 6300
            System.out.println("Mild illness---medicine used");   // line 6370
            milesTraveled -= 5;   // line 6380
            misc -= 2;   // line 6390
            if (misc < 0) {   // line 6440
                youDied();
            } else {
                if (inBlizzard) {   // line 6450
                    if (milesTraveled > 950) {   // line 4940
                        return;
                    }
                } else {
                    southPassSettingMileage = true;   // line 4950
                }
            }
        }
    }

}
