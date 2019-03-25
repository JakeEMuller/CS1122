import java.util.Arrays;

public class AlphabetSort {

    public int[] selectionSort(int[] arr) {

        int n = arr.length;


        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        System.out.println("selection sort " + Arrays.toString(arr));
        return arr;
    }

    public int[] convertToAscii(char[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int ascii = (int) array[i];
            result[i] = ascii;
        }
        System.out.println("convert to ascii" + Arrays.toString(result));
        return result;
    }

    public char[] convertToChar(int[] array) {
        char[] result = new char[array.length];

        for (int i = 0; i < array.length; i++) {
            char character = (char) array[i];
            result[i] = character;
        }
        System.out.println("convert to char " + Arrays.toString(result));
        return result;
    }

    public static char[] sortCharacters(char[] array) {
        AlphabetSort foo = new AlphabetSort();
        int[] intTransfer = foo.convertToAscii(array);
        intTransfer = foo.selectionSort(intTransfer);
        char[] finalChar = foo.convertToChar(intTransfer);
        return finalChar;
    }


    public static void main(String[] args) {
        char[] test = {'b', 'y', 'e', 'a', 'u', 'r', 'l', 'i', 'o'};
        char[] newArray = sortCharacters(test);
        System.out.println(Arrays.toString(newArray));

    }
}
