import java.util.Scanner;
//только номер 1
public class Main {
  
  guessIt();
  
  
  public static void guessIt() {
        int key = (int) (Math.random()*10);
        int attempts = 3;
        boolean fate = false;

        while (true) {
            if (attempts == 0 | isVictory) {
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                Scanner sc = new Scanner(System.in);
                String proposition = sc.nextLine();
                if(proposition.equals("1")) {
                    attempts = 3;
                    secret = (int) (Math.random() * 10);
                    isVictory = false;
                    continue;
                } else {
                    break;
                }
            }

            System.out.println("Введите число(от 0 до 9): ");
            Scanner sc1 = new Scanner(System.in);
            int UserProposition = sc1.nextInt();

            if (userGuess > secret) {
                attempts -= 1;
                System.out.println("Неугадал");
            }

            if (userGuess < secret) {
                attempts -= 1;
                System.out.println("Неугадал");
            }

            if (userProposition == key) {
                fate = true;
                System.out.println("Угадал!");
            }
        }
    }
