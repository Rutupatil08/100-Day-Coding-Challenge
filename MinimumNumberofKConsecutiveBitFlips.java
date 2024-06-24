class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flips = 0;
        int[] flipIndicator = new int[n];
        int flipCount = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flipCount ^= flipIndicator[i - k];
            }

            if (nums[i] == flipCount % 2) {
                if (i + k > n) {
                    return -1;
                }

                flips++;
                flipCount ^= 1;
                flipIndicator[i] = 1;
            }
        }
        
        return flips;
    }
}
