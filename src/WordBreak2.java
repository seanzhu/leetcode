import com.sun.jdi.connect.Connector;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class WordBreak2 {
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        String newString = "#" + s;
        int length = newString.length();
        ArrayList<ArrayList<Integer>> trace = new ArrayList<ArrayList<Integer>>();
        trace.add(new ArrayList<Integer>());
        for (int i = 1; i < length; i++) {
            trace.add(null);
            for (int k = 0; k < i; k++) {
                if (trace.get(k) != null &&
                        dict.contains(newString.substring(k + 1, i + 1))) {
                    if (trace.get(i) == null) {
                        trace.set(i, new ArrayList<Integer>());
                    }
                    trace.get(i).add(k);
                }
            }
        }

        ArrayList<String> ret = new ArrayList<String>();
        if (trace.get(length - 1) == null)
            return ret;

        dfs(ret, trace, length - 1, 0, new Stack<String>(), newString);
        return ret;
    }

    // generate results using DFS
    private static void dfs(ArrayList<String> ret,
                            ArrayList<ArrayList<Integer>> trace,
                            int depth,
                            int level,
                            Stack<String> buffer,
                            String string) {
        if (depth == 0) {
            StringBuffer sb = new StringBuffer();
            while (!buffer.isEmpty()) {
                sb.append(buffer.pop());
                sb.append(" ");
            }
            ret.add(sb.toString().trim());
            return;
        }

        if (level >= trace.get(depth).size())
            return;

        Stack<String> newBuffer = (Stack<String>) buffer.clone();
        int prevIndex = trace.get(depth).get(level);
        newBuffer.push(string.substring(prevIndex + 1, depth + 1));
        dfs(ret, trace, prevIndex, 0, newBuffer, string);

        dfs(ret, trace, depth, level + 1, buffer, string);

    }




    public static void main(String[] args) {
        String string = "catsanddog";
        Set<String> dict = new HashSet<String>(){{
            add("cat");
            add("cats");
            add("and");
            add("sand");
            add("dog");
        }};

        ArrayList<String> result = wordBreak(string, dict);

        for (String s : result)
            System.out.println(s);
    }

}
