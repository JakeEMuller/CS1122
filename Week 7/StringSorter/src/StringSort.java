public class StringSort  {
    public static String sort(String string){
        if(string.length() == 1){
            return string;
        } else {
            String sub = string.substring(0,string.length()-1);
            String temp = Character.toString(string.charAt(string.length()-1));
            return temp + sort(sub);
        }

    }

    public static void main(String[] args) {
        System.out.println(StringSort.sort("Gart is Gay"));
    }
}
