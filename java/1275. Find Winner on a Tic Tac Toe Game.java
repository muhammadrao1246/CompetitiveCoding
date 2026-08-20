import java.util.*;
class Solution {
    public boolean checkForTurn(int turnNumber, int[] matrix){
        boolean won = false;
        // horizontally
        if(matrix[0] == turnNumber && matrix[1] == turnNumber && matrix[2] == turnNumber) won = true;
        else if(matrix[3] == turnNumber && matrix[4] == turnNumber && matrix[5] == turnNumber) won = true;
        else if(matrix[6] == turnNumber && matrix[7] == turnNumber && matrix[8] == turnNumber) won = true;
        // vertically
        else if(matrix[0] == turnNumber && matrix[3] == turnNumber && matrix[6] == turnNumber) won = true;
        else if(matrix[1] == turnNumber && matrix[4] == turnNumber && matrix[7] == turnNumber) won = true;
        else if(matrix[2] == turnNumber && matrix[5] == turnNumber && matrix[8] == turnNumber) won = true;
        // diagonally
        else if(matrix[0] == turnNumber && matrix[4] == turnNumber && matrix[8] == turnNumber) won = true;
        else if(matrix[2] == turnNumber && matrix[4] == turnNumber && matrix[6] == turnNumber) won = true;

        return won;
    }
    public String tictactoe(int[][] moves) {
        int[] matrix = new int[9];

        char turn = 'A';

        // flatting the matrix
        for(int i = 0; i < moves.length; i++){
            matrix[moves[i][1] + (3*moves[i][0])] = i % 2 == 0 ? 1 : 2 ;
        }

        // checking for each 
        // for A which turnNumber is 1
        if(checkForTurn(1, matrix)) return "A";
        else if(checkForTurn(2, matrix)) return "B";

        // if nobody won but still some picks left throw pending
        if(moves.length < 9) return "Pending";
        return "Draw";
    }
}