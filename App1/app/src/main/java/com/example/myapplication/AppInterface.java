package com.example.myapplication;

import android.os.Build;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.content.Context;

import androidx.annotation.RequiresApi;

class AppInterface extends RelativeLayout{
    private TextView[][] board;
    private int size, width;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public AppInterface(Context context, int screenHeight, int screenWidth)
    {
        super(context);

        this.size = 3;

        //create first board in a grid
        board = new TextView[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = new TextView(context);
                board[i][j].setTextSize(30);
                board[i][j].setId(TextView.generateViewId());
                board[i][j].setBackgroundColor(Color.parseColor("#AEC4C0"));
                board[i][j].setGravity(Gravity.CENTER);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0, 0);
                params.width = screenWidth/size;
                params.height = screenHeight/size;
                params.topMargin = 1;
                params.rightMargin = 1;
                if (i > 0){
                    params.addRule(RelativeLayout.BELOW, board[i-1][j].getId());
                }
                if(j > 0){
                    params.addRule(RelativeLayout.RIGHT_OF, board[i][j-1].getId());
                }

                board[i][j].setLayoutParams(params);
                addView(board[i][j]);

            }
        }
    }

    public void drawBoard(char[][] game)
    {
        //draw current board
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j].setText(String.valueOf(game[i][j]));
            }
        }
    }

    public void solvedBoard(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j].setBackgroundColor(Color.parseColor("#FFCCCB"));
            }
        }
    }
}
