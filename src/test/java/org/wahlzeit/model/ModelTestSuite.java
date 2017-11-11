package org.wahlzeit.model;

import org.junit.runner.RunWith;
import  org.junit.runners.Suite;
import org.wahlzeit.model.persistence.AbstractAdapterTest;
import org.wahlzeit.model.persistence.DatastoreAdapterTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        //AbstractAdapterTest.class,
        DatastoreAdapterTest.class,
        AccessRightsTest.class,
        CoordinateTest.class,
        FlagReasonTest.class,
        GenderTest.class,
        GuestTest.class,
        LocationTest.class,
        PhotoFilterTest.class,
        TagsTest.class,
        UserStatusTest.class,
        ValueTest.class
})
public class ModelTestSuite {
}