package co.com.yisus.certification.interactions;

import co.com.yisus.certification.models.BookResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SaveResponseInformation implements Interaction {

    private String vbleName;

    public SaveResponseInformation(String vbleName) {
        this.vbleName = vbleName;
    }

    public static Performable response(String vbleName) {
        return  instrumented(SaveResponseInformation.class, vbleName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(vbleName, SerenityRest.lastResponse().jsonPath().getObject("", BookResponse.class));
    }
}
