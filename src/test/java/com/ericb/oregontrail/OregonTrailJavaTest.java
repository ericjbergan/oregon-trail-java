package com.ericb.oregontrail;

import org.example.Traveler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OregonTrailJavaTest {
    @Test
    public void createTravelerSuccess() {
        Traveler traveler = new Traveler();

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
        assertFalse(traveler.isInBlizzard());
        assertFalse(traveler.ridersAreHostile());
    }


}
