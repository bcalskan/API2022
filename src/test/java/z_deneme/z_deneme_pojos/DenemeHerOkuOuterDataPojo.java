package z_deneme.z_deneme_pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DenemeHerOkuOuterDataPojo {
    //"firstname": "Sally",
    //    "lastname": "Brown",
    //    "totalprice": 111,
    //    "depositpaid": true,
    //    "bookingdates": {
    //        "checkin": "2013-02-23",
    //        "checkout": "2014-10-23"
    //    },
    //    "additionalneeds": "Breakfast"

    private String firstname;
    private String lastname;
    private int totalprice;
    private Boolean depositpaid;
    private DenemeHerOkuInnerDataPojo bookingdates;
    private String additionalneeds;

    public DenemeHerOkuOuterDataPojo(String firstname, String lastname, int totalprice, Boolean depositpaid, DenemeHerOkuInnerDataPojo bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public DenemeHerOkuOuterDataPojo() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public DenemeHerOkuInnerDataPojo getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(DenemeHerOkuInnerDataPojo bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    @Override
    public String toString() {
        return "DenemeHerOkuDataPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
