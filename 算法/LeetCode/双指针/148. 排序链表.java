import java.util.List;

// - https://leetcode-cn.com/problems/sort-list/
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return head;
        ListNode nextList = head.next.next;
        ListNode l1 = sortNode(head);
        while (nextList != null && nextList.next != null) {
            ListNode tempNextList = nextList.next.next;
            ListNode l2 = sortNode(nextList);
            l1 = mergeList(l1, l2);
            nextList = tempNextList;
        }
        if (nextList == null) return l1;
        return mergeList(l1, nextList);
    }
    public ListNode sortNode(ListNode head) {
        if (head.val <= head.next.val) {
            head.next.next = null;
            return head;
        }
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return next;
    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode header = new ListNode();
        ListNode prevNode = header;
        while(l1 != null || l2 != null){
            while (l1 != null && (l2 == null || l1.val <= l2.val)) {
                prevNode.next = l1;
                prevNode = l1;
                l1 = l1.next;
            }
            while (l2 != null && (l1 == null || l2.val < l1.val)) {
                prevNode.next = l2;
                prevNode = l2;
                l2 = l2.next;
            }
        }
        return header.next;
    }
}