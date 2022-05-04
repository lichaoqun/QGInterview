import java.util.List;

// - https://leetcode-cn.com/problems/palindrome-linked-list/

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
    public boolean isPalindrome(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        ListNode prevNode = null;
        ListNode leftHead = null;
        ListNode rightHead = null;
        // - 找到链表的中间节点并且反转前半部分链表
        while(fastNode != null && fastNode.next != null){

            ListNode tempNode = slowNode.next;
            fastNode = fastNode.next.next;

            slowNode.next = prevNode;
            prevNode = slowNode;
            slowNode = tempNode;
            

            // - 奇数长度的链表, 需要将中间节点的向后一位才能得到rightHead;
            if (fastNode != null && fastNode.next == null) {
                rightHead = slowNode.next;
                leftHead = prevNode;
            }else if(fastNode == null){
                rightHead = slowNode;
                leftHead = prevNode;
            }
        }

        while(rightHead != null){
            if (rightHead.val != leftHead.val) {
                return false;
            }
            rightHead = rightHead.next;
            leftHead = leftHead.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1))))));
        s.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2)))));
    }
}