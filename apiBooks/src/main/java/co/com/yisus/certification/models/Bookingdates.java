package co.com.yisus.certification.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Bookingdates {

    @SerializedName("checkin")
    @Expose
    public String checkin;
    @SerializedName("checkout")
    @Expose
    public String checkout;
}
