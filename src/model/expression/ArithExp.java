package model.expression;

import exceptions.ExpressionException;
import exceptions.MyException;
import model.type.IntType;
import utils.dictionary.InterfaceDict;
import utils.dictionary.MyDict;
import model.values.*;

public class ArithExp implements Exp {
    private Exp e1;
    private Exp e2;
    private int op;

    public ArithExp(Exp e1, Exp e2, int op) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    @Override
    public Value eval(InterfaceDict<String, Value> tbl) throws MyException, ExpressionException
    {
        Value v1, v2;
        v1 = e1.eval(tbl);
        if (v1.getType().equals(new IntType()))
        {
            v2 = e2.eval(tbl);
            if (v2.getType().equals(new IntType()))
            {
                IntValue i1 = (IntValue) v1;
                IntValue i2 = (IntValue) v2;
                int n1, n2;
                n1 = i1.getValue();
                n2 = i2.getValue();
                if (op == 1)
                    return new IntValue(n1 + n2);
                else if (op == 2)
                    return new IntValue(n1 - n2);
                else if (op == 3)
                    return new IntValue(n1 * n2);
                else //reach here means operand 4, / //check valid operand in view
                    if (n2 == 0)
                        throw new MyException("Division by zero!");
                    else
                        return new IntValue(n1 / n2);
            } else
                throw new ExpressionException("Second operand is not an integer!");
        } else
            throw new ExpressionException("First operand is not an integer!");
    }

    @Override
    public Exp deepCopy()
    {
        return new ArithExp(e1.deepCopy(),e2.deepCopy(),op);
    }
    @Override
    public String toString()
    {
        String getOp;
        if (op==1)
            getOp="+";
        else if (op==2)
            getOp="-";
        else if(op==3)
            getOp="*";
        else
            getOp="/";
        return e1.toString()+getOp+e2.toString();
    }

}