package model.statement;

import exceptions.MyException;
import model.expression.Exp;
import model.type.BoolType;
import utils.PrgState;
import model.values.*;
import utils.stack.InterfaceMyStack;

public class IfStmt implements Stmt{
    private Exp exp;
    private Stmt stmt1;
    private Stmt stmt2;
    public IfStmt(Exp exp, Stmt stmt1, Stmt stmt2  ) {
        this.exp = exp;
        this.stmt1 = stmt1;
        this.stmt2=stmt2;
    }

    public PrgState execute(PrgState prg) throws MyException
    {
        Value val;
        try {
            val=exp.eval(prg.getSymTable());
        }catch(MyException e)
        {
            throw new MyException(e.getMessage());
        }

        if (!val.getType().equals(new BoolType()))
        {
            throw new MyException("Expression is not boolean!");
        }
        BoolValue cond=(BoolValue) val;
        InterfaceMyStack<Stmt> stack=prg.getExeStack();
        if (cond.getValue())
            stack.push(stmt1);
        else
            stack.push(stmt2);
        return prg;
    }
    public Stmt deepCopy()
    {
        return new IfStmt(exp.deepCopy(), stmt1.deepCopy(), stmt2.deepCopy());
    }
    public String toString()
    {
        return "if ("+exp.toString()+") then ("+stmt1.toString()+") else ("+ stmt2.toString()+" )";
    }
}
