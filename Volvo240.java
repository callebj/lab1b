package com.company;

import java.awt.*;

/**
 * Creates a Volvo240 with the extension of the Car class.
 *
 * @author Calle Bjureblad
 * @version 1.0
 * @since 1.0
 *
 */
public class Volvo240 extends Car implements Movable {
    private final static double trimFactor = 1.25; // The trim factor
    protected Coords currDir = Coords.N; // Initial direction the car is facing
//    protected int x, y = 0; // Initial starting position of the car

    /**
     * Creates a Volvo240 with parameters inherited from Car class
     */
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
    }

    /**
     * Returns the speed factor, and can be different depending on if turbo is on or off.
     *
     * @return the speed factor
     */
    @Override
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }



    /**
     * Moves the car in the current direction the car is facing, by adding the current speed to the x or y -axis.
     */
    public void move() {
        switch (currDir) {
            case N -> setXCoord(getXCoord() + getCurrentSpeed());
            case E -> setYCoord(getYCoord() + getCurrentSpeed());
            case S -> setXCoord(getXCoord() + getCurrentSpeed() * (-1));
            case W -> setYCoord(getYCoord() + getCurrentSpeed() * (-1));
        }
    }

    /**
     * Turns the car to the left from the current direction and changes the current direction to a new one.
     */
    public void turnLeft() {
        switch (currDir) {
            case N -> currDir = Coords.W;
            case E -> currDir = Coords.N;
            case S -> currDir = Coords.E;
            case W -> currDir = Coords.S;
        }
    }

    /**
     * Turns the car to the left from the current direction and changes the current direction to a new one.
     */
    public void turnRight() {
        switch (currDir) {
            case N -> currDir = Coords.E;
            case E -> currDir = Coords.S;
            case S -> currDir = Coords.W;
            case W -> currDir = Coords.N;
        }
    }
}
