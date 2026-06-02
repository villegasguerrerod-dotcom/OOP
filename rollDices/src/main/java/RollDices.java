import java.util.Random;
import java.util.Scanner;

public class RollDices
{
   public static int rollDices()
            {
            Random random = new Random();
            return random.nextInt(6) + 1;
            }
        public static void main(String[] args)
        {
            Scanner data = new Scanner(System.in);

            int dice1, dice2, sum;
            int lives = 5 , launch = 1, consecutive = 0 , totalLaunches = 0, evenCount = 0, oddCount = 0, equalCount = 0;
            String player_name;
            System.out.println("::: WELCOME TO ROLL DICES :::" +
                            "Enter your player name: ");
            player_name = data.nextLine();

            System.out.println("\nHello " + player_name + "!");
            System.out.println("You start with 5 lives.\n");

            while (true)
            {
                System.out.println("========== Launch L" + launch + " ==========" +
                        "\nPress Enter to roll the dices...");
                data.nextLine();
                dice1 = rollDices();
                dice2 = rollDices();
                sum = dice1 + dice2;
                totalLaunches++;
                // Show results
                System.out.println("Playing...");
                System.out.println("Dice 1.....is " + dice1);
                System.out.println("Dice 2.....is " + dice2);
                System.out.println("Sum: " + sum);
                // si sale par, el jugador sigue jugando, si sale impar, pierde una vida. Si salen dos 6, gana una vida extra
                if (sum % 2 == 0)
                {
                    evenCount++;
                    System.out.println("Excelent your number is par you can continue playing.");
                } else {
                    oddCount++;
                    lives--;
                    System.out.println("Sorry you lose one life but continue playing.");
                    }
                if (dice1 == 6 && dice2 == 6)
                {
                lives++;
                System.out.println("Perfect! Double six!" +
                        "\nYou gain one extra life.");                    }
                if (dice1 == dice2) {
                    equalCount++;
                    consecutive++;
                    System.out.println("Equal dices!");
                    System.out.println("Consecutive equal rolls: " + consecutive);
                    } else {
                    consecutive = 0;
                        }
                    System.out.println("Lives remaining: " + lives);
                if (consecutive == 3) {
                System.out.println("YOU ARE WINNER! " +
                "\n You rolled equal dices three times in a row.");
                break;             }
                if (lives == 0)
                        {
                        System.out.println(" GAME OVER " +
                        "\nYou lost all your lives.");
                        break;
                        }
                            launch++;
                            System.out.println();
            }
                System.out.println("\n========== FINAL REPORT ==========" +
                "\nPlayer: " +player_name +
                "\nTotal launches: " + totalLaunches +
                "\nTotal even sums:" + evenCount +
                "\nTotal add sums: " + oddCount +
                "\ntotal equal dice rolls: " + equalCount +
                "\nThanks for playing¡");
        }
}
