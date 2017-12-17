/*
 *   Classname: AbstractCoordinate
 *
 *   Version: 1.2 [10th ADAP-Homework]
 *
 *   Date: 17.12.2017
 *
 */
package org.wahlzeit.model;


import java.util.HashMap;

/**
 * An Abstract class to represent different Coordinate classes.
 */
public abstract class AbstractCoordinate implements Coordinate {

    /**
     * Limit in which 2 doubles are still considered equal
     */
    private static final double DELTA = 1E-6;

    /**
     * HashSet of all Coordinates to guarantee uniqueness
     */
    public static final HashMap<Integer, CartesianCoordinate> allCoordinates = new HashMap<>();

    /**
     * generates the hashkey using the attributes from CartesianCoordinate for the HashMap "allCoordinates"
     */
    public static final int generateHashkeyCartesian(double x, double y, double z){
        int hash = 0;
        hash += Math.floor(x * 1E6) / 1E6;
        hash += Math.floor(y * 1E6) / 1E6;
        hash += Math.floor(z * 1E6) / 1E6;
       return hash;
    }

    /**
     * generates the hashkey using the attributes from SphericCoordinate for the HashMap "allCoordinates"
     */
    public static final int generateHashKeySpheric(double latitude, double longitude, int radius){

        double x = radius * Math.cos(latitude) * Math.cos(longitude);
        double y = radius * Math.cos(latitude) * Math.sin(longitude);
        double z = radius * Math.sin(latitude);
        return generateHashkeyCartesian(x, y, z);
    }

    /**
     * @methodtype comparison
     * @param coordinate Coordinate you want to compare with
     * @return the Distance between to 2 Coordinates
     */
    @Override
    public final double getDistance(Coordinate coordinate){
        assertObjectNotNull(coordinate);

        double distance = this.getCartesianDistance(coordinate);

        assertDistanceNotNegative(distance);
        return  distance;
    }

    /**
     * @methodtype comparison
     * @param coordinate Coordinate you want to compare with
     * @return the Cartesian distance between 2 Coordinates
     */
    @Override
    public final double getCartesianDistance(Coordinate coordinate){
        assertObjectNotNull(coordinate);

        double distance = this.asCartesianCoordinate().doGetDistance(coordinate.asCartesianCoordinate());

        assertDistanceNotNegative(distance);
        return distance;
    }

    /**
     * @methodtype comparison
     * @param coordinate Coordinate you want to compare with
     * @return the Spheric distance between 2 Coordinates
     */
    @Override
    public final double getSphericDistance(Coordinate coordinate){
        assertObjectNotNull(coordinate);

        double distance = this.asSphericCoordinate().doGetDistance(coordinate.asSphericCoordinate());

        assertDistanceNotNegative(distance);
        return distance;
    }

    protected abstract double doGetDistance(Coordinate coordinate);

    /**
     * @methodtype comparison
     * Checks if 2 Coordinates are considered equal
     * @param coordinate the CartesianCoordinate to compare with
     * @return true if the Coordinates are considered equal, false otherwise
     */
    @Override
    public boolean isEqual(Coordinate coordinate){
        assertObjectNotNull(coordinate);

        return this.doIsEqual(coordinate);
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null && !(obj instanceof Coordinate)){
            return false;
        }
        return this.isEqual((Coordinate) obj);
    }

    protected abstract boolean doIsEqual(Coordinate coordinate);

    @Override
    public abstract int hashCode();

    /**
     * @methodtype comparison
     * Helpermethod to check if 2 doubles are equal
     * @param x double
     * @param y double
     * @return true if both doubles are considered equal
     */
    public boolean isDoubleEqual(double x, double y){
        return Math.abs(x - y) <= DELTA;
    }

    /**
     * ------------------------ Assertions ------------------------
     */
    /**
     * Asserts that the given Object is not Null
     * @methodtype assertion
     * @throws IllegalArgumentException if given Object is null
     */
    private void assertObjectNotNull(Object object){
        if(object == null){
            throw new IllegalArgumentException("Given Argument mustn't be null!");
        }
    }

    /**
     * Asserts that the given double is not negative
     * @methodtype assertion
     * @throws CoordinateException if given distance ist negative
     */
    private void assertDistanceNotNegative(double distance){
        if(distance < 0){
            throw new CoordinateException("Calculated distance mustn't be null!");
        }
    }

}
