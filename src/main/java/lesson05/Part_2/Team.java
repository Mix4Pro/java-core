package lesson05.Part_2;

public class Team {
    private final String name;
    private int score;

    Team(String name) {
        this.name = name;
        this.score = 0;
    }

    // Getters

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    // Setters

    public void setScore(int score) {
        this.score += score;
    }
}