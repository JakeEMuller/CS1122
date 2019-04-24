import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Program4 {

    public LinkedBinaryTreeNode<String> loadFile(File file) throws FileNotFoundException {
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
                Question<String> newQuestion = new Question<>(outPut);
                parent.setRight(newQuestion);
                parent = newQuestion;
                lastWasAnswer = false;

            } else if (lastWasAnswer && list.get(i).charAt(0) == 'A' && list.get(i).charAt(1) == ':') {
                outPut = outPut.substring(2);
                Answer<String> newAnswer = new Answer<>(outPut);
                parent.setRight(newAnswer);
                lastWasAnswer = true;

            } else if (!lastWasAnswer && list.get(i).charAt(0) == 'Q' && list.get(i).charAt(1) == ':') {
                outPut = outPut.substring(2);
                Question<String> newQuestion = new Question<>(outPut);
                parent.setLeft(newQuestion);
                parent = newQuestion;
                lastWasAnswer = false;

            } else if (!lastWasAnswer && list.get(i).charAt(0) == 'A' && list.get(i).charAt(1) == ':') {
                outPut = outPut.substring(2);
                Answer<String> newAnswer = new Answer<>(outPut);
                parent.setLeft(newAnswer);
                lastWasAnswer = true;
            }

        }
        return rootQuestion;
    }

    public void writeTree(BinaryTreeNode<String> treeRoot) throws FileNotFoundException {
        File printFile = new File("tree.data");
        PrintWriter writer = new PrintWriter(printFile);
        ArrayList<String> list = new ArrayList<>();
        treeRoot.traversePreorder(node -> {
            String result = "";
            if (node.isLeaf()) {
                result = "A:" + node.getData();
                list.add(result);
            } else if (!node.isLeaf()) {
                result = "Q:" + node.getData();
                list.add(result);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            writer.println(list.get(i));
        }
        writer.close();
    }

    public BinaryTreeNode<String> play20Questions(LinkedBinaryTreeNode<String> tree) {
        BinaryTreeNode<String> currentNode = tree;
        Scanner input = new Scanner(System.in);
        //runs through questions until and answer is come to
        while (!currentNode.isLeaf()) {
            String question = currentNode.getData();
            System.out.println(question);
            String answer = input.next();
            boolean correctInput = true;
            while(correctInput){
                if (answer.equalsIgnoreCase("Yes")) {
                    currentNode = currentNode.getRight();
                    correctInput = false;
                } else if (answer.equalsIgnoreCase("No")) {
                    currentNode = currentNode.getLeft();
                    correctInput = false;
                } else {
                    System.out.println("that is not an answer, everything just broke");
                    answer = input.next();
                }
            }

        }
        //attempt to guess users
        String atemptedAnswer = currentNode.getData();
        atemptedAnswer = "Is it a " + atemptedAnswer;
        System.out.println(atemptedAnswer);
        String userAnswer = input.next();


        boolean correctInput = true;
        while(correctInput){
            if (userAnswer.equalsIgnoreCase("No")) {
                System.out.println("DOH!!, HOW COULD I LOSE");
                correctInput = false;
                return learnNewAnswer(tree, (Answer<String>) currentNode);
            } else if (userAnswer.equalsIgnoreCase("Yes")) {
                System.out.println("HAHA, I win again mortal");
                correctInput = false;
            } else {
                System.out.println("that is not an answer and everthing is now broken!!!");
                userAnswer = input.next();
            }

        }

        return tree;
    }

    public BinaryTreeNode<String> learnNewAnswer(BinaryTreeNode<String> tree, Answer<String> wrongAnswer) {
        //asks user for info to make new question

        Scanner input = new Scanner(System.in);
        System.out.println("What was the animal you were thinking of");
        String animal = input.next();
        System.out.println("What question separates " + animal + " from " + wrongAnswer.getData());
        input.nextLine();
        String newQuestion = input.nextLine();
        System.out.println("What is the Answer to this question (yes or no)");
        String newAnswer = input.next();


        Question<String> newQuestionNode = new Question<>(newQuestion);
        Answer<String> newAnswerNode = new Answer<>(animal);
        Answer<String> oldAnswerNode = wrongAnswer;
        BinaryTreeNode<String> parent = wrongAnswer.getParent();
        wrongAnswer.removeFromParent();
        if (!parent.hasRightChild()) {
            newQuestionNode.setParent(parent);
            parent.setRight(newQuestionNode);

        }
        if (!parent.hasLeftChild()) {
            newQuestionNode.setParent(parent);
            parent.setLeft(newQuestionNode);
        }

        if (newAnswer.equalsIgnoreCase("yes")) {
            newQuestionNode.setLeft(oldAnswerNode);
            newQuestionNode.setRight(newAnswerNode);

        } else if (newAnswer.equalsIgnoreCase("no")) {
            newQuestionNode.setLeft(newAnswerNode);
            newQuestionNode.setRight(oldAnswerNode);
        }
        return newQuestionNode.getRoot();

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
            BinaryTreeNode<String> newPrint = program.play20Questions(rootNode);
            program.writeTree(newPrint);
        } else {
            System.out.println("that is not a correct input (yes or no)");
        }


    }

}
