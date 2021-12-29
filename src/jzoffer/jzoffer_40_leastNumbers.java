package jzoffer;

import java.util.Arrays;

public class jzoffer_40_leastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        qsort(arr, 0, arr.length - 1, k - 1);
        return Arrays.copyOf(arr, k);
    }
    private void qsort(int[] arr, int left, int right, int target) {
        if (right <= left) return;
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j) {
            while (arr[j] >= pivot && i < j) j--;
            arr[i] = arr[j];
            while (arr[i] <= pivot && i < j) i++;
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        if (i > target) {
            qsort(arr, left, i-1, target);
        }
        else {
            qsort(arr, left, i-1, target);
            qsort(arr, j+1, right, target);
        }
    }
}
