class Solution {
    // - 冒泡排序
    public void bubbleSort(int[] nums) {
        for (int end = len - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 0; begin < end; begin++) {
                int curVal = nums[begin];
                int nextIdx = begin + 1;
                int nextVal = nums[nextIdx];
                if (curVal > nextVal) {
                    nums[begin] = nextVal;
                    nums[nextIdx] = curVal;
                    sorted = false;
                }
            }
            if(sorted) break;
        }
    }

    // - 快速排序
    public void QuickSort(int[] nums) {
        int begin = 0, end = nums.length - 1;
        if (end - begin < 2) return;
        sort(begin, end, nums);
    }
    public void sort(int begin, int end, int[] nums) {
        int mid = pivotIndex(begin, end);
        QuickSort(begin, mid, nums);
        QuickSort(mid + 1, end, nums);
    }
    public int pivotIndex(int begin, int end, int[] nums) {
        int piovt = nums[begin];
        end--;
        while (begin < end) {
            while (begin < end) {
                if (nums[begin] < piovt) {
                    begin++;
                    continue;
                }
                nums[end--] = nums[begin];
                break;
            }
            while (begin < end) {
                if (piovt < nums[end]) {
                    end--;
                    continue;
                }
                nums[begin++] = nums[end];
                break;
            }
        }
        nums[begin] = pivot;
        return begin;
    }
}