package com.natritmeyer.examplecucumberjvmspringframework.testrunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"classpath:features/"},
    plugin = {"pretty"},
    glue = {"com.natritmeyer.examplecucumberjvmspringframework.steps"})
public class RunCucumberIT {
}
