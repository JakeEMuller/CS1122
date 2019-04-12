import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Test {
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
        System.out.println(toPutInQueue + "done");
        finder = new Scanner(toPutInQueue);
        //Make queue
        Queue<Character> queue = new Queue<>(queueLength);
        System.out.println(toPutInQueue.length());
        int startingNumber = 0;

        char[] holder = toPutInQueue.toCharArray();
        startingNumber = 0;
        System.out.println(holder.length);
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
