import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort2 {

    public ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        while (!list1.isEmpty() && !list2.isEmpty()) {
            if(!mergedList.isEmpty() && list1.get(0) == mergedList.get(mergedList.size()-1)){
                list1.remove(0);
            } else if(!mergedList.isEmpty() && list2.get(0) == mergedList.get(mergedList.size()-1)){
                list2.remove(0);
            } else if (list1.get(0) <= list2.get(0)) {
                mergedList.add(list1.get(0));
                list1.remove(0);
            } else {
                mergedList.add(list2.get(0));
                list2.remove(0);
            }
        }
        while(!list1.isEmpty()){
            if(!mergedList.isEmpty() && list1.get(0) == mergedList.get(mergedList.size()-1)){
                list1.remove(0);
            } else {
                mergedList.add(list1.get(0));
                list1.remove(0);
            }
            //mergedList.add(list1.get(0));
            //list1.remove(0);
        }
        while(!list2.isEmpty()){
            if(!mergedList.isEmpty() && list2.get(0) == mergedList.get(mergedList.size()-1)){
                list2.remove(0);
            } else {
                mergedList.add(list2.get(0));
                list2.remove(0);
            }
            //mergedList.add(list2.get(0));
            //list2.remove(0);
        }

        return mergedList;
    }


    public static void main(String[] args) {
        MergeSort2 test = new MergeSort2();
        ArrayList<Integer> temp = new ArrayList<>();
        System.out.println(test.merge( new ArrayList<Integer>(Arrays.asList( new Integer[] {1,5,5,4,4})),new ArrayList<Integer> (Arrays.asList( new Integer[] {2,3,9}))));
    }
}
