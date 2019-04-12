import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Queue<E extends Comparable> implements QueueInterface<E> {
    MyList<E> linkedList = new MyList<E>();
    private int sizeLimit;

    public Queue(int sizeLimit) {
        this.sizeLimit = sizeLimit;
    }

    public void enqueue(E element) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException();
        }

        linkedList.add(element);
    }


    /// problem where if multiple of similar elements in the array
    /// will remove the first of the multiple elements.
    public E dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        E frontValue = linkedList.get(0);
        //linkedList.remove(frontValue);
        linkedList.remove(1);
        return frontValue;
    }

    public E peek() {
        E frontValue = linkedList.get(linkedList.size() - 1);
        return frontValue;
    }

    public boolean isEmpty() {
        if (linkedList.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (linkedList.size() == sizeLimit - 1) {
            return true;
        } else {
            return false;
        }

    }

    public int size() {
        return linkedList.size();
    }

    // *******************
    // Main Method
    // *******************
    public static void main(String[] args) {
        String fileLocation = args[0];
        File file = new File(fileLocation);
        Scanner finder = new Scanner(System.in);
        Scanner findInt = new Scanner(System.in);

        try {
            finder = new Scanner(file).useDelimiter("(\\b|\\B)");
            findInt = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // find queue length
        findInt.useDelimiter("[^0-9]+");
        int queueLength = findInt.nextInt();
        //remove first numbers from the data
        String toPutInQueue = "";
        while (finder.hasNext()) {
            toPutInQueue = toPutInQueue + finder.next();
        }

        toPutInQueue = toPutInQueue.substring(Integer.toString(queueLength).length());
        finder = new Scanner(toPutInQueue);
        //Make queue
        Queue<Character> queue = new Queue<>(queueLength);
        int startingNumber = 0;

        char[] holder = toPutInQueue.toCharArray();
        startingNumber = 0;
        while (startingNumber <= holder.length) {

            for (int i = 0; i < queueLength - 1 && i + startingNumber != holder.length; i++) {
                try{
                    queue.enqueue(holder[i+startingNumber]);
                } catch ( QueueFullException e){
                    e.printStackTrace();
                }

            }
            startingNumber = startingNumber + queueLength;

            //System.out.println();
            //System.out.println("intermission");
            //print them out of the queue
            while (!queue.isEmpty()) {
                try {
                    System.out.print(queue.dequeue());
                } catch (QueueEmptyException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }

    }

}
