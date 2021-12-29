package jzoffer;

public class jzoffer_16_pow {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        // 移位代替除以2
        double res = myPow(x, n >> 1);
        res *= res;
        // 与运算代替模运算判断奇偶
        if ((n & 1) == 1) {
            res *= x;
        }
        return res;
    }
}
