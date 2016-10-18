import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        scanWord();
//        GrammarRules grammarRules = new GrammarRules();
//        try {
////            grammarRules.readFile("C:\\Users\\Evgenia\\IdeaProjects\\TAFYA3\\Laba3\\test3.txt");
//            grammarRules.readFile("C:\\Users\\Evgenia\\IdeaProjects\\TAFYA3\\Laba3\\test1.txt");
//            grammarRules.printRulesMap();
//
//            Machine machine = new Machine(grammarRules);
//            machine.readWord("/0!");
//
//        }catch (IOException ioe){
//            System.out.println(" ioex " + ioe.toString());
//        }
    }

    public static void scanWord(){
        Scanner scanner = new Scanner(System.in);

        String command = "";
        String filePath = "C:\\Users\\Evgenia\\IdeaProjects\\TAFYA3\\Laba3\\test1.txt";
        String word = "";

        if(scanner.hasNext()){
            while (!(command = scanner.next()).equals("close")){
                GrammarRules grammarRules = new GrammarRules();
                word = scanner.next();
                try {
                    grammarRules.readFile(command.trim());
                    grammarRules.printRulesMap();
                }catch (IOException ioe){
                    System.out.println(" ioex " + ioe.toString());
                }
                Machine machine = new Machine(grammarRules);
                machine.readWord(word);

                System.out.println("\n\ncontinue working or enter close to close the program");

            }
            System.out.println("program closed");
            return;
        }
    }
}
