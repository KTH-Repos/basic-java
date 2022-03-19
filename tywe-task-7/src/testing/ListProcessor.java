public class ListProcessor
{
    

    public int[] arraySequence(int from, int to)
    {
        if (from==to){
            int[] array = new int[0];
            return array;
        }
        else if(to < from){
            throw new IllegalArgumentException("to must be greater than from.");
        }
        else{
            int[] array = new int[to];
            return array;
        }
    }

    
}