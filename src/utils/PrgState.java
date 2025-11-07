package utils;
import utils.dictionary.InterfaceDict;
import utils.dictionary.MyDict;
import utils.list.ListInterface;
import utils.list.MyList;
import utils.stack.InterfaceMyStack;
import utils.stack.MyStack;
import model.statement.*;
import model.values.*;


public class PrgState {
    private InterfaceMyStack<Stmt> exeStack;
    private InterfaceDict<String, Value> symTable;
    private ListInterface<Value> Out;

    public PrgState(InterfaceMyStack<Stmt> stack, InterfaceDict<String,Value> dict, ListInterface<Value> out, Stmt orgPrg)
    {
        this.exeStack=stack;
        this.symTable=dict;
        this.Out=out;
        exeStack.push(orgPrg);
    }
    public InterfaceMyStack<Stmt> getExeStack()
    {
        return exeStack;
    }
    public InterfaceDict<String,Value> getSymTable()
    {
        return symTable;
    }
    public ListInterface<Value> getOut()
    {
        return Out;
    }

    public void setExeStack(InterfaceMyStack<Stmt> stk)
    {
        this.exeStack=stk;
    }
    public void setSymTable(InterfaceDict<String, Value> dict)
    {
        this.symTable=dict;
    }
    public void setOut(ListInterface<Value> lst)
    {
        this.Out=lst;
    }

    public String toString()
    {
        return "\nProgram State is: \n"+
                "Execution Stack: "+exeStack.toString()+
                "\nSymbol Table: "+symTable.toString()+
                "\nOutput: "+Out.toString()+"\n";
    }
}
