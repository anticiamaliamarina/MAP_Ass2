package model.values;
import model.type.Type;


public interface Value {
    Type getType();
    boolean equals(Value another);
    Value deepCopy();

}
