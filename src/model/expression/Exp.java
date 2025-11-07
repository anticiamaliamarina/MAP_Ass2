package model.expression;
import exceptions.MyException;
import model.values.*;
import utils.dictionary.InterfaceDict;
import utils.dictionary.MyDict;
import exceptions.ExpressionException;

public interface Exp {
    Value eval(InterfaceDict<String,Value> tbl) throws MyException;
    Exp deepCopy();
    String toString();
}
