public class DivisorCalc implements GCDable {
    public int gcd( int num1, int num2 ) throws NumberFormatException{
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        if(num2 == 0 || num1 == 0){
            return 0;
        } else if(num2 <= num1 && num1 % num2 == 0){
            return num2;
        } else if(num1 < num2){
            return gcd(num2, num1);
        } else {
            return gcd(num2, num1 % num2 );
        }
    }

    public static void main(String[] args) {
        DivisorCalc test = new DivisorCalc();
        System.out.println(test.gcd(3,0));
    }
}
