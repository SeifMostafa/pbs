import java.util.*;
import java.util.stream.Stream;

public class roman_to_int {
    List<Character> roman_nums = Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M');

    public int romanToInt(String s) {
        int indexOfBefore = roman_nums.indexOf(s.charAt(0));
        int val_of_before = calc(indexOfBefore);
        int result = val_of_before;

        for (int i = 1; i < s.length(); i++) {
            int indexOfCurrent = roman_nums.indexOf(s.charAt(i));
            int val_of_cur = calc(indexOfCurrent);

            if (indexOfBefore < indexOfCurrent){
                result += (val_of_cur - val_of_before);
                result -= val_of_before;
            }
            else result += val_of_cur;

            indexOfBefore = indexOfCurrent;
            val_of_before = val_of_cur;
        }

        return result;
    }
    private int calc(int index) {
        return (int) (index % 2 == 0 ? Math.pow(10, (index / 2))
                : (int) Math.pow(10, (index / 2))*5);
    }

    public static void main(String [] args){
        roman_to_int romanToInt = new roman_to_int();
        System.out.println(romanToInt.romanToInt("III")); // 3
        System.out.println(romanToInt.romanToInt("LVIII")); // 58
        System.out.println(romanToInt.romanToInt("MCMXCIV")); // 1994

    }
}
