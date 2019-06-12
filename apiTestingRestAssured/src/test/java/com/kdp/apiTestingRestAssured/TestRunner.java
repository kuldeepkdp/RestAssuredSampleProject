package com.kdp.apiTestingRestAssured;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        format={"pretty", "html:target/cucumber"},
        tags={"@ActiveFeature","@Active", },
        //tags={"@dev" },
        features="src/resource/java/feature"
        )

public class TestRunner {

}
