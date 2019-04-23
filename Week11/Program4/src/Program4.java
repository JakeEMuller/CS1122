import java.io.File;
import java.io.FileNotFoundException;
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

        if ( list.get(0).charAt(0) == 'Q' && list.get(0).charAt(1) == ':') {
            String getString = list.get(0).substring(2);
            rootQuestion = new Question<>(getString);
        } else {
            System.out.println("something went wrong");
        }

        LinkedBinaryTreeNode<String> parent = rootQuestion;
        boolean lastWasAnswer = false;

        for (int i = 1; i < list.size(); i++) {
            String outPut = list.get(i);

            while(lastWasAnswer && parent.hasLeftChild() && parent.hasRightChild()){
                parent = (LinkedBinaryTreeNode<String>) parent.getParent();
            }

            // if the last
            if (lastWasAnswer && list.get(i).charAt(0) == 'Q' && list.get(i).charAt(1) == ':') {
                outPut = outPut.substring(2);
                Question<String> newQuestion = new Question(outPut);
                parent.setRight(newQuestion);
                System.out.println("last was anwser question and is: " + outPut);
                System.out.println("parent was: " + parent.data);
                parent = newQuestion;
                lastWasAnswer = false;

            } else if (lastWasAnswer && list.get(i).charAt(0) == 'A' && list.get(i).charAt(1) == ':') {
                outPut = outPut.substring(2);
                Answer<String> newAnswer = new Answer(outPut);
                System.out.println("last was anwser, Answer is: " + outPut);
                System.out.println("parent was: " + parent.data);
                parent.setRight(newAnswer);
                lastWasAnswer = true;

            } else if (!lastWasAnswer && list.get(i).charAt(0) == 'Q' && list.get(i).charAt(1) == ':') {
                outPut = outPut.substring(2);
                Question<String> newQuestion = new Question(outPut);
                parent.setLeft(newQuestion);
                System.out.println("last was not anwser, Question is: " + outPut);
                System.out.println("parent was: " + parent.data);
                parent = newQuestion;
                lastWasAnswer = false;

            } else if (!lastWasAnswer && list.get(i).charAt(0) == 'A' && list.get(i).charAt(1) == ':') {
                outPut = outPut.substring(2);
                Answer<String> newAnswer = new Answer(outPut);
                System.out.println("last was not anwser, Answer is: " + outPut);
                System.out.println("parent was: " + parent.data);
                parent.setLeft(newAnswer);
                lastWasAnswer = true;
            }
        }

//        System.out.println(rootQuestion.getData());
//        System.out.println(rootQuestion.getLeft().getData());
//        System.out.println(rootQuestion.getLeft().getLeft().getData());
//        rootQuestion.traversePreorder(node -> {
//            System.out.println(node.getData());
//        });


        return rootQuestion;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Program4 foo = new Program4();
        File test = new File("tree.data");
        Scanner input = new Scanner(System.in);
        System.out.println("Shall we play a game");
        String answer = input.next();
        if (answer.equalsIgnoreCase("no")) {
            System.out.println("Ok fine I see how it is");
            System.exit(0);
        } else if (answer.equalsIgnoreCase("yes")) {
            foo.loadFile(test);
        }

    }

}
