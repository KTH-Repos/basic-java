import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

/**
  * The GameMap holds the map of the whole "Find your way" application.
  * It includes all the rooms a player can enter into.
  * @author Tomas
  * @version 2020.11.05
  */

public class GameMap {

  private HashMap<String, Room> worldModel;    //A collection of the rooms and their names as key
  private Room startRoom;
  private Room endRoom;
/**
  * Create the whole map for the game.
  */
  public GameMap()
  {
      createRoomsFromFile("map.txt");
  }

  /**
    * Create rooms and assign to them Exits
    * @param filename The file from which the Rooms and their exits are created
    * Assign the room with CoffeeShop as key to the first room in the game.
    */
  public void createRoomsFromFile(String filename) {
    BufferedReader input = null;
    HashMap<String, Room> worldModel = new HashMap<String, Room>();

    try {
          input = new BufferedReader(new FileReader(filename));
          boolean s = true;
          String line;
          String[] roomData;

            while ((line = input.readLine()) != null)
              if (line.startsWith("Room") == s){
                roomData = line.split(",");
                String Name = roomData[1];
                String Description = roomData[2];

                Room room = new Room(Description);
                worldModel.put(Name, room);
              }

              else if (line.startsWith("Exit") == s){
                roomData = line.split(",");
                String Room1 = roomData[1];
                String direction = roomData[2];
                String Room2 = roomData[3];

                worldModel.get(Room1).setExit(direction, worldModel.get(Room2));
              }
            } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
          }


            startRoom = worldModel.get("CoffeeShop");      //Set the fist room to CoffeeShop
            endRoom = worldModel.get("ExitDoor");          
    }
    /**
      * @return the room from which the game starts
      */
    public Room getStartRoom()
    {
      return startRoom;
    }

    /**
      * @return the room at which the game ends
      */
    public Room getEndRoom()
    {
      return endRoom;
    }

}
