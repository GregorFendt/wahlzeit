/*
 *   Classname: CartesianCoordinate
 *
 *   Version: 1.3 [7th ADAP-Homework]
 *
 *   Date: 25.11.2017
 *
 */
package org.wahlzeit.model;


/**
 * A cartesian coordinate to represent a location(x,y,z) in a cartesian coordinate system. x, y, z are specified in double precision
 */
public class CartesianCoordinate extends AbstractCoordinate {

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
     * lazy initialization of the CartesianCoordinate as SphericCoordinate
     */
    private SphericCoordinate sphericCoord;

    /**
     * @methodype initialization
     * Constructs and initializes a coordinate with a specified (x,y,z) location
     */
    public CartesianCoordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * @methodtype get
     * @return corresponding x coordinate
     */
    public double getX(){
        return this.x;
    }

    /**
     * @methodtype get
     * @return corresponding y coordinate
     */
    public double getY(){
        return  this.y;
    }

    /**
     * @methodtype get
     * @return corresponding z coordinate
     */
    public double getZ(){
        return this.z;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        if(sphericCoord != null){
            return sphericCoord;
        }

        initializeSphericCoordinate();
        return sphericCoord;
    }

    /**
     * initializes the spheric representation of the cartesian coordinate
     */
    private void initializeSphericCoordinate(){

        if(sphericCoord != null){
            throw new IllegalStateException("attempt to initialize SphericCoordinate twice");
        }
        double latitude = Math.asin( z / SphericCoordinate.getRadius()) * (180 / Math.PI);
        double longitude = 0;
        if( x > 0 ){
            longitude = Math.asin( y/x ) * ( 180/Math.PI );
        } else if (y > 0){
            longitude = Math.asin( y/x ) * ( 180/Math.PI ) + 180;
        } else {
            longitude = Math.asin( y/x ) * ( 180/Math.PI ) - 180;
        }

        sphericCoord = new SphericCoordinate(latitude, longitude);
    }

    public double concreteGetDistance(Coordinate coordinate){
        CartesianCoordinate cartesianCoord = (CartesianCoordinate) coordinate;
        return Math.sqrt( Math.pow(this.x - cartesianCoord.getX(), 2) + Math.pow(this.y - cartesianCoord.getY(), 2) + Math.pow(this.z - cartesianCoord.getZ(), 2));
    }


    public boolean concreteIsEqual(Coordinate coord){
        CartesianCoordinate cartesianCoordinate = coord.asCartesianCoordinate();
        if(isDoubleEqual(this.x, cartesianCoordinate.getX()) && isDoubleEqual(this.y, cartesianCoordinate.getY()) && isDoubleEqual(this.z, cartesianCoordinate.getZ())){
            return true;
        }
        return false;
    }

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

    @Override
    public int hashCode(){
        int hash = 0;
        hash += Math.floor(x * 1E6) / 1E6;
        hash += Math.floor(y * 1E6) / 1E6;
        hash += Math.floor(z * 1E6) / 1E6;
       return hash;
    }

}
