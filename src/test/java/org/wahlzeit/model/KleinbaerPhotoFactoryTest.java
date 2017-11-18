package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KleinbaerPhotoFactoryTest {

    KleinbaerPhotoFactory instance = null;
    PhotoId id = null;
    KleinbaerPhoto photo1 = null;

    @Before
    public void initialize(){
        instance = KleinbaerPhotoFactory.getInstance();
        id = new PhotoId(0);
        photo1 = instance.createPhoto(id);
    }

    @Test
    public void testInitialization(){
        assertTrue(instance != null);
        assertTrue(id != null);
        assertTrue(photo1 != null);
    }
}
