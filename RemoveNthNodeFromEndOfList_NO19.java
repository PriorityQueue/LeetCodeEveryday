/**
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> s = new Stack<>();
        ListNode after=null,before=null,p=null;
        p = head;
        while(p != null){
            s.push(p);
            p = p.next;
            
        }
        for(int i = 1;i < n;++i){
            
            after = s.pop();
        }
        if(!s.empty())
            p = s.pop();
        else
            return null;
        if(!s.empty())
            before = s.pop();
        else
            return after;
        before.next = after;
        return head;
        
    }
}
