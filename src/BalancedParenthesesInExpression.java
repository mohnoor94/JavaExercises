import java.util.Stack;

public class BalancedParenthesesInExpression {

    private static final char[][] TOKENS = {{'{', '}'}, {'(', ')'}, {'[', ']'}};

    public static void main(String[] args) {
        System.out.println(isBalanced("{([])}"));
        System.out.println(isBalanced("{([])"));
        System.out.println(isBalanced("{([[)}"));
        System.out.println(isBalanced("{(]])}"));
        System.out.println(isBalanced("()"));
        System.out.println(isBalanced("(hello)"));
        System.out.println(isBalanced("{.(,[hi],).}"));
        System.out.println(isBalanced("{.(},[hi],{).}"));
    }

    private static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray())
            if (notTerm(c)) continue;
            else if (isOpenTerm(c)) stack.push(c);
            else if (stack.isEmpty() || !matches(stack.pop(), c)) return false;
        return stack.isEmpty();
    }

    private static boolean notTerm(char c) {
        for (char[] token : TOKENS) if (token[0] == c || token[1] == c) return false;
        return true;
    }

    private static boolean isOpenTerm(char term) {
        for (char[] token : TOKENS) if (token[0] == term) return true;
        return false;
    }

    private static boolean matches(char openTerm, char closeTerm) {
        for (char[] token : TOKENS) if (token[0] == openTerm && token[1] == closeTerm) return true;
        return false;
    }
}