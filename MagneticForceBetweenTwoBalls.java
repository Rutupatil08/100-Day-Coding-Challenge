class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int left = 1;
        int right = position[position.length - 1] - position[0];
        
        while (left < right) {
            int mid = (left + right + 1) / 2; 
            if (canPlaceBalls(position, m, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    private boolean canPlaceBalls(int[] position, int m, int minDist) {
        int count = 1;
        int lastPlaced = position[0];
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPlaced >= minDist) {
                count++;
                lastPlaced = position[i];
                if (count >= m) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] position1 = {1, 2, 3, 4, 7};
        int m1 = 3;
        System.out.println(solution.maxDistance(position1, m1)); 

        int[] position2 = {5, 4, 3, 2, 1, 1000000000};
        int m2 = 2;
        System.out.println(solution.maxDistance(position2, m2));
    }
}
