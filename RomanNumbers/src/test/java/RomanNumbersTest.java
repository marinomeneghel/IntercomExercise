import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by marino on 3/17/16.
 */
public class RomanNumbersTest {

    private RomanNumbers romanNumbers;

    @Before
    public void setup() {
        romanNumbers = new RomanNumbers();
    }

    @Test
    public void testNumbersConversion() {
        assertEquals("I", romanNumbers.numToRoman(1));
        assertEquals("II", romanNumbers.numToRoman(2));
        assertEquals("III", romanNumbers.numToRoman(3));
        assertEquals("IV", romanNumbers.numToRoman(4));
        assertEquals("V", romanNumbers.numToRoman(5));
        assertEquals("VI", romanNumbers.numToRoman(6));
        assertEquals("VII", romanNumbers.numToRoman(7));
        assertEquals("VIII", romanNumbers.numToRoman(8));
        assertEquals("IX", romanNumbers.numToRoman(9));
        assertEquals("X", romanNumbers.numToRoman(10));

        assertEquals("XX", romanNumbers.numToRoman(20));
        assertEquals("XL", romanNumbers.numToRoman(40));
        assertEquals("L", romanNumbers.numToRoman(50));
        assertEquals("LX", romanNumbers.numToRoman(60));

        assertEquals("MCMXC", romanNumbers.numToRoman(1990));
    }



}
