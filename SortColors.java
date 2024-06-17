class Solution {
    public void sortColors(int[] nums) {
        
        int left = 0, right = nums.length - 1, current = 0;

        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left++, current++);
            } else if (nums[current] == 2) {
                swap(nums, current, right--);
            } else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
