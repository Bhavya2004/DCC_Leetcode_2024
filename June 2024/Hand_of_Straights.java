class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        
        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        while (!cardCount.isEmpty()) {
            int minCard = Integer.MAX_VALUE;
            for (int card : cardCount.keySet()) {
                minCard = Math.min(minCard, card);
            }
            
            for (int i = minCard; i < minCard + groupSize; i++) {
                if (!cardCount.containsKey(i)) {
                    return false;
                }
                
                int count = cardCount.get(i);
                if (count == 1) {
                    cardCount.remove(i);
                } else {
                    cardCount.put(i, count - 1);
                }
            }
        }
        
        return true;
    }
}