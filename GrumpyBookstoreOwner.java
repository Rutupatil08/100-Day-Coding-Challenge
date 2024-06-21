class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfiedCustomers = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfiedCustomers += customers[i];
            }
        }

        int maxAdditionalCustomers = 0;
        int currentAdditionalCustomers = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currentAdditionalCustomers += customers[i];
            }
        }
        maxAdditionalCustomers = currentAdditionalCustomers;

        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                currentAdditionalCustomers += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                currentAdditionalCustomers -= customers[i - minutes];
            }
            maxAdditionalCustomers = Math.max(maxAdditionalCustomers, currentAdditionalCustomers);
        }

        return satisfiedCustomers + maxAdditionalCustomers;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));  // Output: 16
        System.out.println(solution.maxSatisfied(new int[]{1}, new int[]{0}, 1));  // Output: 1
    }
}
