import java.util.Stack;

/**
 * Created by Evgenia on 18.10.2016.
 */
public class testing {

    public Stack toStack = new Stack();

    public void addToStack(Stack stack){
        toStack.addAll(stack);
        while (!toStack.isEmpty()){
            System.out.print(toStack.pop() + "  ");
        }
    }
}
