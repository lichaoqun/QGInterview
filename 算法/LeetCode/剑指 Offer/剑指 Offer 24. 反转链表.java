import javax.print.attribute.standard.RequestingUserName;

// - https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/

 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 class Solution {
    public ListNode reverseList(ListNode head) {
      ListNode lastNode = null;
      while(head != null){
          ListNode tempNode = head.next;
          head.next = lastNode;
          lastNode = head;
          head = tempNode;
      }
      return lastNode;
  }
}