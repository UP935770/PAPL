import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.*;

public class DecisionMap {

    DecisionNode head;
    DecisionNode tail;


    public DecisionMap() throws FileNotFoundException {
        Scanner inFile = connectDataSet("src/napdata.csv");
        buildUnorderedList(inFile);
        buildOrderedMap();
        //unorderedMap = null;
    }

    private void append(DecisionNode newNode) {

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.setLinkedNode(null);

            return;
        }

        this.tail.setLinkedNode(newNode);
        this.tail = newNode;
    }


    public Scanner connectDataSet(String pathName) throws FileNotFoundException {
        File prc = new File(pathName);
        return new Scanner(prc);
    }

    public void buildUnorderedList(Scanner dataSet) {

        dataSet.useDelimiter(",");
        DecisionNode node ;
        do {
            String line = dataSet.nextLine();
            node = buildNode(line);
            append(node);
        } while (dataSet.hasNext());
        dataSet.close();

    }

    private void buildOrderedMap() {

        if (head == null) {return;}

        DecisionNode nodeLinker = head;

        while (nodeLinker != null) {
            int firstID = nodeLinker.getFirstID();
            int secondID = nodeLinker.getSecondID();
            int thirdID = nodeLinker.getThirdID();
            int fourthID = nodeLinker.getFourthID();
            int fifthID = nodeLinker.getFifthID();
            int yesID = nodeLinker.getYesID();
            int noID = nodeLinker.getNoID();

            DecisionNode firstNode = nodeFetch(firstID);
            DecisionNode secondNode = nodeFetch(secondID);
            DecisionNode thirdNode = nodeFetch(thirdID);
            DecisionNode fourthNode = nodeFetch(fourthID);
            DecisionNode fifthNode = nodeFetch(fifthID);
            DecisionNode yesNode = nodeFetch(yesID);
            DecisionNode noNode = nodeFetch(noID);

            nodeLinker.setFirstNode(firstNode);
            nodeLinker.setSecondNode(secondNode);
            nodeLinker.setThirdNode(thirdNode);
            nodeLinker.setFourthNode(fourthNode);
            nodeLinker.setFifthNode(fifthNode);
            nodeLinker.setYesNode(yesNode);
            nodeLinker.setNoNode(noNode);

            nodeLinker = nodeLinker.getLinkedNode();

        }

        cleanup();

    }

    private void cleanup(){
        if (head == null) {return;}

        DecisionNode currentNode = head;
        DecisionNode nextNode = head.getLinkedNode();

        while (nextNode != null) {

            currentNode.setLinkedNode(null);

            currentNode = nextNode;
            nextNode = currentNode.getLinkedNode();
        }
    }

    private DecisionNode buildNode(String line) {
        String[] stringArray = line.split(",");
        DecisionNode n = new DecisionNode();

        n.setNodeID(valueOf(stringArray[0]));
        n.setFirstID(valueOf(stringArray[1]));
        n.setSecondID(valueOf(stringArray[2]));
        n.setThirdID(valueOf(stringArray[3]));
        n.setFourthID(valueOf(stringArray[4]));
        n.setFifthID(valueOf(stringArray[5]));
        n.setYesID(valueOf(stringArray[6]));
        n.setNoID(valueOf(stringArray[7]));

        n.setDescription(stringArray[8]);
        n.setQuestion(stringArray[9]);

        return n;
    }

    public DecisionNode entryPoint() {
        return head;
    }

    private DecisionNode nodeFetch(int nodeID) {

        DecisionNode nodeLinker = head;

        while (nodeLinker != null) {
            if(nodeLinker.getNodeID() == nodeID){ break ;}
            nodeLinker = nodeLinker.getLinkedNode();
        }

        return nodeLinker;
    }


    private boolean isEmpty() {
        return this.head == null;
    }
}