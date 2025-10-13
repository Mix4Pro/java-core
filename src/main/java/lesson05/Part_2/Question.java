package lesson05.Part_2;

public class Question {
    private final String question;
    private final String right_answer;
    private final int score;

    Question(String question, String right_answer, int score) {
        if (score > 0) {
            this.question = question;
            this.right_answer = right_answer;
            this.score = score;
        } else {
            throw new IllegalArgumentException("The score can't be less than 0");
        }
    }

    public String getQuestion() {
        return this.question;
    }

    public String getRightAnswer() {
        return this.right_answer;
    }

    public int getScore() {
        return this.score;
    }
}