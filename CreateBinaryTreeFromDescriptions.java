class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> childrenSet = new HashSet<>();
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;

            TreeNode parent = nodeMap.computeIfAbsent(parentVal, k -> new TreeNode(parentVal));
            TreeNode child = nodeMap.computeIfAbsent(childVal, k -> new TreeNode(childVal));

            childrenSet.add(childVal);

            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        int rootVal = 0;
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            if (!childrenSet.contains(parentVal)) {
                rootVal = parentVal;
                break;
            }
        }

        return nodeMap.get(rootVal);
    }
}
