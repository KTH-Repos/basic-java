/**
  * Class - player
  *
  * This class is part of the "Find your way" application.
  * "Find your way" is a very simple, text based adventure game.
  *
  * The player class represents the game character. It contains the name, info about
  * how many rooms the character enters, and reference about the current room the character]
  * is in.
  * @author Tomas
  * @version 2020.11.05
  */


public class Player
{
  private String name;
  private Room currentRoom;
  private int enters;
  private int maxEnters = 5;             //Max number of rooms the character enters

  /**
    * Create the character.
    * @param name holds the name of the character.
    * No rooms entered by the character.
    */

  public Player(String name)
  {
    this.name = name;
    enters = 0;
  }

  /**
    * Get the name of the character.
    * @return the name of the character
    */

  public String getName()
  {
    return name;
  }
  /**
    * Enter a room in the shopping mall
    * @param Room indicates the room to which the character has to enter.
    * The number of enters is increased by 1.
    * The current room is set to the entered room.
    */
  public void enterRoom(Room room)
  {
    enters++;
    currentRoom = room;
  }

  /**
   * Return a description of the room in the form:
   *     You are in the kitchen.
   *     Exits: north west
   * @return A long description of this room
   */
  public String getLongDescription()
  {
    String returnString = currentRoom.getLongDescription();
    return returnString;
  }
  /**
    * @return the current room the character is positioned in.
    */

  public Room getCurrentRoom()
  {
    return currentRoom;
  }

  /**
    * Checks whether the number of enters has exceeded the maximum number of room Enters
    * @return true if number of enters has exceeded the maximum number of room enters.
    */
  public boolean gameOver()
  {
    return enters > maxEnters;
  }

}
