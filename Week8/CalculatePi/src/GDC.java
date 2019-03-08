public class GDC implements GCDable {
    public long gcd(long num1, long num2) {
        if (num2 <= num1 && num1 % num2 == 0) {
            if (num2 == 0) {
                return -1;
            } else {
                return num2;
            }

        } else if (num1 < num2) {
            return gcd(num2, num1);
        } else {
            return gcd(num2, num1 % num2);
        }
    }

    public static void main(String[] args) {
        GDC test = new GDC();
        System.out.println(test.gcd(24, 18));
    }
}
