import java.util.Arrays;

public class AlphabetSort {

    public int[] selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for(int j = i+1; j < n; j++ ){
                if (array[j] < array[min_idx]){
                    min_idx = j;
                }

                int temp = array[min_idx];
                array[min_idx] = array[i];
                array[i] = temp;

            }
        }

        return array;
    }

    public int[] convertToAscii(char[] array){
        int[] result = new int[array.length];

        for(int i = 0; i < array.length; i++){
            int ascii = (int) array[i];
            result[i] = ascii;
        }

        return result;
    }

    public char[] convertToChar(int[] array){
        char[] result = new char[array.length];

        for(int i = 0; i < array.length; i++){
            char character = (char) array[i];
            result[i] = character;
        }

        return result;
    }

    public static char[] sortCharacters(char[] array){
        AlphabetSort foo = new AlphabetSort();
        int[] intTransfer = foo.convertToAscii(array);
        intTransfer = foo.selectionSort(intTransfer);
        char[] finalChar = foo.convertToChar(intTransfer);
        return finalChar;
    }


    public static void main(String[] args) {
        char[] test = {'b','y','e','a','u','r'};
        char[] newArray = sortCharacters(test);
        System.out.println(Arrays.toString(newArray));
        
    }
}
