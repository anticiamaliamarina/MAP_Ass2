package model.values;

import model.type.BoolType;
import model.type.Type;

public class BoolValue implements Value{
    public boolean val;

    public BoolValue(boolean v)
    { this.val=v;}

    public Type getType()
    {
        return new BoolType();
    };
    @Override
    public boolean equals(Value another)
    {
        return another instanceof BoolValue && ((BoolValue) another).val==this.val;
    };
    @Override
    public Value deepCopy()
    {
        return new BoolValue(val);
    };

    public boolean getValue()
    {
        return val;
    }

    public String toString()
    {
        return String.valueOf(val);
    }

}
