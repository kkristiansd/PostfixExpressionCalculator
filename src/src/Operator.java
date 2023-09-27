public class Operator implements Token {
    private char operator;

    public Operator(char operator) {
        this.operator = operator;
    }

    public char getOperatorCharacter() {
        return operator;
    }
}
