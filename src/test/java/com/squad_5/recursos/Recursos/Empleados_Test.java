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
    @Then("a non-empy list is return")
    public void a_non_empy_list_is_return() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("the person in the list")
    public void the_person_in_the_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("their information is returned")
    public void their_information_is_returned() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("the person is not in the list")
    public void the_person_is_not_in_the_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("nothing is returned")
    public void nothing_is_returned() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("consulto los empleados")
    public void buscarEmpleado(){
        empleados = service.getEmpleados();
    }

    @Then("tengo una lista de empleados")
    public void EmpleadosEnlistados(){
        Assert.assertNotNull(empleados);
    }
}
