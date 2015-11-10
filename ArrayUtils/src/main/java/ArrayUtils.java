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

}
