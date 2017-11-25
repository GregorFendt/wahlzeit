/*
 *   Classname: Location
 *
 *   Version: 1.1 [update 2nd ADAP-reviews]
 *
 *   Date: 06.11.2017
 *
 */
package org.wahlzeit.model;

/**
 * Location class which is bound to a specific CartesianCoordinate
 */
public class Location {

    /**
     * Specific coordinate of the location
     */
    private Coordinate coordinate;

    /**
     * @methodtype get
     * Getter method for the CartesianCoordinate-class of Location
     * @return CartesianCoordinate class or Null if not set
     */
    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    /**
     * @methodtype set
     * Setter method for the CartesianCoordinate-class of Location
     * @param coord CartesianCoordinate to be set for Location
     */
    public void setCoordinate(Coordinate coord){
        coordinate = coord;
    }

}
