import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by marino on 11/10/15.
 */
public class CustomerTest {

    public static final double DUBLIN_OFFICE_LATITUDE = 53.3381985;
    public static final double DUBLIN_OFFICE_LONGITUDE = -6.2592576;

    private static final double RATHCOOLE_PARK_LAT = 53.278353;
    private static final double RATHCOOLE_PARK_LONG = -6.437988;

    private static final double NEW_YORK_LAT = 40.712784;
    private static final double NEW_YORK_LONG = -74.005941;

    private static final double ARMAGH_LAT = 54.228015;
    private static final double ARMAGH_LONG = -6.47644;


    @Test
    public void testCustomerCloserThan100km() {
        Customer customer = new Customer(1234, "Name", RATHCOOLE_PARK_LAT, RATHCOOLE_PARK_LONG);
        boolean isNearest = customer.isCloserThan100KmFromCoords(DUBLIN_OFFICE_LATITUDE, DUBLIN_OFFICE_LONGITUDE);
        assertEquals(true, isNearest);
    }

    @Test
    public void testCustomerFartherThan100km() {
        Customer customer = new Customer(1234, "Name", NEW_YORK_LAT, NEW_YORK_LONG);
        boolean isNearest = customer.isCloserThan100KmFromCoords(DUBLIN_OFFICE_LATITUDE, DUBLIN_OFFICE_LONGITUDE);
        assertEquals(false, isNearest);
    }

    // It's nearest but really for a little.
    @Test
    public void testCustomerBorderline() {
        Customer customer = new Customer(1234, "Name", ARMAGH_LAT, ARMAGH_LONG);
        boolean isNearest = customer.isCloserThan100KmFromCoords(DUBLIN_OFFICE_LATITUDE, DUBLIN_OFFICE_LONGITUDE);
        assertEquals(true, isNearest);
    }


}