package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jwang55
 */
public class Test_013_romanToInt {

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i < s.length() - 1 && map.get(ch) < map.get(s.charAt(i + 1))) {
                result -= map.get(ch);
            } else {
                result += map.get(ch);
            }
        }
        return result;
    }
}
