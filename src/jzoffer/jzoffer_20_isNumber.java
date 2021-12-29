package jzoffer;

public class jzoffer_20_isNumber {
    public boolean isNumber(String s) {
        // s为空对象或 s长度为0(空字符串)时, 不能表示数值
        if(s == null || s.length() == 0) return false;
        // 标记是否遇到数位、小数点、‘e’或'E'
        boolean isNum = false, isDot = false, isE = false;
        // 删除字符串头尾的空格，转为字符数组，方便遍历判断每个字符
        char[] str = s.trim().toCharArray();
        for(int i = 0; i < str.length; i++) {
            // 判断当前字符是否为 0~9 的数位
            if(str[i] >= '0' && str[i] <= '9') {
                isNum = true;
            }
            // 遇到正负符号
            else if(str[i] == '-' ||str[i] == '+') {
                // 正负号只可能出现在第一个位置，或者出现在‘e’或'E'的后面一个位置
                if(i != 0 && str[i-1] != 'e' && str[i-1] != 'E') return false;
            }
            // 遇到小数点
            // 1. 小数点前后都可以没有数字，例如.123等于0.123，233.等于233.0；
            // 2. 小数点前后都有数字，例如233.666
            else if(str[i] == '.') {
                // 小数点之前可以没有整数，但是不能重复出现小数点、或出现‘e’、'E'
                if(isDot || isE) return false;
                // 标记已经遇到小数点
                isDot = true;
            }
            // 遇到‘e’或'E'
            // 1. 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
            // 2. 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4
            else if(str[i] == 'e' || str[i] == 'E') {
                // ‘e’或'E'前面必须有整数，且前面不能重复出现‘e’或'E'
                if(!isNum || isE) return false;
                // 标记已经遇到‘e’或'E'
                isE = true;
                // 重置isNum，因为‘e’或'E'之后也必须接上整数，需要新的数字出现把isNum置为true，防止出现 123e或者123e+的非法情况
                isNum = false;
            }
            // 其它情况均为不合法字符
            else return false;
        }
        return isNum;
    }
}
