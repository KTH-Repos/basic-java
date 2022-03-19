import java.util.Random;
import java.util.ArrayList;


public class RandomTester
{

    public Random randomTester;
    public ArrayList words;

    public RandomTester()
    {

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
