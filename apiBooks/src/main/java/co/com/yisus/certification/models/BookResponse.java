package co.com.yisus.certification.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
public class BookResponse {

    @SerializedName("firstname")
    @Expose
    public String firstname;
    @SerializedName("lastname")
    @Expose
    public String lastname;
    @SerializedName("totalprice")
    @Expose
    public double totalprice;
    @SerializedName("depositpaid")
    @Expose
    public Boolean depositpaid;
    @SerializedName("bookingdates")
    @Expose
    public Bookingdates bookingdates;
    @SerializedName("additionalneeds")
    @Expose
    public String additionalneeds;

    public Bookingdates getBookingdates() {
        return bookingdates == null ? new Bookingdates() : bookingdates;
    }
}
