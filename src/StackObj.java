import java.util.ArrayList;
import java.util.HashMap;
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

    public void writeToHistory(){
        Map<String, Character> map = new HashMap<>();
        if(stack.isEmpty()){
            map.put(str.toString(), '\0');
        }else{
            map.put(str.toString(), stack.peek());
        }

        history.add(map);
    }

    public void copyHistory(ArrayList<Map<String, Character>> list){
        for(int i = 0; i < list.size(); i++){
            history.add(list.get(i));
        }
    }

    public void printHistory(){
        System.out.println("history : \n");
        for(Map<String, Character> map : history){
            for(Map.Entry<String, Character> entry : map.entrySet()){
                System.out.println(entry.getKey() + "  " + entry.getValue());
            }
        }
    }
}
