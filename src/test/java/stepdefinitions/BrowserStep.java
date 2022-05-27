package stepdefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import task.pruebaTask;



import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BrowserStep {

    @Before
    public void setThestage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Pablo");
    }

    @Given("Ingreso a la pagina web")
    public void ingreso_a_la_pagina_web() {
            theActorInTheSpotlight().wasAbleTo(Open.url("https://www.saucedemo.com/"));
    }

    @When("Diligencio los datos")
    public void diligencio_los_datos()  {
        theActorInTheSpotlight().attemptsTo(pruebaTask.informacion());

    }

    @Then("Veo el ingreso exitoso")
    public void veo_el_ingreso_exitoso() {
    }

}
