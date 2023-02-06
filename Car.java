package com.company;

import java.awt.*;

/**
 * Create a detailed car with set parameters
 *
 * @author Calle Bjureblad
 * @version 1.0
 * @since 1.0
 * @see Saab95
 * @see Volvo240
 */
abstract class Car extends Vehicle {
    /**
     * Creates a car with specific number of doors, engine power, color of the car, and the model name of the car.
     *
     * @param nrDoors the number of doors of the car
     * @param enginePower the engine power of the car
     * @param color the color of the car
     * @param modelName the model name of the car
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
       super(nrDoors, enginePower, color, modelName);
    }



}
