package com.squad_5.recursos.Recursos;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@CucumberOptions(features = "src/test/resources")
public class CucumberSpringConfiguration { }

