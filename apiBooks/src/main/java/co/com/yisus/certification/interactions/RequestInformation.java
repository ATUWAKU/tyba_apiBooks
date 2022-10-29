package co.com.yisus.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.yisus.certification.utils.Constants.URL_SEARCHBOOK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RequestInformation implements Interaction {

    private String bookId;

    public RequestInformation(String bookId) {
        this.bookId = bookId;
    }

    public static Performable bookInformation(String bookId) {
        return instrumented(RequestInformation.class, bookId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(URL_SEARCHBOOK + "/" + bookId)
                        .with(request -> request
                              .log().all()
                        )
        );
    }
}
