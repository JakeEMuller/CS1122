import java.util.Arrays;

public class MergSort {

    public static int[] sort(int[] a) {
        int[] result;
        if (a.length <= 1) {
            return a;
        }
        int[] first = new int[a.length / 2];
        int[] second = new int[a.length - first.length];

        for (int i = 0; i < first.length; i++) {
            first[i] = a[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = a[first.length + i];
        }
        sort(first);
        sort(second);
        result = merge(first, second, a);
        return result;

    }

    private static int[] merge(int[] first, int[] second, int[] a) {
        int dups = 0;
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;
        int[] newArray;

        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                a[j] = first[iFirst];
                iFirst++;
            } else {
                a[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        while (iFirst < first.length) {
            a[j] = first[iFirst];
            iFirst++;
            j++;
        }
        while (iSecond < second.length) {
            a[j] = second[iSecond];
            iSecond++;
            j++;
        }


        //System.out.println("input array" + Arrays.toString(a));
        //System.out.println("length " + a.length);
        for (int i = 0; i < a.length; i++) {
            //   System.out.println("1 + i =  " + (1 + i) + "\na.length =  " + a.length);
            if ((i + 1) != a.length) {
                if (a[i] == a[i + 1]) {
                    //System.out.println("a[i] " + a[i]);
                    //System.out.println("a[++i] " + a[i + 1]);
                    dups++;
                }
            }
        }
        //System.out.println("dups " + dups);
        newArray = new int[a.length - dups];
        newArray[0] = a[0];
        int index = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                //skip
            } else if (a.length != 1) {
                newArray[index] = a[i];
                index++;
            } else {

            }
        }
        //System.out.println("new array" + Arrays.toString(newArray));

        return newArray;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 7, 6, 6, 6, 8, 9, 9, 9, 4, 4};
        int[] expected = {1, 4, 5, 6, 7, 8, 9};

        System.out.println("return on sort " + Arrays.toString(sort(a)));
        System.out.println("expected result " + Arrays.toString(expected));

    }


}
