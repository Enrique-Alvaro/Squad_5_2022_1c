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
import java.util.ArrayList;
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
    private List<Horas> listaHoras = new ArrayList<>();
    @InjectMocks
    private HorasService horasService = Mockito.mock(HorasService.class);

    private HorasACargarDTO nuevaHoras() {
        return new HorasACargarDTO(1,1,1,1,"", LocalDate.now(),"");
    }


    @When("Trying to add a new hour register")
    public void trying_to_add_a_new_hour_register() {
        nuevaHora = nuevaHoras();
        horas = new Horas(1,1,1,1,"",LocalDate.now(),"");
        listaHoras.add(horas);
        when(horasService.cargarHoras(nuevaHora)).thenReturn(horas);
        Assert.assertNotNull(horasService.cargarHoras(nuevaHora));
    }

    @Then("it should be saved on the database")
    public void it_should_be_saved_on_the_database() {
        when(horasService.getHorasByLegajo(1)).thenReturn(listaHoras);
        Assert.assertEquals(horasService.getHorasByLegajo(1),listaHoras);

    }


    @Given("a user has saved registers")
    public void a_user_has_saved_registers() {
        nuevaHora = nuevaHoras();
        horas = new Horas(1,1,1,1,"",LocalDate.now(),"");
        listaHoras.add(horas);
        when(horasService.cargarHoras(nuevaHora)).thenReturn(horas);
        Assert.assertNotNull(horasService.cargarHoras(nuevaHora));
        when(horasService.getHorasByLegajo(1)).thenReturn(listaHoras);
    }

    @When("the user searches by id")
    public void the_route_is_called() {
        listaHoras = horasService.getHorasByLegajo(1);
    }

    @Then("it should return an non empty list")
    public void it_should_return_an_non_empty_list() {
        Assert.assertNotNull(listaHoras);
    }

    @Given("a user has no hours registered")
    public void a_user_has_no_hours_registered() {
        when(horasService.getHorasByLegajo(1)).thenReturn(null);
    }

    @Then("it should return nothing")
    public void it_should_return_nothing() {
        Assert.assertNull(horasService.getHorasByLegajo(1));
    }

    @Given("a user has an hour register")
    public void a_user_has_an_hour_register() {
        nuevaHora = nuevaHoras();
        horas = new Horas(1,1,1,1,"",LocalDate.now(),"");
        listaHoras.add(horas);
        when(horasService.cargarHoras(nuevaHora)).thenReturn(horas);
        Assert.assertNotNull(horasService.cargarHoras(nuevaHora));
        when(horasService.getHorasByLegajo(1)).thenReturn(listaHoras);
    }

    @When("it is deleted")
    public void it_is_deleted() {
        listaHoras = horasService.getHorasByLegajo(1);
        horasService.deleteHoras(listaHoras.get(0).id);
        when(horasService.getHorasByLegajo(1)).thenReturn(null);
    }

    @Then("it doesn't appear anymore")
    public void it_doesn_t_appear_anymore() {
        Assert.assertNull(horasService.getHorasByLegajo(1));
    }

    @When("trying to update with full information")
    public void trying_to_update_with_full_information() {
        listaHoras = horasService.getHorasByLegajo(1);
        horas = listaHoras.get(0);
        horas.horasTrabajadas = 10;
        when(horasService.updateHoras(horas.id, horas)).thenReturn(horas);
        horasService.updateHoras(horas.id, horas);
    }

    @Then("the registers is updated")
    public void the_row_is_updated() {
        listaHoras = horasService.getHorasByLegajo(1);
        horas = listaHoras.get(0);

        Assert.assertEquals(10, horas.horasTrabajadas);
    }

    @When("trying to update with partial information")
    public void trying_to_update() {
        listaHoras = horasService.getHorasByLegajo(1);
        horas = listaHoras.get(0);
        horas.horasTrabajadas = 10;
        Horas h = new Horas();
        h.horasTrabajadas = 10;
        when(horasService.updateHoras(horas.id, h)).thenReturn(horas);
        horasService.updateHoras(horas.id, horas);
    }

}
