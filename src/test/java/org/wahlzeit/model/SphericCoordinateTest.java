/*
 *  Classname: SphericCoordinateTest
 *
 *  Version: 1.0[6th ADAP-Homework]
 *
 *  Date: 19.11.2017
 *
 */

package org.wahlzeit.model;

import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class SphericCoordinateTest {

    private CartesianCoordinate coord1;
    private SphericCoordinate sphericCoordinate1;
    private SphericCoordinate sphericCoordinate2;
    private SphericCoordinate sphericCoordinate3;

    private final double DELTA = 1E-6;

    /**
     * Initialize a few coordinates and locations
     */
    @Before
    public void initialize(){
        initializeCoordinates();
    }

    public void initializeCoordinates(){
        coord1 = new CartesianCoordinate(4.0, 2.4, 99);
        sphericCoordinate1 = new SphericCoordinate(0.0, 20.2);
        sphericCoordinate2 = new SphericCoordinate(90, -180);
        sphericCoordinate3 = new SphericCoordinate(-44, 89);
    }

    @Test
    public void getterMethodTest(){
        assertEquals(sphericCoordinate1.getLatitude(), sphericCoordinate1.getLatitude());
        assertEquals(sphericCoordinate2.getLongitude(), -180.0);
        assertEquals(sphericCoordinate2.getLatitude(), sphericCoordinate2.getLatitude());
    }

    @Test
    public void getDistanceTest(){
       assertEquals(sphericCoordinate2.getDistance(sphericCoordinate1), sphericCoordinate2.getDistance(sphericCoordinate1), DELTA);
       assertEquals(sphericCoordinate3.getCartesianDistance(coord1), coord1.getCartesianDistance(sphericCoordinate3), DELTA);
       assertEquals(sphericCoordinate1.getSphericDistance(coord1), sphericCoordinate1.getSphericDistance(coord1),DELTA);
       assertEquals(sphericCoordinate2.getSphericDistance(sphericCoordinate2), sphericCoordinate2.getSphericDistance(sphericCoordinate2));
    }

    @Test
    public void asCartesianCoordinate(){
        assertEquals(sphericCoordinate2.asCartesianCoordinate(), sphericCoordinate2.asCartesianCoordinate());
        assertEquals(coord1.asCartesianCoordinate(), coord1.asCartesianCoordinate());
        assertEquals(sphericCoordinate3.asCartesianCoordinate(), sphericCoordinate3.asCartesianCoordinate());
    }

    @Test
    public void asSphericCoordinate(){
        assertEquals(sphericCoordinate3.asSphericCoordinate(), sphericCoordinate3.asSphericCoordinate());
        assertEquals(coord1.asSphericCoordinate(), coord1.asSphericCoordinate());
        assertEquals(sphericCoordinate1.asSphericCoordinate(), sphericCoordinate1.asSphericCoordinate());
    }

    @Test
    public void isEqualTest(){
        assertEquals(sphericCoordinate1.isEqual(sphericCoordinate3), sphericCoordinate2.isEqual(sphericCoordinate3));
        assertEquals(coord1.isEqual(sphericCoordinate3), coord1.isEqual(sphericCoordinate2));
    }

}
