package com.company;

import java.awt.*;

/**
 * Create a detailed Scania truck that can lower and raise the truck bed with set parameters.
 *
 * @author Calle Bjureblad
 * @version 1.0
 * @since 1.0
 */
public class Scania extends Truck implements Movable {
    protected Coords currDir = Coords.N; // Initial direction the car is facing
    private int truckBedAngle; // The angle of the truck bed

    /**
     * Creates a Scania truck that can lower and raise the truck bed with specific number of doors, engine power, color of the car, and the model name of the vehicle.
     */
    public Scania() {
        super(2, 90, Color.blue, "Scania");
        truckBedAngle = 0;
    }

    /**
     * Returns the current truck bed angle.
     *
     * @return the truck bed angle
     */
    public int getTruckBedAngle() {
        return truckBedAngle;
    }

    /**
     * Sets the truck bed angle to + 15, if the "if statement" is not met.
     */
    @Override
    public void lowerTruckBed() {
        if ((truckBedAngle + 15) > 70 || currentSpeed != 0) return;
        truckBedAngle += 15;
    }

    /**
     * Sets the truck bed angle to - 15, if the "if statement" is not met.
     */
    @Override
    public void raiseTruckBed() {
        if ((truckBedAngle - 15) < 0 || currentSpeed != 0) return;
        truckBedAngle -= 15;
    }

    /**
     * Returns the speed factor if the truck bed angle is zero.
     *
     * @return the speed factor
     */
    @Override
    public double speedFactor() {
        if (truckBedAngle != 0) return 0.0;

        return enginePower * 0.01;
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
