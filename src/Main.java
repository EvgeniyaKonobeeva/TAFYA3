import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        GrammarRules grammarRules = new GrammarRules();
        try {
//            grammarRules.readFile("C:\\Users\\Evgenia\\IdeaProjects\\TAFYA3\\Laba3\\test3.txt");
            grammarRules.readFile("C:\\Users\\Evgenia\\IdeaProjects\\TAFYA3\\Laba3\\test1.txt");
            grammarRules.printRulesMap();

        }catch (IOException ioe){
            System.out.println(" ioex " + ioe.toString());
        }
    }
}
