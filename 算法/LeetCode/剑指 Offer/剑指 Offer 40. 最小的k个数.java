import java.util.Comparator;
import java.util.PriorityQueue;

// - https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int [] ans = new int[k];
        if (k == 0) return ans;
        PriorityQueue <Integer> queue = new PriorityQueue<>((n1, n2) -> n2 - n1);
        int i = 0;
        for (; i < k; i++) {
            queue.offer(arr[i]);
        }
        for(; i < arr.length; i++){
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        i = k;
        while (i > 0) {
            ans[k - i] = queue.poll();
            i--;
        }
        return ans;
    }
}