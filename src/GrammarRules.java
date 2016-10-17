import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Evgenia on 16.10.2016.
 */
public class GrammarRules {
    private Map<Character, ArrayList<String>> rulesMap = new HashMap<>();

    /*входной алфавит*/
    private Set<String> inputAlphabet = new HashSet<>();

    /*алфавит магазинных символов*/
    private Set<String> pushdownAlphabet = new HashSet<>();

    private String inputString;

    private Stack<String> stack = new Stack<>();

    public void readFile(String filePath) throws IOException{
        Scanner scanner = new Scanner(new File(filePath));
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()){
            ruleParsing(scanner.next().trim());
        }
    }


    public void ruleParsing(String str){
        ArrayList<String> rightPart = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        char[] symbols = str.toCharArray();

        pushdownAlphabet.add(String.valueOf(symbols[0]));

        int pointerPos = findSymbPos('>', symbols);

        for(int i = pointerPos+1; i < symbols.length; i++){
            if(symbols[i] != '|'){

                sb.append(symbols[i]);

                addToAlphabetSets(symbols[i]);

            }else{
                rightPart.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        if(sb.length() != 0)
            rightPart.add(sb.toString());

        rulesMap.put(symbols[0], rightPart);
    }

    protected int findSymbPos(char searchSymb, char[] symbsArr){
        int pos = -1;
        for(int i = 0; i < symbsArr.length; i++){
            if(symbsArr[i] == searchSymb) {
                pos = i;
                return pos;
            }
        }
        return pos;
    }

    public void printRulesMap(){
        System.out.println("grammar rules from file ");
        for(Map.Entry<Character, ArrayList<String>> entry : rulesMap.entrySet()){
            System.out.print(entry.getKey() + " ---- ");
            for(int i = 0; i < entry.getValue().size(); i++){
                System.out.print(entry.getValue().get(i) + "|");
            }
            System.out.println();
        }

        System.out.println("input alphabet : ");
        for(String s : inputAlphabet){
            System.out.print(s + "  ");
        }
        System.out.println();

        System.out.println("pushdown alphabet");
        for(String s : pushdownAlphabet){
            System.out.print(s + "  ");
        }

        System.out.println();
    }

    protected void addToAlphabetSets(char ch){

        pushdownAlphabet.add(String.valueOf(ch));

        if(!Character.isUpperCase(ch)){
            inputAlphabet.add(String.valueOf(ch));
        }
    }

    public Map<Character, ArrayList<String>> getRulesMap() {
        return rulesMap;
    }
}
