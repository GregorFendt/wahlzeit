/*
 *  Classname: CartesianCoordinateTest
 *
 *  Version: 1.2[6th ADAP-Homework]
 *
 *  Date: 19.11.2017
 *
 */

package org.wahlzeit.model;

import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Testcases for the CartesianCoordinate class
 */
public class CartesianCoordinateTest {

    private CartesianCoordinate coord1;
    private CartesianCoordinate coord2;
    private CartesianCoordinate coord3;
    private SphericCoordinate sphericCoordinate;

    private final double DELTA = 1E-6;

    /**
     * Initialize a few coordinates and locations
     */
    @Before
    public void initialize(){
        initializeCoordinates();
    }

    public void initializeCoordinates(){

        coord1 = new CartesianCoordinate(0.0, 0.0, 0.0);
        coord2 = new CartesianCoordinate(10.0, 20.2, 45.0);
        coord3 = new CartesianCoordinate(-1.1, 13.5, 4.99);
        sphericCoordinate = new SphericCoordinate(60, 50);
    }

    /**
     * Test the getterMethods of the CartesianCoordinate class
     */
    @Test
    public void getterMethodsTest(){
        assertEquals(coord1.getZ(), 0.0);
        assertEquals(coord2.getX(), 10.0);
        assertEquals(coord2.getX(), 10.0);
        assertEquals(coord2.getY(), 20.2);
        assertEquals(coord2.getZ(), 45.0);
        assertEquals(coord3.getX(), -1.1);
        assertEquals(coord3.getY(), 13.5);
        assertEquals(coord3.getZ(), 4.99);
    }

    /**
     * Test the getDistance method of the CartesianCoordinate class
     */
    @Test
    public void getCartesianDistanceTest(){

        double dist1to2 = coord1.getDistance(coord2);
        double dist1to1 = coord1.getDistance(coord1);
        double dist2to3 = coord2.getCartesianDistance(coord3);
        double dist3to2 = coord3.getCartesianDistance(coord2);

        assertEquals(dist1to2, 50.3293, DELTA);
        assertEquals(dist1to1, 0.0, DELTA);
        assertEquals(dist2to3, dist3to2, DELTA);
    }

    /**
     * Test the isEqual method of the CartesianCoordinate class
     */
    @Test
    public void isEqualTest(){
        assertTrue(coord1.isEqual(new CartesianCoordinate(0.0, 0.0, 0.0)));
        assertTrue(coord2.isEqual(new CartesianCoordinate(10.0, 20.2, 45.0)));
        assertTrue(coord3.isEqual(new CartesianCoordinate(-1.1, 13.5, 4.99)));
        assertFalse(coord1.equals(null));
        assertFalse(coord1.isEqual(null));
    }

    @Test
    public void asCartesianCoordinateTest(){
        assertEquals(coord1.asCartesianCoordinate(), coord1.asCartesianCoordinate());
        assertEquals(coord2.asCartesianCoordinate().getX(), 10.0, DELTA);
    }

    @Test
    public void asSphericCoordinateTest(){
        assertEquals(coord2.asSphericCoordinate(), coord2.asSphericCoordinate());
        assertEquals(coord3.asSphericCoordinate(), coord3.asSphericCoordinate());
        assertEquals(coord3.asSphericCoordinate().getLatitude(), coord3.asSphericCoordinate().getLatitude(), DELTA);
    }

    @Test
    public void getSphericDistanceTest(){
        assertEquals(coord1.getSphericDistance(coord2), coord2.getSphericDistance(coord1), DELTA);
        assertEquals(coord3.getSphericDistance(coord1), coord3.getSphericDistance(coord1), DELTA);
    }

}
