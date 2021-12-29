package greedy;

import java.util.Arrays;

public class LC_135_Candy {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candy[i + 1] = candy[i] + 1;
            }
        }
        for (int i = ratings.length - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candy[i - 1] = Math.max(candy[i] + 1, candy[i - 1]);
            }
        }
        int res = 0;
        for (int num : candy) {
            res += num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ratings = new int[]{1, 0, 2};
        System.out.println(new LC_135_Candy().candy(ratings));
    }
}
