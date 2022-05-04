// - https://leetcode-cn.com/problems/merge-k-sorted-lists/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len == 0) return null;
        if(len == 1) return lists[0];
         ListNode l0 = lists[0];
         ListNode l1 = lists[1];
         ListNode header = mergeTwoLists(l0, l1);
         for (int i = 2; i < len; i++) {
             header = mergeTwoLists(header, lists[i]);
         }

        return header;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode header = new ListNode();
        ListNode prevNode = header;
        while(l1 != null || l2 != null){
            while(l1 != null && (l2 == null || l1.val < l2.val)){
                prevNode.next = l1;
                prevNode = l1;
                l1 = l1.next;
            }

            while (l2 != null && (l1 == null || l1.val >= l2.val)) {
                prevNode.next = l2;
                prevNode = l2;
                l2 = l2.next;
            }
        }
        return header.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header = new ListNode();
        ListNode prevNode = header;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val) {
                prevNode.next = l1;
                prevNode = l1;
                l1 = l1.next;
                continue;
            }
            prevNode.next = l2;
            prevNode = l2;
            l2 = l2.next;
        }
        prevNode.next = (l1 == null) ? l2 : l1;
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
        ListNode node1 = createNode(new int []{1 ,4, 5});
        ListNode node2 = createNode(new int []{1, 3, 4});
        ListNode node3 = createNode(new int []{2, 6});
        printf(s.mergeKLists(new ListNode [] {node1, node2, node3}));
    }
}