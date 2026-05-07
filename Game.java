import java.util.*;


public class Game {
   private int score = 0;
   private WordManager wordManager;


   public Game(WordManager wm) {
       this.wordManager = wm;
   }


   public void play(Scanner sc) {
       ArrayList<String> words = wordManager.getWords();


       if (words.isEmpty()) {
           System.out.println("No words available!");
           return;
       }


       Random rand = new Random();
       String word = words.get(rand.nextInt(words.size()));


       Queue<Character> queue = new LinkedList<>();
       Stack<Character> stack = new Stack<>();


       for (char c : word.toCharArray()) {
           queue.add(c);
           stack.push(c);
       }


       int shuffleTimes = rand.nextInt(10) + 5;
       for (int i = 0; i < shuffleTimes; i++) {
           queue.add(queue.remove());
       }


       StringBuilder jumbled = new StringBuilder();
       for (char c : queue) {
           jumbled.append(c);
       }


       System.out.println("\nJumbled word: " + jumbled);


       checkGuess(sc, word, stack, 1);
   }


   private boolean checkGuess(Scanner sc, String word, Stack<Character> stack, int attemptsLeft) {
       System.out.print("Your guess: ");
       String guess = sc.nextLine();


       if (guess.equalsIgnoreCase(word)) {
           System.out.println("Correct!");
           score++;
           return true;
       }


       if (attemptsLeft == 0) {
           System.out.println("Wrong again! Word was: " + word);
           return false;
       }


       System.out.println("Wrong!");


       char hint = stack.pop();
       System.out.println("Hint: Last letter is '" + hint + "'");


       System.out.println("Try again:");
       return checkGuess(sc, word, stack, attemptsLeft - 1);
   }


   public void showScore() {
       System.out.println("Score: " + score);
   }
}

