package org.wahlzeit.services;

import org.junit.runner.RunWith;
import  org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        EmailSuite.class,
        LogBuilderTest.class
})

public class servicesSuite {
}
