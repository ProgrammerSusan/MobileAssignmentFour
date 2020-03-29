package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    private Game game;
    private AppInterface appInterface;
    private GestureDetector swipe;
    private final int SIZE = 10;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Point screenSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(screenSize);
        //create event handler
        TouchHandler touchHandler = new TouchHandler();
        swipe = new GestureDetector(this, touchHandler);
        //create game
        game = new Game();
        //create interface
        appInterface = new AppInterface(this);
        //draw initial and goal board
        appInterface.drawBoard(game.getBoard());
        setContentView(appInterface);
    }

    public boolean onTouchEvent(MotionEvent event){
        swipe.onTouchEvent(event);
        return true;
    }

    private int screenHeight()
    {
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);

        int DP = (int)(getResources().getDisplayMetrics().density);

        return size.y - 80*DP;
    }

    private class TouchHandler extends GestureDetector.SimpleOnGestureListener
    {
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY)
        {
            int startIndex = getY(event1)/(screenHeight()/SIZE);

            int endIndex = getY(event2)/(screenHeight()/SIZE);

            game.exchange(startIndex, endIndex);
            appInterface.drawBoard(game.getBoard());
            
            return true;
        }

        private int getY(MotionEvent event)
        {
            int DP = (int)(getResources().getDisplayMetrics().density);

            return (int)(event.getY() - 80*DP);
        }
    }
}
