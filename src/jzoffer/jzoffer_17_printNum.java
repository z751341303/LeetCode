package jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jzoffer_17_printNum {
//    int[] res;
//    int index = 0;
//    StringBuilder str;
//    char[] loop = new char[]{'0','1','2','3','4','5','6','7','8','9'};
//    public int[] printNumbers(int n) {
//        res = new int[(int)Math.pow(10, n) - 1];
//        str = new StringBuilder();
//        dfs(n);
//        return res;
//    }
//    void dfs(int n) {
//        if (str.length() == n && index < res.length) {
//            if (! str.toString().equals("0"))
//                res[index++] = Integer.parseInt(str.toString());
//            return;
//        }
//        for (int i = 0; i < 10; i++) {
//            str.append(loop[i]);
//            dfs(n);
//            str.deleteCharAt(str.length() - 1);
//        }
//    }
    public int[] printNumbers(int n) {
        List<Character> path = new ArrayList<>();
        List<String> ansList = new ArrayList<>();
        dfs(n, 0, ansList, path);
        int[] ans = new int[ansList.size()];
        for(int i = 0; i < ansList.size(); i++){
            ans[i] = Integer.valueOf(ansList.get(i));
        }
        return ans;
    }

    private void dfs(int n, int  depth, List<String> ansList, List<Character> path){
        //此时构建字符串形式的数字
        if(depth == n){
            StringBuilder sb = new StringBuilder();
            // flag表示前导字符是否是0
            boolean flag = false;
            for(int i = 0; i < n; i++){
                Character c = path.get(i);
                //忽略字符串中的前导0字符
                if(flag || !c.equals('0')){
                    flag = true;
                    sb.append(c);
                }
            }

            //全是0字符组成的，跳过
            if(!flag){
                return;
            }
            //将有效字符串放到列表里面
            String sNum = sb.toString();
            ansList.add(sNum);
            return;
        }
        for(char i = '0'; i <= '9'; i++){
            //当前路径中添加当前数字的字符形式；
            path.add(i);
            dfs(n, depth+1, ansList, path);
            //回溯
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new jzoffer_17_printNum().printNumbers(2)));
    }
}
