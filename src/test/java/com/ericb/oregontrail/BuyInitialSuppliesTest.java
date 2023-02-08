package com.ericb.oregontrail;

import ericb.oregontrail.Game;
import ericb.oregontrail.Traveler;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class BuyInitialSuppliesTest {
    Random rng = new Random();
    Scanner sc = new Scanner(System.in);
    PrintStream ps = System.out;
    Traveler traveler = new Traveler(sc);
    Game game = new Game(rng, sc, ps);

    @Test
    public void buysSuppliesSuccessfully() {

    }
}
