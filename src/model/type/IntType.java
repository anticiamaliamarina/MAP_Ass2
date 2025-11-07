package model.type;

import model.values.*;

public class IntType implements Type {
    private String type="Int";

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof IntType;
    }

    @Override
    public String toString() { return type;}

    @Override
    public Type deepCopy()
    {
        return new IntType();
    }

    @Override
    public Value defaultValue() { return new IntValue(0);}

}
