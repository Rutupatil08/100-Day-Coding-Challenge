public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int currentIndex = 0;

        for (int i = 0; i < k; i++) {
            while (currentIndex < n && projects[currentIndex][0] <= w) {
                maxHeap.add(projects[currentIndex][1]);
                currentIndex++;
            }

            if (maxHeap.isEmpty()) {
                break;
            }

            w += maxHeap.poll();
        }

        return w;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        System.out.println(solution.findMaximizedCapital(k, w, profits, capital)); 
    }
}
