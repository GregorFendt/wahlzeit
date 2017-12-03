/*
 *   Classname: SphericCoordinate
 *
 *   Version: 1.1 [created while doing 7th ADAP-homework]
 *
 *   Date: 25.11.2017
 *
 */
package org.wahlzeit.model;


/**
 * Implementation of the CartesianCoordinate Interface as a geographic coordinate system
 */
public class SphericCoordinate extends AbstractCoordinate {

    /**
     * north-south position of a point on the Earth's surface from -90 Degrees to 90 Degrees
     */
    private double latitude;
    /**
     * east-west position of a point on the Earth's surface from -180 Degrees to 180 Degrees
     */
    private double longitude;

    private CartesianCoordinate cartesianCoord;
    /**
     * RADIUS of the earth in meters
     */
    private static final int RADIUS = 6371_000;

    /**
     * @methodtype initialization
     * Constructs and initializes a spheric coordinate
     */
    public SphericCoordinate(double latitude, double longitude){
        assertLatitude(latitude);
        assertLongitude(longitude);

        this.latitude = latitude;
        this.longitude = longitude;

        assertClassInvariants();
    }

    /**
     * @methodtype get
     * @return corresponding latitude
     */
    public double getLatitude(){
        assertClassInvariants();
        return this.latitude;
    }

    /**
     * @methodtype get
     * @return corresponding longitude
     */
    public double getLongitude(){
        assertClassInvariants();
        return this.longitude;
    }

    /**
     * @methodtype get
     * @return RADIUS of the earth
     */
    public int getRadius(){
        assertClassInvariants();
        return RADIUS;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        assertClassInvariants();

        if(cartesianCoord != null){
            return  cartesianCoord;
        }
        initializeCartesicanCoordinate();

        assertObjectNotNull(cartesianCoord);
        assertClassInvariants();
        return cartesianCoord;
    }

    private void initializeCartesicanCoordinate(){
        assertClassInvariants();
        assertCartesianCoordIsNull();

        double x = RADIUS * Math.cos(latitude) * Math.cos(longitude);
        double y = RADIUS * Math.cos(latitude) * Math.sin(longitude);
        double z = RADIUS * Math.sin(latitude);

        cartesianCoord = new CartesianCoordinate(x, y, z);

        assertObjectNotNull(cartesianCoord);
        assertClassInvariants();
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        assertClassInvariants();
        return this;
    }

    public double doGetDistance(Coordinate coord) {
        assertClassInvariants();
        assertObjectNotNull(coord);
        assertCoordinateInstanceOfSphericCoordinate(coord);

        SphericCoordinate sphericCoord = (SphericCoordinate) coord;

        double phi1 = Math.toRadians(latitude);
        double phi2 = Math.toRadians(sphericCoord.getLatitude());
        double phiDelta = Math.toRadians( sphericCoord.getLatitude()-latitude );
        double gammaDelta = Math.toRadians( sphericCoord.getLongitude()-longitude );

        double a = Math.sin(phiDelta/2) * Math.sin(phiDelta/2) +
                Math.cos(phi1) * Math.cos(phi2) *
                        Math.sin(gammaDelta/2) * Math.sin(gammaDelta/2);
        double c = Math.atan2( Math.sqrt(a), Math.sqrt(1-a));
        double distance = RADIUS * c;

        assertDistanceNotNegative(distance);
        assertClassInvariants();
        return distance;
    }

    public boolean doIsEqual(Coordinate coord) {
        assertClassInvariants();
        assertObjectNotNull(coord);

        SphericCoordinate sphericCoordinate = coord.asSphericCoordinate();
        if(isDoubleEqual(this.longitude, sphericCoordinate.longitude) && isDoubleEqual(this.latitude, sphericCoordinate.latitude)){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        assertClassInvariants();

        int hash = 0;
        hash += Math.floor(longitude * 1E6) / 1E6;
        hash += Math.floor(latitude * 1E6) / 1E6;
        hash += Math.floor(RADIUS * 1E6) / 1E6;
       return hash;
    }

    /**
     * --------------------------------------- Assertions ---------------------------------------------
     */
    /**
     * Asserts that Latitude or Longitude never reach invalid values
     * @methodtype assertion
     * @throws IllegalStateException if Latitude or Longitude are set to an invalid value
     */
     void assertClassInvariants(){
        if(Math.abs(this.latitude) > 90 || Math.abs(this.longitude) > 180){
            throw(new IllegalStateException("Latitude or Longitude of coordinate are set to an invalid value!"));
        }
    }

    /**
     * Assert that given latitude has a valid value
     * @methodtype assertion
     * @throws IllegalArgumentException if latitude is a invalid value
     */
    private void assertLatitude(double latitude){
        if(Math.abs(latitude) > 90){
            throw(new IllegalArgumentException("latitude mustn't be below -90 or above 90 Degrees"));
        }
    }

    /**
     * Assert that given longitude has a valid value
     * @methodtype assertion
     * @throws IllegalArgumentException if longitude is a invalid value
     */
    private void assertLongitude(double longitude){
        if(Math.abs(longitude) > 180){
            throw(new IllegalArgumentException("latitude mustn't be below -180 or above 180 Degrees"));
        }
    }

    /**
     * Asserts that the given Object is not Null
     * @methodtype assertion
     * @throws IllegalArgumentException if given Object is null
     */
    private void assertObjectNotNull(Object object){
        if(object == null){
            throw new IllegalStateException("Given Object mustn't be null!");
        }
    }

    /**
     * Asserts that the given Coordinate is instanceOf CartesianCoordinate
     * @methodtype assertion
     * @throws IllegalStateException if given Coordinate is not instanceOf CartesianCoordinate
     */
    private void assertCoordinateInstanceOfSphericCoordinate(Coordinate coordinate){
        if(!(coordinate instanceof SphericCoordinate)){
           throw new IllegalStateException("Given Coordinate must be a SphericCoordinate");
        }
    }

    /**
     * Asserts that cartesianCoord is Null
     * @methodtype assertion
     * @throws IllegalArgumentException if cartesianCoord is not null
     */
    private void assertCartesianCoordIsNull(){
        if(cartesianCoord != null){
            throw new IllegalStateException("cartesianCoord musn't be initialized twice!");
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
