import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Evgenia on 17.10.2016.
 */
public class Machine {
    private Map<Character, ArrayList<String>> grammarRules;
    private boolean hasPositiveResult = false;

    public Machine(GrammarRules grammarRules){
        this.grammarRules = grammarRules.getRulesMap();
    }

    public void readWord(String word){
        char[] inputStr = word.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push('E');
        StackObj obj = new StackObj(stack, inputStr);
        obj.writeToHistory();
        readWord2(obj);
    }


    public void readWord2(StackObj obj){

        while (!obj.stack.empty() && obj.str.length != 0 && !hasPositiveResult){
            if(obj.stack.size() > obj.str.length){
                Thread.currentThread().interrupt();
                break;
            }
            char stackCh = obj.stack.peek();

            if(Character.isUpperCase(stackCh)){
                obj.stack.pop();

                ArrayList<String> list = grammarRules.get(stackCh);
                for (int i = 0; i < list.size(); i++){
//                  create new obj with old values of stack? history and str
                    StackObj newObj = new StackObj();
                    newObj.copyObject(obj);
//                  work with new obj
                    pushArrToStack(list.get(i).toCharArray(), newObj.stack);
                    newObj.writeToHistory();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            readWord2(newObj);
                        }
                    }).start();
                }
            }else {
                if(obj.str[0] == stackCh){
                    obj.stack.pop();
                    obj.str = removeFromArr(obj.str);
                    obj.writeToHistory();
                }else{
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

        if((obj.stack.isEmpty() && obj.str.length == 0)){
            obj.printHistory();
            System.out.println("read");
            hasPositiveResult = true;
            Thread.currentThread().interrupt();
            return;
        }
        else{
            Thread.currentThread().interrupt();
//            System.out.println("can't read");
            return;
        }
    }

    protected char[] removeFromArr(char arr[]){
        char arr2[] = new char[arr.length-1];

        for(int i = 1; i < arr.length; i++){
            arr2[i-1] = arr[i];
        }
        return arr2;
    }

    protected void pushArrToStack(char[] arr, Stack<Character> stack){
        for(int i = arr.length-1; i > -1; i--){
            stack.push(arr[i]);
        }
    }




}
