import java.util.Arrays;

public class InsertionSort {

    public void insertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int target = array[i];
            int j = i - 1;
            for (; j >= 0 && array[j] > target; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = target;
            System.out.println("Move " + target + " to position " +  (j+2));
        }

    }

    public static void main(String[] args) {
        InsertionSort test = new InsertionSort();
        int[] array = {1,5,2,6,5,6};
        test.insertionSort(array);
        System.out.println(Arrays.toString(array));

    }
}


