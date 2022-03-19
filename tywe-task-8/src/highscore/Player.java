/**
  * The Player class holds basic information about a player such as name,
  * country and score.
  *
  * @author Tomas
  * @version 2020.11.05
  */

public class Player {
    String name;
    String country;
    int score;
/**
  * Create a player.
  * @param name the name of the player
  * @param country the country of the player
  * @param score the score of the player
  */
    public Player(String name, String country, int score) {
        this.name = name;
        this.country = country;
        this.score = score;
    }
/**
  * @return the info about a player.
  */
    public String toString() {
        return "Player " + name + " from " + country + " scored " + score + " points";
    }
}
