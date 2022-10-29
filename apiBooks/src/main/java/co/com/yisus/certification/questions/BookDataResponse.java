package co.com.yisus.certification.questions;

import co.com.yisus.certification.models.BookResponse;
import co.com.yisus.certification.utils.FieldsResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Switch;

import static co.com.yisus.certification.utils.Constants.RESPONSE_BOOK;
import static co.com.yisus.certification.utils.FieldsResponse.FIRST_NAME;

public class BookDataResponse implements Question<String> {

    private FieldsResponse field;

    public BookDataResponse(FieldsResponse field) {
        this.field = field;
    }

    public static BookDataResponse extract(FieldsResponse field) {
        return new BookDataResponse(field);
    }

    @Override
    public String answeredBy(Actor actor) {
        BookResponse resp = actor.recall(RESPONSE_BOOK);

        switch(field){
            case FIRST_NAME:
                return resp.getFirstname();
            case LAST_NAME:
                return resp.getLastname();
            case TOTAL_PRICE:
                return Double.toString(resp.getTotalprice());
            case DEPOSIT_PAID:
                return Boolean.toString(resp.getDepositpaid());
            case CHECKIN:
                return resp.getBookingdates().getCheckin();
            case CHECKOUT:
                return resp.getBookingdates().getCheckout();
            default:
                throw new RuntimeException();

        }


    }
}
