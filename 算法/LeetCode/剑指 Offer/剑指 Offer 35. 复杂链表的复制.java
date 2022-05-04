import java.util.ArrayList;
import java.util.List;

// - https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node node = head;
        List<Node> oldList = new ArrayList<>();
        List<Node> newList = new ArrayList<>();
        while(node != null){
            oldList.add(node);
            newList.add(new Node(node.val));
            node = node.next;
        }

        Node nextNode = null;
        for (int i = oldList.size() - 1; i >= 0; i--){
            int randomIdx = oldList.indexOf(oldList.get(i).random);
            Node curNode = newList.get(i);
            curNode.next = nextNode;
            curNode.random = (randomIdx < 0) ? null : newList.get(randomIdx);
            nextNode = curNode;
        }

        return newList.get(0);
    }