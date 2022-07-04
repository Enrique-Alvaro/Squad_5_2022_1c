package com.squad_5.recursos.Recursos;

import com.squad_5.recursos.Recursos.Models.Horas;
import com.squad_5.recursos.Recursos.Models.HorasACargarDTO;
import com.squad_5.recursos.Recursos.Repositories.HorasRepository;
import com.squad_5.recursos.Recursos.Services.HorasService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@CucumberOptions(
        glue = {"com.rappi.config", "com.rappi.glue.hooks", "com.rappi.definitions"},
        features = "src/test/resources",
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber.json"
        }
)
public class CargaHoras_Test extends CargaHorasServicesTest {

    private Horas horas;
    private HorasACargarDTO nuevaHora;
    private List<Horas> listaHoras;
    @Autowired
    private HorasService horasService;


    @When("Trying to add a new hour register")
    public void trying_to_add_a_new_hour_register() {
        nuevaHora = new HorasACargarDTO(1,1,1,1,"", LocalDate.now(),"");
        cargarHoras(nuevaHora);
    }

    @Then("it should be saved on the database")
    public void it_should_be_saved_on_the_database() {
        Assert.assertNotNull(getHorasByLegajo(1));
    }


    @Given("a user has saved registers")
    public void a_user_has_saved_registers() {
        nuevaHora = new HorasACargarDTO(1,1,1,1,"", LocalDate.now(),"");
    }

    @When("the route is called")
    public void the_route_is_called() {

    }

    @Then("it should return an non empty list")
    public void it_should_return_an_non_empty_list() {
        Assert.assertNotNull(horasService.getHorasByLegajo(1));
    }

    @Given("a user has no hours registered")
    public void a_user_has_no_hours_registered() {

    }

    @Then("it should return nothing")
    public void it_should_return_nothing() {
        Assert.assertNull(horasService.getHorasByLegajo(2));
    }

    @Given("a user has an hour register")
    public void a_user_has_an_hour_register() {
        nuevaHora = new HorasACargarDTO(1,3,1,1,"", LocalDate.now(),"");
        horasService.cargarHoras(nuevaHora);
    }

    @When("it is deleted")
    public void it_is_deleted() {
        listaHoras = horasService.getHorasByLegajo(3);
        horasService.deleteHoras(listaHoras.get(0).id);
    }

    @Then("it doesn't appear anymore")
    public void it_doesn_t_appear_anymore() {
        Assert.assertNull(getHorasByLegajo(3));
    }

    @Given("a row doesn't exist")
    public void a_row_doesn_t_exist() {
        horas = null;
    }

    @When("trying to delete it")
    public void trying_to_delete_it() {
        deleteHoras(10);
    }

    @Then("it shouldn't do anything")
    public void it_shouldn_t_do_anything() {

    }

    @Given("a row exists")
    public void a_row_exists() {
        nuevaHora = new HorasACargarDTO(1,4,1,1,"", LocalDate.now(),"");
        cargarHoras(nuevaHora);
    }

    @When("trying to update with full information")
    public void trying_to_update_with_full_information() {
        listaHoras = horasService.getHorasByLegajo(4);
        horas = listaHoras.get(0);
        horas.horasTrabajadas = 10;
        horasService.updateHoras(horas.id, horas);
    }

    @Then("the row is updated")
    public void the_row_is_updated() {
        listaHoras = horasService.getHorasByLegajo(4);
        horas = listaHoras.get(0);
        Assert.assertEquals(10, horas.horasTrabajadas);
    }

    @When("trying to update")
    public void trying_to_update() {
        listaHoras = horasService.getHorasByLegajo(4);
        horas = listaHoras.get(0);
        horas.horasTrabajadas = 0;
    }

    @Then("nothing is updated")
    public void nothing_is_updated() {

    }
}
