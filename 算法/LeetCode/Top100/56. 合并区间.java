import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 */
class Solution {
    public int[][] merge1(int[][] intervals) {

        // - 排序
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int temp[] = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }
        for (int[] is : intervals) {
            System.out.println(is[0] + "-" + is[1]);
        }
        // - 合并区间
        int tempResult[][] = new int[intervals.length][2];
        int[] lastArray = intervals[0];
        int idx = 0;
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            if (start > lastArray[1]) {
                tempResult[idx] = lastArray;
                lastArray = intervals[i];
                idx++;
            }
            start = Math.min(lastArray[0], intervals[i][0]);
            int end = Math.max(lastArray[1], intervals[i][1]);
            lastArray = new int[] { start, end };
        }
        tempResult[idx] = lastArray;

        // - 截取数组元素
        int result[][] = new int[idx + 1][2];
        for (int i = 0; i <= idx; i++) {
            result[i] = tempResult[i];
        }

        return result;
    }

    public int[][] merge(int[][] intervals) {

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
        int[][] result = s.merge(
                new int[][] {
                        new int[] { 1, 3 },
                        new int[] { 7, 9 },
                        new int[] { 2, 5 },
                        new int[] { 9, 10 },
                        new int[] { 3, 6 },
                        new int[] { 0, 1 }
                });
        for (int[] is : result) {
            System.out.println(is[0] + "-" + is[1]);
        }
    }
}