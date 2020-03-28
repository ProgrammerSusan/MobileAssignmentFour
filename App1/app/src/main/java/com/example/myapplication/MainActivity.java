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
        appInterface = new AppInterface(this, swipe);
        //draw initial and goal board
        appInterface.drawBoard(game.getBoard());
        setContentView(appInterface);
    }

    private class TouchHandler extends GestureDetector.SimpleOnGestureListener
    {
        public boolean onSingleTapConfirmed(MotionEvent event)
        {
            return true;
        }

        public boolean onDoubleTap(MotionEvent event)
        {
            return true;
        }

        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY)
        {
            //draw updated board
            appInterface.drawBoard(game.getBoard());
            return true;
        }
    }
}
