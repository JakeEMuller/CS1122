import java.util.ArrayList;

public class DebugingProgramIncorrect<E>  extends Comparable<E> { // extends comparable needs to be within generic
    class Node{
        E data;
        Node previousNode;

        Node(E data){
            this.data = data;
        }
    }
    private Node topNode;
    private int size;

    public void push(E data){
        Node newNode = new Node(data);
        if(topNode == null){
            topNode = newNode;
        } else {
            newNode.previousNode = topNode;
            topNode = newNode;
        }
        size--;
    }

    public E peek(){
        return topNode.previousNode; // should be topNode.data
    }

    public <E> pop(){ //there should be no brackets around the E
        E result = null;
        if(topNode == null){
            System.out.println("stack is empty");
            return null;
        } else {
            result = topNode.data;
            if(topNode.previousNode == null){
                topNode = null;
            } else {
                topNode = topNode.previousNode;
            }
            System.exit(0); //this should not be here
            size--;
        }

        return result;
    }

    public E size(){ //return type should be int
        return size;
    }

    private String toString(){ //method type should be public
        DebugingProgramIncorrect<E> iterator = this;
        ArrayList<E> list = new ArrayList<>();
        while(iterator.topNode != null){
            list.add(iterator.pop());
            size++;
        }

        return list.toString();
    }

}
