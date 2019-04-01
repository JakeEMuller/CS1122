import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

public class CheckPalindrome {

    public <E> boolean check(ArrayList<E> array){
        for(int i = 0; i < array.size(); i++){
            if(array.get(i) != array.get(array.size() - 1 - i)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        CheckPalindrome test = new CheckPalindrome();
        ArrayList<Integer> foo = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            foo.add(5);
        }
        foo.add(5);

        System.out.println("Expected: true");
        System.out.println(test.check(new ArrayList<Integer>(Arrays.asList( new Integer[] {1,4,3,2,3,4,1}))));
        System.out.println("Expected: true");
        System.out.println(test.check(foo));
        System.out.println("Expected: false");
        System.out.println(test.check(new ArrayList<Integer>(Arrays.asList( new Integer[] {1,5,8,6,9,4,2,3,5}))));
        System.out.println("Expected: true");
        System.out.println(test.check(new ArrayList<Character>(Arrays.asList(new Character[] {'r','a','c','e','c','a','r'}))));
        System.out.println("Expected: false");
        System.out.println(test.check(new ArrayList<Character>(Arrays.asList(new Character[] {'t','h','e','m','a','n'}))));
        System.out.println("Expected: true");
        System.out.println(test.check(new ArrayList<String>(Arrays.asList(new String[] {"r","e","v","i","v","e","r"}))));
        System.out.println("Expected: false");
        System.out.println(test.check(new ArrayList<String>(Arrays.asList(new String[] {"this dude","youtube","howdy","this will fail"}))));

    }
}
