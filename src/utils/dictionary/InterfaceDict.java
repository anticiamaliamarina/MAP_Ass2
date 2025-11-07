package utils.dictionary;

public interface InterfaceDict<Key,Val> {
    void addToDictionary(Key k, Val l);

    Val getValueFromKey(Key k);

    void updateDictionary(Key k, Val l);
    void removeByKey(Key k);
    void removeByKeyAndVal(Key k, Val l);
    boolean isDefined(Key k);
    String toString();
}

