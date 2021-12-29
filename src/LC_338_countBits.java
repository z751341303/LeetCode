public class LC_338_countBits {
    // dp方法
    public int[] countBits_A(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        if (n == 0) {
            return res;
        }
        for (int i = 1; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = res[i - 1];
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }

    // 暴力解法：重点是下面的Brian Kernighan算法
    public int[] countBits_B(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }
    // Brian Kernighan 算法的原理是：
    // 对于任意整数 xx，令 x = x & (x-1)
    // 该运算将 xx 的二进制表示的最后一个 1 变成 0 。
    // 因此，对 xx 重复该操作，直到 xx 变成 00，则操
    // 作次数即为 xx 的「一比特数」。
    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
}
