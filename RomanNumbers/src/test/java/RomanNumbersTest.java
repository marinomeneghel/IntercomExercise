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
    public void test0IsEmpityString() {
        assertEquals("", romanNumbers.toRoman(0));
    }

    @Test
    public void testOneIsI() {
        assertEquals("I", romanNumbers.toRoman(1));
    }

    @Test
    public void testTwoIsII() {
        assertEquals("II", romanNumbers.toRoman(2));
    }

    @Test
    public void testFourIsIV() {
        assertEquals("IV", romanNumbers.toRoman(4));
    }

    @Test
    public void testFiveIsV() {
        assertEquals("V", romanNumbers.toRoman(5));
    }

    @Test
    public void testSixIsVI() {
        assertEquals("VI", romanNumbers.toRoman(6));
    }

    @Test
    public void testNineIsIX() {
        assertEquals("IX", romanNumbers.toRoman(9));
    }

    @Test
    public void testTenIsX() {
        assertEquals("X", romanNumbers.toRoman(10));
    }

    @Test
    public void testsFortyIsXL() {
        assertEquals("XL", romanNumbers.toRoman(40));
    }

    @Test
    public void testFiftyIsL() {
        assertEquals("L", romanNumbers.toRoman(50));
        assertEquals("LX", romanNumbers.toRoman(60));
    }

    @Test
    public void testTwentySevenIsXXVII() {
        assertEquals("XXVII", romanNumbers.toRoman(27));
    }

    @Test
    public void testEightyNineIsLXXXIX() {
        assertEquals("LXXXIX", romanNumbers.toRoman(89));
    }

    @Test
    public void testSixHundredNinetyOneIsDCXCI() {
        assertEquals("DCXCI", romanNumbers.toRoman(691));
    }

    @Test
    public void testNineteenEightyThreeIsMCMLXXXIII() {
        assertEquals("MCMLXXXIII", romanNumbers.toRoman(1983));
    }

    @Test
    public void testTwoThousandForHundredAndTwelveIsMMCDXII() {
        assertEquals("MMCDXII", romanNumbers.toRoman(2412));
    }

    @Test
    public void testNineteenNinetyIsMCMXC() {
        assertEquals("MCMXC", romanNumbers.toRoman(1990));
    }

}
