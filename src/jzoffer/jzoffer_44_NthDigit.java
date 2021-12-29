package jzoffer;

public class jzoffer_44_NthDigit {
    /* 数字范围     数量    位数    占多少位
        1-9        9       1      9
        10-99      90      2      180
        100-999    900     3      2700
        1000-9999  9000    4      36000  ...
    */
    public int findNthDigit(int n) {
        // 位数
        int digit = 1;
        // 范围起始值，所占位数
        long start = 1, count = 9;
        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            count = start * digit * 9;
        }
        // 判断在哪个数里(最先是从0开始的)
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
