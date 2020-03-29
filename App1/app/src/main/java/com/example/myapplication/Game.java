package com.example.myapplication;

import android.util.Log;

class Game {
    private char[][] board;
    private char[][] goal;

    public Game()
    {
        //create Slide object
        Slide slider = new Slide();
        //create initial and goal boards
        board = slider.generateInitialBoard();
        goal = slider.generateGoalBoard();
    }

    public char[][] getBoard()
    {
        //return current board
        return board;
    }

    public char[][] getGoal()
    {
        //return goal board
        return goal;
    }
    public void exchange(int i, int j, int m, int n)
    {
        try{
            if(board[i][j] == ' ' || board[m][n] == ' '){
                //checks if moving to an adjacent spot avoiding diagonals
                if((Math.abs(i - m) == 1 && j == n) || (Math.abs(j - n) == 1 && i == m)){
                    char temp = board[i][j];
                    board[i][j] = board[m][n];
                    board[m][n] = temp;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            int x = 1;  //placeholder code
        }
    }

    public boolean solved(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != goal[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}