package model.type;
import model.values.Value;

public interface Type {
    boolean equals(Object another);
    String toString();
    Type deepCopy();
    Value defaultValue();
}
