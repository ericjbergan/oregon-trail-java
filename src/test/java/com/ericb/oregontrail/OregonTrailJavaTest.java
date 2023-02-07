package com.ericb.oregontrail;

import ericb.oregontrail.Game;
import ericb.oregontrail.Traveler;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class OregonTrailJavaTest {
    Random rng = new Random();
    Scanner sc = new Scanner(System.in);
    PrintStream ps = System.out;
    Game game = new Game(rng, sc, ps);
    Traveler traveler = Game.getTraveler();

    @Test
    public void createTravelerSuccess() {
        assertEquals(traveler.getCashBalance(), 700);
        assertEquals(traveler.getOxen(), -1);
        assertEquals(traveler.getFood(), -1);
        assertEquals(traveler.getAmmunition(), -1);
        assertEquals(traveler.getClothing(), -1);
        assertEquals(traveler.getMisc(), -1);

        assertFalse(traveler.hasInsuffClothing());
        assertFalse(traveler.hasClearedSouthPass());
        assertFalse(traveler.isSouthPassSettingMileage());
        assertFalse(traveler.hasClearedBlueMountains());
        assertFalse(traveler.isInjured());
        assertFalse(traveler.isSick());
        assertFalse(traveler.inBlizzard());
        assertFalse(traveler.ridersAreHostile());
    }


}
