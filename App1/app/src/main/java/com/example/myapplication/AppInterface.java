package com.example.myapplication;

import android.os.Build;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.content.Context;

import androidx.annotation.RequiresApi;

class AppInterface extends GridLayout{
    private TextView[][] board;
    private int size, width;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public AppInterface(Context context)
    {
        super(context);

        this.size = 3;
        this.width = 60;

        final int dp = (int)(getResources().getDisplayMetrics().density);
        width = width * dp;
        setRowCount(9);
        setColumnCount(9);

        //create first board in a grid
        board = new TextView[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = new TextView(context);
                board[i][j].setTextSize(15);
                board[i][j].setBackgroundColor(Color.parseColor("#AEC4C0"));
                board[i][j].setGravity(Gravity.CENTER);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = width;
                params.height = width;
                params.rowSpec = GridLayout.spec(i,1);
                params.columnSpec = GridLayout.spec(j + 4, 1);
                params.topMargin = params.bottomMargin = 1;
                params.leftMargin = params.rightMargin = 1;
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
}
