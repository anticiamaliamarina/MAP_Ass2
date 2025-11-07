package repository;

import utils.PrgState;
import utils.list.ListInterface;
import utils.list.MyList;

public class Repository implements RepositoryInterface{
    private ListInterface<PrgState> prgStateList;

    public Repository(PrgState prg)
    {
        prgStateList=new MyList<>();
        prgStateList.addItem(prg);
    }
    @Override
    public void addPrg(PrgState prg)
    {
        prgStateList.addItem(prg);
    }
    @Override
    public PrgState getCrrPrgState()
    {
        return prgStateList.getItemFromPos(0);
    }
}
