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

    StringBuilder strBuilder = new StringBuilder();

    public String toRoman(int decimal) {
        if(digitRomanMap.containsKey(decimal)) {
            return digitRomanMap.get(decimal);
        }

        for (Map.Entry entry : digitRomanMap.entrySet()) {
            int key = (Integer) entry.getKey();
            if(decimal > key)
                return new RomanNumbers().toRoman(key) + new RomanNumbers().toRoman(decimal - key);
        }
        return strBuilder.toString();
    }

}
