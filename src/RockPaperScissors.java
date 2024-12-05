import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Player A, enter your move (R, P, S): ");
        String playerAMove = scanner.nextLine().toUpperCase();

        if (!playerAMove.equals("R") && !playerAMove.equals("P") && !playerAMove.equals("S")) {
            System.out.println("Invalid move. Exiting the game.");
            System.exit(0);
        }

        System.out.println("Player B, enter your move (R, P, S): ");
        String playerBMove = scanner.nextLine().toUpperCase();

        if (!playerBMove.equals("R") && !playerBMove.equals("P") && !playerBMove.equals("S")) {
            System.out.println("Invalid move. Exiting the game.");
            System.exit(0);
        }

        if (playerAMove.equals(playerBMove)) {
            System.out.println("It's a tie! Both players chose " + playerAMove);
        } else if ((playerAMove.equals("R") && playerBMove.equals("S")) ||
                (playerAMove.equals("S") && playerBMove.equals("P")) ||
                (playerAMove.equals("P") && playerBMove.equals("R"))) {
            System.out.println("Player A wins! " + getVictoryMessage(playerAMove));
        } else {
            System.out.println("Player B wins! " + getVictoryMessage(playerBMove));
        }
    }

    private static String getVictoryMessage(String move) {
        switch (move) {
            case "R":
                return "Rock breaks Scissors";
            case "P":
                return "Paper covers Rock";
            default:
                return "Scissors cuts Paper";
        }
    }
}