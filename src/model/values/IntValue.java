package model.values;
import model.type.IntType;
import model.type.Type;

public class IntValue implements Value{
    int val;
    public IntValue(int v)
    {
        val=v;
    }
    @Override
    public Type getType()
    {
        return new IntType();
    }
    int getVal(){ return val;}
    @Override
    public String toString(){ return Integer.toString(val);}

    public boolean equals(Value another)
    {
        return another instanceof IntValue && ((IntValue) another ).val==this.val;
    }
    public Value deepCopy()
    {
      return new IntValue(val);
    };
    public int getValue()
    {
        return val;
    }

}
