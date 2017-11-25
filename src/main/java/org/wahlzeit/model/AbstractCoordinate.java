/*
 *   Classname: AbstractCoordinate
 *
 *   Version: 1.0 [7th ADAP-Homework]
 *
 *   Date: 25.11.2017
 *
 */
package org.wahlzeit.model;

/**
 * An Abstract class to represent different Coordinate classes.
 */
public abstract class AbstractCoordinate implements Coordinate {

   /**
    * @methodtype comparison
    * @param coordinate Coordinate you want to compare with
    * @return the Distance between to 2 Coordinates
    */
   @Override
   public final double getDistance(Coordinate coordinate){
       if(coordinate == null){
           throw new IllegalArgumentException("Given Coordinate must not benull");
       }
       return this.concreteGetDistance(coordinate);
   }

    /**
     * @methodtype comparison
     * @param coordinate Coordinate you want to compare with
     * @return the Cartesian distance between 2 Coordinates
     */
   @Override
   public final double getCartesianDistance(Coordinate coordinate){
       return this.asCartesianCoordinate().getDistance(coordinate.asSphericCoordinate());
   }

    /**
     * @methodtype comparison
     * @param coordinate Coordinate you want to compare with
     * @return the Spheric distance between 2 Coordinates
     */
   @Override
   public final double getSphericDistance(Coordinate coordinate){
       return this.asSphericCoordinate().getDistance(coordinate.asCartesianCoordinate());
   }

   protected abstract double concreteGetDistance(Coordinate coordinate);

   /**
    * @methodtype comparison
    * Checks if 2 Coordinates are considered equal
    * @param coordinate the CartesianCoordinate to compare with
    * @return true if the Coordinates are considered equal, false otherwise
    */
   @Override
   public boolean isEqual(Coordinate coordinate){
      if(coordinate == null){
         return false;
      }
      return this.concreteIsEqual(coordinate);
   }

    @Override
    public boolean equals(Object obj){
        if(obj == null && !(obj instanceof Coordinate)){
            return false;
        }
        return this.isEqual((Coordinate) obj);
    }

    protected abstract boolean concreteIsEqual(Coordinate coordinate);

}
