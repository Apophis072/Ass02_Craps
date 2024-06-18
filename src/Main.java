
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //Defining variables and importing utils
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        int rollA = -1;
        int rollB = -2;
        int sum = 0;
        int point = 0;
        String complete = "N";
        String playAgain = "N";

        do {
            //first dice rolls
            rollA = rnd.nextInt(6) + 1;
            rollB = rnd.nextInt(6) + 1;
            sum = rollA + rollB;
            System.out.println("\nThe result of the first roll is " + rollA + ".\tThe result of the second roll is " + rollB + ". The sum is " + sum + ".");

            //preceding steps if the first roll does not get a win or a lose.
            if (sum == 7 || sum == 11) {
                System.out.println("You rolled a natural! All players who placed a bet on the Pass Line win!");
            } else if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You rolled a craps! All players who placed a bet on the Pass Line lose!");
            } else {
                point = sum;
                System.out.println("You did not get 2,3,7,11, or 12 so " + sum + " becomes the Point.");
                System.out.println("If you roll the Point again all players who placed a bet on the Pass Line win, but if you roll a 7 all players on Pass Line lose.");
                rnd.nextInt();
            }
            if (point == sum) {

                do {
                    System.out.println("Press any letter or number to continue with the roll.");
                    if (in.hasNextLine() || in.hasNextInt()) {
                        rollA = rnd.nextInt(6) + 1;
                        rollB = rnd.nextInt(6) + 1;
                        sum = rollA + rollB;

                        System.out.println("You rolled a " + rollA + " and a " + rollB + ". The sum is " + sum + ".");
                        if (sum == point) {
                            System.out.println("You rolled the Point, " + point + "! All players on the Pass Line win!");
                            complete = "Y";
                        } else if (sum == 7) {
                            System.out.println("You rolled a sum of 7! All players on the Pass Line lose!");
                            complete = "Y";
                        } else {
                            System.out.println("You did not roll the Point, " + point + ", or 7. Roll again.");
                        }
                    } else {
                        System.out.println("You are cheating by trying to leave the game.");
                        System.exit(0);
                    }
                    in.nextLine();
                } while (complete.equals("N"));
            }

            //To play again or in the actual game the next players turn to roll
            System.out.println("To play again press y. Press anything else to quit.");
            playAgain = in.nextLine();
        } while (playAgain.equalsIgnoreCase("Y"));

    }
}