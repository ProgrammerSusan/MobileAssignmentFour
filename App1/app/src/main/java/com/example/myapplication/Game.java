package com.example.myapplication;

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
        //ensure array not out of bounds
        if(i < 3 && j < 3 && m < 3 && n < 3){
            if(exchangeValidation(i, j, m, n)){
                char temp = board[i][j];
                board[i][j] = board[m][n];
                board[m][n] = temp;
            }
        }
    }

    private boolean exchangeValidation(int i, int j, int m, int n){
        //checks that if one of the spaces are blank
        //checks if spaces are adjacent and prohibits diagonal
        //extracted into separate method for readability
        return (board[i][j] == ' ' || board[m][n] == ' ') && (Math.abs(i - m) == 1 && j == n) || (Math.abs(j - n) == 1 && i == m);
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