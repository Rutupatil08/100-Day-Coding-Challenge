class Solution {
    public int countPairs(TreeNode root, int distance) {
        // Array to store the count of good leaf node pairs
        int[] result = new int[1];
        countPairsHelper(root, distance, result);
        return result[0];
    }

    private int[] countPairsHelper(TreeNode node, int distance, int[] result) {
        if (node == null) return new int[distance + 1];
        
        if (node.left == null && node.right == null) {
            int[] leaves = new int[distance + 1];
            leaves[1] = 1;
            return leaves;
        }

        int[] leftLeaves = countPairsHelper(node.left, distance, result);
        int[] rightLeaves = countPairsHelper(node.right, distance, result);

        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance - i; j++) {
                result[0] += leftLeaves[i] * rightLeaves[j];
            }
        }

        int[] leaves = new int[distance + 1];
        for (int i = 1; i < distance; i++) {
            leaves[i + 1] = leftLeaves[i] + rightLeaves[i];
        }

        return leaves;
    }
}
