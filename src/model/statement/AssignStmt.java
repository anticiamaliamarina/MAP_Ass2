package model.statement;

import exceptions.MyException;
import exceptions.NotDeclared;
import exceptions.NotMatchException;
import utils.PrgState;
import model.expression.*;
import utils.dictionary.InterfaceDict;
import model.values.*;
import model.type.*;

public class AssignStmt implements Stmt{
    private String id;
    private Exp expr;

    public AssignStmt(String id, Exp expr)
    {
        this.id=id;
        this.expr=expr;
    }

    @Override
    public PrgState execute(PrgState prg) throws MyException
    {
        InterfaceDict<String, Value> table=prg.getSymTable();
        if (table.isDefined(id))
        {
            Value val=expr.eval(table);
            Type type=table.getValueFromKey(id).getType();
            if (val.getType().equals(type))
            {
                table.updateDictionary(id, val);
            }
            else
            {
                throw new NotMatchException("Type of expression and assignament do not match!");
            }
        }
        else
            throw new NotDeclared("Variable was not declared!");

        return prg;
    }
    @Override
    public Stmt deepCopy()
    {
        return new AssignStmt(id, expr.deepCopy());
    }
    @Override
    public String toString()
    {
        return id+"="+expr.toString();
    }
}
