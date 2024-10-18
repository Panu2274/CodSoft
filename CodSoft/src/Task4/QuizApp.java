package Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

class Quiz {
	
    private List<Question> questions;
    private int currentScore;
    private int totalQuestions;
    private int currentQuestionIndex;
    private List<String> userAnswers;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.totalQuestions = questions.size();
        this.currentQuestionIndex = 0;
        this.currentScore = 0;
        this.userAnswers = new ArrayList<>();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (currentQuestionIndex < totalQuestions) {
            Question question = questions.get(currentQuestionIndex);
            displayQuestion(question);

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question.");
                    userAnswers.add("No answer");
                    currentQuestionIndex++;
                    if (currentQuestionIndex < totalQuestions) {
                        start(); 
                    } else {
                        displayResults(); 
                    }
                }
            };
            timer.schedule(task, 10000); 

            System.out.print("\nEnter your answer (1-4): ");
            int userAnswer;
            if (sc.hasNextInt()) {
                userAnswer = sc.nextInt();
                timer.cancel(); 

                if (userAnswer - 1 == question.getCorrectAnswerIndex()) {
                    currentScore++;
                    userAnswers.add("Correct");
                } else {
                    userAnswers.add("Incorrect");
                }
            } else {
               
                System.out.println("Invalid input! Moving to the next question.");
                userAnswers.add("No answer");
                timer.cancel();
            }

            currentQuestionIndex++;
            if (currentQuestionIndex == totalQuestions) {
                displayResults();
            }
        }
        sc.close();
    }

    private void displayQuestion(Question question) {
        System.out.println("\nQuestion " + (currentQuestionIndex + 1) + ": " + question.getQuestionText());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    private void displayResults() {
        System.out.println("\n*** Quiz Completed ***\n");
        System.out.println("Your final score: " + currentScore + "/" + totalQuestions);

        System.out.println("\n\n--- Correct Answers ---\n");
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestionText());
            System.out.println("Correct Answer: " + question.getOptions()[question.getCorrectAnswerIndex()]);
            System.out.println("Your Response: " + userAnswers.get(i));
            System.out.println();
        }

        System.exit(0);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();

        System.out.println("      Welcome to Quiz Application     ");
        System.out.println();
        questions.add(new Question("Which keyword is used to define a class in Java?", new String[]{"class", "define", "public", "object"}, 0));
        questions.add(new Question("What is the default value of an int variable in Java?", new String[]{"null", "0", "1", "-1"}, 1));
        questions.add(new Question("Which method is used to start a thread in Java?", new String[]{"run()", "execute()", "start()", "begin()"}, 2));
        questions.add(new Question("Which of these is not a primitive data type in Java?", new String[]{"int", "float", "String", "char"}, 2));
        questions.add(new Question("What is the size of a byte variable in Java?", new String[]{"4 bits", "8 bits", "16 bits", "32 bits"}, 1));
        questions.add(new Question("Which collection class allows you to store key-value pairs?", new String[]{"List", "Set", "Map", "Queue"}, 2));
        questions.add(new Question("Which of the following is not an access modifier in Java?", new String[]{"private", "public", "protected", "internal"}, 3));
        questions.add(new Question("What is the purpose of the 'super' keyword in Java?", new String[]{"To refer to the current object", "To create a new object", "To refer to the parent class", "To access static methods"}, 2));
        questions.add(new Question("Which exception is thrown when a division by zero occurs in Java?", new String[]{"IOException", "NullPointerException", "ArithmeticException", "ClassNotFoundException"}, 2));
        questions.add(new Question("What does JVM stand for?", new String[]{"Java Variable Machine", "Java Virtual Machine", "Java Value Method", "Java Verified Module"}, 1));

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}
