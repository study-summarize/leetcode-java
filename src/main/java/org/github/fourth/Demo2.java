package org.github.fourth;

import java.util.*;


public class Demo2 {

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("a", Arrays.asList("1", "2", "3"));
        map.put("b", Arrays.asList("4", "5", "6"));

        List<Map<String, String>> convert = new Demo2().convert(map);
        System.out.println(convert);

    }

    public List<Map<String, String>> convert(Map<String, List<String>> map) {
        if (map == null) {
            return null;
        }
        List<Map<String, String>> result = new ArrayList<>();
        Map<String, String> item = new HashMap<>();
        helper(result, item, 0, map.entrySet().stream().toList());
        return result;
    }

    private void helper(List<Map<String, String>> result, Map<String, String> item, int index, List<Map.Entry<String, List<String>>> list) {
        if (item.keySet().size() == list.size()) {
            result.add(new HashMap<>(item));
            return;
        }

        for (int i = index; i < list.size(); i++) {
            Map.Entry<String, List<String>> entry = list.get(i);
            for (int j = 0; j < entry.getValue().size(); j++) {
                item.put(list.get(i).getKey(), entry.getValue().get(j));
                helper(result, item, index + 1, list);
                item.remove(list.get(i).getKey());
            }
        }
    }

}

