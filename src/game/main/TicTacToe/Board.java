package game.main.TicTacToe;

/**
 * @author yifengguo
 */
@SuppressWarnings("Duplicates")
public class Board {
    private char[][] board;
    private boolean gameEnd; // to record if game is ended <- some wins or game ties

    public Board() {
        board = new char[3][3];
        initializeBoard();
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public char[][] getBoard() {
        return board;
    }

    public void initializeBoard() {
        board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean makeMove(int row, int col, char currentPlayer) throws GameEndedException {
        if (gameEnd) {
            throw new GameEndedException("The game has ended, please start a new one.");
        }
        if (checkFull()) {
            System.out.println("The board is full and no one wins.");
            gameEnd = true;
        }
        if (board[row][col] != '-') {
            System.out.println("cannot move this position, try again!");
        } else {
            board[row][col] = currentPlayer;
        }
        return checkWin(row, col, currentPlayer);
    }

    private boolean checkWin(int row, int col, char currentPlayer) {
        boolean isWin;

        isWin = true;
        // check row direction win case
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] != currentPlayer) {
                isWin = false;
                break;
            }
        }
        // for each kind of direction, if win, need to end the game and return true
        if (isWin) {
            gameEnd = true;
            System.out.println("The game is ove, the winner is " + currentPlayer);
            printBorad();
            return true;
        }

        isWin = true; // reset isWin
        // check column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != currentPlayer) {
                isWin = false;
                break;
            }
        }
        if (isWin) {
            gameEnd = true;
            System.out.println("The game is ove, the winner is " + currentPlayer);
            printBorad();
            return isWin;
        }

        isWin = true;
        // check negative diagonal
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != currentPlayer) {
                isWin = false;
                break;
            }
        }
        if (isWin) {
            gameEnd = true;
            System.out.println("The game is ove, the winner is " + currentPlayer);
            printBorad();
            return isWin;
        }

        isWin = true;
        // check positive diagonal
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][board.length - i - 1] != currentPlayer) {
                isWin = false;
                break;
            }
        }
        if (isWin) {
            gameEnd = true;
            System.out.println("The game is ove, the winner is " + currentPlayer);
            printBorad();
            return isWin;
        }
        return false;
    }

    public boolean checkFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBorad() {
        for (int i = 0; i < this.getBoard().length; i++) {
            for (int j = 0; j < this.getBoard()[0].length; j++) {
                System.out.print(this.getBoard()[i][j] + " ");
            }
            System.out.println();
        }
    }

}
