/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
    
        // Create a hashmap to store cumulative sums
        Map<Integer, ListNode> map = new HashMap<>();
    
        int sum = 0;
        ListNode curr = dummy;
    
        while (curr != null) {
            sum += curr.val;
        
            if (map.containsKey(sum)) {
                // Remove nodes between the two cumulative sums
                ListNode prev = map.get(sum).next;
                int tempSum = sum;
            
                while (prev != curr) {
                    tempSum += prev.val;
                    map.remove(tempSum);
                    prev = prev.next;
                }
            
                // Update the next pointer of the previous node
                map.get(sum).next = curr.next;
            } else {
                map.put(sum, curr);
            }
        
            curr = curr.next;
        }
    
        return dummy.next;
        }
}