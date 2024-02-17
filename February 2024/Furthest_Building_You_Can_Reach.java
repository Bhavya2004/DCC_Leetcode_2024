class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderUsed = new PriorityQueue<>();
        
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            
            if (diff > 0) {
                if (ladders > 0) {
                    ladderUsed.offer(diff);
                    ladders--;
                } else if (!ladderUsed.isEmpty() && diff > ladderUsed.peek()) {
                    bricks -= ladderUsed.poll();
                    ladderUsed.offer(diff);
                } else {
                    bricks -= diff;
                }
                
                if (bricks < 0) {
                    return i;
                }
            }
        }
        
        return heights.length - 1;
    }
}