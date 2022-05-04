import java.util.List;

// - https://leetcode-cn.com/problems/merge-two-sorted-lists/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header = new ListNode();
        ListNode lastNode = header;
        while (l1 != null || l2 != null) {
            while (l1 != null && (l2 == null || l1.val <= l2.val)) {
                lastNode.next = l1;
                lastNode = l1;
                l1 = l1.next;
            }
            while (l2 != null && (l1 == null || l1.val >= l2.val)) {
                lastNode.next = l2;
                lastNode = l2;
                l2 = l2.next;
            }
        }

        return header.next;
    }

    public static ListNode createNode(int[] array) {
        ListNode lastNode = null;
        ListNode result = null;
        for(int i = 0; i < array.length; i++){
            ListNode node = new ListNode(array[i]);
            if(lastNode == null){
                lastNode = node;
                result = node;
                continue;
            }
            lastNode.next = node;
            lastNode = node;
        }
        return result;

    }
    public static void printf(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while(node != null){
            sb.append(node.val);
            if(node.next != null){
                sb.append("-");
            }
            node = node.next;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node1 = createNode(new int []{});
        ListNode node2 = createNode(new int []{0});
        printf(node1);
        printf(node2);
        printf(s.mergeTwoLists(node1, node2));
    }
}