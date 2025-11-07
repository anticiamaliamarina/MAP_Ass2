package model.statement;

import exceptions.MyException;
import model.expression.Exp;
import utils.PrgState;
import utils.list.ListInterface;
import model.values.*;

public class PrintStmt implements Stmt{
    private Exp expr;

    public PrintStmt(Exp exp)
    {
        this.expr=exp;
    }

    @Override
    public PrgState execute(PrgState prg) throws MyException
    {
        ListInterface<Value> output=prg.getOut();
        Value val;
        try {
            val=this.expr.eval(prg.getSymTable());
        }
        catch(MyException e)
        {
            throw new MyException(e.getMessage());
        }
        output.addItem(val);
        return prg;
    }
    @Override
    public Stmt deepCopy()
    {
        return new PrintStmt(expr.deepCopy());
    }
    @Override
    public String toString()
    {
        return "print( "+expr.toString()+" )";
    }
}
