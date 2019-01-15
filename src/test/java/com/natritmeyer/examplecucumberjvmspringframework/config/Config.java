package com.natritmeyer.examplecucumberjvmspringframework.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource("application.properties")
@ComponentScan("com.natritmeyer.examplecucumberjvmspringframework")
public class Config {
}
