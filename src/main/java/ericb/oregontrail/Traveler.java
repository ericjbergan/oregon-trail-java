package ericb.oregontrail;

import java.util.*;

public class Traveler {
    Resource cashBalance = new Resource("cashBalance", 700);
    Resource oxen = new Resource("oxen", 0);
    Resource food = new Resource("food", 0);
    Resource ammunition = new Resource("ammunition", 0);
    Resource clothing = new Resource("clothing", 0);
    Resource misc = new Resource("misc", 0);
    private boolean insuffClothing = false;
    private boolean clearedSouthPass = false;
    private boolean southPassSettingMileage = false;
    private boolean clearedBlueMountains = false;
    private boolean injured = false;
    private boolean sick = false;
    private boolean blizzard = false;
    private boolean ridersAreHostile = false;
    private boolean visitingFort = false;
    private int marksmanship;
    private int totalTurns = 0;
    private int milesTraveled = 0;
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

    public boolean isSouthPassSettingMileage() {
        return southPassSettingMileage;
    }

    public void setSouthPassSettingMileage(boolean southPassSettingMileage) {
        this.southPassSettingMileage = southPassSettingMileage;
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
        this.injured = injured;
    }

    public boolean isSick() {
        return sick;
    }

    public void setSick(boolean sick) {
        this.sick = sick;
    }

    public boolean inBlizzard() {
        return blizzard;
    }

    public void setBlizzard(boolean inBlizzard) {
        this.blizzard = inBlizzard;
    }

    public boolean ridersAreHostile() {
        return ridersAreHostile;
    }

    public void setRidersAreHostile(boolean ridersAreHostile) {
        this.ridersAreHostile = ridersAreHostile;
    }

    public boolean isVisitingFort() {
        return visitingFort;
    }

    public void setVisitingFort(boolean visitingFort) {
        this.visitingFort = visitingFort;
    }

    public int getMarksmanship() {
        return marksmanship;
    }

    public void setMarksmanship(int marksmanship) {
        this.marksmanship = marksmanship;
    }

    public int getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(int milesTraveled) {
        this.milesTraveled += milesTraveled;
    }

    public int getTotalTurns() {
        return totalTurns;
    }

    public void setTotalTurns() {
        this.totalTurns++;
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
