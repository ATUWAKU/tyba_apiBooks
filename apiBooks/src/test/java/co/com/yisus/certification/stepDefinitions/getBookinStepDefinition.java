package co.com.yisus.certification.stepDefinitions;

import co.com.yisus.certification.models.BookResponse;
import co.com.yisus.certification.questions.BookDataResponse;
import co.com.yisus.certification.tasks.ConsultBook;
import co.com.yisus.certification.utils.FieldsResponse;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.ensure.Ensure;


import java.util.Map;

import static co.com.yisus.certification.utils.Constants.BASE_URL_API;
import static co.com.yisus.certification.utils.Constants.RESPONSE_BOOK;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class getBookinStepDefinition {

    private static final String FRONTEND = "FrontEnd";

    @Before
    public void setup(){
        OnStage.setTheStage(OnlineCast.whereEveryoneCan(
                CallAnApi.at(BASE_URL_API)));
        SerenityRest.useRelaxedHTTPSValidation();
    }

    @DataTableType
    public BookResponse convert(Map<String, String> obj){
        BookResponse resp = new BookResponse();

        resp.setFirstname(obj.get("firstname") == null ? "" : obj.get("firstname"));
        resp.setLastname(obj.get("lastname") == null ? "" : obj.get("lastname"));
        resp.setTotalprice(obj.get("totalprice") == null ? 0 : Double.parseDouble(obj.get("totalprice")));
        resp.setDepositpaid(obj.get("depositpaid") == null ? false : Boolean.parseBoolean(obj.get("depositpaid")));
        resp.getBookingdates().setCheckin(obj.get("checkin") == null ? "" : obj.get("checkin"));
        resp.getBookingdates().setCheckout(obj.get("checkout") == null ? "" : obj.get("checkout"));

        return resp;
    }

    @When("I request boo information with id {string}")
    public void iRequestBooInformationWithId(String bookId) {
        theActorCalled(FRONTEND) .attemptsTo(
                ConsultBook.with(bookId)
        );
    }
    @Then("The service must show")
    public void theServiceMustShow(BookResponse data) {
        Ensure.that(BookDataResponse.extract(FieldsResponse.FIRST_NAME)).isEqualTo(data.getFirstname());
        Ensure.that(BookDataResponse.extract(FieldsResponse.LAST_NAME)).isEqualTo(data.getLastname());
        Ensure.that(BookDataResponse.extract(FieldsResponse.TOTAL_PRICE)).isEqualTo(Double.toString(data.getTotalprice()));
        Ensure.that(BookDataResponse.extract(FieldsResponse.DEPOSIT_PAID)).isEqualTo(Boolean.toString(data.getDepositpaid()));
        Ensure.that(BookDataResponse.extract(FieldsResponse.CHECKIN)).isEqualTo(data.getBookingdates().getCheckin());
        Ensure.that(BookDataResponse.extract(FieldsResponse.CHECKOUT)).isEqualTo(data.getBookingdates().getCheckout());
    }
}
