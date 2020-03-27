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

    public void up()
    {
        //move blank up
        if(x != 0){
            char temp = board[x - 1][y];
            board[x - 1][y] = ' ';
            board[x][y] = temp;
            x--;
        }
    }

    public void down()
    {
        //move blank down
        if(x != 2){
            char temp = board[x + 1][y];
            board[x + 1][y] = ' ';
            board[x][y] = temp;
            x++;
        }
    }

    public void right()
    {
        //move blank right
        if(y != 2){
            char temp = board[x][y + 1];
            board[x][y + 1] = ' ';
            board[x][y] = temp;
            y++;
        }
    }

    public void left()
    {
        //move blank left
        if(y != 0){
            char temp = board[x][y - 1];
            board[x][y - 1] = ' ';
            board[x][y] = temp;
            y--;
        }
    }
}