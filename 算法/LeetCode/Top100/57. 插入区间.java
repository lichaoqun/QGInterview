// - https://leetcode-cn.com/problems/insert-interval/
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
class Solution {
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        // - 插入
        int newLen = intervals.length + 1;
        int[][] newIntervals = new int [newLen][2];
        for (int i = 0; i < intervals.length; i++) {
            newIntervals[i] = intervals[i];
        }
        newIntervals[newLen - 1] = newInterval;
        if (intervals.length == 0)  return newIntervals;

        // - 排序
        for (int end = newIntervals.length - 1; end > 0; end--) {
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (newIntervals[begin][0] < newIntervals[begin - 1][0]) {
                    int[] temp = newIntervals[begin];
                    newIntervals[begin] = newIntervals[begin - 1];
                    newIntervals[begin - 1] = temp;
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }

        // - 合并
        int idx = 0;
        int[][] result = new int [newLen][2];
        int[] lastArray = newIntervals[0];
        for (int i = 1; i < result.length; i++) {
            int[]cur = newIntervals[i];
            if (cur[0] >= lastArray[0] && cur[0] <= lastArray[1]) {
                lastArray[0] = Math.min(cur[0], lastArray[0]);
                lastArray[1] = Math.max(cur[1], lastArray[1]);
                continue;
            }
            result[idx] = lastArray;
            lastArray = cur;
            idx++;
        }
        result[idx++] = lastArray;

        // - 截取有效的
        int[][] newResult = new int [idx][2];
        for (int i = 0; i < idx; i++) {
            newResult[i] = result[i];
        }

        for (int[] is : newResult) {
            System.out.println(is[0] + "-" + is[1]);
        }
        return newResult;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // - 插入
        int newLen = intervals.length + 1;
        int[][] newIntervals = new int [newLen][2];
        for (int i = 0; i < intervals.length; i++) {
            newIntervals[i] = intervals[i];
        }
        newIntervals[newLen - 1] = newInterval;
        if (intervals.length == 0)  return newIntervals;

        // - 排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        
        // - 合并区间
        List<int[]> result = new ArrayList<int[]>();
        int[] lastArray = intervals[0];
        int idx = 0;
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            if (start > lastArray[1]) {
                result.add(lastArray);
                lastArray = intervals[i];
                idx++;
            }
            start = Math.min(lastArray[0], intervals[i][0]);
            int end = Math.max(lastArray[1], intervals[i][1]);
            lastArray = new int[] {start, end };
        }
        result.add(lastArray);
        return result.toArray(new int[idx++][]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // System.out.println(s.insert(new int[][] {
        //     new int[] { 1, 2 },
        //     new int[] { 3, 5 },
        //     new int[] { 6, 7 },
        //     new int[] { 8, 10 },
        //     new int[] { 12, 16 }
        // }, new int[]{4, 8}));
        System.out.println(s.insert(new int[][] {
            new int[] { 1, 5 }
        }, new int[]{0, 3}));
    }
}
