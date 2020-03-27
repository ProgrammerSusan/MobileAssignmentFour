package com.example.myapplication;

import android.os.Build;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.content.Context;

import androidx.annotation.RequiresApi;

class AppInterface extends GridLayout{
    private TextView[][] board;
    private TextView[][] goal;
    private int size, width;
    private Button up, down, right, left;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public AppInterface(Context context, View.OnClickListener buttonHandler)
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

        //create second board in a grid
        goal = new TextView[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                goal[i][j] = new TextView(context);
                goal[i][j].setTextSize(15);
                goal[i][j].setBackgroundColor(Color.parseColor("#AEC4C0"));
                goal[i][j].setGravity(Gravity.CENTER);
                GridLayout.LayoutParams parameters = new GridLayout.LayoutParams();
                parameters.rowSpec = GridLayout.spec(i + 4,1);
                parameters.columnSpec = GridLayout.spec(j + 4, 1);
                parameters.width = width;
                parameters.height = width;
                parameters.topMargin = parameters.bottomMargin = 1;
                parameters.leftMargin = parameters.rightMargin = 1;
                goal[i][j].setLayoutParams(parameters);
                addView(goal[i][j]);

            }
        }
        //create four buttons, attach event handler
        GridLayout.LayoutParams upP = new GridLayout.LayoutParams();
        upP.rowSpec = GridLayout.spec(7,1);
        upP.columnSpec = GridLayout.spec(8,1);
        up = new Button(context);
        up.setId(Button.generateViewId());
        up.setOnClickListener(buttonHandler);
        up.setGravity(Gravity.CENTER);
        up.setLayoutParams(upP);
        up.setText("UP");
        GridLayout.LayoutParams downP = new GridLayout.LayoutParams();
        downP.rowSpec = GridLayout.spec(7,1);
        downP.columnSpec = GridLayout.spec(3,1);
        down = new Button(context);
        down.setId(Button.generateViewId());
        down.setOnClickListener(buttonHandler);
        down.setGravity(Gravity.CENTER);
        down.setLayoutParams(downP);
        down.setText("DOWN");
        GridLayout.LayoutParams leftP = new GridLayout.LayoutParams();
        leftP.rowSpec = GridLayout.spec(8,1);
        leftP.columnSpec = GridLayout.spec(3,1);
        left = new Button(context);
        left.setId(Button.generateViewId());
        left.setOnClickListener(buttonHandler);
        left.setGravity(Gravity.CENTER);
        left.setLayoutParams(leftP);
        left.setText("LEFT");
        GridLayout.LayoutParams rightP = new GridLayout.LayoutParams();
        rightP.rowSpec = GridLayout.spec(8, 1);
        rightP.columnSpec = GridLayout.spec(8,1);
        right = new Button(context);
        right.setId(Button.generateViewId());
        right.setOnClickListener(buttonHandler);
        right.setGravity(Gravity.CENTER);
        right.setLayoutParams(rightP);
        right.setText("RIGHT");
        addView(up);
        addView(down);
        addView(left);
        addView(right);
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

    public int findButton(Button button)
    {
        if (button == up)
            return 1;
        else if (button == down)
            return 2;
        else if (button == right)
            return 3;
        else
            return 4;
    }
}
