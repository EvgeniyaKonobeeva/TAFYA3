import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Evgenia on 17.10.2016.
 */
public class StackObj {
    public Stack<Character> stack = new Stack<>();

    public char[] str;

    public ArrayList<Map<String, Character>> history = new ArrayList<>();

    public StackObj(Stack<Character> stack, char[] str) {
        this.stack.addAll(stack);
        this.str = str;
    }
}
