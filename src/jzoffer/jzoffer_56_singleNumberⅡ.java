package jzoffer;

public class jzoffer_56_singleNumberⅡ {
    /*
    如果把所有的出现三次的数字的二进制表示的每一位都分别加起来，那么每一位都能被3整除
    */
    public int singleNumberA(int[] nums) {
        int[] binary = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                if ((nums[i] >> j & 1) == 1) {
                    binary[j]++;
                }
            }
        }
        int res = 0;
        // (binary[i] % 3 == 0)成立对应的位，只出现一次的数字也为0
        for (int i = 0; i < 32; i++) {
            if (binary[i] % 3 != 0) {
                res += 1 << i;
            }
        }
        return res;
    }

    /*
    0 ^ x = x,
    x ^ x = 0；
    x & ~x = 0,
    x & ~0 =x;
    一开始a = 0, b = 0;
    x第一次出现后，a = (a ^ x) & ~b的结果为 a = x, b = (b ^ x) & ~a的结果为 b = 0.
    x第二次出现：a = (a ^ x) & ~b, a = (x ^ x) & ~0, a = 0; b = (b ^ x) & ~a 化简， b = (0 ^ x) & ~0 , b = x;
    x第三次出现：a = (a ^ x) & ~b, a = (0 ^ x) & ~x, a = 0; b = (b ^ x) & ~a 化简， b = (x ^ x) & ~0 , b = 0;
    所以出现三次的同一个数，a和b最终都变回了0. 只出现一次的数，按照上面x第一次出现的规律可知a = x, b = 0;因此最后返回a.
    */
    public int singleNumberB(int[] nums) {
        int a = 0;
        int b = 0;

        for(int num : nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }

        return a;
    }

}
