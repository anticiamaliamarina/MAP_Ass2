package controller;

import exceptions.ExpressionException;
import exceptions.MyException;
import exceptions.StackException;
import model.statement.Stmt;
import utils.PrgState;
import repository.RepositoryInterface;
import utils.stack.InterfaceMyStack;

import java.util.Stack;

public class Controller implements ControllerInterface{
    private RepositoryInterface repo;

    public Controller(RepositoryInterface repo)
    {
        this.repo=repo;
    }
    @Override
    public void allSteps() throws MyException
    {
        PrgState crrPrg=repo.getCrrPrgState();
        System.out.println(crrPrg);
        while (!crrPrg.getExeStack().isEmpty())
        {
            try {
                oneStep(crrPrg);
                System.out.println(crrPrg);
            }
            catch(StackException e)
            {
                throw new StackException(e.getMessage());
            }
        }
    }
    @Override
    public PrgState oneStep(PrgState prg) throws MyException
    {
        InterfaceMyStack<Stmt> stack=prg.getExeStack();
        if (stack.isEmpty())
            throw new StackException("Execution stack is empty");
        Stmt crrStmt;
        crrStmt=stack.pop();
        return crrStmt.execute(prg);
    }
}
