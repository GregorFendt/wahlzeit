/*
 *  Classname: LocationCoordinateTest
 *
 *  Version: 1.0 [created because of 2nd ADAP-homework]
 *
 *  Date: 30.10.2017
 *
 */

package org.wahlzeit.services;

import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Testcases for the Location and Coordinate classes
 */
public class LocationCoordinateTest {

    private Location loc1;
    private Location loc2;
    private Coordinate coord1;
    private Coordinate coord2;
    private Coordinate coord3;

    /**
     * Initialize a few coordinates and locations
     */
    @Before
    public void initialize(){
        initializeCoordinates();
        initializeLocations();
    }

    public void initializeCoordinates(){

        coord1 = new Coordinate(0.0, 0.0, 0.0);
        coord2 = new Coordinate(10.0, 20.2, 45.0);
        coord3 = new Coordinate(-1.1, 13.5, 4.99);
    }

    public void initializeLocations(){
        loc1 = new Location();
        loc2 = new Location();
    }

    /**
     * Test the getterMethods of the Coordinate class
     */
    @Test
    public void getterMethodsTest(){

        loc1.coordinate = coord1;
        assertEquals(loc1.coordinate.getZ(), 0.0);
        loc2.coordinate = coord2;
        assertEquals(loc2.coordinate.getX(), 10.0);
        assertEquals(coord2.getX(), 10.0);
        assertEquals(coord2.getY(), 20.2);
        assertEquals(coord2.getZ(), 45.0);
        assertEquals(coord3.getX(), -1.1);
        assertEquals(coord3.getY(), 13.5);
        assertEquals(coord3.getZ(), 4.99);
    }

    /**
     * Test the getDistance method of the Coordinate class
     */
    @Test
    public void getDistanceTest(){

        double dist1to2 = coord1.getDistance(coord2);
        double dist1to1 = coord1.getDistance(coord1);
        double dist2to3 = coord2.getDistance(coord3);
        double dist3to2 = coord3.getDistance(coord2);

        assertEquals(dist1to2, 50.3293, 0.000_001);
        assertEquals(dist1to1, 0.0);
        assertEquals(dist2to3, dist3to2, 0.000_001);
    }

    /**
     * Test the isEqual method of the Coordinate class
     */
    @Test
    public void isEqualTest(){
        assertTrue(coord1.isEqual(new Coordinate(0.0, 0.0, 0.0)));
        assertTrue(coord2.isEqual(new Coordinate(10.0, 20.2, 45.0)));
        assertTrue(coord3.isEqual(new Coordinate(-1.1, 13.5, 4.99)));
    }
}
