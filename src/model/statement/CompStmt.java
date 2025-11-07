package model.statement;

import exceptions.MyException;
import utils.PrgState;
import utils.stack.InterfaceMyStack;

public class CompStmt implements Stmt{
    private Stmt first;
    private Stmt second;

    public CompStmt(Stmt first, Stmt second)
    {
        this.first=first;
        this.second=second;
    }

    @Override
    public PrgState execute(PrgState prg) throws MyException
    {
        InterfaceMyStack<Stmt> prog=prg.getExeStack();
        prog.push(second);
        prog.push(first);
        return prg;
    }
    @Override
    public Stmt deepCopy(){
        return new CompStmt(first.deepCopy(), second.deepCopy());
    }
    @Override
    public String toString()
    {
        return "( "+first.toString()+" | "+second.toString();
    }
}
