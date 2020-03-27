package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.*;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Game game;
    private AppInterface appInterface;
    private GestureDetector swipe;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Point screenSize = new Point();
        TouchHandler touchHandler = new TouchHandler();
        swipe = new GestureDetector(this, touchHandler);
        getWindowManager().getDefaultDisplay().getSize(screenSize);
        //create event handler
        ButtonHandler button = new ButtonHandler();
        //create game
        game = new Game();
        //create interface
        appInterface = new AppInterface(this, button);
        //draw initial and goal board
        appInterface.drawBoard(game.getBoard());
        setContentView(appInterface);
    }

    public class ButtonHandler implements Button.OnClickListener
    {
        public void onClick(View view)
        {
            //find out which button was clicked
            Button clicked = (Button) findViewById(view.getId());
            int found = appInterface.findButton(clicked);
            //make move in the board
            if(found == 1){
                game.up();
            }
            else if(found == 2){
                game.down();
            }
            else if(found == 3){
                game.right();
            }
            else{
                game.left();
            }
            //draw updated board
            appInterface.drawBoard(game.getBoard());
        }
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
            return true;
        }
    }
}
