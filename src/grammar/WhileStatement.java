package grammar;

public class WhileStatement implements Node{

    protected Node expression;
    protected Node loopStatement;

    WhileStatement(Node expression, Node loopStatement){
        this.expression = expression;
        this.loopStatement = loopStatement;
    }


    @Override
    public double evaluate() throws SyntaxError {

        if(expression.evaluate() != 1.0){
            loopStatement.evaluate();
        }
        return 0;
    }
       
}
