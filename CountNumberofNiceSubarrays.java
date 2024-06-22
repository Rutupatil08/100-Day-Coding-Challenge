class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 1; 

        int count = 0;
        int oddCount = 0;
        
        for (int num : nums) {
            oddCount += num % 2; 
            
            if (oddCount >= k) {
                count += prefixSum[oddCount - k];
            }
            
            prefixSum[oddCount]++;
        }
        
        return count;
    }
}
