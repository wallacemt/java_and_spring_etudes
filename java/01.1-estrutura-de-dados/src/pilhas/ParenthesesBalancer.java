package pilhas;

import java.util.Stack;

public class ParenthesesBalancer {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();

            }
        }


         return stack.isEmpty();
    }


    static void main(String[] args) {
        String[] expressions = {
                "(a + b)",
                "((a - b) * c)",
                "(a * (b + c)"
        };
        for (String c : expressions) {
            System.out.println("A Expressao " + c + " esta balanceada?: " + isBalanced(c));

        }
    }

}
