package backtrack;/*
17. 电话号码的字母组合
https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_17_PhoneNumber {
    Map<Character, String> map = new HashMap<Character, String>(){{;
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        Search(res, digits, "", 0);
        return res;
    }
    private void Search(List<String> res, String digits, String ans, int i){
        if(i == digits.length()){
            res.add(ans);
            return;
        }
        char[] str = map.get(digits.charAt(i)).toCharArray();
        for(char c : str){
            ans += c;
            Search(res, digits, ans, i+1);
            ans = ans.substring(0, ans.length()-1);
        }
    }

    public static void main(String[] args) {
        LC_17_PhoneNumber test = new LC_17_PhoneNumber();
        System.out.println(test.letterCombinations("23"));
    }
}
