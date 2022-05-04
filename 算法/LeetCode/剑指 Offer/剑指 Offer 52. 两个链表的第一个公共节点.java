import org.w3c.dom.Node;

// - https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
 }
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB ) {
          pA = (pA == null) ? headB : pA.next;
          pB = (pB == null) ? headA : pB.next;  
        } 
        return pA;
    }
}