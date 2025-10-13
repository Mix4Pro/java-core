package lesson05.Part_2;

import java.util.ArrayList;

public class Quiz {
    private final ArrayList<Question> questionCollection = new ArrayList<>();
    private final ArrayList<Team> teamCollection = new ArrayList<>();
    private final ArrayList<Team> winnerCollection = new ArrayList<>();


    public void addQuestion(String inp_question, String inp_answer, int score) {
        try {
            Question question = new Question(inp_question, inp_answer, score);
            if (!questionCollection.isEmpty()) {
                boolean found = false;
                for (Question collection_question : questionCollection) {
                    if (collection_question.getQuestion().equals(question.getQuestion())) {
                        found = true;
                        System.out.println("This question already exists");
                        break;
                    }
                }

                if (!found) {
                    questionCollection.add(question);
                }
            } else {
                questionCollection.add(question);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error while adding question : " + inp_question);
        }
    }

    public void addTeam(String name) {
        if (!teamCollection.isEmpty()) {
            boolean found = false;
            for (Team team : teamCollection) {
                if (team.getName().equals(name)) {
                    found = true;
                    System.out.println("This team already exists");
                    break;
                }
            }

            if (!found) {
                Team team = new Team(name);
                teamCollection.add(team);
            }
        } else {
            Team team = new Team(name);
            teamCollection.add(team);
        }
    }

    public void guessAnswer(Team team, Question question, String guessing_answer) {
        if (question.getRightAnswer().equalsIgnoreCase(guessing_answer)) {
            System.out.println("You got it right !");
            team.setScore(question.getScore());
            System.out.println("+ " + question.getScore());
        } else {
            System.out.println("You didn't get it right");
        }
    }

    public void getResults() {
        Team winner = teamCollection.getFirst();
        for (int i = 0; i < teamCollection.size(); i++) {
            if (winner.getScore() < teamCollection.get(i).getScore()) {
                winnerCollection.clear();
                winnerCollection.add(teamCollection.get(i));
            }
            if (winner.getScore() == teamCollection.get(i).getScore() && teamCollection.get(i).getScore() != 0) {
                winnerCollection.add(teamCollection.get(i));
            }
        }
        
        if (winnerCollection.size() > 1) {
            System.out.print("\nThe winners are : ");
            for (Team team : winnerCollection) {
                System.out.print(team.getName() + " ");
            }
        } else if (winnerCollection.size() == 1) {
            System.out.println("\n The winner is : " + winnerCollection.getFirst().getName());
        } else {
            System.out.println("There are no winners");
        }
    }

    public int getQuestionCollectionSize() {
        return this.questionCollection.size();
    }


    public Question getAQuestion(int index) {
        return this.questionCollection.get(index);
    }

    public int getTeamCollectionSize() {
        return this.teamCollection.size();
    }

    public Team getATeam(int index) {
        return this.teamCollection.get(index);
    }
}