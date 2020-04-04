package com.example.app3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class MainActivity extends AppCompatActivity
{
    private GestureDetector gd;
    private Paint paint;
    GraphicsView gv;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gv = new GraphicsView(this);
        TouchHandler touch = new TouchHandler();
        gd = new GestureDetector(this, touch);
        setContentView(gv);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public boolean onTouchEvent(MotionEvent event)
    {
        //Log.d("onDraw", "onTouch");
        int strtx= (int) event.getRawX();
        int strty= (int) event.getRawY()-210;

        GraphicsView.addition(event, strtx, strty);
        setContentView(gv);
        //gd.onTouchEvent(event);
        return false;
    }

    public class TouchHandler extends GestureDetector.SimpleOnGestureListener
    {
        public int strtx, strty;

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e)
        {
            Log.d("onDraw", "Single tap");
            strtx= (int) e.getRawX();
            strty= (int) e.getRawY()-210;

            GraphicsView.addition(e, strtx, strty);
            setContentView(gv);
            return true;
        }
    }

}
