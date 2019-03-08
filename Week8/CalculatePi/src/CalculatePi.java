import java.util.Random;

public class CalculatePi implements FindPi {
    public long gcd(long num1 , long num2){
        {
            if (num2 % num1 == 0)
                return num1;
            else
                return gcd(num2, num1 % num2);
        }
    }
    public double calculatePi ( long max, int range ){
        int count = 0;
        int k = range;
        Random num1 = new Random();
        Random num2 = new Random();
        for(int i = 0; i < range; i++){
            long long1 = num1.nextInt((int) max);
            long long2 = num2.nextInt((int) max);
            long temp = gcd(long1+1, long2+1);
            if(temp == 1){
                count++;
                System.out.println(count);
            }
        }
        double pi;
        if(count == 0) {
         pi = 0;
        }
        else {
            pi = Math.sqrt(6 / ((double) count / (double)range));
        }

        return pi;
        }


    public static void main(String[] args) {
        CalculatePi test = new CalculatePi();
        System.out.println(test.calculatePi(1000000,1000000));
    }
}



