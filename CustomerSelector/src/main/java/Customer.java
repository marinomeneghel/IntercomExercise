import com.google.gson.Gson;

/**
 * Created by Marino Meneghel on 11/10/15.
 */
public class Customer implements Comparable {

    private long user_id;
    private String name;
    private double longitude;
    private double latitude;

    /**
     * Construct a new Customer instance
     */
    public Customer(long user_id, String name, double latitude, double longitude) {
        this.user_id = user_id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * Decodes a json-encoded string containing customer information
     * into a {@link Customer} object
     * @param customersJson the json-encoded customers string
     */
    public static Customer getCustomerFromJson(String customersJson) {
        return new Gson().fromJson(customersJson, Customer.class);
    }


    public double getLatitude() { return latitude; }

    public double getLongitude() { return longitude; }

    public String getName() { return name; }

    public long getUser_id() { return user_id; }

    /**
     * Perform a calculation using the spherical law of cosines to define if the location of
     * this Customer instance is inside the range of 100km from the params point.
     * @param lat latitude of the point from which calculate the range
     * @param lon longitude of the point from which calculate the range
     * @return true if inside the range, false otherwise
     */
    public boolean isCloserThan100KmFromCoords(double lat, double lon) {

        double customerLatRad = Math.toRadians(latitude);
        double customerLonRad = Math.toRadians(longitude);
        double givenPointLatRad = Math.toRadians(lat);
        double givenPointLonRad = Math.toRadians(lon);

        // Apply spherical law of cosines
        double angle = Math.acos(Math.sin(customerLatRad) * Math.sin(givenPointLatRad) + Math.cos(customerLatRad)
                * Math.cos(givenPointLatRad) * Math.cos(customerLonRad - givenPointLonRad));

        angle = Math.toDegrees(angle);

        // Each degree on a great circle on earth is 111.2225 km
        double distance = 111.2225 * angle;
        System.out.print("result= " + distance);

        return distance < 100;
    }

    /**
     * Compare this object id with the given one
     * @param object the object to compare this instance with
     * @return 1 if this > object | 0 if this == object | -1 if this < object
     */
    public int compareTo(Object object) {
        Customer customer = (Customer) object;
        return user_id > customer.getUser_id() ? 1 : user_id == customer.getUser_id() ? 0 : -1;
    }

}
