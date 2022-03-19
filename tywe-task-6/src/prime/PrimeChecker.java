public class PrimeChecker
{
    public static boolean isPrime(int n)
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

    public static void main(String[] args)
    {
      for(int i = 1; i < 26; i++){
         if(isPrime(i)){
             System.out.println(i + " is a prime number!");
         }
         else{
             System.out.println(i + " is not a prime number:(");
         }

        }
    }

}
