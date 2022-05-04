// - https://leetcode-cn.com/problems/linked-list-cycle-ii/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && slowNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                ListNode tempNode = head;
                while(tempNode != slowNode){
                    tempNode  = tempNode.next;
                    slowNode = slowNode.next;
                }
                return slowNode;
            }
        }
        return null;
    }
}