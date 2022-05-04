import java.util.List;
// - https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // - 虚拟头结点, 通常链表需要判断头结点的都可以用虚拟头结点作
        ListNode header = new ListNode(0, head);

        ListNode fastNode = head;
        ListNode slowNode = header;

        // - 快指针移动n个距离
        while(n > 0){
            fastNode = fastNode.next;
            n--;
        }


        // - 快慢指针同步移动
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        // - 快指针移动到尾部, 慢指针
        slowNode.next = slowNode.next.next;
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
        ListNode node = createNode(new int[]{1, 2});
        printf(node);
        printf(s.removeNthFromEnd(node, 1));
    }
}