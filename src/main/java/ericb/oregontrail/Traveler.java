package ericb.oregontrail;

import java.util.*;

public class Traveler {
    Resource cashBalance = new Resource("cashBalance", 700);
    Resource oxen = new Resource("oxen", 0);
    Resource food = new Resource("food", 0);
    Resource ammunition = new Resource("ammunition", 0);
    Resource clothing = new Resource("clothing", 0);
    Resource misc = new Resource("misc", 0);
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
    private final Scanner sc;

    public Traveler(Scanner sc) {
        this.sc = sc;
    }

    public Resource[] getResources() {
        return new Resource[]{oxen, food, ammunition, clothing, misc};
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
















}
