package quizopedia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    int correctOption;
    String correctAnswer;

    Question(String questionText, String[] options, int correctOption, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
        this.correctAnswer = correctAnswer;
    }
}

class Competition {
    protected int score = 0;

    void showRules() {
        System.out.println("\nHere are the rules of our Quiz game:");
        System.out.println("1) Question format: Multiple choice questions.");
        System.out.println("2) Time limits: Try to answer promptly.");
        System.out.println("3) Scoring: +1 for correct answer.");
        System.out.println("4) No hints will be provided.");
        System.out.println("5) Cheating prevention: Please don’t cheat.");
        System.out.println("6) Data privacy: Your data is secure.\n");
    }

    boolean askQuestion(Scanner sc, Question q, int qNumber) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";

        System.out.println("Question " + qNumber + ": " + q.questionText);
        for (int i = 0; i < q.options.length; i++) {
            System.out.println((i + 1) + ") " + q.options[i]);
        }

        System.out.print("Your answer (1-" + q.options.length + "): ");
        int choice;
        try {
            choice = sc.nextInt();
            if (choice < 1 || choice > q.options.length) {
                System.out.println(ANSI_RED + "Invalid choice. Skipping question." + ANSI_RESET);
                return false;
            }
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Invalid input. Skipping question." + ANSI_RESET);
            sc.nextLine(); // clear buffer
            return false;
        }

        if (choice == q.correctOption) {
            System.out.println(ANSI_GREEN + "Correct!" + ANSI_RESET + "\n");
            score++;
            return true;
        } else {
            System.out.println(ANSI_RED + "Incorrect! Correct answer is: " + q.correctAnswer + ANSI_RESET + "\n");
            return false;
        }
    }

    void printFinalScore(int totalQuestions) {
        System.out.println("Your total score is: " + score + "/" + totalQuestions);
        System.out.println("Percentage: " + (score * 100 / totalQuestions) + "%");
    }

    void printReward() {
        switch (score) {
            case 10:
                System.out.println("*** Congratulations! You won a CAR! ***");
                break;
            case 9:
                System.out.println("*** Congratulations! You won an iPHONE! ***");
                break;
            case 8:
                System.out.println("*** Congratulations! You won a VACATION TRIP! ***");
                break;
            default:
                System.out.println("Well done! Better luck next time.");
        }
    }
}

class QuizGame extends Competition {
    private List<Question> questions = new ArrayList<>();

    QuizGame() {
        questions.add(new Question("Who is the CEO of PepsiCo?",
                new String[]{"Satya Nadella", "Sundar Pichai", "Indra Nooyi", "Mark Zuckerberg"}, 3, "Indra Nooyi"));
        questions.add(new Question("Who is the CEO of Google?",
                new String[]{"Sundar Pichai", "Mark Zuckerberg", "Larry Page", "Ratan Tata"}, 1, "Sundar Pichai"));
        questions.add(new Question("Who is the CEO of Instagram?",
                new String[]{"Mark Zuckerberg", "Indira Noori", "Sundar Pichai", "Adam Mosseri"}, 4, "Adam Mosseri"));
        questions.add(new Question("Who is the CEO of Microsoft?",
                new String[]{"Satya Nadella", "Mark Zuckerberg", "Sundar Pichai", "Kavita"}, 1, "Satya Nadella"));
        questions.add(new Question("Who is the CEO of Facebook?",
                new String[]{"Satya Nadella", "Adam Mosseri", "Sundar Pichai", "Mark Zuckerberg"}, 4, "Mark Zuckerberg"));
        questions.add(new Question("Which datatype is used to store integer values?",
                new String[]{"String", "int", "double", "boolean"}, 2, "int"));
        questions.add(new Question("Which datatype is not used to store fractional values?",
                new String[]{"String", "float", "double", "all of these"}, 1, "String"));
        questions.add(new Question("Which of the following are characteristics of Java?",
                new String[]{"easy", "object oriented", "simple", "all of these"}, 4, "all of these"));
        questions.add(new Question("Which of the following is not an access modifier?",
                new String[]{"public", "private", "double", "protected"}, 3, "double"));
        questions.add(new Question("Which class is used to take input in Java?",
                new String[]{"Color", "Button", "awt", "Scanner"}, 4, "Scanner"));
    }

    void startQuiz(Scanner sc) {
        System.out.println("Starting the quiz...\n");

        for (int i = 0; i < questions.size(); i++) {
            askQuestion(sc, questions.get(i), i + 1);
        }

        printFinalScore(questions.size());
        printReward();
        System.out.println("Thank you for playing!\n");
    }
}

public class quizopedia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("\n*************************************");
        System.out.println("!!! Welcome " + name + " to our Quiz Game !!!");
        System.out.println("*************************************\n");

        QuizGame game = new QuizGame();
        game.showRules();

        int choice;
        do {
            System.out.println("Press 1 to ALLOW and start quiz");
            System.out.println("Press 2 to DENY and exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                game.startQuiz(sc);
            } else if (choice == 2) {
                System.out.println("Thank you for your consideration!");
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.\n");
            }
        } while (choice != 1 && choice != 2);

        sc.close();
    }
}
