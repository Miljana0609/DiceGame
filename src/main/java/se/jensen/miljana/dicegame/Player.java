package se.jensen.miljana.dicegame;

public class Player {

    private String firstName;
    private String lastName;
    private int score;

    public Player() {
        this.score = 0;
    }

    //Set metod för- och efternamn
    public void setFirstName(String firstName) {
        if (firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name can NOT be empty!");
        }
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        if (lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name can NOT be empty!");
        }
        this.lastName = lastName;
    }

    //Metod som returnerar fullnamn
    public String getFullName() {
        return firstName + " " + lastName;
    }

    //Metod som uppdaterar score
    public void addToScore(int points) {
        score += points;
    }

    //Hämtar poäng
    public int getScore() {
        return score;

    }
}


