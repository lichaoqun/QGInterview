import java.util.ArrayList;
import java.util.List;

// - https://leetcode-cn.com/problems/subsets/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << len); i++) {
            List <Integer> tempList = new ArrayList<Integer>();
            for (int j = 0; j < len; j++) {
                if(((1 << j) & i) == 0) continue;
                tempList.add(nums[j]);
            }
            result.add(tempList);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> re = s.subsets(new int[]{1, 2, 3});
        for (List<Integer> list : re) {
            System.out.println("====");
            for (Integer i : list) {
                System.out.print(i);
            }
        }
    }
}