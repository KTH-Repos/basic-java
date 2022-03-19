import java.util.Random;
import java.util.ArrayList; 
/**
 * Write a description of class RandomTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RandomTester
{

    public Random randomTester;
    public ArrayList words;
    /**
     * Constructor for objects of class RandomTester
     */
    public RandomTester()
    {
        // initialise instance variables
        randomTester = new Random ();
        words = new ArrayList<String>();
        words.add("class");
        words.add("Edit");
        words.add("Tools");
        words.add("Options");
        words.add("java");
        words.add("cut");
        words.add("Find");
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void printOneRandom()
    {
        int randomNumber = randomTester.nextInt();
        System.out.println(randomNumber);
    }

    public void printMultiRandom(int howmany)
    {
        
        int i = 0;
        while (i < howmany) {
        printOneRandom();
        i++;
       }
    }
    public void throwDice ()
    {
        int ranNumber = randomTester.nextInt(6);
        System.out.println(ranNumber + 1);
    }
    
    public void getResponse()
    {
        int ranIndex = randomTester.nextInt(words.size());
        System.out.println(words.get(ranIndex));
    }
    
    public int randInRangeMinMax(int Min,int Max)
    {
        return randomTester.nextInt(Max - Min + 1) + Min;
    }
   
}
