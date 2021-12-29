package string;

import java.util.LinkedList;

public class LC_394_decodeString {
    public String decodeString(String s) {
        char[] str = s.toCharArray();
        LinkedList<Integer> stack_int = new LinkedList<>();
        LinkedList<String> stack_str = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int multi = 0;
        for (Character c : str) {
            if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(String.valueOf(c));
            } else if (c == '[') {
                stack_int.addLast(multi);
                stack_str.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                int n = stack_int.removeLast();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(stack_str.removeLast() + temp);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
