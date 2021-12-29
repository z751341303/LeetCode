package array;

import java.util.*;


public class LC_399_Division {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 统计所有出现过的字符，并赋予对应的索引值
        int index = 0;
        Map<String, Integer> map=new HashMap<>();
        for (List<String> list:equations){
            for (String s:list){
                if(!map.containsKey(s)){
                    map.put(s, index++);
                }
            }
        }
        // 用矩阵作图结构
        double[][] graph = new double[index][index];
        for (int i = 0; i < index; i++) {
            Arrays.fill(graph[i], -1.0);
        }
        int x=0;
        for (List<String> list:equations) {
            int a=map.get(list.get(0));
            int b=map.get(list.get(1));
            double value = values[x++];
            graph[a][b] = value;
            graph[b][a] = 1 / value;
        }
        for (int k = 0; k < index; k++) {
            for (int i = 0; i < index; i++) {
                for (int j = 0; j < index; j++) {
                    if (graph[i][k] > 0 && graph[k][j] > 0) {
                        graph[i][j] = graph[i][k] * graph[k][j];
                    }
                }
            }
        }
        // 查表
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String ia = query.get(0);
            String ib = query.get(1);
            if (map.containsKey(ia) && map.containsKey(ib)) {
                double ans = graph[map.get(ia)][map.get(ib)];
                res[i] = ans > 0 ? ans : -1.0;
            } else {
//                res[i] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> eq1 = Arrays.asList("a","b");
        List<String> eq2 = Arrays.asList("b","c");
        equations.add(eq1);
        equations.add(eq2);
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> q1 = Arrays.asList("a","c");
        List<String> q2 = Arrays.asList("b","a");
        List<String> q3 = Arrays.asList("a","e");
        List<String> q4 = Arrays.asList("a","a");
        List<String> q5 = Arrays.asList("x","x");
        queries.add(q1);
        queries.add(q2);
        queries.add(q3);
        queries.add(q4);
        queries.add(q5);
        System.out.println(Arrays.toString(new LC_399_Division().calcEquation(equations, values, queries)));
    }
}
