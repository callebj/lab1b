package com.company;

import java.awt.*;

/**
 * Create a detailed truck that can transport cargo with set parameters.
 *
 * @author Calle Bjureblad
 * @version 1.0
 * @since 1.0
 */
public class TruckTransporter extends Truck implements Movable {
    protected Coords currDir = Coords.N; // Initial direction the car is facing

    /**
     * Creates a truck that can transport cars with specific number of doors, engine power, color of the car, and the model name of the vehicle.
     */
    public TruckTransporter(){
        super(2, 100, Color.darkGray, "Truck123");
    }

    /**
     * Moves the car in the current direction the car is facing, by adding the current speed to the x or y-axis.
     * And sets the coordinate for all the cars in the trunk to the coordinates as the truck.
     */
    public void move() {
        for (Car car : truckTransporterTrunk) {
            car.setXCoord(this.getXCoord());
            car.setYCoord(this.getYCoord());
        }

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
