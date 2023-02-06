package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Creates a car workshop that can store cars and return cars.
 *
 * @author Calle Bjureblad
 * @version 1.0
 * @since 1.0
 *
 */
public class CarWorkshop<T extends Vehicle> {
    protected int maxCarsInWorkshop; // Max cars allowed in the workshop
    private final List<T> carsInWorkshop = new ArrayList<>(maxCarsInWorkshop); // The cars in the workshop

    /**
     * Sets the max amount of cars in the workshop.
     *
     * @param maxCarsInWorkshop the max amount of cars allowed in the workshop
     */
    public CarWorkshop(int maxCarsInWorkshop) {
        this.maxCarsInWorkshop = maxCarsInWorkshop;
    }

    /**
     * Loads cars into a workshop.
     *
     * @param car the car the add to the workshop
     */
    public void loadCarInWorkshop(T car) {
        carsInWorkshop.add(car);
    }

    /**
     * Removes the car from the workshop and then returns that removed car.
     *
     * @param car the car to be removed
     * @return the car that got removed
     */
    public T removeCarFromWorkshop(T car){
       return carsInWorkshop.remove(carsInWorkshop.indexOf(car));
    }

    /**
     * Testing
     */
    public void getCarsInWorkshop() {
        for (T t:carsInWorkshop) {
            System.out.println(t.toString());
        }
    }
}
