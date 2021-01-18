import java.io.FileNotFoundException;
import java.util.Scanner;

public class DecisionMapTest {

    public static void main(String[] args) throws FileNotFoundException {

        Utils u = new Utils();
        Scanner choice = new Scanner(System.in);
        DecisionMap naptime;
        try {
            naptime = new DecisionMap();
        } catch(FileNotFoundException fe){
            u.console("File not found");
            return;
        }

        u.lineBreak();
        u.console("Start...");

        navigateMap(u, naptime);

    }


    public static void navigateMap(Utils u, DecisionMap naptime) {
        DecisionNode node = naptime.entryPoint();

        while (node != null) {

            u.console(node.getDescription());
            u.console(node.getQuestion());

            if (node.getQuestion().equals("-")) {
                u.pressEnterToContinue();
                node = node.getFirstNode();
            } else {
                if (node.nodeID == 2) {
                    try {
                        int decision = u.fromConsoleGetInt("Enter a number between 0 and 23: ");
                        if (decision >= 6 && decision < 10) {
                            node = node.getFirstNode();
                        } else if (decision >= 10 && decision < 15) {
                            node = node.getSecondNode();
                        } else if (decision >= 15 && decision < 18) {
                            node = node.getThirdNode();
                        } else if (decision >= 18 && decision < 22) {
                            node = node.getFourthNode();
                        } else if ((decision == 22 || decision == 23) || (decision < 6)) {
                            node = node.getFifthNode();
                        }

                    } catch (Exception e) {
                        System.out.println("Invalid input, try again");
                    }

                } else if (node.nodeID == 0) {
                    try {
                        int decision = u.fromConsoleGetInt("(press 1 for exhausted or 2 for not very tired) : ");
                        switch (decision) {

                            case 1:
                                node = node.getFirstNode();
                                break;
                            case 2:
                                node = node.getSecondNode();
                                break;
                        }

                    } catch (Exception e) {
                        System.out.println("Invalid input, try again");

                    }
                }else if (node.nodeID == 6){
                    try{
                        int decision = u.fromConsoleGetInt("(press 6 for yes, 7 for no, or 1 for I'll check): ");
                        switch (decision){
                            case 6:
                                node = node.getYesNode();
                                break;
                            case 7:
                                node = node.getNoNode();
                                break;
                            case 1:
                                node = node.getFirstNode();
                                break;
                        }

                    } catch (Exception e){
                        System.out.println("Invalid input, try again");
                    }


                } else if (node.nodeID == 20) {
                    try {
                        int decision = u.fromConsoleGetInt("(press 1 for good or 2 for bad) : ");
                        switch (decision) {

                            case 1:
                                node = node.getFirstNode();
                                break;
                            case 2:
                                node = node.getSecondNode();
                                break;
                        }
                        } catch (Exception e) {
                            System.out.println("Invalid input, try again");}
                    } else if (node.nodeID == 18) {
                        try {
                            int decision = u.fromConsoleGetInt("(press 1 for better or 2 for still tired) : ");
                            switch (decision) {

                                case 1:
                                    node = node.getFirstNode();
                                    break;
                                case 2:
                                    node = node.getSecondNode();
                                    break;
                            }

                    } catch (Exception e) {
                        System.out.println("Invalid input, try again");
                    }
                } else {
                    try {
                        int decision = u.fromConsoleGetInt("Yes or No? (press 6 for Yes or 7 for No): ");
                        switch (decision) {
                            case 6:
                                node = node.getYesNode();
                                break;
                            case 7:
                                node = node.getNoNode();
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input, try again");}

                    }
                }
            }
        }
    }
