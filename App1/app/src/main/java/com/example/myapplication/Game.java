package com.example.myapplication;

class Game {
    private char[][] board;
    private char[][] goal;
    private int x, y;

    public Game()
    {
        //create Slide object
        Slide slider = new Slide();
        //create initial and goal boards
        board = slider.generateInitialBoard();
        goal = slider.generateGoalBoard();
        //determine the location of blank
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == ' '){
                    x = i;
                    y = j;
                }
            }
        }
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
        if(board[i][j] == ' ' || board[m][n] == ' '){
            if(Math.abs(i - m) <= 1 && Math.abs(j - n) <= 1){
                char temp = board[i][j];
                board[i][j] = board[m][n];
                board[m][n] = temp;
            }
        }
    }
}