class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> arr[a[0]] * arr[b[1]] - arr[a[1]] * arr[b[0]]);
        for (int i = 1; i < arr.length; i++) {
            pq.offer(new int[]{0, i});
        }
        while (--k > 0) {
            int[] curr = pq.poll();
            if (++curr[0] < curr[1]) {
                pq.offer(curr);
            }
        }
        int[] result = pq.poll();
        return new int[]{arr[result[0]], arr[result[1]]};
    }
}