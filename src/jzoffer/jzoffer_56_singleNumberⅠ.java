package jzoffer;

public class jzoffer_56_singleNumberⅠ {
    /*
    如果数组中只有一个数字只出现过一次，其他数字都出现两次，那全部异或的结果就是该数
     */
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for(int num : nums) {
            n ^= num;
        }
        // 左移操作直到找到两个数的二进制不同位
        // n & m == 1时说明这一位的异或结果为1
        // 例如 n & 0010 = 1 表示n的从低往高数第二位是1
        while((n & m) == 0) {
            m <<= 1;
        }
        for(int num: nums) {
            if((num & m) == 0) x ^= num;
            else y ^= num;
        }
        return new int[] {x, y};
    }
}
