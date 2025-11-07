package controller;

import exceptions.MyException;
import utils.PrgState;

public interface ControllerInterface {
      void allSteps() throws  MyException;
      PrgState oneStep(PrgState prg) throws MyException;
}
