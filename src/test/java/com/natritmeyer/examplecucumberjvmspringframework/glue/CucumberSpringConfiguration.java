package com.natritmeyer.examplecucumberjvmspringframework.glue;

import com.natritmeyer.examplecucumberjvmspringframework.config.Config;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Config.class)
@CucumberContextConfiguration
public class CucumberSpringConfiguration {
}
