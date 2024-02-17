package com.jsonplaceholder.stepDefinitions;

import com.jsonplaceholder.tasks.GetCommentsByIdTask;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.hasItems;

public class commentsStepDef {

    Actor admin = Actor.named("admin")
            .whoCan(CallAnApi.at("https://jsonplaceholder.typicode.com"));

    @When("I consume the endpoint by {string}")
    public void iConsumeTheEndpointBy(String idPost) {
        admin.attemptsTo(
                GetCommentsByIdTask.getCommentsByIdTask(idPost)
        );

    }
    @Then("I willl be able to wiew the comments available for the desired PostId")
    public void iWilllBeAbleToWiewTheCommentsAvailableForTheDesiredPostId() {

        admin.should(
                seeThatResponse("Email of comments is",
                response -> response.body("email",
                        hasItems("Presley.Mueller@myrl.com",
                          "Dallas@ole.me")))
        );


    }
}
