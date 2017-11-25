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
     * Limit in which 2 doubles are still considered equal
     */
    private static final double DELTA = 1E-6;
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
        if(Math.abs(latitude) > 90 || Math.abs(longitude) > 180){
            throw(new IllegalArgumentException());
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * @methodtype get
     * @return corresponding latitude
     */
    public double getLatitude(){
        return this.latitude;
    }

    /**
     * @methodtype get
     * @return corresponding longitude
     */
    public double getLongitude(){
        return this.longitude;
    }

    /**
     * @methodtype get
     * @return RADIUS of the earth
     */
    public static int getRadius(){
        return RADIUS;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        if(cartesianCoord != null){
            return  cartesianCoord;
        }

        initializeCartesicanCoordinate();
        return cartesianCoord;
    }

    private void initializeCartesicanCoordinate(){

        if(cartesianCoord != null){
            throw new IllegalStateException("attempt to initialize CartesianCoordinate twice");
        }

        double x = RADIUS * Math.cos(latitude) * Math.cos(longitude);
        double y = RADIUS * Math.cos(latitude) * Math.sin(longitude);
        double z = RADIUS * Math.sin(latitude);

        cartesianCoord = new CartesianCoordinate(x, y, z);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    public double concreteGetDistance(Coordinate coord) {

        SphericCoordinate sphericCoord = (SphericCoordinate) coord;

        double phi1 = Math.toRadians(latitude);
        double phi2 = Math.toRadians(sphericCoord.getLatitude());
        double phiDelta = Math.toRadians( sphericCoord.getLatitude()-latitude );
        double gammaDelta = Math.toRadians( sphericCoord.getLongitude()-longitude );

        double a = Math.sin(phiDelta/2) * Math.sin(phiDelta/2) +
                Math.cos(phi1) * Math.cos(phi2) *
                        Math.sin(gammaDelta/2) * Math.sin(gammaDelta/2);
        double c = Math.atan2( Math.sqrt(a), Math.sqrt(1-a));

        return RADIUS * c;
    }

    public boolean concreteIsEqual(Coordinate coord) {
        SphericCoordinate sphericCoordinate = coord.asSphericCoordinate();
        if(isDoubleEqual(this.longitude, sphericCoordinate.longitude) && isDoubleEqual(this.latitude, sphericCoordinate.latitude)){
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
        hash += Math.floor(longitude * 1E6) / 1E6;
        hash += Math.floor(latitude * 1E6) / 1E6;
        hash += Math.floor(RADIUS * 1E6) / 1E6;
       return hash;
    }

}
