package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static junit.framework.TestCase.assertTrue;

public class KleinbaerPhotoManagerTest {

    PhotoManager manager = null;
    PhotoId id = null;
    KleinbaerPhoto photo1 = null;

    @Before
    public void initialize(){
        manager = KleinbaerPhotoManager.getInstance();
        id = new PhotoId(1);
        photo1 = new KleinbaerPhoto(id);
        try {
            manager.addPhoto(photo1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInitialize(){
        assertTrue(manager != null);
        assertTrue(manager.getPhoto(id) != null);
    }
}
