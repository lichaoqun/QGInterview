import java.util.List;

// - https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/

 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 class Solution1 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fastNode = head;
        while(k > 0){
            fastNode = fastNode.next;
            k--;
        }
        ListNode header = new ListNode(0);
        header.next = head;
        ListNode slowNode =  header;

        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return header.next;
    }
}

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while(k > 0){
            fastNode = fastNode.next;
            k--;
        }
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}