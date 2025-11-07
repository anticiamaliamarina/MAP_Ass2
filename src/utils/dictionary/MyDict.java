package utils.dictionary;


import java.util.Map;
import java.util.HashMap;

public class MyDict<Key, Val> implements InterfaceDict<Key,Val>{
    private Map<Key,Val> dict;

    public MyDict(){
        dict=new HashMap<>();
    }
    @Override
    public void addToDictionary(Key k, Val l)
    {
       dict.put(k,l);
    };
    @Override
    public  Val getValueFromKey(Key k)
    {
        return dict.get(k);
    };
    @Override
    public void updateDictionary(Key k, Val l)
    {
        dict.put(k,l);
    };

    public Map<Key,Val> getAll()
    {
        return new HashMap<>(dict);
    }
    @Override
    public void removeByKey(Key k)
    {
        dict.remove(k);
    }
    @Override
    public void removeByKeyAndVal(Key k, Val l)
    {
        dict.remove(k,l);
    }
    @Override
    public boolean isDefined(Key k)
    {
        return dict.containsKey(k);
    }
    @Override
    public String toString()
    {
        return dict.toString();
    }
}
