class Solution {
    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);

        int value = 0;
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] != heights[i]) {
                value++;
            }
        }
        
        return value;
    }
}
