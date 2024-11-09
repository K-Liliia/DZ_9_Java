package org.example.steps;

import org.example.data.SharedTestData;
import org.example.restLists.ListClass;

public abstract class BaseSteps {
    protected ListClass listClass = new ListClass();

    protected static SharedTestData sharedTestData = new SharedTestData();
}
