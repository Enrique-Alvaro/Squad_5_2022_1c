package com.squad_5.recursos.Recursos;

import com.squad_5.recursos.Recursos.Models.Empleado;
import com.squad_5.recursos.Recursos.Services.EmpleadoService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber.json"
        }
)
public class Empleados_Test {
    private EmpleadoService service = new EmpleadoService();
    private Empleado[] empleados;


    @When("i wish to obtain resources")
    public void buscarEmpleado(){
        empleados = service.getEmpleados();
    }

    @Then("i got a list of employees")
    public void EmpleadosEnlistados(){
        Assert.assertNotNull(empleados);
    }
}
