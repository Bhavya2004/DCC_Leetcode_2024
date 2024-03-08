class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMp = new HashMap<>();
        int maxFreq = 0;
        for(var num : nums){
            freqMp.put(num, freqMp.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMp.get(num));
        }

        int maxFreqEleCnt = 0;
        for(var entry : freqMp.entrySet()){
            int currEleFreq = entry.getValue();
            if(currEleFreq == maxFreq){
                maxFreqEleCnt++;
            }
        }
        return maxFreq * maxFreqEleCnt;
    }
}