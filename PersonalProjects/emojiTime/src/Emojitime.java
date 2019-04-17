import java.util.Scanner;

public class Emojitime {

    public String convertToEmoji(String string){
        char[] array = string.toCharArray();
        String result = "";
        for(int i = 0; i < array.length; i++){
            if(array[i] == 'a' || array[i] == 'A'){
                result = result + ":regional_indicator_a: ";
            } else if(array[i] == 'b' || array[i] == 'B'){
                result = result + ":regional_indicator_b: ";
            } else if(array[i] == 'c' || array[i] == 'C'){
                result = result + ":regional_indicator_c: ";
            } else if(array[i] == 'd' || array[i] == 'D'){
                result = result + ":regional_indicator_d: ";
            } else if(array[i] == 'e' || array[i] == 'E'){
                result = result + ":regional_indicator_e: ";
            } else if(array[i] == 'f' || array[i] == 'F'){
                result = result + ":regional_indicator_f: ";
            } else if(array[i] == 'g' || array[i] == 'G'){
                result = result + ":regional_indicator_g: ";
            } else if(array[i] == 'h' || array[i] == 'H'){
                result = result + ":regional_indicator_h: ";
            } else if(array[i] == 'i' || array[i] == 'I'){
                result = result + ":regional_indicator_i: ";
            } else if(array[i] == 'j' || array[i] == 'J'){
                result = result + ":regional_indicator_j: ";
            } else if(array[i] == 'k' || array[i] == 'K'){
                result = result + ":regional_indicator_k: ";
            } else if(array[i] == 'l' || array[i] == 'L'){
                result = result + ":regional_indicator_l: ";
            } else if(array[i] == 'm' || array[i] == 'M'){
                result = result + ":regional_indicator_m: ";
            } else if(array[i] == 'n' || array[i] == 'N'){
                result = result + ":regional_indicator_n: ";
            } else if(array[i] == 'o' || array[i] == 'O'){
                result = result + ":regional_indicator_o: ";
            } else if(array[i] == 'p' || array[i] == 'P'){
                result = result + ":regional_indicator_p: ";
            } else if(array[i] == 'q' || array[i] == 'Q'){
                result = result + ":regional_indicator_q: ";
            } else if(array[i] == 'r' || array[i] == 'R'){
                result = result + ":regional_indicator_r: ";
            } else if(array[i] == 's' || array[i] == 'S'){
                result = result + ":regional_indicator_s: ";
            } else if(array[i] == 't' || array[i] == 'T'){
                result = result + ":regional_indicator_t: ";
            } else if(array[i] == 'u' || array[i] == 'U'){
                result = result + ":regional_indicator_u: ";
            } else if(array[i] == 'v' || array[i] == 'V'){
                result = result + ":regional_indicator_v: ";
            } else if(array[i] == 'w' || array[i] == 'W'){
                result = result + ":regional_indicator_w: ";
            } else if(array[i] == 'x' || array[i] == 'X'){
                result = result + ":regional_indicator_x: ";
            } else if(array[i] == 'y' || array[i] == 'Y'){
                result = result + ":regional_indicator_y: ";
            } else if(array[i] == 'z' || array[i] == 'Z'){
                result = result + ":regional_indicator_z: ";
            } else if(array[i] == ' '){
                result = result + "  ";
            } else {
                result = result + array[i];
            }

        }


        return result;
    }


    public static void main(String[] args) {
        Emojitime test = new Emojitime();
        Scanner in = new Scanner(System.in);
        System.out.println("Type in the sentence you want to convert to emoji");
        String input = in.nextLine();
        System.out.println(test.convertToEmoji(input));
    }
}
