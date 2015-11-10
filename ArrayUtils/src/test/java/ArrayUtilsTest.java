import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by marino on 11/10/15.
 */
public class ArrayUtilsTest {

    private ArrayUtils arrayUtils;

    @Before
    public void setUp() throws Exception {
        arrayUtils = new ArrayUtils();
    }

    @Test
    public void testNullArray() {
        int[][] array = null;
        arrayUtils.reduce(array);
        // We expect an empty array because it've been initialized anyway
        assertEquals(null, arrayUtils.reducedArray);
    }

    @Test
    public void testEmpityArray() {
        int[][] array = new int[][] {};
        arrayUtils.reduce(array);

        assertEquals(new ArrayList(), arrayUtils.reducedArray);
    }

    @Test
    public void testNotNestedArray() {
        List array = new ArrayList();
        array.add(0);
        array.add(1);
        array.add(2);
        array.add(3);

        arrayUtils.reduce(array);
        assertEquals(array, arrayUtils.reducedArray);
    }

    @Test
    public void testOneLevelNestedArray() {
        List arrayList = new ArrayList();
        arrayList.add(Arrays.asList(1, 2));
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(Arrays.asList(5, 6, 7, 8));

        arrayUtils.reduce(arrayList);
        List expected = new ArrayList(Arrays.asList(1,2,1,2,3,4,5,6,7,8));
        assertEquals(expected, arrayUtils.reducedArray);
    }

    @Test
    public void testTwoLevelNestedArray() {
        List arrayList = new ArrayList();
        arrayList.add(Arrays.asList(1, 2, Arrays.asList(3,4)));
        arrayList.add(5);
        arrayList.add(Arrays.asList(6, Arrays.asList(7)));

        arrayUtils.reduce(arrayList);
        List expected = new ArrayList(Arrays.asList(1,2,3,4,5,6,7));
        assertEquals(expected, arrayUtils.reducedArray);
    }

    @Test
    public void testNonIntegerType() {
        List array = new ArrayList();
        array.add(0);
        array.add(1);
        array.add(2);
        array.add("string");

        arrayUtils.reduce(array);
        System.out.print("reduced array " + arrayUtils.reducedArray);
        assertEquals(null, arrayUtils.reducedArray);
    }



}