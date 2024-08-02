class Solution {
    public int minSwaps(int[] nums) {
        int k = 0;
        for (int num : nums) {
            if (num == 1) {
                k++;
            }
        }
        if (k == 0) {
            return 0; 
        }
        int n = nums.length;
        int cnt = 0; 
        int maxCount = 0; 

        for (int i = 0; i < k; i++) {
            if (nums[i] == 1) {
                cnt++;
            }
        }
        maxCount = cnt;
        for (int i = k; i < n + k; i++) {
            if (nums[i % n] == 1) {
                cnt++;
            }
            if (nums[(i - k) % n] == 1) {
                cnt--;
            }
            maxCount = Math.max(maxCount, cnt);
        }
        return k - maxCount;
    }
}
