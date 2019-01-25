import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Find {
    public static void main(String[] args) {
        String seek = args[0];
        Scanner look;
        try {
            for (int i = 1; args.length > i; i++) {
                File file = new File(args[i]);
                look = new Scanner(file);
                for (; look.hasNext(); ) {
                    String test = look.nextLine();
                    if (test.contains(seek)) {
                        System.out.println(test);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
