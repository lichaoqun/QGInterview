import java.util.ArrayList;

// - https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(0, head.val);
            head = head.next;
            count++;
        }
        int []arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public void reverse(ListNode node){
        if (node.next == null) return;
        reverse(node.next);
        tmp.add(node);
    }
}