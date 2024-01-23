class Solution {
    int maxLength = 0;

    public int maxLength(List<String> arr) {
        backtrack(arr, 0, new StringBuilder());
        return maxLength;
    }

    public void backtrack(List<String> arr, int index, StringBuilder sb) {
        if (index == arr.size()) {
            maxLength = Math.max(maxLength, sb.length());
            return;
        }

        // Exclude the current string
        backtrack(arr, index + 1, sb);

        // Include the current string if it has unique characters
        if (isUnique(sb, arr.get(index))) {
            sb.append(arr.get(index));
            backtrack(arr, index + 1, sb);
            sb.delete(sb.length() - arr.get(index).length(), sb.length());
        }
    }

    public boolean isUnique(StringBuilder sb, String s) {
        int[] count = new int[26];
        for (char c : sb.toString().toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (count[c - 'a'] > 0) {
                return false;
            }
            count[c - 'a']++;
        }
        return true;
    }
}