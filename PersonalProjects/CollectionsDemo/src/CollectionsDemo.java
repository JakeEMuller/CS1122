import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CollectionsDemo {
    public static void main(String[] args) {

        //arrayList demo
        System.out.println("Arraylist Demo \n");
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[] {1,2,3,4,5,6,7,8,9,10,10}));
        System.out.println(list);
        list.remove(new Integer(10));
        System.out.println(list);
        list.remove(new Integer(10));
        System.out.println(list + "\n\n");

        //HashMap Demo
        System.out.println("HashMap Demo \n");
        HashMap<String, String> contacts = new HashMap<>();
        contacts.put("Bob","bob@mtu.edu");
        contacts.put("Carl","carl@mtu.edu");
        contacts.put("Mark","mark@mtu.edu");
        contacts.put("Jacob","jacob@mtu.edu");

        for( String name: contacts.keySet()){
            System.out.printf("%s : %s\n", name, contacts.get(name));
        }



    }
}
