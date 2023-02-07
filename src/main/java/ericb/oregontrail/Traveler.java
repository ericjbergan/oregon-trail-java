package ericb.oregontrail;

import java.util.*;

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
    boolean injured = false;
    boolean sick = false;
    boolean blizzard = false;
    boolean ridersAreHostile = false;
    private int marksmanship;
    private int totalTurns = 0;
    private int milesTraveled = 0;
    private int travelHandicap = 0;
    private int eatingChoice = 0;
    private int milesPreviousTurn = 0;
    private Random rng;
    private Scanner sc;

    public Traveler(Random rng) {
        this.rng = rng;
    }

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

        this.oxen += oxen;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food += food;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(int ammunition) {

        this.ammunition += ammunition;
    }

    public int getClothing() {
        return clothing;
    }

    public void setClothing(int clothing) {
        this.clothing += clothing;
    }

    public int getMisc() {
        return misc;
    }

    public void setMisc(int misc) {
        this.misc += misc;
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

    public boolean isInsuffClothing() {
        return insuffClothing;
    }

    public boolean isSouthPassSettingMileage() {
        return southPassSettingMileage;
    }

    public void setSouthPassSettingMileage(boolean southPassSettingMileage) {
        this.southPassSettingMileage = southPassSettingMileage;
    }

    public boolean ridersAreHostile() {
        return ridersAreHostile;
    }

    public boolean hasClearedBlueMountains() {
        return clearedBlueMountains;
    }

    public void setClearedBlueMountains(boolean clearedBlueMountains) {
        this.clearedBlueMountains = clearedBlueMountains;
    }

    public boolean isInjured() {
        return injured;
    }

    public void setInjured(boolean injured) {
        injured = injured;
    }

    public boolean isSick() {
        return sick;
    }

    public void setSick(boolean sick) {
        sick = sick;
    }

    public boolean inBlizzard() {
        return blizzard;
    }

    public void setBlizzard(boolean inBlizzard) {
        this.blizzard = inBlizzard;
    }

    public void setRidersAreHostile(boolean ridersAreHostile) {
        this.ridersAreHostile = ridersAreHostile;
    }

    public int getMarksmanship() {
        return marksmanship;
    }

    public void setMarksmanship() {
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
    }

    public int getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(int milesTraveled) {
        this.milesTraveled += milesTraveled;
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

    public int getEatingChoice() {
        return eatingChoice;
    }

    public void setEatingChoice(int eatingChoice) {
        this.eatingChoice = eatingChoice;
    }

    public int getMilesPreviousTurn() {
        return milesPreviousTurn;
    }

    public void setMilesPreviousTurn(int milesPreviousTurn) {
        this.milesPreviousTurn = milesPreviousTurn;
    }

    private void nextBoundedInt(int min, int max) {

    }

    public void buyInitialSupplies() {
        int cash = 700;
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












}
