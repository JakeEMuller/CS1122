
/**
  * Interface for  Euclids algorithm for finding the greatest common divisor of 
  * two positive integers. The greatest common divisor is the largest integer 
  * that divides both integers without producing a remainder.
  * 
  * The recursive algorithm is defined as follows:
  * 
  * gcd( num1, num2 ) is num2 if num2 <= num1 and num2 divides num1.
  * gcd( num1, num2 ) is gcd( num2, num1 ) if num1 < num2
  * gcd( num1, num2 ) is gcd( num2, num1 % num2 ) otherwise
  *
  */
public interface GCDable {
   /**
    * Returns the greatest common divisor.
    * 
    * Euclid's recursive algorithm is defined as follows:
    * 
    * gcd( num1, num2 ) is num2 if num2 <= num1 and num2 divides num1.
    * gcd( num1, num2 ) is gcd( num2, num1 ) if num1 < num2
    * gcd( num1, num2 ) is gcd( num2, num1 % num2 ) otherwise
    * 
    * @param num1
    * @param num2
    * @return
    */
   public int gcd( int num1, int num2 );

}
