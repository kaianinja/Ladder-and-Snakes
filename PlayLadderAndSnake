import java.util.Scanner;
/**
 * Sisahga Phimmasone - 40210015
 * Cleopatr-Aliak Manoukian - 40211001
 * COMP 249
 * Assignment # 1
 * Due Date - Monday, February 7, 2022 @ 23:59
 * ---------------------------------------------------------------------------------------------------
 *Assignment 1
 *Question: Part I)
 *Written by: Cleopatr-Aliak Manoukian and Sisahga Phimmasone - 40211001 and 40210015 respectively.
*
 *---------------------------------------------------------------------------------------------------
 *@author Cleopatr-Aliak
 *@author Sisahga
*/
public class PlayLadderAndSnake 
{

    public static void main(String[] args)
    {
        Scanner k = new Scanner(System.in);

        boolean userWantsToPlayAgain = false;

        do
        {

            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
            System.out.println("=                        Welcome to Ladders and Snakes                          =");
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");

            System.out.println("\n|Rules|:\n\t- Players start below box 1.\n\t- First player to reach 100 on the board wins.\n\t- If you reach the bottom of a ladder, climb to the top of the ladder." +
                    "\n\t- If you reach the head of a snake, you must slide down to its tail.\n");

            System.out.print("\nEnter the number of players for your game (between 2-4 players inclusively): ");
            int players = k.nextInt();

            int attempts = 1;
            while((players < 2 || players > 4) && players != 0)
            {
                boolean thirdAttempt = (attempts == 3);
                String invalidEndString = thirdAttempt ? " (Attention! This is your last attempt): " : ": ";
                if (attempts == 4)
                {
                    System.out.println("\nInvalid attempt #4: You have exhausted all of your attempts. The program will now terminate.\n\nGoodbye!");
                    System.exit(0);
                }
                System.out.print("\nInvalid attempt #" + attempts + ": Number of players not between 2 and 4. Please try again" + invalidEndString);
                attempts++;
                players = k.nextInt();
            }

            LadderAndSnake snake = new LadderAndSnake(players);

            snake.play();

            System.out.println("Do you want to play this game again? (yes or no): ");
            String userAnswer;
            userAnswer = k.next();

            if (userAnswer.equals("yes"))
                userWantsToPlayAgain = true;
            else if (userAnswer.equals("no"))
                userWantsToPlayAgain = false;
            else
                while (!userAnswer.equals("yes") && !userAnswer.equals("no"))
                {
                    System.out.println("Do you want to play this game again? (yes or no): ");
                    userAnswer = k.next();
                    if (userAnswer == "yes")
                        userWantsToPlayAgain = true;
                    else if (userAnswer == "no")
                        userWantsToPlayAgain = false;
                }

        } while (userWantsToPlayAgain);

        System.out.println("\n\tThanks For Playing LadderAndSnake!\n\tGoodbye!");

        k.close();
    }
    
}
