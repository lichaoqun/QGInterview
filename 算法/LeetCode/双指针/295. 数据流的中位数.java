import java.util.List;
import java.util.PriorityQueue;

import javax.swing.text.AbstractDocument.Content;

// - https://leetcode-cn.com/problems/find-median-from-data-stream/
class MedianFinder {
    List<Integer> list;
    // public MedianFinder() {
    // list = new ArrayList<>();
    // }

    // public void addNum(int num) {
    // int left = 0;
    // int right = list.size();
    // while(left < right){
    // int mid = (left + right) >> 1;
    // if (num > list.get(mid)) {
    // left = mid + 1;
    // continue;
    // }
    // right = mid;
    // }
    // list.add(left, num);
    // }

    // public double findMedian() {

    // int mid = list.size() >> 1;

    // // - 偶数长度
    // if ((list.size() & 1) == 0) {
    // return (list.get(mid - 1) + list.get(mid)) / 2.0;
    // }
    // return list.get(mid);
    // }

    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
            return;
        }

        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder s = new MedianFinder();
        s.addNum(-1);
        s.addNum(-2);
        s.addNum(-3);
        s.addNum(-4);
        s.addNum(-5);
        System.out.println();
    }
}
