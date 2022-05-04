// - https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);
        ListNode lastNode = header;
        while(l1 != null || l2 != null){
            while(l1 != null && ((l2 == null) || l1.val <= l2.val)){
                lastNode.next = l1;
                lastNode = l1;
                l1 = l1.next;
            }
            while(l2 != null && ((l1 == null) || l1.val >= l2.val)){
                lastNode.next = l2;
                lastNode = l2;
                l2 = l2.next;
            }
        }
        return header.next;
    }
}