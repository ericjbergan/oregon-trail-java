package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Traveler {
    private int marksmanship;
    private int milesTraveled = 0;
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
        this.booleanFlags.put("hasInjury", false);
        this.booleanFlags.put("hasIllness", false);
        this.booleanFlags.put("inBlizzard", false);
    }

    public void buyInitialSupplies() {
        int oxen = -1;
        int food = -1;
        int ammunition = -1;
        int clothing = -1;
        int misc = -1;

        System.out.println("\nCurrent cash balance: " + supplyBalances.get("cashBalance"));
        System.out.println("How much do you want to spend on food? Enter between 0-" +
                supplyBalances.get("cashBalance"));

        while (oxen < 200 || oxen > 300) {
            System.out.println("\nCurrent cash balance: " + supplyBalances.get("cashBalance"));
            System.out.println("\nHow much do you want to spend on your oxen team? Enter between 200-300.");

            try {
                String newInput = sc.nextLine();
                oxen = Integer.parseInt(newInput);
                if (oxen < 200 || oxen > 300) {
                    throw new IllegalArgumentException("Please enter a number between 200 and 300...");
                }
                supplyBalances.put("oxen", oxen);
                supplyBalances.put("cashBalance", supplyBalances.get("cashBalance") - oxen);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (food < 0 || food > supplyBalances.get("cashBalance")) {
            System.out.println("\nCurrent cash balance: " + supplyBalances.get("cashBalance"));
            System.out.println("\nHow much do you want to spend on your food? Enter between 0- " +
                    supplyBalances.get("cashBalance"));

            try {
                String newInput = sc.nextLine();
                food = Integer.parseInt(newInput);
                if (food < 0 || food > supplyBalances.get("cashBalance")) {
                    throw new IllegalArgumentException("Please enter a number between 0 and " +
                            supplyBalances.get("cashBalance"));
                }
                supplyBalances.put("food", food);
                supplyBalances.put("cashBalance", supplyBalances.get("cashBalance") - food);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            supplyBalances.put("food", food);
        }


        while (ammunition < 0 || ammunition > supplyBalances.get("cashBalance")) {
            System.out.println("\nCurrent cash balance: " + supplyBalances.get("cashBalance"));
            System.out.println("How much do you want to spend on ammunition? Enter between 0-" +
                    supplyBalances.get("cashBalance") + ". Remember, each dollar spent buys 50 bullets.");

            try {
                String newInput = sc.nextLine();
                ammunition = Integer.parseInt(newInput);
                if (ammunition < 0 || ammunition > supplyBalances.get("cashBalance")) {
                    throw new IllegalArgumentException("Please enter a number between 0 and " +
                            supplyBalances.get("cashBalance"));
                }
                supplyBalances.put("ammunition", ammunition);
                supplyBalances.put("cashBalance", supplyBalances.get("cashBalance") - ammunition);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            supplyBalances.put("ammunition", ammunition * 50);
        }

        while (clothing < 0 || clothing > supplyBalances.get("cashBalance")) {
            System.out.println("\nCurrent cash balance: " + supplyBalances.get("cashBalance"));
            System.out.println("How much do you want to spend on clothing? Enter between 0-" +
                    supplyBalances.get("cashBalance"));

            try {
                String newInput = sc.nextLine();
                clothing = Integer.parseInt(newInput);
                if (clothing < 0 || clothing > supplyBalances.get("cashBalance")) {
                    throw new IllegalArgumentException("Please enter a number between 0 and " +
                            supplyBalances.get("cashBalance"));
                }
                supplyBalances.put("clothing", clothing);
                supplyBalances.put("cashBalance", supplyBalances.get("cashBalance") - clothing);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            supplyBalances.put("clothing", clothing);
        }

        while (misc < 0 || misc > supplyBalances.get("cashBalance")) {
            System.out.println("\nCurrent cash balance: " + supplyBalances.get("cashBalance"));
            System.out.println("How much do you want to spend on miscellaneous supplies? Enter between 0-" +
                    supplyBalances.get("cashBalance"));

            try {
                String newInput = sc.nextLine();
                misc = Integer.parseInt(newInput);
                if (misc < 0 || misc > supplyBalances.get("cashBalance")) {
                    throw new IllegalArgumentException("Please enter a number between 0 and " +
                            supplyBalances.get("cashBalance"));
                }
                supplyBalances.put("misc", misc);
                supplyBalances.put("cashBalance", supplyBalances.get("cashBalance") - misc);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            supplyBalances.put("misc", misc);
        }
    }

    public void buyFortSupplies() {

    }

    public void hunt() {

    }

}
