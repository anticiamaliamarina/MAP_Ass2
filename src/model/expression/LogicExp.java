package model.expression;

import exceptions.ExpressionException;
import exceptions.MyException;
import model.type.BoolType;
import model.values.BoolValue;
import model.values.Value;
import utils.dictionary.InterfaceDict;

public class LogicExp implements Exp{
    private Exp e1;
    private Exp e2;
    private int op;

    public LogicExp(Exp e1, Exp e2, int op)
    {
        this.e1=e1;
        this.e2=e2;
        this.op=op; //5 for AND, 6 for OR
    }

    @Override
    public Value eval(InterfaceDict<String,Value> tbl) throws MyException
    {
        Value v1, v2;
        v1=e1.eval(tbl);
        if (v1.getType().equals(new BoolType()))
        {
            v2=e2.eval(tbl);
            if (v2.getType().equals(new BoolType()))
            {
                BoolValue b1=(BoolValue)v1;
                BoolValue b2=(BoolValue) v2;
                boolean n1, n2;
                n1=b1.getValue();
                n2=b2.getValue();
                if (op==5)
                    return new BoolValue(n1&&n2);
                else
                    return new BoolValue(n1||n2);

            }
            else
                throw new ExpressionException("Second operand is not boolean!");
        }
        else
            throw new ExpressionException("First operand is not boolean!");
    }

    @Override
    public Exp deepCopy()
    {
        return new LogicExp(e1.deepCopy(), e2.deepCopy(), op);
    };
    @Override
    public String toString()
    {
        String getOp;
        if (op==5)
            getOp="&&";
        else
            //means op=6
            getOp="||";
        return e1.toString()+getOp+e2.toString();
    }
}
