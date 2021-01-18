

public class DecisionNode {

    int nodeID;
    int yesID;
    int noID;
    int firstID;
    int secondID;
    int thirdID;
    int fourthID;
    int fifthID;

    String description;
    String question;
    DecisionNode firstNode;
    DecisionNode secondNode;
    DecisionNode thirdNode;
    DecisionNode fourthNode;
    DecisionNode fifthNode;
    DecisionNode yesNode;
    DecisionNode noNode;

    DecisionNode linkedNode;

    public DecisionNode() {}

    public DecisionNode getLinkedNode() {return linkedNode;}
    public void setLinkedNode(DecisionNode linkedNode) {this.linkedNode = linkedNode;}

    public int getNodeID() {return nodeID;}
    public void setNodeID(int nodeID) {this.nodeID = nodeID;}

    // first
    public int getFirstID() {return firstID;}
    public void setFirstID(int firstID) {this.firstID = firstID; }
    //second
    public int getSecondID() {return secondID;}
    public void setSecondID(int secondID) {this.secondID = secondID; }
    //third
    public int getThirdID() {return thirdID;}
    public void setThirdID(int thirdID) {this.thirdID = thirdID; }
    //fourth
    public int getFourthID() {return fourthID;}
    public void setFourthID(int fourthID) {this.fourthID = fourthID; }
    //fifth
    public int getFifthID() {return fifthID;}
    public void setFifthID(int fifthID) {this.fifthID = fifthID; }
    //yes
    public int getYesID() {return yesID;}
    public void setYesID(int yesID) {this.yesID = yesID; }
    //no
    public int getNoID() {return noID;}
    public void setNoID(int noID) {this.noID = noID;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description; }
    public String getQuestion() {return question;}
    public void setQuestion(String question) {this.question = question;}
    // first
    public DecisionNode getFirstNode() {return firstNode;}
    public void setFirstNode(DecisionNode firstNode) {this.firstNode = firstNode;}
    // second
    public DecisionNode getSecondNode() {return secondNode;}
    public void setSecondNode(DecisionNode secondNode) {this.secondNode = secondNode;}
    // third
    public DecisionNode getThirdNode() {return thirdNode;}
    public void setThirdNode(DecisionNode thirdNode) {this.thirdNode = thirdNode;}
    // fourth
    public DecisionNode getFourthNode() {return fourthNode;}
    public void setFourthNode(DecisionNode fourthNode) {this.fourthNode = fourthNode;}
    // fifth
    public DecisionNode getFifthNode() {return fifthNode;}
    public void setFifthNode(DecisionNode fifthNode) {this.fifthNode = fifthNode;}
    // yes
    public DecisionNode getYesNode() {return yesNode;}
    public void setYesNode(DecisionNode yesNode) {this.yesNode = yesNode;}
    // no
    public DecisionNode getNoNode() {return noNode;}
    public void setNoNode(DecisionNode noNode) {this.noNode = noNode;}
}

