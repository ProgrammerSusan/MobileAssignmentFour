package com.example.app2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import static com.example.app2.Controller.output;

public class MainActivity extends AppCompatActivity {

    public GestureDetector gd;
    public static int count = Model.count;
    public Context contex;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        contex = this;
        Controller cont = new Controller(this);
        setContentView(cont);

        TouchHandler temp = new TouchHandler();
        gd = new GestureDetector(this, temp);
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        gd.onTouchEvent(event);
        return true;
    }

    public class TouchHandler extends GestureDetector.SimpleOnGestureListener
    {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        public boolean onSingleTapConfirmed(MotionEvent event)
        {
            //move window
            Controller.windowUpdate();
            Controller cont = new Controller(contex);
            setContentView(cont);
            return true;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        public boolean onDoubleTap(MotionEvent e)
        {
            //swap numbers
            Model.updateArray(Controller.window, Controller.window2);
            Controller.updateScreen();
            Controller cont = new Controller(contex);
            setContentView(cont);
            if(Model.isSorted())
            {
                TextView count = Controller.text;
                count.setText("You've won!");
                //disable tap abilities
            }
            else
            {
                Log.d("doubletap", output+"");
                TextView count = Controller.text;
                count.setText(Model.counter());
            }
            return true;
        }
    }
}
