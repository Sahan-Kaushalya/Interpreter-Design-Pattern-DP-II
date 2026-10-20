package lk.kaushalya.model;

// this is rule for the interpreter pattern
// interpret method cannot be void, it should return a value
interface  Expression{
    public int interpret();
}

class TerminalExpression implements Expression{

    private int value;

    public TerminalExpression(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return this.value;
    }
}

class NonTerminalExpression implements Expression{

    private Expression ex1;
    private Expression ex2;

    public NonTerminalExpression(Expression ex1, Expression ex2) {
        this.ex1 = ex1;
        this.ex2 = ex2;
    }

    @Override
    public int interpret() {
        return ex1.interpret() + ex2.interpret();
    }
}

public class Test {
    public static void main(String[] args) {
        Expression e1 = new NonTerminalExpression(
                new TerminalExpression(10),
                new TerminalExpression(20)
        );

        Expression e2 = new NonTerminalExpression(
                new NonTerminalExpression(
                        new TerminalExpression(10),
                        new TerminalExpression(20)
                ), new TerminalExpression(50)
        );

        Expression e3 = new NonTerminalExpression(
                new NonTerminalExpression(
                        new NonTerminalExpression(
                                new TerminalExpression(10),
                                new TerminalExpression(20)
                        ),
                        new TerminalExpression(30)
                ), new NonTerminalExpression(
                        new TerminalExpression(40),
                        new TerminalExpression(50)
                )
        );

        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println("Interpreter Pattern");
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.println("Result e1: "+e1.interpret());
        System.out.println("Result e2: "+e2.interpret());
        System.out.println("Result e3: "+e3.interpret());
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println(" End of Interpreter Pattern");
        System.out.println("------------------------------------------------");

    }
}
