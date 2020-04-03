package com.example.myapplication;

import android.os.Bundle;
import java.util.Timer;
import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends Activity
{
    private Game game;
    private GameView gameView;
    private GestureDetector gestureDetector;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        game = new Game();

        gameView = new GameView(this, game);
        setContentView(gameView);

        Timer timer = new Timer();
        GameTimerTask task = new GameTimerTask(game, gameView);
        timer.schedule(task, 5000, 20);

        TouchHandler temp = new TouchHandler();
        gestureDetector = new GestureDetector(this, temp);
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        gestureDetector.onTouchEvent(event);

        return true;
    }

    private class TouchHandler extends GestureDetector.SimpleOnGestureListener
    {
        public boolean onSingleTapConfirmed(MotionEvent event)
        {
            game.fire();

            return true;
        }
    }
}