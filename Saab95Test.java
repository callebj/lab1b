package com.company;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    Saab95 saab = new Saab95();

    @org.junit.jupiter.api.Test
    void speedFactor() {
        saab.setTurboOff();
        assertEquals(1.25, saab.speedFactor());

        saab.setTurboOn();
        assertEquals(1.625, saab.speedFactor());

        saab.setTurboOff();
    }

    @org.junit.jupiter.api.Test
    void incrementSpeed() {
        double firstSpeed = saab.getCurrentSpeed();
        saab.incrementSpeed(100);
        assertEquals(saab.getCurrentSpeed(), (firstSpeed + saab.speedFactor() * 100));

    }

    @org.junit.jupiter.api.Test
    void decrementSpeed() {
        double firstSpeed = saab.getCurrentSpeed();
        saab.decrementSpeed(50);
        assertEquals(saab.getCurrentSpeed(), (firstSpeed - saab.speedFactor() * 50));
    }

    @org.junit.jupiter.api.Test
    void move() {
        double firstPos = saab.x;
        saab.move();
        assertEquals(saab.x, firstPos + saab.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        Movable.Coords firstDir = saab.currDir;
        saab.turnLeft();
        assertNotSame(firstDir, saab.currDir);

        saab.turnRight();
    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        Movable.Coords firstDir = saab.currDir;
        saab.turnRight();
        assertNotSame(firstDir, saab.currDir);

        saab.turnLeft();
    }
}