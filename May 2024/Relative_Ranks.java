class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] ranks = new String[score.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        Arrays.sort(score);
        
        for (int i = score.length - 1; i >= 0; i--) {
            int index = map.get(score[i]);
            if (i == score.length - 1) {
                ranks[index] = "Gold Medal";
            } else if (i == score.length - 2) {
                ranks[index] = "Silver Medal";
            } else if (i == score.length - 3) {
                ranks[index] = "Bronze Medal";
            } else {
                ranks[index] = String.valueOf(score.length - i);
            }
        }
        
        return ranks;
    }
}