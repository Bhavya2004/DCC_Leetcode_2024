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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode t1=head,t2=head;
        while(n!=0){
            t1 = t1.next;
            n--;
        }
   
        if(t1 == null){
            return head.next;
        }
        while(t1.next!=null){
            t1 = t1.next;
            t2 = t2.next;
        }
        t2.next = t2.next.next;
        return head;
    }
}