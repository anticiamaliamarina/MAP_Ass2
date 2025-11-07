package view;
import model.expression.ArithExp;
import model.expression.ConstantValue;
import model.expression.VariableExp;
import model.type.IntType;
import model.statement.*;
import model.type.*;
import model.values.*;
import model.expression.*;


public class Examples {
    public static Stmt example1()
    {
        //int v; v=2; x=v+5; Print(x);
        return new CompStmt(
                new VarDecl("v", new IntType()),
                new CompStmt(
                        new AssignStmt("v", new ConstantValue(new IntValue(2))),
                        new CompStmt(
                                new VarDecl("x", new IntType()),
                                new CompStmt(
                                        new AssignStmt("x", new ArithExp(
                                                new VariableExp("v"),
                                                new ConstantValue(new IntValue(5)),
                                                1)
                                                    ),
                                        new PrintStmt(new VariableExp("x"))
                                            )
                                    )
                            )
                            );
    };

    public static Stmt example2()
    {
        //bool x; x=true; int y; if (x) then y=1, else y=2; Print(y)
        return new CompStmt( new VarDecl("x", new BoolType()),
                new CompStmt(
                        new AssignStmt("x", new ConstantValue(new BoolValue(true))),
                        new CompStmt(
                                new VarDecl("y", new IntType()),
                                new CompStmt(
                                        new IfStmt(
                                                new VariableExp("x"),
                                                new AssignStmt("y", new ConstantValue(new IntValue(1))),
                                                new AssignStmt("y", new ConstantValue(new IntValue(2)))
                                        ),
                                        new PrintStmt(new VariableExp("y"))
                                )
                        )
                )
        );
    }

    public static Stmt example3()
    {
        //bool a; bool b; a=true; b=false; bool c; c=a||b; print(c);
        return new CompStmt(new VarDecl("a",new BoolType()),
                            new CompStmt(new VarDecl("b", new BoolType()),
                                    new CompStmt(new AssignStmt("a", new ConstantValue(new BoolValue(true))),
                                                 new CompStmt(new AssignStmt("b", new ConstantValue(new BoolValue(false))),
                                                         new CompStmt(new VarDecl("c", new BoolType()),
                                                                 new CompStmt(new AssignStmt("c", new LogicExp(new VariableExp("a"),new VariableExp("b"),6 )),
                                                                         new PrintStmt(new VariableExp("c"))
                                                                                )
                                                                 )
                                                         )
                                            )
                                        )

                            );
    }
}
