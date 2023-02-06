package com.company;

/**
 * Movable is used to move the car on an X and Y axis.
 *
 * @see Volvo240
 * @see Saab95
 */
public interface Movable {
   /**
    * Contains the compass directions: North, East, South, and West.
    * Used to move the car in different directions.
    */
   public enum Coords {N, E, S, W};

   /**
    * Moves the car in the current direction the car is facing.
    */
   void move();

   /**
    * Turns the car to the left from the current direction.
    */
   void turnLeft();

   /**
    * Turns the car the right from the current direction.
    */
   void turnRight();

}
