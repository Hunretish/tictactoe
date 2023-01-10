import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create a new board object
        Board board = new Board();

        Scanner in = new Scanner(System.in);
        System.out.println("Tic Tac Toe!");
        System.out.print("Player 1, enter your name? ");
        String p1 = in.nextLine();
        System.out.print("Player 2, enter your name? ");
        String p2 = in.nextLine();

        boolean player1 = true;

        boolean gameEnded = false;
        while(!gameEnded) {

            board.draw();

            if(player1) {
                System.out.println(p1 + "'s Turn (x):");
            } else {
                System.out.println(p2 + "'s Turn (o):");
            }

            char c;
            if(player1) {
                c = 'x';
            } else {
                c = 'o';
            }

            int row;
            int col;

            while(true) {

                System.out.print("Enter row (0, 1, or 2): ");
                row = in.nextInt();
                System.out.print("Enter column (0, 1, or 2): ");
                col = in.nextInt();

                // Check if the position is valid
                if(row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("Position invalid please try again!");
                } else if(!board.isEmpty(row, col)) {
                    // Check if the position is already occupied
                    System.out.println("Position invalid please try again!");
                } else {
                    break;
                }

            }
            board.set(row, col, c);

            // Check to see if either player has won
            if(board.hasWon()) {
                System.out.println(p1 + " has won!");
                gameEnded = true;
            } else if(board.hasWon()) {
                System.out.println(p2 + " has won!");
                gameEnded = true;
            } else {
                if(board.isFull()) {
                    System.out.println("It's a tie!");
                    gameEnded = true;
                } else {
                    player1 = !player1;
                }
            }
        }

        board.draw();

        // Close the Scanner object
        in.close();
    }
}