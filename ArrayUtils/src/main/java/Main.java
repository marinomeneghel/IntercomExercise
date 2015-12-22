import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by marino on 11/20/15.
 */
public class Main {

    public static void main(String[] args) {

        ArrayUtils arrayUtils = new ArrayUtils();

        List<Integer> numbers = Arrays.asList(2, 3, 2, 3, 8, 7, 7);
        arrayUtils.findOdds(numbers);


        List<Integer> input = Arrays.asList(123, -2, 477, 3, 14, 6551);

        int foldResult = arrayUtils.foldArray(input);
        System.out.print("Fold array result " + foldResult + " | Original Array " + Arrays.asList(input));
    }


}
