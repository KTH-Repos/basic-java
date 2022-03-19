import java.util.ArrayList;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList<>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }

    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     *
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(bid);
            if(successful) {
                System.out.println("The bid for lot number " +
                                   lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                                   " already has a bid of: " +
                                   highestBid.getValue());
            }
        }
    }

    public void close() {
        for(Lot lot : lots) {
            System.out.println(lot.getNumber() + ": " + lot.getDescription());
            Bid highestBid = lot.getHighestBid();
            Person Bidder = highestBid.getBidder();
            String name = Bidder.getName();
                if(highestBid != null) {
                    System.out.println("Highest bidder: " + Bidder + name );
                    System.out.println("Bid: " + highestBid.getValue());
                }
                else {
                    System.out.println("This item is not sold");
                }
        }
    }

    public ArrayList<Lot> getUnsold() {
        ArrayList<Lot> unsold = new ArrayList<Lot>();
        for(Lot lot : lots) {
            Bid highestBid = lot.getHighestBid();
            if(highestBid == null) {
                unsold.add(lot);
            }
        }
        return unsold;
      }

      /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
    public Lot getLot(int lotNumber)
      {
        Lot lot = null;
        if (lots.size() > 0) {
            lot = lots.get(0);
            int nextIndex = 1;
            while(lot.getNumber() != lotNumber && nextIndex < lots.size()){
                lot = lots.get(nextIndex);
                nextIndex++;
            }
        }
        if (lot == null || lot.getNumber() != lotNumber){
            System.out.println("The lot with the number " + lotNumber + " does not exist");
            return null;
        }
        else{
            return lot;
        }
      }

      /**
 * Remove the lot with the given lot number.
 * @param number The number of the lot to be removed.
 * @return The Lot with the given number, or null if
 * there is no such lot.
 */
    public Lot removeLot(int number)
      {
        Lot lot = getLot(number);
        if (lots != null){
          lots.remove(lot);
        }
        return lot;
      }
}
