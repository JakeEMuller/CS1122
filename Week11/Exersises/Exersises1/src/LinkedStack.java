import java.util.ArrayList;

// ***********************************************************
// a Stack program but with debuging errors to correct (answer key)
// ************************************************************
public class LinkedStack<E  extends Comparable<E>> {
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
        size++;
    }

    public E peek(){
        return topNode.data;
    }

    public E pop(){
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
            size--;
        }

        return result;
    }

    public int size(){
        return size;
    }

    public String toString(){
        LinkedStack<E> iterator = this;
        ArrayList<E> list = new ArrayList<>();
        while(iterator.topNode != null){
            list.add(iterator.pop());
            size++; // for some reason the iterator pop is effecting the size of parent stack
        }

        return list.toString();
    }

    public static void main(String[] args) {
        LinkedStack<Integer> test = new LinkedStack<>();
        test.push(5);
        test.push(7);
        test.push(8);
        test.push(10);
        test.push(8);
        test.push(9);
        System.out.println("peek expected, 9 : received: " + test.peek());
        System.out.println(test.toString());
        System.out.println(test.size());

    }

}
