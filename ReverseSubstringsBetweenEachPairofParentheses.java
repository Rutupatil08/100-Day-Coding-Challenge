class Solution {
    public String reverseParentheses(String s) {
        return helper(s.toCharArray(), new int[]{0});
    }

    private String helper(char[] s, int[] i) {
        StringBuilder sb = new StringBuilder();
        while (i[0] < s.length) {
            if (s[i[0]] == ')') {
                i[0]++;
                return sb.reverse().toString();
            } else if (s[i[0]] == '(') {
                i[0]++;
                sb.append(helper(s, i));
            } else {
                sb.append(s[i[0]++]);
            }
        }
        return sb.toString();
    }
}
