// - https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode fast = head;
        ListNode header = new ListNode(10);
        ListNode slow = header;
        slow.next = head;
        while (fast != null) {
            if (fast.val == val) {
                slow.next = slow.next.next;
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return header.next;

    }
}