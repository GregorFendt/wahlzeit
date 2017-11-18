package org.wahlzeit.model;

import org.junit.*;

import static junit.framework.TestCase.assertEquals;

/**
 * Testclass for Kleinbaer.java
 */
public class KleinbaerTest {

    private Kleinbaer testWaschbaer;
    private Kleinbaer testMakibaer;
    private Kleinbaer testWickelbaer;
    private Kleinbaer testKatzenfrett;

    @Before
    public void initializeTestSetup(){
        testWaschbaer = new Kleinbaer(Kleinbaer.kleinbaerengenus.WASCHBAER);
        testKatzenfrett = new Kleinbaer(Kleinbaer.kleinbaerengenus.KATZENFRETT);
        testMakibaer = new Kleinbaer(Kleinbaer.kleinbaerengenus.MAKIBAER);
        testWickelbaer = new Kleinbaer(Kleinbaer.kleinbaerengenus.WICKELBAER);
    }

    @Test
    public void testGetters(){
        assertEquals(testWickelbaer.getSCIENTIFIC_NAME(), "Procyonidae");
        assertEquals(testKatzenfrett.getGenus(), Kleinbaer.kleinbaerengenus.KATZENFRETT);
        assertEquals(testMakibaer.getNumberOfTeeth(), 40);
        assertEquals(testWickelbaer.getNumberOfTeeth(), 36);
        assertEquals(testWaschbaer.getMaxWeight(), 12_000);
        assertEquals(testKatzenfrett.getMaxWeight(), 1_300);
        assertEquals(testWaschbaer.getMaxSnoutVentLength(), 60);
        assertEquals(testMakibaer.getMaxTailLength(), 48);
    }

    @Test
    public void testSetter(){
        testWickelbaer.setGenus(Kleinbaer.kleinbaerengenus.WASCHBAER);
        assertEquals(testWickelbaer.getMaxWeight(), 12_000);
        assertEquals(testWickelbaer.getNumberOfTeeth(), 40);

        testWickelbaer.setNumberOfTeeth(3);
        assertEquals(testWickelbaer.getNumberOfTeeth(), 3);
        testWickelbaer.setGenus(Kleinbaer.kleinbaerengenus.WICKELBAER);
        assertEquals(testWickelbaer.getMaxTailLength(), 55);

    }
}
