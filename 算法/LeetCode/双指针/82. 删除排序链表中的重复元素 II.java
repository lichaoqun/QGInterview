import java.net.http.WebSocket.Listener;
import java.util.List;

import javax.xml.validation.Validator;

// - https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/

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
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode header = new ListNode(Integer.MAX_VALUE, head);
        ListNode curNode = header;
        while (curNode.next != null && curNode.next.next != null) {
            int nextVal = curNode.next.val;
            if (nextVal == curNode.next.next.val) {
                while (curNode.next != null && curNode.next.val == nextVal) {
                    curNode.next = curNode.next.next;
                }
                continue;
            }
            curNode = curNode.next;
        }
        return header.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode header = new ListNode(Integer.MAX_VALUE, head);
        ListNode prevNode = header;
        ListNode curNode = prevNode.next;

        while (curNode != null && curNode.next != null) {
            int curVal = curNode.val;
            if (curVal == curNode.next.val) {
                while (curNode != null && curNode.val == curVal) {
                    curNode = curNode.next;
                }
                prevNode.next = curNode;
                continue;
            }
            prevNode = curNode;
            curNode = curNode.next;
        }
        return header.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.deleteDuplicates(
        new ListNode(1, 
        new ListNode(2, 
        new ListNode(3, 
        new ListNode(3, 
        new ListNode(4, 
        new ListNode(4, 
        new ListNode(5,null)))))))); 
    }
}