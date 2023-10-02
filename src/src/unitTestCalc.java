import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.EmptyStackException;
public class unitTestCalc {

    @Test
    public void testEvaluateExpression_Addition() {
        PostfixCalculator calculator = new PostfixCalculator();
        ArrayList<Token> tokenList = new ArrayList<>();
        tokenList.add(new Operand(2));
        tokenList.add(new Operand(3));
        tokenList.add(new Operator('+'));
        int result = calculator.evaluateExpression(tokenList);
        assertEquals(5, result);
    }

    @Test
    public void testEvaluateExpression_Subtraction() {
        PostfixCalculator calculator = new PostfixCalculator();
        ArrayList<Token> tokenList = new ArrayList<>();
        tokenList.add(new Operand(5));
        tokenList.add(new Operand(3));
        tokenList.add(new Operator('-'));
        int result = calculator.evaluateExpression(tokenList);
        assertEquals(2, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testEvaluateExpression_DivisionByZero() {
        PostfixCalculator calculator = new PostfixCalculator();
        ArrayList<Token> tokenList = new ArrayList<>();
        tokenList.add(new Operand(5));
        tokenList.add(new Operand(0));
        tokenList.add(new Operator('/'));
        calculator.evaluateExpression(tokenList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEvaluateExpression_InvalidOperator() {
        PostfixCalculator calculator = new PostfixCalculator();
        ArrayList<Token> tokenList = new ArrayList<>();
        tokenList.add(new Operand(2));
        tokenList.add(new Operand(3));
        tokenList.add(new Operator('%')); // Invalid operator
        calculator.evaluateExpression(tokenList);
    }

    @Test(expected = EmptyStackException.class)
    public void testEvaluateExpression_EmptyStack() {
        PostfixCalculator calculator = new PostfixCalculator();
        ArrayList<Token> tokenList = new ArrayList<>();
        // No operands or operators in the token list
        calculator.evaluateExpression(tokenList);
    }
}
