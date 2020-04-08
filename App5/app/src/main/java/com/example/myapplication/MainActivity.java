package com.example.myapplication;


import android.os.Bundle;
import java.util.Timer;
import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.media.SoundPool;

public class MainActivity extends Activity
{
    private Game game;
    private GameView gameView;
    private GestureDetector gestureDetector;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        SoundPool.Builder soundPoolBuilder = new SoundPool.Builder();
        SoundPool soundPool = soundPoolBuilder.build();
        int soundId = soundPool.load(this, R.raw.explosion, 1);

        game = new Game(soundPool, soundId);

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
        public boolean onDoubleTapEvent(MotionEvent event)
        {
            game.fire();

            return true;
        }
    }
}