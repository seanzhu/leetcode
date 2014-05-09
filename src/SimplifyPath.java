import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return "/";

        Stack<String> stack = new Stack<String>();
        String[] splits = path.trim().split("/");
        for (String str : splits) {
            if (str == null || str.length() == 0 || str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(str);
            }
        }

        if (stack.isEmpty())
            return "/";

        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty()) {
            buffer.insert(0, stack.pop());
            buffer.insert(0, "/");
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        SimplifyPath test = new SimplifyPath();
        System.out.println(test.simplifyPath("/.."));
    }
}
