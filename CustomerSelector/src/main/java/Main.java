import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by marino on 11/10/15.
 */
public class Main {

    public static final double DUBLIN_OFFICE_LATITUDE = 53.3381985;
    public static final double DUBLIN_OFFICE_LONGITUDE = -6.2592576;

    public static void main(String[] args) {
        CustomerSelector customerSelector = new CustomerSelector();
        List<Customer> customers = customerSelector.getCustomersList();

        List<Customer> selectedCustomers = new ArrayList<Customer>();

        for(Customer customer : customers) {
            boolean isNearest = customer.isCloserThan100KmFromCoords(DUBLIN_OFFICE_LATITUDE, DUBLIN_OFFICE_LONGITUDE);
            System.out.print(" is it nearest? " + isNearest);
            if(isNearest) {
                selectedCustomers.add(customer);
            }
        }

        Collections.sort(selectedCustomers);
        for(Customer customer : selectedCustomers) {
            System.out.print("Invite: " + customer.getName() + " id= " + customer.getUser_id() + "\n");
        }
    }


}
