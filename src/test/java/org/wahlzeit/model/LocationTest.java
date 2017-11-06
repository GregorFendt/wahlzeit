/*
 *  Classname: LocationTest
 *
 *  Version: 1.0 [created because of 2nd ADAP-reviews]
 *
 *  Date: 06.11.2017
 *
 */
package org.wahlzeit.model;

import org.junit.*;

import static junit.framework.TestCase.assertEquals;

/**
 * Testcases for the Location class
 */
public class LocationTest {

    @Test
    public void testSetAndGet(){
        Location loc = new Location();
        Coordinate coord = new Coordinate(1d, 1d, 1d);
        loc.setCoordinate(coord);
        assertEquals(loc.getCoordinate(), coord);
    }
}
