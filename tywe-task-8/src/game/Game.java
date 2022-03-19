/**
 *  This class is the main class of the "Find your way" application.
 *  "Find your way" is a very simple, text based adventure game.  Users
 *  can walk around some scenery.
 *
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 *
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 *
 * @author  Tomas
 * @version 2020.11.05
 */

public class Game
{
    private Parser parser;
    private Room currentRoom;
    private Room endRoom;
    private GameMap gamemap;
    private Player player;

    /**
     * Create the game and initialise its internal map.
     */
    public Game()
    {
        gamemap = new GameMap();
        player = new Player("Sam");
        currentRoom = gamemap.getStartRoom();
        endRoom = gamemap.getEndRoom();
        parser = new Parser();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);

            if (player.gameOver()){
              System.out.println("Sorry, have reached the maximum number of room enters");
              finished = true;
            }
            if (player.getCurrentRoom() == endRoom){
              System.out.println("Good job! You've won.");
              finished = true;
            }
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Glad to have you on board on this adventure");
        System.out.println("Try to find your way out of this shopping mall");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
      }



    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp()
    {
        System.out.println("Sam is lost. He is alone. He wanders");
        System.out.println("in the shopping mall.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /**
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            player.enterRoom(nextRoom);
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());

        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
