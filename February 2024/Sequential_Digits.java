class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String digits = "123456789";

        for (int i = 0; i < digits.length(); i++) {
            for (int j = i + 1; j <= digits.length(); j++) {
                int num = Integer.parseInt(digits.substring(i, j));
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }

        Collections.sort(result); 

        return result;
    }
}