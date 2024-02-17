package com.jsonplaceholder.tasks;

import com.jsonplaceholder.constants.CommentsConstant;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetCommentsByIdTask implements Task {

    public final String postId;


    public GetCommentsByIdTask(String postId){this.postId = postId;}



    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource(CommentsConstant.comments)
                        .with(
                                request -> request
                                        .queryParam("postId",postId)
                        )
        );

    }
    public static GetCommentsByIdTask getCommentsByIdTask(String postId){
        return instrumented(GetCommentsByIdTask.class,postId);
    }
}
