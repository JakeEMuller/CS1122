import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    ArrayList<ContactEntry> list;
    int entries;

    public ContactList() {
        list = new ArrayList<ContactEntry>();
        entries = 0; //number of entries in the list
    }

    public ArrayList<ContactEntry> getList() {
        return list;
    }

    public void setList(ArrayList<ContactEntry> list) {
        this.list = list;
    }

    public int getEntries() {
        return entries;
    }

    public void setEntries(int entries) {
        this.entries = entries;
    }

    void addEntry(String name, String email) {
        // add a new item at the end of the list.
        ContactEntry entry = new ContactEntry(name, email);
        list.add(entry);
        entries++;
    }

    String getEmail(String name) {
        // return email associated with name,
        // or return null if the name does not occur in the list.
        for (int index = 0; index < entries; index++) {
            ContactEntry entry = list.get(index);
            if (name.equals(entry.getName())) { // found it!
                return list.get(index).getEmail();

            }
        }
        return null; // name wasnt found
    }


    public static ContactList loadContacts(String filepath) {
        ArrayList<String> info = new ArrayList<String>();
        ContactList test = new ContactList();
        Scanner scan = new Scanner(System.in);
        File contacts = new File(filepath);
        try { // catches file not found exception
            scan = new Scanner(contacts);
            while (scan.hasNext()) { // reads the file and adds it to an ArrayList
                info.add(scan.next());
            }
            for (int i = 0; info.size() > i; i++) {
                String name = "";
                String email = "";
                int type = 0; // 0 for name, 1 for email
                for (int j = 0; info.get(i).length() > j; j++) {
                    char colon = info.get(i).charAt(j);
                    if (colon == ':') { // once the colon is found it switches to the email varable
                        type++;
                        j++;
                    }
                    if (type == 0) { // tests to see if the methods should be loading to name or email
                        name += Character.toString(info.get(i).charAt(j));
                    } else if (type == 1) {
                        email += Character.toString(info.get(i).charAt(j));
                    }

                }
                test.addEntry(name, email); // adds to entry
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
        return test;
    }

    public void storeContacts(String filepath) {
        try (PrintWriter pwt = new PrintWriter(filepath)) {
            for (int i = 0; getEntries() > i; i++) {
                String name = getList().get(i).getName();
                String email = getList().get(i).getEmail();
                pwt.print(name);
                pwt.print(":");
                pwt.println(email);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public String toString() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; getEntries() > i; i++) {
            String info = "";
            info += getList().get(i).getName();
            info += ":" + getList().get(i).getEmail();
            result.add(info);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ContactList user;
        Scanner ui = new Scanner(System.in);
        System.out.println("Enter a file to load");
        Scanner temp = new Scanner(System.in);
        String file = temp.next();
        user = ContactList.loadContacts(file);
        System.out.println("you have loaded from " + file);
        System.out.println();
        int action = 24;
        while (action != 5) {
            Scanner universal = new Scanner(System.in);
            String name;
            String email;
            System.out.println("1.) Look up an email address.");
            System.out.println("2.) Add an entry to the contacts list.");
            System.out.println("3.) Delete an entry from the list.");
            System.out.println("4.) Change someone's email.");
            System.out.println("5.) Quit the program.\n\n");
            System.out.print("Enter a command: ");
            action = ui.nextInt();
            if (action == 1) {
                // look up email
                System.out.println("Enter the name you are looking for");
                name = universal.next();
                System.out.printf("The email of %s is %s \n\n", name, user.getEmail(name));
            } else if (action == 2) {
                // add entry
                System.out.println("please enter an name and email separtated by a colon (Example, \"Joe Schome:jSchome@gmail.com\"):");
                String nameEmail = universal.nextLine();
                System.out.println();
                String[] info = nameEmail.split(":");
                name = info[0];
                email = info[1];
                user.addEntry(name, email);
                System.out.printf("%s:%s has been added\n", name, email);
            } else if (action == 3) {
                // delete an entry
                System.out.println("enter the name you want to remove from the list:");
                name = universal.nextLine();
                if (user.getEmail(name) != null) { // test to see if element exists
                    for (int i = 0; user.getList().size() > i; i++)
                    if (name.equalsIgnoreCase(user.getList().get(i).getName())) { //checks to see if name is equal to the element in the list
                        user.getList().remove(i);
                        user.setEntries(user.getEntries() - 1);
                    }
                    System.out.printf("You have removed %s from the list\n\n", name);

                } else {
                    System.out.println("The name entered does not exist in the list");
                }
            } else if (action == 4) {
                // change email
                System.out.println("Enter a name of the person you want to change the email of");
                name = universal.nextLine();
                System.out.printf("Enter the email you would like to replace %s's old email with: \n\n", name);
                email = universal.nextLine();
                if (user.getEmail(name) != null) {
                    for (int i = 0; user.getList().size() > i; i++)
                        if (name.equalsIgnoreCase(user.getList().get(i).getName())) { //checks to see if name is equal to the element in the list
                            user.getList().get(i).setEmail(email);
                        }
                    System.out.printf("You have changed %s's email to %s \n\n", name, email);

                } else {
                    System.out.println("That name is not in the contact base");
                }

            } else if (action == 5) {
                // save additions and close
                user.storeContacts(file);
            }

        }
    }
}