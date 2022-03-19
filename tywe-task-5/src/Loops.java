/* Exercises 4.30-4.33

*/

public class Loops {

/* Exercise 4.30*/
public static void multiplesOfFive()
{
  int multiplefive = 10;
  while (multiplefive <= 95){
    System.out.println(multiplefive);
    multiplefive = multiplefive + 5;
  }
}
/* Exercise 4.31*/
  public static void intSum()
  {
    int sum = 0;
    int startNumber = 1;
    while (startNumber <= 10){
      sum = sum + startNumber;
      startNumber++;
    }
    System.out.println ("The total sum = " + sum);
  }
/*Exercise 4.32*/
  public static int sum(int a, int b)
  {
    int sum = 0;
    int startNumber = a;
    while (startNumber <= b){
      sum = sum + startNumber;
      startNumber++;
    }
    return sum;
  }
/*Exercise 4.33*/
  public static boolean isPrime (int n)
  {
    int divider = 2;
    while (divider < n) {
      if (n % divider == 0) {
        return false;
      }
      divider++;
    }
    return true;
  }

  public static void main(String[] args) {
    multiplesOfFive();
    intSum();
    System.out.println(sum(4,5));
    System.out.println(isPrime(19));
    System.out.println(isPrime(532));
  }
}
