import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marino on 11/10/15.
 */
public class CustomerSelector {

    /**
     * Stream the customers.txt file from resources
     */
    public List<Customer> getCustomersList() {
        InputStream customersStream = getClass().getResourceAsStream("customers.txt");

        List<Customer> customers = new ArrayList<Customer>();
        BufferedReader br = new BufferedReader( new InputStreamReader( customersStream ) );
        try {
            for (String line; (line = br.readLine()) != null;) {
                Customer customer = Customer.getCustomerFromJson(line);
                customers.add(customer);
            }
            customersStream.close();
        } catch (IOException e) {
            System.out.print("Exception reading customers file " + e);
        }

        return customers;
    }


}
