package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    Volvo240 volvo = new Volvo240();
    @Test
    void speedFactor() {
        assertEquals(1.25, volvo.speedFactor());
    }

    @Test
    void incrementSpeed() {
        double firstSpeed = volvo.getCurrentSpeed();
        volvo.incrementSpeed(100);
        assertEquals(volvo.getCurrentSpeed(), (Math.min(firstSpeed + volvo.speedFactor() * 100, volvo.getEnginePower())));
    }

    @Test
    void decrementSpeed() {
        double firstSpeed = volvo.getCurrentSpeed();
        volvo.decrementSpeed(50);
        assertEquals(volvo.getCurrentSpeed(), (Math.max(firstSpeed - volvo.speedFactor() * 50, 0)));
    }

    @Test
    void move() {
        double firstPos = volvo.x;
        volvo.move();
        assertEquals(volvo.x, firstPos + volvo.getCurrentSpeed());
    }

    @Test
    void turnLeft() {
        Movable.Coords firstDir = volvo.currDir;
        volvo.turnLeft();
        assertNotSame(firstDir, volvo.currDir);

        volvo.turnRight();
    }

    @Test
    void turnRight() {
        Movable.Coords firstDir = volvo.currDir;
        volvo.turnRight();
        assertNotSame(firstDir, volvo.currDir);

        volvo.turnLeft();
    }
}