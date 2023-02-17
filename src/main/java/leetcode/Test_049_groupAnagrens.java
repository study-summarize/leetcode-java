package leetcode;

import java.util.*;

/**
 * @author jwang55
 */
public class Test_049_groupAnagrens {
    /**
     * 使用字符+count为key
     */
    public List<List<String>> group2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 按字母+个数作为key
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                counts[ch - 'a']++;
            }
            // build hash key
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != 0) {
                    char ch = (char) (i + 'a');
                    sb.append(ch).append(counts[i]);
                }
            }

            if (map.containsKey(sb.toString())) {
                map.get(sb.toString()).add(str);
            } else {
                map.put(sb.toString(), Arrays.asList(str));
            }
        }
        result.addAll(map.values());
        return result;
    }

    /**
     * 对字符串使用同一的排序为key
     */
    public List<List<String>> group(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 按字母序排序
            char[] toCharArray = str.toCharArray();
            Arrays.sort(toCharArray);
            String sortedStr = new String(toCharArray);

            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                map.put(sortedStr, Arrays.asList(str));
            }
        }
        result.addAll(map.values());
        return result;
    }

}
