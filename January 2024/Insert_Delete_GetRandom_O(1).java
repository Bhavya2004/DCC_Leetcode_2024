class RandomizedSet {
    public List<Integer> nums;
    public Map<Integer, Integer> numToIndex;
    public Random random;
    public RandomizedSet() {
        nums = new ArrayList<>();
        numToIndex = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (numToIndex.containsKey(val)) {
            return false;
        }
        nums.add(val);
        numToIndex.put(val, nums.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!numToIndex.containsKey(val)) {
            return false;
        }
        int index = numToIndex.get(val);
        int lastNum = nums.get(nums.size() - 1);
        nums.set(index, lastNum);
        numToIndex.put(lastNum, index);
        nums.remove(nums.size() - 1);
        numToIndex.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */