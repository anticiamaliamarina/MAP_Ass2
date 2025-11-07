package utils.stack;

import exceptions.MyException;
import utils.dictionary.InterfaceDict;

public interface InterfaceMyStack<T> {
    T pop() throws MyException;
    void push(T val);
    T top();
    boolean isEmpty();
    int size();
    String toString();
}
