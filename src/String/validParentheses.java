package String;

import java.util.Stack;

/**
 * Created by janet1 on 6/17/18.
 */
public class validParentheses {

        public static boolean isValid(String s) {


            Stack<Character> stack = new Stack<Character>();
            for (char c : s.toCharArray()) {
                if (c == '(')
                    stack.push(')');
                else if (c == '{')
                    stack.push('}');
                else if (c == '[')
                    stack.push(']');
                else if (stack.isEmpty() || stack.pop() != c)
                    return false;
            }
            return stack.isEmpty();
        }

    public static void main(String[] args) {
        String s = "()";
        String s1 = "[}";
        System.out.println(isValid(s));
        System.out.println(isValid(s1));

    }
}
