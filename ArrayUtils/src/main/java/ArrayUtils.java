import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Marino Meneghel on 11/10/15.
 */
public class ArrayUtils {

    List reducedArray;

    public ArrayUtils() {
        reducedArray = new ArrayList();
    }


    /**
     * Reduces the given multidimensional array of integers to a single array
     * @param array the array to reduce
     */
    public void reduce(List array) {
        if(array == null) {
            reducedArray = null;
            return;
        }

        for(Object obj : array) {

            if(obj instanceof List) {
                reduce((List) obj);

            } else if(obj instanceof Integer) {
                reducedArray.add(obj);

            } else {
                reducedArray = null;
                return;
            }
        }
    }

    /**
     * Same as {@link ArrayUtils#reduce(List)}
     * @param objects an arbitrary int[][] to reduce
     */
    public void reduce(int[][] objects) {
        if(objects == null) {
            reducedArray = null;
            return;
        }

        List array = new ArrayList();
        Collections.addAll(array, objects);
        reduce(array);
    }

    /**
     * Given a list of integers where each number appears an even number of times apart
     * from one number which appears an odd number of times, return the value
     * of the number appearing an odd number of times.
     * @param numbers
     * @return
     */
    public int findOdds(List<Integer> numbers) {
        for(int num : numbers) {
            System.out.println("current num = " + num);
            if(countOccourrencies(num, numbers) % 2 != 0) {
                return num;
            }
        }
        return 0; // bah
    }

    private int countOccourrencies(int num, List<Integer> numbers) {

        int occourrencies = 0;
        for(int current : numbers) {
            System.out.println("countOccurrencies = " + current);
            if(num == current) {
                occourrencies ++;
            }
        }
        return occourrencies;
    }

    /**
     * TODO first version, to refactor -- ho to improve this?
     * Fold an array summing the elements
     * Sums the first with every other element in the array and then remove it.
     * This operation is recursive for every array item
     * eg: [1,4,7] => [5, 8] => [13] => return 13
     * @param input the array to fold
     * @return the final sum as explained above
     */
    public int foldArray(List<Integer> input) {

        for(int i=0; i<input.size(); i++) {

            int increment = input.get(i);
            for(int j=i; j<input.size()-1; j++) {
                input.set(j+1, input.get(j+1) + increment);
            }
        }
        return input.get(input.size()-1);
    }


}
