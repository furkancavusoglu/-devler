import java.util.*;

public class Expression {
    /*****************************************************************
     * Converts an infix expression to a postfix expression and returns
     * a pointer to the buffer containing the postfix expression
     *****************************************************************/
    public static String Infix2Postfix(String infixExpr) {
// initializing empty String for result
        String result = new String("");
        // initializing empty stack
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infixExpr.length(); ++i) {
            char c = infixExpr.charAt(i);
            if (c == ' ')
                continue;
            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;
                // If the scanned character is an '(', push it to the stack.
            else if (c == '(') {
                result += " ";
                stack.push(c);
            }
            //  If the scanned character is an ')', pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += " " + stack.pop();
                stack.pop();
            } else { // an operator is encountered
                result += " ";
                while (!stack.isEmpty() && (c == '+' && stack.peek() == '+' || c == '+' && stack.peek() == '-' || c == '+' && stack.peek() == '*' || c == '+' && stack.peek() == '/'
                        || c == '-' && stack.peek() == '+' || c == '-' && stack.peek() == '-' || c == '-' && stack.peek() == '*' || c == '-' && stack.peek() == '/'))
                    result += " " + stack.pop() + " ";
                stack.push(c);
            }
        }
        // pop all the operators from the stack
        while (!stack.isEmpty())
            result += " " + stack.pop();
        result = result.trim();
        result = result.replaceAll("  ", " ");
        return result;
    }
// end-Infix2Postfix

    /*****************************************************************
     * Given an expression in postfix form, evaluates the expression and returns the result
     *****************************************************************/
    public static int EvaluatePostfixExpression(String postfixExpr) {
        Stack<Integer> s = new Stack<>();
        String[] items = postfixExpr.split(" ");
        for (String item : items) {
            try {
                s.push(Integer.valueOf(item));
            } catch (NumberFormatException e) {
                if (s.size() > 1) {
                    Integer value1 = s.pop();
                    Integer value2 = s.pop();
                    switch (item) {
                        case "+":
                            s.push(value2 + value1);
                            break;
                        case "-":
                            s.push(value2 - value1);
                            break;
                        case "*":
                            s.push(value2 * value1);
                            break;
                        case "/":
                            s.push(value2 / value1);
                            break;
                    }
                }
            }
        }
        return s.pop();
    } //end-EvaluatePostfixExpression

    /*****************************************************************
     * Given a postfix expression, converts this to an expression tree
     * and returns a pointer to the root of the tree
     *****************************************************************/
    public static ExpressionTreeNode Postfix2ExpressionTree(String postfixExpr) {
        Stack<ExpressionTreeNode> s = new Stack<ExpressionTreeNode>();
        byte operator = 0;
        byte operand = 1;
        ExpressionTreeNode root;
        String[] items = postfixExpr.split(" ");
        for (String item : items) {
            if (Character.isDigit(item.charAt(0))) {
                ExpressionTreeNode digit = new ExpressionTreeNode(operand);
                digit.operand = Integer.parseInt(item);
                s.push(digit);
            } else {
                ExpressionTreeNode arithmaticOperator = new ExpressionTreeNode(operator);
                arithmaticOperator.right = s.pop();
                arithmaticOperator.left = s.pop();
                arithmaticOperator.operator = item.charAt(0);
                s.push(arithmaticOperator);
            }
        }
        root = s.pop();
        return root;
    } //end-Postfix2ExpressionTree

    /*****************************************************************
     * Given a pointer to the root of an expression tree, evaluates
     * the expression tree, and returns the result
     *****************************************************************/
    public static int EvaluateExpressionTree(ExpressionTreeNode root) {
        // Checking empty tree
        if (root == null)
            return 0;

       // accessing the leaf node
        if (root.left == null && root.right == null)
            return root.operand;

        // Evaluating right tree
        int right_sum = EvaluateExpressionTree(root.right);

        // Evaluating left tree
        int left_sum = EvaluateExpressionTree(root.left);

        switch (root.operator) {
            case '+':
                return left_sum + right_sum;
            case '-':
                return left_sum - right_sum;
            case '*':
                return left_sum * right_sum;
            case '/':
                return left_sum / right_sum;
            default:
                return 0;
        }
    } //end-EvaluateExpressionTree
};
