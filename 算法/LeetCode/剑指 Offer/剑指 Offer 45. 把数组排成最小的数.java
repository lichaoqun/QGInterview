// - https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
class Solution {
    public String minNumber(int[] nums) {
        int len = nums.length;
        for (int end = len - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 0; begin < end; begin++) {
                int curVal = nums[begin];
                int nextIdx = begin + 1;
                int nextVal = nums[nextIdx];
                StringBuilder curSb = new StringBuilder();
                curSb.append(curVal).append(nextVal);
                StringBuilder nextSb = new StringBuilder();
                nextSb.append(nextVal).append(curVal);
                if (Long.valueOf(curSb.toString()) > Long.valueOf(nextSb.toString())) {
                    nums[begin] = nextVal;
                    nums[nextIdx] = curVal;
                    sorted = false;
                }
            }
            if(sorted == true) break;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< len; i++){
            sb.append(nums[i]);
        }
        return sb.toString();
    }
}
