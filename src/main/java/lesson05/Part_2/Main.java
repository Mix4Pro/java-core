package lesson05.Part_2;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Quiz quiz = new Quiz();
        quiz.addQuestion("What country has the largest area ?", "Russia", 100);
        quiz.addQuestion("What country has the smallest area ?", "Vatican City", 100);
        quiz.addQuestion("What sport do players in the NBA play ?", "Basketball", 100);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Create 2 teams : ");

        System.out.print("Team 1 name : ");
        quiz.addTeam(scanner.nextLine());

        System.out.print("Team 2 name : ");
        quiz.addTeam(scanner.nextLine());

        int quiz_question_size = quiz.getQuestionCollectionSize();
        for (int i = 0; i < quiz_question_size; i++) {
            Question question = quiz.getAQuestion(i);
            int quiz_team_size = quiz.getTeamCollectionSize();
            System.out.println("The question : " + question.getQuestion());
            for (int j = 0; j < quiz_team_size; j++) {
                System.out.printf(quiz.getATeam(j).getName() + " answer is : ");
                quiz.guessAnswer(quiz.getATeam(j), question, scanner.nextLine());
            }
        }
        quiz.getResults();

    }
}