import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        GrammarRules grammarRules = new GrammarRules();
        try {
//            grammarRules.readFile("C:\\Users\\Evgenia\\IdeaProjects\\TAFYA3\\Laba3\\test3.txt");
            grammarRules.readFile("D:\\IdeaProjects\\TAFYA3\\Laba3\\test0");
            grammarRules.printRulesMap();

            Machine machine = new Machine(grammarRules);
            machine.readWord("a+a*a");

        }catch (IOException ioe){
            System.out.println(" ioex " + ioe.toString());
        }
    }
}
