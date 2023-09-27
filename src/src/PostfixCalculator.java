import java.util.ArrayList;
import java.util.EmptyStackException;

public class PostfixCalculator {
    public int evaluateExpression(ArrayList<Token> tokenList) {
        LinkedList<Integer> stack = new LinkedList<>();

        for (Token token : tokenList) {
            if (token instanceof Operand) {
                stack.push(((Operand) token).getValue());
            } else if (token instanceof Operator) {
                char operatorChar = ((Operator) token).getOperatorCharacter();

                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operatorChar, operand1, operand2);
                stack.push(result);
            }
        }

        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.pop();
    }

    private int performOperation(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
