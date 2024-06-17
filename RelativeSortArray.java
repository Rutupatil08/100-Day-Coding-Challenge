class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int maxEl = Arrays.stream(arr1).max().getAsInt();
        int[] freq = new int[maxEl + 1];
        for (int el : arr1)
            freq[el]++;

        List<Integer> ans = new ArrayList<>();
        for (int el : arr2) {
            while (freq[el]-- > 0) {
                ans.add(el);
            }
        }
        for (int el = 0; el <= maxEl; el++) {
            int f = freq[el];
            while (f > 0 && f-- > 0) {
                ans.add(el);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
