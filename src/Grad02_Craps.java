import java.util.Random;
import java.util.Scanner;

public class Grad02_Craps {
    public static void main(String[] args) {

        Random rnd = new Random(); // create a Random object called rnd.
        Scanner in = new Scanner(System.in); //add the scanner for play again

        //Set the loop for the game
        boolean totalGameDone = false;
        while (!totalGameDone) {

            //Roll Dice Here
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int crapsRoll = die1 + die2; // Gaussian range from 2 to 12 as in rolling two dice

            System.out.println("You rolled " + die1 + " and " + die2);

                //Results from rolling the dice
                if (crapsRoll == 7 || crapsRoll == 11) {
                    System.out.println("\nNatural roll! Your total is " + crapsRoll + ", you win!");

                } else if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                    System.out.println("\nYour total is " + crapsRoll + "... Crap! You lose!");

                } else {
                    System.out.println("\nYour score is " + crapsRoll);

                    int point = crapsRoll;
                    boolean pointSet = false;

                    boolean gameDone = false;
                    while (!pointSet) {
                        int newDie1 = rnd.nextInt(6) + 1;
                        int newDie2 = rnd.nextInt(6) + 1;
                        int newRoll = newDie1 + newDie2;
                        System.out.println("\nRolling again: " + newDie1 + " and " + newDie2);
                        System.out.println("Your score is " + newRoll);

                            // Introduce delay between rolls
                            try {
                                Thread.sleep(1000); // Delay of 1 second (1000 milliseconds)
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        if (newRoll == 7) {
                            System.out.println("\nYou rolled a 7, you lose!");
                            gameDone = true;
                            pointSet = true;
                        } else if (newRoll == point) {
                            System.out.println("\nYou rolled your point, you win!");
                            gameDone = true;
                            pointSet = true;
                        }

                    }
                }
            //call the method and ask to play again
            boolean playAgain = SafeInput.getYNConfirm(in, "\nWould you like to play again? ");
            if (!playAgain) {
                totalGameDone = true;
            }
        }
    }
}