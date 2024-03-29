package com.booboo.CAREN.Parser;

public class AssignmentStatement implements Node {
    protected Variable variable;
    protected Node expression;

    AssignmentStatement(Node expression, Variable variable){
        this.expression = expression;
        this.variable = variable;
    }

    @Override
    public int evaluate() throws SyntaxError {
        variable.addValue(expression.evaluate());
        System.out.println(variable.identifier + " -> " + variable.evaluate() );
        return 0;
    }
    
}
