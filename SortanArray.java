class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        if (high - low < 10) { // Use insertion sort for small arrays
            insertionSort(array, low, high);
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private void merge(int[] array, int low, int mid, int high) {
        int[] leftPart = Arrays.copyOfRange(array, low, mid + 1);
        int[] rightPart = Arrays.copyOfRange(array, mid + 1, high + 1);

        int p1 = 0, p2 = 0, writeInd = low;
        while (p1 < leftPart.length && p2 < rightPart.length) {
            if (leftPart[p1] <= rightPart[p2]) {
                array[writeInd++] = leftPart[p1++];
            } else {
                array[writeInd++] = rightPart[p2++];
            }
        }

        while (p1 < leftPart.length) {
            array[writeInd++] = leftPart[p1++];
        }

        while (p2 < rightPart.length) {
            array[writeInd++] = rightPart[p2++];
        }
    }

    private void insertionSort(int[] array, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= low && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
