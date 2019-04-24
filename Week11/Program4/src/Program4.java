import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Program4 {

    public LinkedBinaryTreeNode loadFile(File file) throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        ArrayList<String> list = new ArrayList<>();

        while (reader.hasNextLine()) {
            list.add(reader.nextLine());
        }

        // initiates root element
        Question<String> rootQuestion = null;

        if (list.get(0).charAt(0) == 'Q' && list.get(0).charAt(1) == ':') {
            String getString = list.get(0).substring(2);
            rootQuestion = new Question<>(getString);
        } else {
            System.out.println("something went wrong");
        }

        LinkedBinaryTreeNode<String> parent = rootQuestion;
        boolean lastWasAnswer = false;

        for (int i = 1; i < list.size(); i++) {
            String outPut = list.get(i);

            //makes sure left and right nodes arnt filled
            while (lastWasAnswer && parent.hasLeftChild() && parent.hasRightChild()) {
                parent = (LinkedBinaryTreeNode<String>) parent.getParent();
            }

            if (lastWasAnswer && list.get(i).charAt(0) == 'Q' && list.get(i).charAt(1) == ':') {
                outPut = outPut.substring(2);
                Question<String> newQuestion = new Question(outPut);
                parent.setRight(newQuestion);
                parent = newQuestion;
                lastWasAnswer = false;

            } else if (lastWasAnswer && list.get(i).charAt(0) == 'A' && list.get(i).charAt(1) == ':') {
                outPut = outPut.substring(2);
                Answer<String> newAnswer = new Answer(outPut);
                parent.setRight(newAnswer);
                lastWasAnswer = true;

            } else if (!lastWasAnswer && list.get(i).charAt(0) == 'Q' && list.get(i).charAt(1) == ':') {
                outPut = outPut.substring(2);
                Question<String> newQuestion = new Question(outPut);
                parent.setLeft(newQuestion);
                parent = newQuestion;
                lastWasAnswer = false;

            } else if (!lastWasAnswer && list.get(i).charAt(0) == 'A' && list.get(i).charAt(1) == ':') {
                outPut = outPut.substring(2);
                Answer<String> newAnswer = new Answer(outPut);
                parent.setLeft(newAnswer);
                lastWasAnswer = true;
            }

        }
        return rootQuestion;
    }

    public void writeTree(BinaryTreeNode treeRoot) throws FileNotFoundException {
        File printFile = new File("tree.data");
        PrintWriter writer = new PrintWriter(printFile);
        ArrayList<String> list = new ArrayList<>();
        treeRoot.traversePreorder(node -> {
            String result = "";
            if (node.isLeaf()){
                result = "A:" + node.getData();
                list.add(result);
            } else if(!node.isLeaf()){
                result = "Q:" + node.getData();
                list.add(result);
            }
        });
        for(int i = 0; i < list.size(); i++){
            writer.println(list.get(i));
        }
        writer.close();
    }

    public void play20Questions(LinkedBinaryTreeNode<String> tree){
        BinaryTreeNode<String> currentNode = tree;
        Scanner input = new Scanner(System.in);
        //runs through questions until and answer is come to
        while(!currentNode.isLeaf()){
            String question = currentNode.getData();
            System.out.println(question);
            String answer = input.next();
            if(answer.equalsIgnoreCase("Yes")){
                currentNode = currentNode.getRight();
            } else if(answer.equalsIgnoreCase("No")){
                currentNode = currentNode.getLeft();
            } else {
                System.out.println("that is not an answer, everything just broke");
            }
        }
        //attempt to guess users
        String atemptedAnswer = currentNode.getData();
        System.out.println(atemptedAnswer);
        String userAnswer = input.next();
        if(userAnswer.equalsIgnoreCase("No")){
            System.out.println("DOH!!, HOW COULD I LOSE");
            //insert fix method here
        } else if(userAnswer.equalsIgnoreCase("Yes")){
            System.out.println("HAHA, I win again mortal");
        } else {
            System.out.println("that is not an answer and everthing is now broken");
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        Program4 program = new Program4();
        File file = new File("tree.data");
        Scanner input = new Scanner(System.in);
        System.out.println("Shall we play a game");
        String answer = input.next();
        if (answer.equalsIgnoreCase("no")) {
            System.out.println("Ok fine I see how it is");
            System.exit(0);
        } else if (answer.equalsIgnoreCase("yes")) {
            LinkedBinaryTreeNode<String> rootNode = program.loadFile(file);
            program.play20Questions(rootNode);
        }

    }

}
