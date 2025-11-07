package utils.list;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> implements ListInterface<T>{

    private List<T> list;
    public MyList()
    {
        list=new ArrayList<>();
    }
    @Override
    public void addItem(T item)
    {
        list.add(item);
    }
    @Override
    public T getItemFromPos(int index)
    {
        return list.get(index);
    }
    @Override
    public String toString() {
        return list.toString();
    }
    public ArrayList<T> getAll()
    {
        return new ArrayList<>(list);
    }
    @Override
    public void removeItem(T item)
    {
        list.remove(item);
    };
}
