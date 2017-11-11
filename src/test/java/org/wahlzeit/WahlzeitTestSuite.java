package org.wahlzeit;

import org.junit.runner.RunWith;
import  org.junit.runners.Suite;
import org.wahlzeit.handlers.HandlersTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.services.ServicesTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        UtilsTestSuite.class,
        ServicesTestSuite.class,
        ModelTestSuite.class,
        HandlersTestSuite.class

})

public class WahlzeitTestSuite {
}
