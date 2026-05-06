import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        WordManager wm = new WordManager();
        Game game = new Game(wm);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Play Game");
            System.out.println("2. View Words");
            System.out.println("3. Add Word");
            System.out.println("4. Remove Word");
            System.out.println("5. View Score");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    game.play(sc);
                    break;
                case 2:
                    wm.viewWords();
                    break;
                case 3:
                    System.out.print("Enter new word: ");
                    wm.addWord(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Enter word to remove: ");
                    wm.removeWord(sc.nextLine());
                    break;
                case 5:
                    game.showScore();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}