
import java.util.Scanner;

public class Utils {

    public void console(String  info){System.out.println(info);}
    public void lineBreak(){
        System.out.println("\n---------------");
    }


    public void pressEnterToContinue(){

        console("Press Enter key to continue...");
        try { System.in.read();}
        catch(Exception e) {
            System.out.println(" ");
        }

    }

    public int fromConsoleGetInt(String prompt){

        Scanner scan = new Scanner(System.in);
        console(prompt);
        int retVal = scan.nextInt();
        scan = null;
        return retVal;

    }

}
