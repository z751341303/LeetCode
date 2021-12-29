package jzoffer;

public class jzoffer_43_countOne {
    public int countDigitOne(int n) {
        int count = 0;
        long i = 1;
        long high = n / 10, cur = n % 10, low = 0;
        // 循环出口：所有位都统计完
        while (n / i != 0) {
            // 如果当前位为0，该位出现过1的次数即为高位的真实值
            if (cur == 0) {
                count += high * i;
            } else if (cur == 1) {
                count += high * i + low + 1;
            } else {
                count += (high + 1) * i;
            }
            low += cur * i;
            cur = high % 10;
            high = high / 10;
            i *= 10;
        }
        return count;
    }
}
