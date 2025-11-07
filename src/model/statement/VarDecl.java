package model.statement;

import exceptions.AlreadyExists;
import exceptions.MyException;
import utils.PrgState;
import model.type.*;
import utils.dictionary.InterfaceDict;
import model.values.*;

public class VarDecl implements Stmt{
    private String id;
    private Type type;

    public VarDecl(String id, Type type)
    {
        this.id=id;
        this.type=type;
    }
    public PrgState execute(PrgState prg) throws MyException
    {
        InterfaceDict<String, Value> symTable=prg.getSymTable();
        if (symTable.isDefined(id))
            throw new AlreadyExists("Variable already declared!");
        symTable.addToDictionary(id, type.defaultValue());

        return prg;

    }
    public Stmt deepCopy()
    {
        return new VarDecl(id, type.deepCopy());
    }
    public String toString()
    {
        return "( "+id+"->"+type.toString()+" )";
    }
}
