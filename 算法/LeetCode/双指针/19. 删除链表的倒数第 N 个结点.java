// - https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

class ListNode {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastNode = head;
        ListNode header = new ListNode(0, head);
        ListNode slowNode = header;

        // - 移动快指针
        while (n > 0) {
            fastNode = fastNode.next;
            n--;
        }

        // - 双指针移动
        while (fastNode != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        slowNode.next = slowNode.next.next;

        return header.next;
    }
}