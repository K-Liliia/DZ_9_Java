package org.example.steps;

import io.cucumber.java.en.Then;

public class ResponseSteps extends BaseSteps{
    @Then("User check response status {int}")
    public void checkResponseStatus(int statusCode){
        sharedTestData.getResponse().then().statusCode(statusCode);
    }
}
