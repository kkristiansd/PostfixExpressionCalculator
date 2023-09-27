import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PostfixCalculator calculator = new PostfixCalculator();


        ArrayList<Token> tokenList = new ArrayList<>();
        tokenList.add(new Operand(5)); // Push the operand 5 onto the stack
        tokenList.add(new Operand(3)); // Push the operand 3 onto the stack
        tokenList.add(new Operator('+')); // Pop two operands, add them, and push the result


        int result = calculator.evaluateExpression(tokenList);
        System.out.println("Result: " + result);
    }
}