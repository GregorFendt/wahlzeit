/*
 *   Classname: Location
 *
 *   Version: 1.2 [10th ADAP homework]
 *
 *   Date: 17.12.2017
 *
 */
package org.wahlzeit.model;

/**
 * Location class which is bound to a specific Coordinate
 */
public class Location {

    /**
     * Specific coordinate of the location
     */
    private Coordinate coordinate;

    /**
     * @methodtype get
     * Getter method for the Coordinate-class of Location
     * @return Coordinate class or Null if not set
     */
    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    /**
     * @methodtype set
     * Setter method for the Coordinate-class of Location
     * @param coord Coordinate to be set for Location
     */
    public void setCoordinate(Coordinate coord){
        coordinate = coord;
    }

}
