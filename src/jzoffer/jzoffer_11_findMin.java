package jzoffer;

public class jzoffer_11_findMin {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                // 如果相等，去重
                right--;
            }
        }
        return numbers[left];
    }
}
