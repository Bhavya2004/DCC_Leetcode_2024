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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevNode = null;
    ListNode nextNode = null;
    ListNode currentNode = list1;
    int count = 0;
    
    // Traverse list1 to find the (a-1)th node and the bth node
    while (currentNode != null) {
        if (count == a - 1) {
            prevNode = currentNode;
        }
        if (count == b) {
            nextNode = currentNode.next;
            break;
        }
        currentNode = currentNode.next;
        count++;
    }
    
    // Traverse list2 to find the last node
    ListNode lastNode = list2;
    while (lastNode.next != null) {
        lastNode = lastNode.next;
    }
    
    // Set the next pointer of the last node of list2 to nextNode
    lastNode.next = nextNode;
    
    // Set the next pointer of prevNode to the head of list2
    prevNode.next = list2;
    
    return list1;
    }
}