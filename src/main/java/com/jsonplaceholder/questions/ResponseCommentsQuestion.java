package com.jsonplaceholder.questions;

import com.jsonplaceholder.models.ResponseCommentsModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseCommentsQuestion implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(ResponseCommentsModel.class);
    }
}
