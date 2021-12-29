package jzoffer;

public class jzoffer_14_cuttingRope {
    public int cuttingRope(int n) {
        if (n==1 || n==2)
            return 1;
        if (n == 3) {
            return 2;
        }
        // 数论，将数拆分为2和3的乘积是最好的
        int sum = 1;
        while (n > 4) {
            n -= 3;
            sum *= 3;
        }
        return sum * n;
    }
}
