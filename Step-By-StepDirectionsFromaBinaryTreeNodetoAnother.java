class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();
        
        // Find path from root to startValue
        findPath(root, startValue, pathToStart);
        // Find path from root to destValue
        findPath(root, destValue, pathToDest);
        
        // Find the first point where paths diverge
        int i = 0;
        while (i < pathToStart.length() && i < pathToDest.length() && pathToStart.charAt(i) == pathToDest.charAt(i)) {
            i++;
        }
        
        // Steps to go up to the LCA
        String upSteps = "U".repeat(pathToStart.length() - i);
        
        // Steps to go down to the destination
        String downSteps = pathToDest.substring(i);
        
        return upSteps + downSteps;
    }
    
    private boolean findPath(TreeNode root, int value, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        }
        
        path.append('L');
        if (findPath(root.left, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        path.append('R');
        if (findPath(root.right, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        return false;
    }
}
