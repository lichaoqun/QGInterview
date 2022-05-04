import java.util.Arrays;

// - https://leetcode-cn.com/problems/meeting-rooms-ii/
/**
 * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
 * 为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {

        int len = intervals.length;
        int[]startTimes = new int [len];
        int[]endTimes = new int [len];

        // - 保存开始时间和结束时间
        for (int idx = 0; idx < len; idx++) {
            startTimes[idx] = intervals[idx][0];
            endTimes[idx] = intervals[idx][1];
        }

        // - 排序
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        // - 遍历
        int startIdx= 0;
        int endIdx = 0;
        int ans = 0;
        while (startIdx < len) {
            if (startTimes[startIdx] < endTimes[endIdx]) {
                ans++;
                startIdx++;
                continue;
            }
            startIdx++;
            endIdx++;
            
        }
        return Math.max(ans, 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minMeetingRooms(new int[][]{
            new int[]{0, 30},
            new int[]{2, 10},
            new int[]{15, 20}
        });
    }
}