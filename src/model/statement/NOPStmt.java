package model.statement;

import exceptions.MyException;
import utils.PrgState;

public class NOPStmt implements Stmt{
    public PrgState execute(PrgState prg) throws MyException
    {
        return prg;
    }
    public Stmt deepCopy()
    {
        return new NOPStmt();
    }
    public String toString()
    {
        return "No operation.";
    }
}
