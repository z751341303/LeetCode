package sort;

import tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

class quickSort {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1};
        qsort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void qsort(int[] arr, int left, int right) {
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
        qsort(arr, left, i-1);
        qsort(arr, j+1, right);
    }
}