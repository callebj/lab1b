package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {
    Scania scania = new Scania();
    @Test
    void lowerTruckBed() {
        int initAngle = scania.getTruckBedAngle();
        scania.lowerTruckBed();
        assertEquals(scania.getTruckBedAngle(), initAngle + 15);
    }

    @Test
    void raiseTruckBed() {
        int initAngle = scania.getTruckBedAngle();
        scania.raiseTruckBed();
        assertEquals(scania.getTruckBedAngle(), initAngle);
    }
}