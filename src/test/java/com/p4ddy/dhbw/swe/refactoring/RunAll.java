package com.p4ddy.dhbw.swe.refactoring;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({CustomerTest.class, MovieTest.class, RentalTest.class})
public class RunAll {

}
