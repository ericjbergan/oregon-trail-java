package com.ericb.oregontrail;

import ericjbergan.oregontrail.Game;
import ericjbergan.oregontrail.Traveler;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class BuyInitialSuppliesTest {
    Random rng = new Random();
    Scanner sc = new Scanner(System.in);
    PrintStream ps = System.out;
    Traveler traveler = new Traveler(rng);
    Game game = new Game(rng, sc, ps);

    @Test
    public void buysSuppliesSuccessfully() {

    }
}
