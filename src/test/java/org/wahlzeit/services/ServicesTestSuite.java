package org.wahlzeit.services;

import org.junit.runner.RunWith;
import  org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        EmailTestSuite.class,
        LogBuilderTest.class
})

public class ServicesTestSuite {
}
