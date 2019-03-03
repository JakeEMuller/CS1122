public class GDC implements GCDable {
    public int gcd( int num1, int num2 ){
        if(num2 <= num1 && num1 % num2 == 0){
            return num2;
        } else if(num1 < num2){
            return gcd(num2, num1);
        } else {
            return gcd(num2, num1 % num2 );
        }
    }

    public static void main(String[] args) {
        GDC test = new GDC();
        System.out.println(test.gcd(24,18));
    }
}
