// - https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
class Solution {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = (numbers.length - 1);
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[right] < numbers[mid]) {
                left = mid + 1;
            }else if(numbers[right] > numbers[mid]){
                right = mid;
            }else{
                right-=1;
            }
        }
        return numbers[left];
    }
}