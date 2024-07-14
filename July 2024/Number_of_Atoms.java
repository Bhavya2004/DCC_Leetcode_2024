class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> currMap = new HashMap<>();
        int i = 0, n = formula.length();

        while (i < n) {
            char c = formula.charAt(i);
            i++;

            if (c == '(') {
                stack.push(currMap);
                currMap = new HashMap<>();
            } else if (c == ')') {
                int count = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + formula.charAt(i) - '0';
                    i++;
                }

                if (count == 0) {
                    count = 1;
                }

                if (!stack.isEmpty()) {
                    Map<String, Integer> tempMap = currMap;
                    currMap = stack.pop();
                    for (String key : tempMap.keySet()) {
                        currMap.put(key, currMap.getOrDefault(key, 0) + tempMap.get(key) * count);
                    }
                }
            } else {
                int start = i - 1;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String atom = formula.substring(start, i);

                int count = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + formula.charAt(i) - '0';
                    i++;
                }

                if (count == 0) {
                    count = 1;
                }

                currMap.put(atom, currMap.getOrDefault(atom, 0) + count);
            }
        }

        StringBuilder sb = new StringBuilder();
        List<String> atoms = new ArrayList<>(currMap.keySet());
        Collections.sort(atoms);
        for (String atom : atoms) {
            sb.append(atom);
            int count = currMap.get(atom);
            if (count > 1) {
                sb.append(count);
            }
        }

        return sb.toString();
    }
}