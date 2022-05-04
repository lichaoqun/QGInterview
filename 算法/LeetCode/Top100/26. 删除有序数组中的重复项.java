import javax.print.attribute.standard.Sides;

// - https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
class Solution {
    /**
     * 快慢指针
     * 1. 慢指针指向nums[0], 快指针指向nums[1] 然后遍历nums数组(数组遍历的条件是 快指针 < 数组长度)
     * 1. 如果nums[快指针] != nums[慢指针], while循环 快指针++指导nums[快指针] ! = nums[慢指针], nums[慢指针
     * + 1] = nums[快指针]
     * 2. 如果nums[快指针] != nums[慢指针], 快指针++, 慢指针++;
     */
    public int removeDuplicates2(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;

        int sIdx = 0;
        int qIdx = sIdx + 1;
        for(; qIdx < len; sIdx++, qIdx++){
            // - 出现重复数字
            if (nums[sIdx] == nums[qIdx]) {
                while(qIdx < len  && nums[sIdx] == nums[qIdx]) qIdx++;

                // - 直到最后一个字符都是一样的
                if(qIdx >= len){
                    break;
                } 

                // - 遍历结束之前出现了不一样的
                nums[sIdx + 1] = nums[qIdx];
                continue;
            }

            if (sIdx != qIdx) {
                nums[sIdx + 1] = nums[qIdx];
            }
        }
        return sIdx + 1;
    }

    public int removeDuplicates1(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;

        int sIdx = 0;
        for(int qIdx = sIdx + 1; qIdx < len; qIdx++){
            if (nums[sIdx] != nums[qIdx]) {
                nums[++sIdx] = nums[qIdx];
            }
        }
        return sIdx + 1;
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int slowIdx = 0;
        int fastIdx= slowIdx + 1;
        while (fastIdx < len) {
            if (nums[slowIdx] != nums[fastIdx]){
                nums[++slowIdx] = nums[fastIdx];
            }
            fastIdx++;
        }
        return slowIdx + 1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = new int[] {1,1, 2, 3};
        // int [] nums = new int[] {1,1,2};
        // int [] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        // int [] nums = new int[] {1, 1};
        // int [] nums = new int[] {1, 2, 3};
        int count = s.removeDuplicates1(nums);
        for (int i = 0; i < count; i++) {
            System.out.println(nums[i]);
        }
    }
}