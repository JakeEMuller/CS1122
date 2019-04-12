import java.util.NoSuchElementException;

public class myList<E extends Comparable> {

    private class Node {
        E data;
        Node nextNode;
        Node lastNode;

        public Node(E data, Node nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }

        public Node(E data) {
            this.data = data;
        }

        public Node() {

        }
    }

    Node firstNode = null;
    Node lastNode = null;
    int size = 0;

    public E get(int i) {
        if (i < 0 || i >= size()) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        int count = 0;
        Node currentNode = firstNode;
        while (count != i) {
            currentNode = currentNode.nextNode;
            count++;
        }
        return currentNode.data;

    }

    public void add(int index, E value) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int count = 0;
        Node currentNode = firstNode;
        Node previousNode = null;
        while (count != index) {
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
            count++;
        }
        Node newNode = new Node(value);
        if (previousNode == null) {
            newNode.nextNode = firstNode;
            firstNode = newNode;
        } else if (currentNode == null) {
            newNode.nextNode = null;
            previousNode.nextNode = newNode;
            lastNode = newNode;
        } else {
            newNode.nextNode = previousNode.nextNode;
            previousNode.nextNode = newNode;
            size++;
        }
    }

    public void add(E o) {
        Node newNode = new Node(o);
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            lastNode.nextNode = newNode;
            lastNode = newNode;
        }
        size++;
    }

    public void remove(E value) {
        Node currentNode = firstNode;
        Node previousNode = null;
        while (currentNode != null && !value.equals(currentNode.data)) {
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        if (currentNode == null) {
            throw new NoSuchElementException();
        }
        if (previousNode == null) {
            firstNode = currentNode.nextNode;
        } else {
            previousNode.nextNode = currentNode.nextNode;
        }
        currentNode.nextNode = null;
        size--;

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        myList<Integer> test = new myList<>();
        test.add(0);
        test.add(1);
        test.add(11);
        test.add(1,200);
        test.remove(1);
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i));
        }
    }

}
