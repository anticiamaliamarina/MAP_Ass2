package model.type;

import model.values.*;

public class BoolType implements Type {

    private String type="Bool";

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof BoolType;
    }

    @Override
    public String toString() { return type;}

    @Override
    public Type deepCopy() {
        return new BoolType();
    }
    @Override
    public Value defaultValue(){ return new BoolValue(false);}

}