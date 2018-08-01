//Given a sorted linked list, delete all duplicates such that each element appear only once.

//Example
//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3.



/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode curr = head;        
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }            
        }
        
        return head;        
    }
}


