/*
 *   Classname: CartesianCoordinate
 *
 *   Version: 1.5 [10th ADAP-Homework]
 *
 *   Date: 17.12.2017
 *
 */
package org.wahlzeit.model;


import com.googlecode.objectify.annotation.Subclass;

/**
 * A cartesian coordinate to represent a location(x,y,z) in a cartesian coordinate system. x, y, z are specified in double precision
 */
@Subclass
public class CartesianCoordinate extends AbstractCoordinate {

    /**
     * The X value of this coordinate
     */
    private final double x;
    /**
     * The Y value of this coordinate
     */
    private final double y;
    /**
     * The Z value of this coordinate
     */
    private final double z;

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

        assertObjectNotNull(sphericCoord);
        return sphericCoord;
    }

    /**
     * initializes the spheric representation of the cartesian coordinate
     */
    private void initializeSphericCoordinate(){
        assertSphericCoordIsNull();

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

        assertObjectNotNull(sphericCoord);
    }

    public double doGetDistance(Coordinate coordinate){
        assertObjectNotNull(coordinate);
        assertCoordinateInstanceOfCartesianCoordinate(coordinate);

        CartesianCoordinate cartesianCoord = (CartesianCoordinate) coordinate;
        double distance = Math.sqrt( Math.pow(this.x - cartesianCoord.getX(), 2) + Math.pow(this.y - cartesianCoord.getY(), 2) + Math.pow(this.z - cartesianCoord.getZ(), 2));

        assertDistanceNotNegative(distance);
        return distance;
    }


    public boolean doIsEqual(Coordinate coord){
        assertObjectNotNull(coord);

        CartesianCoordinate cartesianCoordinate = coord.asCartesianCoordinate();
        if(isDoubleEqual(this.x, cartesianCoordinate.getX()) && isDoubleEqual(this.y, cartesianCoordinate.getY()) && isDoubleEqual(this.z, cartesianCoordinate.getZ())){
            return true;
        }
        return false;
    }


    @Override
    public int hashCode(){
        int hash = 0;
        hash += Math.floor(x * 1E6) / 1E6;
        hash += Math.floor(y * 1E6) / 1E6;
        hash += Math.floor(z * 1E6) / 1E6;
       return hash;
    }

    /**
     * --------------------------------------- Assertions ---------------------------------------------
     */

    /**
     * Asserts that the given Object is not Null
     * @methodtype assertion
     * @throws CoordinateException if given Object is null
     */
    private void assertObjectNotNull(Object object){
        if(object == null){
            throw new CoordinateException("Given Object mustn't be null!");
        }
    }

    /**
     * Asserts that the given Coordinate is instanceOf CartesianCoordinate
     * @methodtype assertion
     * @throws CoordinateException if given Coordinate is not instanceOf CartesianCoordinate
     */
    private void assertCoordinateInstanceOfCartesianCoordinate(Coordinate coordinate){
        if(!(coordinate instanceof CartesianCoordinate)){
           throw new CoordinateException("Given Coordinate must be a CartesianCoordinate");
        }
    }

    /**
     * Asserts that sphericCoord is Null
     * @methodtype assertion
     * @throws CoordinateException if sphericCoord is not null
     */
    private void assertSphericCoordIsNull(){
        if(sphericCoord != null){
            throw new CoordinateException("sphericCoord musn't be initialized twice!");
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
