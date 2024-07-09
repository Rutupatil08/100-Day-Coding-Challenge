class Solution {
    public double averageWaitingTime(int[][] customers) {
        int finished_prev = 0;
        double time_waiting = 0.0;

        for (int[] customer : customers) {
            int arrive = customer[0];
            int cook_time = customer[1];

            int start_cook = Math.max(arrive, finished_prev);
            int end_time = start_cook + cook_time;
            finished_prev = end_time;
            time_waiting += end_time - arrive;
        }

        return time_waiting / customers.length;
    }
}
