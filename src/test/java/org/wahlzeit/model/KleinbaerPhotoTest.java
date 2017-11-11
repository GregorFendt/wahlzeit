package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Testclass of {@link KleinbaerPhoto}
 */
public class KleinbaerPhotoTest {
    private Kleinbaer testWaschbaer;
    private Kleinbaer testWickelbaer;
    private KleinbaerPhoto photo;
    @Before
    public void initialize(){
        testWaschbaer = new Kleinbaer(Kleinbaer.kleinbaerengenus.WASCHBAER);
        testWickelbaer = new Kleinbaer(Kleinbaer.kleinbaerengenus.WICKELBAER);
        photo = new KleinbaerPhoto(testWaschbaer);
    }

    @Test
    public void testGetters(){
        assertEquals(photo.getKleinbaer(), testWaschbaer);
    }

    @Test
    public void testSetters(){
        photo.setKleinbaer(testWickelbaer);
        assertEquals(photo.getKleinbaer(), testWickelbaer);
    }
}
