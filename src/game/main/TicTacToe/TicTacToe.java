package game.main.TicTacToe;

import java.util.Scanner;

/**
 * @author yifengguo
 */
public class TicTacToe {
    private Board board;
    private char currentPlayer;
    private static char DEFAULT_INITIAL_PLAYER = 'X';

    public Board getBoard() {
        return board;
    }

    public TicTacToe() {
        board = new Board();
        currentPlayer = DEFAULT_INITIAL_PLAYER;
    }

    public void changePlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    public void play() throws GameEndedException {
        Scanner scanner = new Scanner(System.in);
        while (!board.isGameEnd()) {
            this.getBoard().printBorad();
            System.out.println(currentPlayer + " please choose a position to move:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            boolean move = this.getBoard().makeMove(row, col, currentPlayer);
            if (move) {
                return;
            } else {
                changePlayer();
            }
            if (this.getBoard().checkFull()) {
                System.out.println("The board is full and no one wins.");
                break;
            }
        }
    }
}
