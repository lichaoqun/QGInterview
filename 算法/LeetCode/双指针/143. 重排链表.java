// - https://leetcode-cn.com/problems/reorder-list/
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
    public void reorderList(ListNode head) {
        ListNode sNode = head;
        ListNode fNode = head;
        
        // - 链表的中间节点
        while (fNode != null && fNode.next != null) {
            sNode = sNode.next;
            fNode = fNode.next.next;
        }
        ListNode head2 = sNode.next;
        sNode.next = null;

        // - 反转链表
        ListNode prevNode = null;
        while (head2 != null) {
            ListNode temp = head2.next;
            head2.next = prevNode;
            prevNode = head2;
            head2 = temp;
        }
        head2 = prevNode;

        // - 合并链表
        ListNode head1 = head;
        while (head1 != null && head2 != null) {
            ListNode head1Temp = head1.next;
            ListNode head2Temp = head2.next;

            head1.next = head2;
            head1 = head1Temp; 

            head2.next = head1;
            head2 = head2Temp;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // s.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, null))));
        s.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null)))));

    }
}