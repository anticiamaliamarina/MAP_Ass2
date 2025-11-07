package model.expression;

import exceptions.ExpressionException;
import exceptions.MyException;
import model.values.Value;
import utils.dictionary.InterfaceDict;

public class ConstantValue implements Exp{
    private Value val;
    public ConstantValue(Value val)
    {
        this.val=val;
    }
    public Value eval(InterfaceDict<String,Value> tbl) throws MyException, ExpressionException
    {
        return this.val;
    }
    public Exp deepCopy()
    {
        return new ConstantValue(val.deepCopy());
    }
    public String toString()
    {
        return val.toString();
    }

}
