import java.util.*;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOption;

    public QuizQuestion(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private List<QuizQuestion> questions;
    private int score;
    private int timeLimitPerQuestion; // in seconds

    public Quiz(List<QuizQuestion> questions, int timeLimitPerQuestion) {
        this.questions = questions;
        this.timeLimitPerQuestion = timeLimitPerQuestion;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion question : questions) {
            System.out.println(question.getQuestion());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Your choice (1-" + options.size() + "): ");
            int userChoice = scanner.nextInt();

            if (userChoice == question.getCorrectOption()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was option " + question.getCorrectOption() );
            }

            try {
                Thread.sleep(timeLimitPerQuestion * 1000); // Pause for the specified time limit
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        displayResult();
    }

    private void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your final score: " + score + " out of " + questions.size());
    }
}

    public class QuizTask {
    public static void main(String[] args) {
        List<QuizQuestion> questions = new ArrayList<>();

        // Sample quiz questions


 questions.add(new QuizQuestion("The native place of Mr.loki?", Arrays.asList("b.lore", "bangarpet", "dawarka", "kolar"), 2));

  questions.add(new QuizQuestion("full form of KGF?", Arrays.asList("kolar gold fields", "kolar goldeen field", "kaveri golden field", "karanataka gold fields"), 1));

   questions.add(new QuizQuestion("kotilingeshwara temple is in'?", Arrays.asList("kolar", "b.lore", "belagavi", " cnikkamangluru"), 1));

        Quiz quiz = new Quiz(questions, 10); // Set a 10-second time limit for each question
        quiz.startQuiz();
    }
}