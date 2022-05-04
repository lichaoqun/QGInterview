// - https://leetcode-cn.com/problems/add-two-numbers/

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

    // - 使用虚拟头结点
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // - 虚拟头结点
        ListNode header = new ListNode();

        // - 新链表的尾结点, 每次相加后更新
        ListNode lastNode = header;

        // - 记录进位的值
        int tempVal = 0;

        while (l1 != null || l2 != null) {
            // - l1和l2的value
            int l1Val = 0;
            int l2Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }

            // - 计算进位的值
            int result = l1Val + l2Val + tempVal;
            tempVal = result / 10;
            
            // - 创建节点
            ListNode node = new ListNode(result % 10);
            lastNode.next = node;

            // - 更新新链表的尾结点
            lastNode = node;
        }

        if (tempVal > 0) {
            ListNode node = new ListNode(tempVal);
            lastNode.next = node;
        }
        return header.next;
    }

    public static ListNode createNode(int[] array) {
        ListNode lastNode = null;
        ListNode result = null;
        for (int i = 0; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            if (lastNode == null) {
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
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append("-");
            }
            node = node.next;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {

        ListNode l1 = createNode(new int[] { 9, 9, 9, 9, 9, 9, 9 });
        ListNode l2 = createNode(new int[] { 9, 9, 9, 9 });
        printf(l1);
        printf(l2);

        Solution s = new Solution();
        printf(s.addTwoNumbers1(l1, l2));

    }
}