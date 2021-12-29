//程序员的算法题Q4

/*
m:人数  n:木棒长度，即要切分的段数  current:当前的木棒段数 x:操作次数
 */
public class CutBar {

    public static int cut(int m , int n, int current) {
        if(current >= n) {
            return 0;
        }else if(current < m) {
            return cut(m, n, current * 2) + 1;
        }else{
            return cut(m, n, current + m) + 1;
        }
    }

    public static void main(String[] args) {
        CutBar test = new CutBar();
        int x = 0, y = 0;
        x = test.cut(3, 20, 1);
        y = test.cut(5,100,1);
        System.out.println(x);
        System.out.println(y);
    }
}
