package org.wahlzeit;

import org.junit.runner.RunWith;
import  org.junit.runners.Suite;
import org.wahlzeit.handlers.handlersSuite;
import org.wahlzeit.model.modelSuite;
import org.wahlzeit.services.servicesSuite;
import org.wahlzeit.utils.utilsSuite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        utilsSuite.class,
        servicesSuite.class,
        modelSuite.class,
        handlersSuite.class

})

public class wahlzeitSuite {
}
