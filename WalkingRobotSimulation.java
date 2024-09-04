class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        HashSet<String> obs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obs.add(obstacle[0] + "," + obstacle[1]);
        }

        int x = 0, y = 0, dx = 0, dy = 1;
        int ans = 0;

        for (int c : commands) {
            if (c == -1) {
                int temp = dx;
                dx = dy;
                dy = -temp;
            } else if (c == -2) { 
                int temp = dx;
                dx = -dy;
                dy = temp;
            } else {
                for (int i = 0; i < c; i++) {
                    int xx = x + dx;
                    int yy = y + dy;

                    if (obs.contains(xx + "," + yy)) break;
                    x = xx;
                    y = yy;
                    ans = Math.max(ans, x * x + y * y); }
            }
        }

        return ans;
    }
}
