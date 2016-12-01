/*
        Μέλη Ομάδας
    Λόκκας Ιωάννης ΑΜ: 3120095
    Μπούζας Βασίλειος ΑΜ: 3120124
    Τασσιάς Παναγιώτης ΑΜ: 3120181
 */

 /* Every possible child of the MinMax algorithm is an object typeof State 
    
    Each State has it's own fields that used by the MinMax algorithm to determine
    which one is best and return it.

    Also this class contains all the required methods to evaluate the state like
    isTerminal(), evaluate(), getChildren etc that all used by the MinMax algorithm
 */
package Score4_AI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class State {

    private int[][] board;

    //Check which player won this game
    private int winner = Game.EMPTY;

    //Min-Max value
    private int value;

    //int array for returning the move from MinMax function
    private int[] move = {-1, -1};

    /* Int array that corresponds to the empty cells in the real board
    
        For Example:
            availableRows[0] = 5 means that at Board Column 0 there are 6 empty cells
     */
    private int[] availableRows = {5, 5, 5, 5, 5, 5, 5};

    //ArrayList which contains all the subarrays of board
    private List subarrays;

    public State() {

    }

    public State(int[][] board) {
        this.board = board;
        splitBoard();
    }

    public State(int[][] board, int[] availableRows, int[] rowCol) {
        this.board = board;
        this.availableRows = availableRows;
        this.move = rowCol;
        splitBoard();
    }

    //copy constructor
    public State(State state) {
        //copy each field
        this.value = state.value;

        //copy the board
        this.board = new int[6][7];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                this.board[row][col] = state.getBoard()[row][col];
            }
        }

        //copy the availableRows
        this.availableRows = new int[7];
        this.availableRows = Arrays.copyOf(state.availableRows, state.availableRows.length);

        //call to local splitBoard to fill the local subarrays list
        state.splitBoard();
        this.subarrays = state.subarrays;
    }

    //Function that is used by getChildren()
    //Makes on board-copy a possible move based on current turn
    public State makeMove(int col, int turn) {
        int[] rowCol = new int[2];

        int row = this.availableRows[col];

        if (row != -1) {
            if (this.board[row][col] == Game.EMPTY) {
                if (turn == Game.AI) {
                    this.board[row][col] = Game.AI;
                } else {
                    this.board[row][col] = Game.PLAYER;
                }
                this.availableRows[col] = row - 1;
            } else {
                return null;
            }
        }

        //set Row-Col of the last move
        this.move[0] = row;
        this.move[1] = col;

        return this;
    }

    //Function to produce each State child and add it in an ArrayList
    public ArrayList<State> getChildren(int turn) {
        ArrayList children = new ArrayList<State>();

        for (int column = 0; column < board[0].length; column++) {
            //copy the current state
            State child = new State(this);

            //produce the child and add them in arraylist
            children.add(child.makeMove(column, turn));
        }
        return children;
    }

    // State evaluation
    public void evaluate() {

        splitBoard();
        for (int index = 0; index < subarrays.size(); index++) {
            int[][] subarray = (int[][]) subarrays.get(index);
            this.value += evalMiniArray(subarray);

        }
    }

    //Heuristic formula which is used by state evaluation function
    private int evalMiniArray(int[][] sub) {

        final int doubles = 50;
        final int triples = 500;
        final int quads = 1000000;

        int totalMiniValue = 0;

        int sum_row = 0;
        int sum_col = 0;
        int sum_diag1 = 0;
        int sum_diag2 = 0;
        int sumOfMaxInARow = 0;
        int sumOfMinInARow = 0;
        int sumOfMaxInACol = 0;
        int sumOfMinInACol = 0;

        int sumOfMaxInLastRow = 0;
        int sumOfMinInLastRow = 0;

        for (int row = 0; row < sub.length; row++) {
            for (int col = 0; col < sub[row].length; col++) {
                sum_row += sub[row][col];
                sum_col += sub[col][row];

                if (row == 4) {
                    if (sub[row][col] == 1) {
                        ++sumOfMaxInLastRow;
                    } else if (sub[row][col] == -1) {
                        ++sumOfMinInLastRow;
                    } else if (sumOfMaxInLastRow != 3 && sumOfMinInLastRow != -3) {
                        sumOfMaxInLastRow = 0;
                        sumOfMaxInLastRow = 0;
                    }
                }

                if (sub[row][col] == 1) {
                    ++sumOfMaxInARow;
                    sumOfMinInARow = 0;
                } else if (sub[row][col] == -1) {
                    ++sumOfMinInARow;
                    sumOfMaxInARow = 0;
                } else if (sumOfMaxInARow != 3 && sumOfMinInARow != -3) {
                    sumOfMinInARow = 0;
                    sumOfMaxInARow = 0;
                }

                if (sub[col][row] == 1) {
                    ++sumOfMaxInACol;
                    sumOfMinInACol = 0;
                } else if (sub[col][row] == -1) {
                    ++sumOfMinInACol;
                    sumOfMaxInACol = 0;
                } else if (sumOfMaxInACol != 3 && sumOfMinInACol != -3) {
                    sumOfMinInACol = 0;
                    sumOfMaxInACol = 0;
                }

                if (row == col) {
                    sum_diag1 += sub[row][col];
                }
                if (row == sub.length - 1 - row) {
                    sum_diag2 += sub[row][col];
                }
            }

            switch (sum_row) {
                case (4):
                    totalMiniValue += quads;
                    break;
                case (-4):
                    totalMiniValue -= quads;
                    break;
                case (3):
                    totalMiniValue += triples;

                    if (sumOfMaxInARow == 3) {
                        totalMiniValue += 100 * triples;
                    }
                    break;
                case (-3):
                    totalMiniValue -= triples;

                    if (sumOfMinInARow == 3) {
                        totalMiniValue -= 100 * triples;
                    }
                    break;
                case (2):
                    totalMiniValue += doubles;
                    break;
                case (-2):
                    totalMiniValue -= doubles;
                    break;
                default:
                    totalMiniValue += sum_row;
                    break;
            }

            switch (sum_col) {
                case (4):
                    totalMiniValue += quads;
                    break;
                case (-4):
                    totalMiniValue -= quads;
                    break;
                case (3):
                    totalMiniValue += triples;

                    if (sumOfMaxInACol == 3) {
                        totalMiniValue += 100 * triples;
                    }
                    break;
                case (-3):
                    totalMiniValue -= triples;

                    if (sumOfMinInACol == 3) {
                        totalMiniValue -= 100 * triples;
                    }
                    break;
                case (2):
                    totalMiniValue += doubles;
                    break;
                case (-2):
                    totalMiniValue -= doubles;
                    break;
                default:
                    totalMiniValue += sum_col;
                    break;
            }

            sum_row = 0;
            sum_col = 0;
        }

        if (sumOfMaxInLastRow == 3) {
            totalMiniValue += 500 * triples;
        } else if (sumOfMaxInLastRow == -3) {
            totalMiniValue -= 500 * triples;
        }

        switch (sum_diag1) {
            case (4):
                totalMiniValue += quads;
                break;
            case (-4):
                totalMiniValue -= quads;
                break;
            case (3):
                totalMiniValue += triples;
                break;
            case (-3):
                totalMiniValue -= triples;
                break;
            case (2):
                totalMiniValue += doubles;
                break;
            case (-2):
                totalMiniValue -= doubles;
                break;
            default:
                totalMiniValue += sum_col;
                break;
        }

        switch (sum_diag2) {
            case (4):
                totalMiniValue += quads;
                break;
            case (-4):
                totalMiniValue -= quads;
                break;
            case (3):
                totalMiniValue += triples;
                break;
            case (-3):
                totalMiniValue -= triples;
                break;
            case (2):
                totalMiniValue += doubles;
                break;
            case (-2):
                totalMiniValue -= doubles;
                break;
            default:
                totalMiniValue += sum_col;
                break;
        }

        return totalMiniValue;
    }
    
    // Split the State board into 4x4 sub-boards on which evaluation is executed
    private void splitBoard() {
        subarrays = new ArrayList<int[][]>();
        int[][] splittedBoard;

        for (int r = 5; r >= 3; r--) {
            for (int c = 3; c <= 6; c++) {
                splittedBoard = new int[4][4];
                for (int row = r, splRow = 3; row >= r - 3; row--, splRow--) {
                    for (int col = c - 3, splCol = 0; col <= c; col++, splCol++) {
                        splittedBoard[splRow][splCol] = board[row][col];
                    }
                }
                subarrays.add(splittedBoard);
            }
        }
    }

    // Checks if current state is terminal
    public boolean isTerminal() {

        //check if game has ended without winner
        int sum_full = 0;
        for (int avRow : this.availableRows) {
            if (avRow == -1) {
                sum_full += 1;
            }
        }
        if (sum_full == 7) {
            this.winner = -1;
            return true;
        }

        for (int index = 0; index < subarrays.size(); index++) {
            int sum_row = 0;
            int sum_col = 0;
            int sum_diag1 = 0;
            int sum_diag2 = 0;

            int[][] sub = (int[][]) subarrays.get(index);
            for (int row = 0; row < sub.length; row++) {
                for (int col = 0; col < sub[row].length; col++) {
                    sum_row += sub[row][col];
                    sum_col += sub[col][row];

                    if (row == col) {
                        sum_diag1 += sub[row][col];
                    }
                    if (row == sub.length - 1 - row) {
                        sum_diag2 += sub[row][col];
                    }
                }

                if (sum_row == 4 || sum_col == 4) {
                    this.winner = Game.AI;
                    return true;
                } else if (sum_row == -4 || sum_col == -4) {
                    this.winner = Game.PLAYER;
                    return true;
                }
                sum_row = 0;
                sum_col = 0;
            }

            if (sum_diag1 == 4 || sum_diag2 == 4) {
                this.winner = Game.AI;
                return true;
            } else if (sum_diag1 == -4 || sum_diag2 == -4) {
                this.winner = Game.PLAYER;
                return true;
            }
        }
        return false;
    }

    // Setters & Getters
    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int[] getAvailableRows() {
        return availableRows;
    }

    public void setAvailableRows(int[] availableRows) {
        this.availableRows = availableRows;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int[] getMove() {
        return move;
    }

    public void setMove(int[] rowCol) {
        this.move = rowCol;
    }

    public int getWinner() {
        return this.winner;
    }
}
