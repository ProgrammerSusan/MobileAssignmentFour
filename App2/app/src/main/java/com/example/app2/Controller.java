package com.example.app2;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.widget.*;
import android.view.*;

import androidx.annotation.RequiresApi;

public class Controller extends GridLayout
{
    public static int[] numbers = Model.generateList();;
    public static EditText[] box;
    public static int window = (int)((Math.random()*10)-1);
    public static int window2 = window+1;
    public static int output;
    public static int dp;
    public static Context cont;
    public static TextView text;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public Controller(Context context)
    {
        super(context);
        cont = context;

        setRowCount(13);
        setColumnCount(5);
        dp = (int)(getResources().getDisplayMetrics().density);

        TextView space = new TextView(context);
        space = new EditText(context);
        space.setEnabled(false);
        space.setGravity(Gravity.CENTER_HORIZONTAL);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = 60*dp;
        params.height = 60*dp;
        params.rowSpec = GridLayout.spec(0, 1);
        params.columnSpec = GridLayout.spec(0,1);
        params.topMargin = 40*dp;
        params.bottomMargin = 40*dp;
        params.leftMargin = params.rightMargin = 10*dp;
        space.setLayoutParams(params);
        addView(space);

        TextView space2 = new TextView(context);
        space2 = new EditText(context);
        space2.setEnabled(false);
        space2.setGravity(Gravity.CENTER_HORIZONTAL);
        params = new GridLayout.LayoutParams();
        params.width = 180*dp;
        params.height = 60*dp;
        params.rowSpec = GridLayout.spec(1, 1);
        params.columnSpec = GridLayout.spec(0,2);
        params.leftMargin = params.rightMargin = 10*dp;
        space2.setLayoutParams(params);
        addView(space2);

        text = new TextView(context);
            output = text.getId();
            Log.d("controller", output+"");
        text.setBackgroundColor(Color.parseColor("#AEC4C0"));
        text.setText("You have "+Model.count+" tries left");
        text.setEnabled(false);
        text.setTextColor(Color.parseColor("#000000"));
        text.setTextSize((int) (20));
        text.setGravity(Gravity.CENTER_HORIZONTAL);
        params = new GridLayout.LayoutParams();
        params.width = 350*dp;
        params.height = 60*dp;
        params.rowSpec = GridLayout.spec(0, 1);
        params.columnSpec = GridLayout.spec(1,3);
        params.topMargin = 40*dp;
        params.bottomMargin = 40*dp;
        params.leftMargin = params.rightMargin = 10*dp;
        text.setLayoutParams(params);
        addView(text);

        box = new EditText[numbers.length];

        if (window >= numbers.length)
        {
            window = 0;
            window2 = 1;
        }
        else if (window2 == numbers.length)
            window2 = 0;
        for(int i = 0; i < numbers.length; i++)
        {
            box[i] = new EditText(context);
            if (i == window||i==window2)
                box[i].setBackgroundColor(Color.parseColor("#B5AEC4"));
            else
                box[i].setBackgroundColor(Color.parseColor("#AEC4C0"));
            //Log.d("numbers", numbers[i]+"");
            box[i].setText(numbers[i] + "");
            box[i].setEnabled(false);
            box[i].setTextColor(Color.parseColor("#000000"));
            box[i].setTextSize((int) (20));
            box[i].setGravity(Gravity.CENTER_HORIZONTAL);
            params = new GridLayout.LayoutParams();
            params.width = 120*dp;
            params.height = 60*dp;
            params.rowSpec = GridLayout.spec(i+1, 1);
            params.columnSpec = GridLayout.spec(2, 1);
            params.topMargin = params.bottomMargin = 1;
            params.leftMargin = params.rightMargin = 1;
            box[i].setLayoutParams(params);
            addView(box[i]);
        }
    }

    public static void windowUpdate()
    {
        window++;
        window2++;
        box = new EditText[numbers.length];

        if (window >= numbers.length)
        {
            window = 0;
            window2 = 1;
        }
        else if (window2 == numbers.length)
            window2 = 0;
        for(int i = 0; i < numbers.length; i++)
        {
            box[i] = new EditText(cont);
            if (i == window||i==window2)
                box[i].setBackgroundColor(Color.parseColor("#B5AEC4"));
            else
                box[i].setBackgroundColor(Color.parseColor("#AEC4C0"));
            box[i].setText(numbers[i] + "");
        }

    }

    public static void updateScreen()
    {
        box = new EditText[numbers.length];

        if (window >= numbers.length)
        {
            window = 0;
            window2 = 1;
        }
        else if (window2 == numbers.length)
            window2 = 0;
        for(int i = 0; i < numbers.length; i++)
        {
            box[i] = new EditText(cont);
            if (i == window||i==window2)
                box[i].setBackgroundColor(Color.parseColor("#B5AEC4"));
            else
                box[i].setBackgroundColor(Color.parseColor("#AEC4C0"));
            box[i].setText(numbers[i] + "");
        }
    }

}
