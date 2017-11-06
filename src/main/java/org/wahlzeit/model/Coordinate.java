/*
 *   Classname: Coordinate
 *
 *   Version: 1.1 [update 2nd ADAP-reviews]
 *
 *   Date: 06.11.2017
 *
 */
package org.wahlzeit.model;


/**
 * A coordinate to represent a location(x,y,z) in a cartesian coordinate system. x, y, z are specified in double precision
 */
public class Coordinate {

    /**
     * Limit in which 2 doubles are still considered equal
     */
    private static final double DELTA = 1E-6;

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
     * Constructs and initializes a coordinate with a specified (x,y,z) location
     */
    public Coordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

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
     * Checks if the 3 coordinates(x,y,z) are exactly! the same for both Coordinate classes
     * @param coord reference Coordinate with which to compare
     * @return true if both Coordinate-classes are the same in all 3 coordinates, false otherwise
     */
    public boolean isEqual(Coordinate coord){

        if(coord == null) {
            return false;
        }

        if(isDoubleEqual(this.x, coord.getX()) && isDoubleEqual(this.y, coord.getY()) && isDoubleEqual(this.z, coord.getZ())){
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null && !(obj instanceof Coordinate)){
            return false;
        }
        return this.isEqual((Coordinate) obj);
    }

    /**
     * Helpermethod to check if 2 doubles are equal
     * @param x double
     * @param y double
     * @return true if both doubles are considered equal
     */
    public boolean isDoubleEqual(double x, double y){
        return Math.abs(x - y) <= DELTA;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += Math.floor(x * 1E6) / 1E6;
        hash += Math.floor(y * 1E6) / 1E6;
        hash += Math.floor(z * 1E6) / 1E6;
       return hash;
    }

}
