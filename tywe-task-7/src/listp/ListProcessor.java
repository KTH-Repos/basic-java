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
            int dif = to - from;
            int[] array = new int[dif];
            for(int i = from; i < to; i++){
                array[i] = i;
            }
            return array;

        }
    }


}