package model.expression;

import exceptions.DictionaryException;
import exceptions.ExpressionException;
import exceptions.MyException;
import model.values.Value;
import utils.dictionary.InterfaceDict;

public class VariableExp implements Exp{
    private final String id;


    public VariableExp(String id)
    {
        this.id=id;
    }
    public Value eval(InterfaceDict<String,Value> tbl) throws MyException
    {
        if (tbl.isDefined(id))
            return tbl.getValueFromKey(id);
        else
            throw new DictionaryException("Variable "+id +" is not defined!");
    }
    public Exp deepCopy()
    {
        return new VariableExp(id);
    }
    public String toString()
    {
        return id;
    }
}
