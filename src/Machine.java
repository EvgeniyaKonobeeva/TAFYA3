import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Evgenia on 17.10.2016.
 */
public class Machine {
    private Map<String, ArrayList<String>> grammarRules;
    private String inputString;
    private Stack<Character> stack = new Stack<>();

    public Machine(GrammarRules grammarRules){
        this.grammarRules = grammarRules.getRulesMap();
        stack.push('E');
    }

    public void readWord(String word){
        char[] inputStr = word.toCharArray();


    }

    protected void pushArrToStack(char[] arr, Stack<Character> stack){
        for(int i = arr.length-1; i > -1; i--){
            stack.push(arr[i]);
        }
    }

//    protected void readString(char[] strs, Stack<Character> stack){
//        char[] str = strs;
//        while (!stack.empty() && str.length != 0){
//            char stackCh = stack.peek();
//
//            if(Character.isUpperCase(stackCh)){
//                stack.pop();
//
//                ArrayList<String> list = grammarRules.get(stackCh);
//                for (int i = 0; i < list.size(); i++){
//                    Stack<Character> newStack = new Stack<>();
//                    newStack.addAll(stack);
//                    pushArrToStack(list.get(i).toCharArray(), newStack);
//                    readString(str, newStack);
////                    TODO добавить многопоточность из пула потоков, именно здесь вести запись истории переходов
//                }
//            }else {
//                if(str[0] == stackCh){
//                    stack.pop();
//                }
//            }
//        }
//
//        if(stack.isEmpty() && str.length == 0){
////            TODO good result, otherwise - bad result
//        }
//    }

    public void readWord2(StackObj obj){

        while (!obj.stack.empty() && obj.str.length != 0){
            char stackCh = obj.stack.peek();

            if(Character.isUpperCase(stackCh)){
                obj.stack.pop();

                ArrayList<String> list = grammarRules.get(stackCh);
                for (int i = 0; i < list.size(); i++){
                    StackObj newObj = new StackObj(obj.stack, obj.str);
                    pushArrToStack(list.get(i).toCharArray(), newObj.stack);
                    readWord2(newObj);
//                    TODO добавить многопоточность из пула потоков, именно здесь вести запись истории переходов
                }
            }else {
                if(obj.str[0] == stackCh){
                    obj.stack.pop();
                    obj.str = removeFromArr(obj.str);
                }
            }
        }

        if(obj.stack.isEmpty() && obj.str.length == 0){
//            TODO good result, otherwise - bad result
        }

    }

    protected char[] removeFromArr(char arr[]){
        char arr2[] = new char[arr.length-1];

        for(int i = 1; i < arr.length; i++){
            arr2[i-1] = arr[i];
        }
        return arr2;
    }




}
