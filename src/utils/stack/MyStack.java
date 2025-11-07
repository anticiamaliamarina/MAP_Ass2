package utils.stack;

import exceptions.MyException;
import exceptions.StackException;

import java.util.ArrayList;
//use array list sau linked list
//get all sa fie o copie->copy constructor de type MyStack; deep copy like

public class MyStack<T> implements InterfaceMyStack<T>{
    private ArrayList<T> stack;

    public MyStack()
    {
        stack=new ArrayList<>();
    }

    @Override
    public T pop() throws MyException {
        if (stack.isEmpty())
            throw new StackException("Stack is empty");

        return stack.remove(stack.size()-1);
    }
    @Override
    public void push(T val)
    {
        stack.add(val);
    }

    @Override
    public T top()
    {
        return stack.get(stack.size()-1);
    }

    @Override
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    @Override
    public int size()
    {
        return stack.size();
    }

    public ArrayList<T> getAll(){
        return new ArrayList<>(stack);
    };
    @Override
    public String toString()
    {
        return stack.toString();
    }
}
