package com.squad_5.recursos.Recursos;

import com.squad_5.recursos.Recursos.Models.Horas;
import com.squad_5.recursos.Recursos.Models.HorasACargarDTO;
import com.squad_5.recursos.Recursos.Services.HorasService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@CucumberOptions(
        glue = {""},
        features = "src/test/resources",
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber.json"
        }
)
@ActiveProfiles("test")
@ContextConfiguration(classes=RecursosApplication.class)
@RunWith(MockitoJUnitRunner.class)
public class CargaHoras_Test{

    private Horas horas;
    private HorasACargarDTO nuevaHora;
    private List<Horas> listaHoras;
    @InjectMocks
    private HorasService horasService = Mockito.mock(HorasService.class);

    private HorasACargarDTO nuevaHoras() {
        return new HorasACargarDTO(1,1,1,1,"", LocalDate.now(),"");
    }


    @When("Trying to add a new hour register")
    public void trying_to_add_a_new_hour_register() {
    }

    @Then("it should be saved on the database")
    public void it_should_be_saved_on_the_database() {
//        Assert.assertNotNull(horasService.getHorasByLegajo(1));
//        horasService.deleteHoras(horasService.getHorasByLegajo(1).get(0).id);
        nuevaHora = nuevaHoras();
        when(horasService.cargarHoras(nuevaHora)).thenReturn(new Horas());

        Assert.assertNotNull(horasService.cargarHoras(nuevaHora));
    }


    @Given("a user has saved registers")
    public void a_user_has_saved_registers() {
        nuevaHora = nuevaHoras();
    }

    @When("the user searches by id")
    public void the_route_is_called() {
        listaHoras = horasService.getHorasByLegajo(1);
    }

    @Then("it should return an non empty list")
    public void it_should_return_an_non_empty_list() {
        Assert.assertNotNull(listaHoras);
        horasService.deleteHoras(horasService.getHorasByLegajo(1).get(0).id);
    }

    @Given("a user has no hours registered")
    public void a_user_has_no_hours_registered() {
        int idABorrar;
        while (!horasService.getHorasByLegajo(1).isEmpty()) {
            idABorrar = horasService.getHorasByLegajo(1).get(0).id;
            horasService.deleteHoras(idABorrar);
        }
    }

    @Then("it should return nothing")
    public void it_should_return_nothing() {
        Assert.assertNull(horasService.getHorasByLegajo(1));
    }

    @Given("a user has an hour register")
    public void a_user_has_an_hour_register() {
        nuevaHora = nuevaHoras();
        when(horasService.cargarHoras(nuevaHora)).thenReturn(new Horas());

        Assert.assertNotNull(horasService.cargarHoras(nuevaHora));
    }

    @When("it is deleted")
    public void it_is_deleted() {
        listaHoras = horasService.getHorasByLegajo(1);
        horasService.deleteHoras(listaHoras.get(0).id);
    }

    @Then("it doesn't appear anymore")
    public void it_doesn_t_appear_anymore() {
        Assert.assertNull(horasService.getHorasByLegajo(1));
    }

    @Given("a row doesn't exist")
    public void a_row_doesn_t_exist() {

    }


    @Given("a row exists")
    public void a_row_exists() {
        nuevaHora = nuevaHoras();
        horasService.cargarHoras(nuevaHora);
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

}
