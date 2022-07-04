package com.squad_5.recursos.Recursos;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@CucumberOptions(features = "src/test/resources")
public class CucumberSpringConfiguration { }

