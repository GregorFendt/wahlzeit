/*
 *   Classname: Coordinate
 *
 *   Version: 1.0 [6th ADAP-Homework]
 *
 *   Date: 19.11.2017
 *
 */
package org.wahlzeit.model;

/**
 * A coordinate interface to represent different kinds of coordinates
 */
public interface Coordinate {

   /**
    * @methodtype conversion
    * @return the cartesian representation of the coordinate
    */
   public CartesianCoordinate asCartesianCoordinate();

   /**
    * @methodtype comparison
    * @param coordinate Coordinate you want to compare with
    * @return the CartesianDistance between 2 Coordinates
    */
   public double getCartesianDistance(Coordinate coordinate);

   /**
    * @methodtype conversion
    * @return the spheric representation of the coordinate
    */
   public SphericCoordinate asSphericCoordinate();

   /**
    * @methodtype comparison
    * @param coordinate Coordinate you want to compare with
    * @return the SphericDistance between 2 Coordinates
    */
   public double getSphericDistance(Coordinate coordinate);

   /**
    * @methodtype comparison
    * @param coordinate Coordinate you want to compare with
    * @return the Distance between to 2 Coordinates
    */
   public double getDistance(Coordinate coordinate);

   /**
    * @methodtype comparison
    * Checks if 2 Coordinates are considered equal
    * @param coordinate the Coordinate to compare with
    * @return true if the Coordinates are considered equal, false otherwise
    */
   public boolean isEqual(Coordinate coordinate);
}
