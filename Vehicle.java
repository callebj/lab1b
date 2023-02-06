package com.company;

import java.awt.*;

/**
 * Create a detailed vehicle with set parameters
 *
 * @author Calle Bjureblad
 * @version 1.0
 * @since 1.0
 * @see Car
 */
abstract class Vehicle {
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected double x,y;
    protected String modelName; // The car model name
    protected int nrDoors; // Number of doors on the car

    /**
     * Creates a vehicle with specific number of doors, engine power, color of the car, and the model name of the vehicle.
     *
     * @param nrDoors the number of doors of the car
     * @param enginePower the engine power of the car
     * @param color the color of the car
     * @param modelName the model name of the car
     */
    public Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = 0;
        this.y = 0;

        stopEngine();
    }

    /**
     * Returns the number of doors the car.
     *
     * @return the amount of doors the car has
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returns the engine power the car.
     *
     * @return the amount of engine power the car has
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Returns the current speed the car.
     *
     * @return the current speed of the car
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Returns the current color of the car.
     *
     * @return the color of the car
     */
    public Color getColor(){
        return color;
    }

    /**
     * Returns the x position of a vehicle.
     *
     * @return the x coordinate of the vehicle
     */
    public double getXCoord() {
        return x;
    }

    /**
     * Returns the y position of a vehicle.
     *
     * @return the y coordinate of the vehicle
     */
    public double getYCoord() {
        return y;
    }

    /**
     * Sets a new x value of the car.
     *
     * @param _x the new x value
     */
    public void setXCoord(double _x) {
        x = _x;
    }

    /**
     * Sets the new y value of the car.
     *
     * @param _y the new y value
     */
    public void setYCoord(double _y) {
        y = _y;
    }

    /**
     * Sets a new color for the car.
     *
     * @param clr the new color of the car
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Sets the current speed to 0.1.
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets the current speed to 0.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Returns the speed factor that is used to accelerate and decelerate the car.
     *
     * @return the speed factor
     */
    public double speedFactor() {
        return enginePower * 0.01;
    };

    /**
     * Sets the current speed of th car to a new value, the method ONLY increases the speed.
     *
     * @param amount the amount the car should increase speed by
     */
    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * Sets the current speed of the car to a new value, the method ONLY decreases the speed.
     *
     * @param amount the amount the car should decrease speed by
     */
    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    /**
     * Increments the speed by a set amount.
     * Amount is only between 1 and 0.
     *
     * @param amount the amount to increase the speed of the car
     */
    public void gas(double amount){
        if (amount > 1 || amount < 0) return;
        //if (getCurrentSpeed() < 0 || getCurrentSpeed() > getEnginePower()) return;

        double initSpeed = getCurrentSpeed();
        incrementSpeed(amount);

        if (initSpeed > getCurrentSpeed() || getCurrentSpeed() > getEnginePower()) {
            currentSpeed = initSpeed;
        }
    }

    /**
     * Decrements the speed by a set amount.
     * Amount is only between 1 and 0.
     *
     * @param amount the amount to decrease the speed of the car
     */
    public void brake(double amount){
        if (amount > 1 || amount < 0) return;

        double initSpeed = getCurrentSpeed();
        decrementSpeed(amount);

        if (initSpeed <= getCurrentSpeed() || getCurrentSpeed() <= 0) {
            currentSpeed = 0;
        }
    }
}
