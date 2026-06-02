import java.util.Random;
import java.util.Scanner;

public class RollDices
{

   // Function to roll dice
   public static int rollDices()
   {
            Random random = new Random();
            return random.nextInt(6) + 1;
   }

        public static void main(String[] args) {

            Scanner data = new Scanner(System.in);

            // Variables
            int lives = 5;
            int dice1, dice2, sum;

            int launch = 1;
            int consecutive = 0;

            // Counters for report
            int totalLaunches = 0;
            int evenCount = 0;
            int oddCount = 0;
            int equalCount = 0;

            String player_name;

            // Welcome
            System.out.println("::: WELCOME TO ROLL DICES :::"
                    );

            System.out.print("Enter your player name: ");
            player_name = data.nextLine();

            System.out.println("\nHello " + player_name + "!");
            System.out.println("You start with 5 lives.\n");

            // Main loop
            while (true) {

                System.out.println("========== Launch L" + launch + " ==========");

                System.out.println("Press Enter to roll the dices...");
                data.nextLine();

                // Roll dices
                dice1 = rollDices();
                dice2 = rollDices();

                sum = dice1 + dice2;

                totalLaunches++;

                // Show results
                System.out.println("Dice 1: " + dice1);
                System.out.println("Dice 2: " + dice2);
                System.out.println("Sum: " + sum);

                // Even or odd validation
                if (sum % 2 == 0) {

                    evenCount++;

                    System.out.println("Even sum. Continue playing.");

                } else {

                    oddCount++;

                    lives--;

                    System.out.println("Odd sum. You lose one life.");
                }

                // Double six = gain life
                if (dice1 == 6 && dice2 == 6) {

                    lives++;

                    System.out.println("Awesome! Double six!");
                    System.out.println("You gain one extra life.");
                }

                // Equal dices validation
                if (dice1 == dice2) {

                    equalCount++;

                    consecutive++;

                    System.out.println("Equal dices!");
                    System.out.println("Consecutive equal rolls: " + consecutive);

                } else {

                    consecutive = 0;
                }

                // Show lives
                System.out.println("Lives remaining: " + lives);

                // WIN condition
                if (consecutive == 3) {

                    System.out.println("\n🎉 YOU WIN! 🎉");
                    System.out.println("You rolled equal dices three times in a row.");

                    break;
                }

                // GAME OVER condition
                if (lives == 0) {

                    System.out.println("💀 GAME OVER 💀" +
                            "\nYou lost all your lives.");
                            break;
                }

                launch++;

                System.out.println();
            }

            // Final report
            System.out.println("\n========== FINAL REPORT ==========" +
                    "\nPlayer: " +player_name +
                    "\nTotal launches: " + totalLaunches +
                    "\nTotal even sums:" + evenCount +
                    "\nTotal add sums: " + oddCount +
                    "\ntotal equal dice rolls: " + equalCount +
                    "\nThanks for playing¡");

            data.close();
        }
    }
