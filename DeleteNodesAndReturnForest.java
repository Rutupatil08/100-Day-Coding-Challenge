class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> to_delete_set = new HashSet<>();
        for (int val : to_delete) {
            to_delete_set.add(val);
        }
        List<TreeNode> res = new ArrayList<>();
        if (!to_delete_set.contains(root.val)) {
            res.add(root);
        }
        dfs(root, to_delete_set, res);
        return res;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> to_delete_set, List<TreeNode> res) {
        if (node == null) return null;
        node.left = dfs(node.left, to_delete_set, res);
        node.right = dfs(node.right, to_delete_set, res);
        if (to_delete_set.contains(node.val)) {
            if (node.left != null) res.add(node.left);
            if (node.right != null) res.add(node.right);
            return null;
        }
        return node;
    }
}
