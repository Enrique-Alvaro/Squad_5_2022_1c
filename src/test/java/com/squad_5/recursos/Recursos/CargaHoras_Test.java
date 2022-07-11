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
    private List<Horas> expectedHours = new ArrayList<>();
    @InjectMocks
    private HorasService horasService = Mockito.mock(HorasService.class);

    private HorasACargarDTO nuevaHoras() {
        return new HorasACargarDTO(1,1,1,1,"", LocalDate.now(),"");
    }


    @When("Trying to add a new hour register with {int} hours")
    public void trying_to_add_a_new_hour_register_with_hours(Integer workedHours) {
        nuevaHora = nuevaHoras();
        horas = new Horas(1,workedHours,1,1,"",LocalDate.now(),"");
        listaHoras.add(horas);
        when(horasService.cargarHoras(nuevaHora)).thenReturn(horas);
        Assert.assertNotNull(horasService.cargarHoras(nuevaHora));
    }

    @Then("it should be saved on the database")
    public void it_should_be_saved_on_the_database() {
        when(horasService.getHorasByLegajo(1)).thenReturn(listaHoras);
        Assert.assertEquals(horasService.getHorasByLegajo(1),listaHoras);

    }


    @Given("a user has loaded {int} hours for Project {int} on Task {int}")
    public void a_user_has_loaded_hours_for_project_on_task(Integer workedHours, Integer projectCode, Integer taskCode) {
        nuevaHora = nuevaHoras();
        horas = new Horas(1,workedHours,taskCode,projectCode,"",LocalDate.now(),"");
        listaHoras.add(horas);
        when(horasService.cargarHoras(nuevaHora)).thenReturn(horas);
        Assert.assertNotNull(horasService.cargarHoras(nuevaHora));
        when(horasService.getHorasByLegajo(1)).thenReturn(listaHoras);
    }

    @When("the user searches their workload")
    public void the_route_is_called() {
        listaHoras = horasService.getHorasByLegajo(1);
    }

    @Then("it should return a list of their worked hours")
    public void it_should_return_an_non_empty_list() {
        Assert.assertNotNull(listaHoras);
    }

    @Given("a user has no hours registered")
    public void a_user_has_no_hours_registered() {
        when(horasService.getHorasByLegajo(1)).thenReturn(null);
    }

    @When("the user searches their worked hours")
    public void the_user_searches_their_worked_hours() {
        expectedHours = horasService.getHorasByLegajo(1);
    }

    @Then("it should return nothing")
    public void it_should_return_nothing() {
        Assert.assertNull(expectedHours);
    }

    @Given("a user has loaded {int} hours for Project {int} in Task {int}")
    public void a_user_has_loaded_hours(Integer workedHours, Integer projectCode, Integer taskCode) {
        nuevaHora = nuevaHoras();
        horas = new Horas(1,workedHours,taskCode,projectCode,"",LocalDate.now(),"");
        listaHoras.add(horas);
        when(horasService.cargarHoras(nuevaHora)).thenReturn(horas);
        Assert.assertNotNull(horasService.cargarHoras(nuevaHora));
        when(horasService.getHorasByLegajo(1)).thenReturn(listaHoras);
    }

    @When("that load is deleted")
    public void it_is_deleted() {
        listaHoras = horasService.getHorasByLegajo(1);
        horasService.deleteHoras(listaHoras.get(0).id);
        when(horasService.getHorasByLegajo(1)).thenReturn(null);
    }

    @Then("it doesn't appear anymore")
    public void it_doesn_t_appear_anymore() {
        Assert.assertNull(horasService.getHorasByLegajo(1));
    }

    @Given("a user has loaded {int} hours in Task {int} of Project {int}")
    public void a_user_has_loaded_hours_in_task_of_project(
            Integer workedHours,
            Integer taskCode,
            Integer projectCode) {
        horas = new Horas(1,workedHours,taskCode,projectCode,"",LocalDate.now(),"");
        listaHoras.add(horas);
        when(horasService.getHorasByLegajo(1)).thenReturn(listaHoras);
    }

    @When("updating hours to {int}, Project to {int}, Task to {int} and description to {string}")
    public void updating_hours_to_project_to_task_to_and_description_to(
            Integer newWorkedHours,
            Integer newProjectCode,
            Integer newTaskCode,
            String newDescription) {
        listaHoras = horasService.getHorasByLegajo(1);
        horas = listaHoras.get(0);
        horas.horasTrabajadas = newWorkedHours;
        horas.codigoProyecto = newProjectCode;
        horas.codigoTarea = newTaskCode;
        horas.detalle = newDescription;
        when(horasService.updateHoras(horas.id, horas)).thenReturn(horas);
        horasService.updateHoras(horas.id, horas);
    }

    @Then("the update is reflected")
    public void the_update_is_reflected() {
        listaHoras = horasService.getHorasByLegajo(1);
        horas = listaHoras.get(0);

        Assert.assertEquals(10, horas.horasTrabajadas);
        Assert.assertEquals(9, horas.codigoProyecto);
        Assert.assertEquals(2, horas.codigoTarea);
        Assert.assertEquals("Create login", horas.detalle);
    }

    @Given("a user has loaded {int} hours on Task {int} for Project {int}")
    public void a_user_has_loaded_hours_on_task_for_project(
            Integer workedHours,
            Integer taskCode,
            Integer projectCode) {
        horas = new Horas(1,workedHours,taskCode,projectCode,"",LocalDate.now(),"");
        listaHoras.add(horas);
        when(horasService.getHorasByLegajo(1)).thenReturn(listaHoras);
    }
    @When("updating only the hours to {int}")
    public void updating_only_the_hours_to(Integer newWorkedHours) {
        listaHoras = horasService.getHorasByLegajo(1);
        horas = listaHoras.get(0);
        horas.horasTrabajadas = newWorkedHours;
        when(horasService.updateHoras(horas.id, horas)).thenReturn(horas);
        horasService.updateHoras(horas.id, horas);
    }
    @Then("the hours are updated")
    public void the_hours_are_updated() {
        listaHoras = horasService.getHorasByLegajo(1);
        horas = listaHoras.get(0);

        Assert.assertEquals(11, horas.horasTrabajadas);
    }
}
