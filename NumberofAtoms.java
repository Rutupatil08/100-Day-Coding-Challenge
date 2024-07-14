import java.util.*;

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> currentMap = new HashMap<>();
        int len = formula.length();
        int i = 0;

        while (i < len) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                stack.push(currentMap);
                currentMap = new HashMap<>();
                i++;
            } else if (ch == ')') {
                int start = ++i;
                while (i < len && Character.isDigit(formula.charAt(i))) i++;
                int multiplier = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                if (!stack.isEmpty()) {
                    Map<String, Integer> top = currentMap;
                    currentMap = stack.pop();
                    for (String key : top.keySet()) {
                        currentMap.put(key, currentMap.getOrDefault(key, 0) + top.get(key) * multiplier);
                    }
                }
            } else {
                int start = i++;
                while (i < len && Character.isLowerCase(formula.charAt(i))) i++;
                String element = formula.substring(start, i);
                start = i;
                while (i < len && Character.isDigit(formula.charAt(i))) i++;
                int count = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                currentMap.put(element, currentMap.getOrDefault(element, 0) + count);
            }
        }

        List<String> elements = new ArrayList<>(currentMap.keySet());
        Collections.sort(elements);
        StringBuilder sb = new StringBuilder();
        for (String element : elements) {
            sb.append(element);
            int count = currentMap.get(element);
            if (count > 1) sb.append(count);
        }
        return sb.toString();
    }
}
