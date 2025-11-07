package view;
import controller.*;
import exceptions.*;
import model.values.Value;
import repository.*;
import utils.*;
import model.statement.*;
import utils.dictionary.InterfaceDict;
import utils.dictionary.MyDict;
import utils.list.ListInterface;
import utils.list.MyList;
import utils.stack.InterfaceMyStack;
import utils.stack.MyStack;
import view.Examples;
import java.util.Scanner;


public class View {

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Stmt prg=null;
        int option;
        while (prg==null) {
            System.out.println("1. int v; v=2; x=v+5; Print(x);");
            System.out.println("2. bool x; x=true; int y; if (x) then y=1, else y=2; Print(y)");
            System.out.println("3. bool a; bool b; a=true; b=false; bool c; c=a||b; Print(c);");
            System.out.println("Select 1, 2 or 3: ");

            option = sc.nextInt();
            switch (option) {
                case 1:
                    prg = Examples.example1();
                    break;
                case 2:
                    prg = Examples.example2();
                    break;
                case 3:
                    prg = Examples.example3();
                    break;
                default:
                    System.out.println("Invalid option!");
            }

        }
        InterfaceMyStack<Stmt> exeStack=new MyStack<>();
        InterfaceDict<String, Value> symTable=new MyDict<>();
        ListInterface<Value> output=new MyList<>();

        PrgState program=new PrgState(exeStack, symTable, output, prg);
        RepositoryInterface repo=new Repository(program);
        Controller ctrl=new Controller(repo);
        try {
            ctrl.allSteps();
        }
        catch(MyException e)
        {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
