/*
 *   Classname: Coordinate
 *
 *   Version: 1.0 [created because of the 2nd ADAP-homework]
 *
 *   Date: 29.10.2017
 *
 */
package org.wahlzeit.services;


/**
 * A coordinate to represent a location(x,y,z) in a cartesian coordinate system. x, y, z are specified in double precision
 */
public class Coordinate {

    /**
     * Constructs and initializes a coordinate with a specified (x,y,z) location
     */
    public Coordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * The X value of this coordinate
     */
    private double x;
    /**
     * The Y value of this coordinate
     */
    private double y;
    /**
     * The Z value of this coordinate
     */
    private double z;

    /**
     * Getter Method for x
     * @return corresponding x coordinate
     */
    public double getX(){
        return this.x;
    }

    /**
     * Getter Method for y
     * @return corresponding y coordinate
     */
    public double getY(){
        return  this.y;
    }

    /**
     * Getter Method for z
     * @return corresponding z coordinate
     */
    public double getZ(){
        return this.z;
    }

    /**
     * Calculates direct distance between this and the given Coordinate in double precision
     * @param coord reference Coordinate with which the direct distance is calculated of
     * @return the direct distance between the 2 Coordinate-classes in double precision
     */
    public double getDistance(Coordinate coord){
        return Math.sqrt( Math.pow(this.x - coord.getX(), 2) + Math.pow(this.y - coord.getY(), 2) + Math.pow(this.z - coord.getZ(), 2));
    }


    /**
     * Checks if the 3 coordinates(x,y,z) are the same for both Coordinate classes
     * @param coord reference Coordinate with which to compare
     * @return true if both Coordinate-classes are the same in all 3 coordinates, false otherwise
     */
    public boolean isEqual(Coordinate coord){

        if(this. x == coord.getX() && this.y == coord.getY() && this.z == coord.getZ()){
            return true;
        }
        return false;
    }

    /**
    * Checks if the 3 coordinates(x,y,z) are the same for both Coordinate classes
    * @param coord reference Coordinate with which to compare
    * @return true if both Coordinate-classes are the same in all 3 coordinates, false otherwise
    */
    public boolean equals(Coordinate coord){
        return this.isEqual(coord);
    }

}
