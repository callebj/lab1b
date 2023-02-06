package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Create a detailed truck with set parameters.
 *
 * @author Calle Bjureblad
 * @version 1.0
 * @since 1.0
 */
abstract class Truck extends Vehicle {
    protected final List<Car> truckTransporterTrunk = new ArrayList<>(10); //

    protected boolean rampDown; // Ramp down or up

    /**
     * Creates a truck with specific number of doors, engine power, color of the car, and the model name of the car.
     *
     * @param nrDoors the number of doors of the car
     * @param enginePower the engine power of the car
     * @param color the color of the car
     * @param modelName the model name of the car
     */
    public Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);

        rampDown = false;
    }

    /**
     * Lowers the truck bed.
     */
    public void lowerTruckBed() {
        if (currentSpeed != 0) return;
        rampDown = true;
    }

    /**
     * Raises the truck bed.
     */
    public void raiseTruckBed() {
        rampDown = false;
    }

    /**
     * Load a car onto the truck.
     *
     * @param car the car to be loaded
     */
    public void loadCarOnTruck(Car car) {
        if (!rampDown) return;
        if (car.getXCoord() > (getXCoord() + 5) && car.getYCoord() > (getYCoord() + 5)) return;

        truckTransporterTrunk.add(car);
    }

    /**
     * Removes the last car from the truck bed.
     *
     * @return the removed car from the truck
     */
    public Car removeCarFromTruck() {
        if (!rampDown) return null;

        int lastCarIndex = truckTransporterTrunk.size() - 1;

        Car lastCar = truckTransporterTrunk.get(lastCarIndex);
        lastCar.setXCoord(getXCoord() - 5);
        lastCar.setYCoord(getYCoord());

        return truckTransporterTrunk.remove(lastCarIndex);
    }

    public void test(){
        for (Car car : truckTransporterTrunk) {
            System.out.println(car);
        }
    }
}
