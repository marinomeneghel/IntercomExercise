import javafx.util.Pair;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by marino on 3/17/16.
 */
public class RomanNumbers {

    static Map<Integer, String> digitRomanMap = new LinkedHashMap<Integer, String>();
    static {
        digitRomanMap.put(1000, "M");
        digitRomanMap.put(900, "CM");
        digitRomanMap.put(500, "D");
        digitRomanMap.put(400, "CD");
        digitRomanMap.put(100, "C");
        digitRomanMap.put(90, "XC");
        digitRomanMap.put(50, "L");
        digitRomanMap.put(40, "XL");
        digitRomanMap.put(10, "X");
        digitRomanMap.put(9, "IX");
        digitRomanMap.put(5, "V");
        digitRomanMap.put(4, "IV");
        digitRomanMap.put(1, "I");
    }

    public String numToRoman(int num) {
        StringBuilder strBuilder = new StringBuilder();

        int remaining = num;
        for (Object entryObject : digitRomanMap.entrySet()) {
            Map.Entry entry = (Map.Entry) entryObject;
            int value = (Integer) entry.getKey();
            String romanValue = (String) entry.getValue();
            remaining = appendRomanNumber(remaining, value, romanValue, strBuilder);
        }

        return strBuilder.toString();
    }

    public int appendRomanNumber(int number, int value, String romanDigit, StringBuilder builder) {
        while(number >= value) {
            builder.append(romanDigit);
            number -= value;
        }
        return number;
    }

}
