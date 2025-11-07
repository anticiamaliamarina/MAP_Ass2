package repository;

import utils.PrgState;
import utils.list.ListInterface;


public interface RepositoryInterface {
    void addPrg(PrgState prg);
    PrgState getCrrPrgState();
}
