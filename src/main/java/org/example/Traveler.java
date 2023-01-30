package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Traveler {
    private int marksmanship;
    private int totalTurns = 0;
    private int milesTraveled = 0;
    private int travelHandicap = 0;
    private Map<String, Integer> supplyBalances = new HashMap<>();
    private Map<String, Boolean> booleanFlags = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public Traveler() {
        setSupplyBalances();
        setBooleanFlags();
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

    public Map<String, Integer> getSupplyBalances() {
        return supplyBalances;
    }

    public void setSupplyBalances() {
        this.supplyBalances.put("cashBalance", 700);
        this.supplyBalances.put("oxen", -1);
        this.supplyBalances.put("food", -1);
        this.supplyBalances.put("ammunition", -1);
        this.supplyBalances.put("clothing", -1);
        this.supplyBalances.put("misc", -1);
    }

    public Map<String, Boolean> getBooleanFlags() {
        return booleanFlags;
    }

    public void setBooleanFlags() {
        this.booleanFlags.put("insuffClothing", false);
        this.booleanFlags.put("clearedSouthPass", false);
        this.booleanFlags.put("clearedBlueMountains", false);
        this.booleanFlags.put("isInjured", false);
        this.booleanFlags.put("isSick", false);
        this.booleanFlags.put("inBlizzard", false);
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

    public void setSupplyBalances(Map<String, Integer> supplyBalances) {
        this.supplyBalances = supplyBalances;
    }

    public void setBooleanFlags(Map<String, Boolean> booleanFlags) {
        this.booleanFlags = booleanFlags;
    }

    public void buyInitialSupplies() {
        int cash = supplyBalances.get("cashBalance");
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

            supplyBalances.put("oxen", oxen);
        }

        System.out.println("\nCurrent cash balance: " + supplyBalances.get("cashBalance"));
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

            supplyBalances.put("food", food);
        }

        System.out.println("\nCurrent cash balance: " + supplyBalances.get("cashBalance"));
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

            supplyBalances.put("ammunition", ammunition * 50);
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

            supplyBalances.put("clothing", clothing);
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

            supplyBalances.put("misc", misc);
        }
    }

    public void buyFortSupplies() {
        int cash = supplyBalances.get("cashBalance");
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

            supplyBalances.put("food", supplyBalances.get("food") + newFood);
        }

        System.out.println("\nCurrent cash balance: " + supplyBalances.get("cashBalance"));
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

            supplyBalances.put("ammunition", supplyBalances.get("ammunition") + newAmmunition * 50);
        }

        System.out.println("\nCurrent cash balance: " + cash);
        System.out.println("How much do you want to spend on clothing? Enter between 0-" + cash);
        while (newClothing < 0 || newClothing > cash) {

            try {
                String newInput = sc.nextLine();
                newClothing = Integer.parseInt(newInput);
                if (newClothing < 0 || newClothing > supplyBalances.get("cashBalance")) {
                    throw new IllegalArgumentException("Please enter a number between 0 and " +
                            supplyBalances.get("cashBalance"));
                }
                cash -= newClothing;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            supplyBalances.put("clothing", supplyBalances.get("clothing") + newClothing);
        }

        System.out.println("\nCurrent cash balance: " + cash);
        System.out.println("How much do you want to spend on miscellaneous supplies? Enter between 0-" + cash);
        while (newMisc < 0 || newMisc > cash) {

            try {
                String newInput = sc.nextLine();
                newMisc = Integer.parseInt(newInput);
                if (newMisc < 0 || newMisc > cash) {
                    throw new IllegalArgumentException("Please enter a number between 0 and " +
                            supplyBalances.get("cashBalance"));
                }
                cash -= newMisc;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            supplyBalances.put("misc", supplyBalances.get("misc") + newMisc);
        }

        supplyBalances.put("cashBalance", cash);
    }

    public void hunt() {
        // todo implement this
    }

    public void visitDoctor(String reason) {
        if (reason.equals("illness")) {
            System.out.println("You are sick.");
            booleanFlags.replace("isSick", false);
        } else {
            System.out.println("You are injured.");
            booleanFlags.replace("isInjured", false);
        }

        supplyBalances.put("cashBalance", supplyBalances.get("cashBalance") - 20);
        System.out.println("The doctor bill will be $20.");

        if (supplyBalances.get("cashBalance") < 0) {
            System.out.println("You can't afford a doctor. You died from your " + reason + ".");
        }
    }


}
