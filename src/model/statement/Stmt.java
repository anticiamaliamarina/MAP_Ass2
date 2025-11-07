package model.statement;

import exceptions.MyException;
import utils.PrgState;

public interface Stmt {
    PrgState execute(PrgState prg) throws MyException;
    Stmt deepCopy();
    String toString();
}
