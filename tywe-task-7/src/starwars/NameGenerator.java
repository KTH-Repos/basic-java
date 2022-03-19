

public class NameGenerator
{

    public String generateStarWarsName(String firstName, String lastName, String mothersMaidenName, String birthCity)
    {
        String newFirstName = lastName.substring (0,3) + firstName.substring (0,2);
        String newLastName = mothersMaidenName.substring (0,2) + birthCity.substring (0,3);
        return newFirstName + " " + newLastName;
    }
  }
