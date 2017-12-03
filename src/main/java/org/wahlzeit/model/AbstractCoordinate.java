/*
 *   Classname: AbstractCoordinate
 *
 *   Version: 1.1 [8th ADAP-Homework]
 *
 *   Date: 03.12.2017
 *
 */
package org.wahlzeit.model;

/**
 * An Abstract class to represent different Coordinate classes.
 */
public abstract class AbstractCoordinate implements Coordinate {

    /**
     * Limit in which 2 doubles are still considered equal
     */
    private static final double DELTA = 1E-6;

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
     * @throws IllegalStateException if given distance ist negative
     */
    private void assertDistanceNotNegative(double distance){
        if(distance < 0){
            throw new IllegalStateException("Calculated distance mustn't be null!");
        }
    }

}
