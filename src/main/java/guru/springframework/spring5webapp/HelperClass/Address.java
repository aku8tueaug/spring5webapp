package guru.springframework.spring5webapp.HelperClass;

public class Address {
    private String addressLine;
    private String city;
    private String state;
    private String zip;

    public Address() {
    }

    public Address(String addressLine, String city, String state, String zip) {
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
