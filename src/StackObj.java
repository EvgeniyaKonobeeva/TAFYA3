import java.util.*;

/**
 * Created by Evgenia on 17.10.2016.
 */
public class StackObj {
    public Stack<Character> stack = new Stack<>();

    public char[] str;

    public ArrayList<Map<String, String>> history = new ArrayList<>();

    public StackObj(Stack<Character> stack, char[] str) {
        this.stack.addAll(stack);
        this.str = str;
    }
    public StackObj(){}

    public void writeToHistory() {
        Map<String, String> map = new HashMap<>();
        if (stack.isEmpty()) {
            map.put(String.copyValueOf(str), "\0");
        } else {
            map.put(String.copyValueOf(str), Arrays.toString(stack.toArray()));
        }

        history.add(map);
    }

    public void copyHistory(ArrayList<Map<String, String>> list) {
        for (int i = 0; i < list.size(); i++) {
            this.history.add(list.get(i));
        }
    }

    public void printHistory() {
        System.out.println("history : \n");
        for (Map<String, String> map : history) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println( "(s0 "+ entry.getKey() + "  " + entry.getValue() + ")");
            }
        }
//        System.out.println("(s0, alpha, h0)");
//        System.out.println("(s0, alpha, alpha)");

    }

    public void copyObject(StackObj oldObj){
        this.stack.addAll(oldObj.stack);
        this.str = oldObj.str;
        copyHistory(oldObj.history);
    }


}
