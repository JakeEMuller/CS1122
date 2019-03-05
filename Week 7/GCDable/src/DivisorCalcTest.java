public class DivisorCalcTest {
    public static void main(String[] args) {
        DivisorCalc test = new DivisorCalc();
        System.out.println(test.gcd(18,24) + " pass if 6");
        System.out.println(test.gcd(10,4) + " pass if 2");
        System.out.println(test.gcd(6,3) + " pass if 3");
        System.out.println(test.gcd(7,1) + " pass if 1");
        System.out.println(test.gcd(81,81) + " pass if 81");
        System.out.println(test.gcd(-1,6) + " pass if 1");
        System.out.println(test.gcd(-18,24)  + " pass if 6");
        System.out.println(test.gcd(-10,-5) + " pass if 5");
        System.out.println(test.gcd(6,0) + " pass if 0 (indicating Not possible)");
    }
}
