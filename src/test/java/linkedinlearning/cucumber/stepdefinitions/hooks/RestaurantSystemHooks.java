package linkedinlearning.cucumber.stepdefinitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class RestaurantSystemHooks {
    // Execute method for all scenarios that match with the specified tag
    @Before("@SmokeTest")
    public void beforeSmokeTestMessage(Scenario sc) {
        System.out.println(String.format(">> Before Smoke Test method '%s'", sc.getName()));
    }

    @Before
    public void beforeDisplayMessage(Scenario sc) {
        System.out.println(String.format(">> Before method '%s'", sc.getName()));
    }

    @After
    public void afterDisplayMessage(Scenario sc) {
        System.out.println(String.format(">> After method '%s'", sc.getName()));
    }
}
