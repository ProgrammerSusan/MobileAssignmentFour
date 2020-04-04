package com.example.app3;

import android.content.Context;
import android.graphics.*;
import android.os.Build;
import android.util.Log;
import android.view.*;
import androidx.annotation.RequiresApi;
import java.util.LinkedList;

public class GraphicsView extends View
{
    public static Paint palette;
    private static int counter = 0, color=Color.parseColor("#000000"), action, xstrt, ystrt, xend, yend;
    public static MotionEvent event, event1, event2;
    public static LinkedList<Point> paints = new LinkedList<Point>();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public GraphicsView(Context context){ super(context);}

    public void onDraw(Canvas canvas)
    {
        if (action==MotionEvent.ACTION_DOWN && xstrt>=850 && ystrt>=1355)
        {
            if (counter<7)
                counter++;
            else
                counter = 0;

            //if in palette change the color of the textview and paint
            switch (counter)
            {
                case 0:
                    color = Color.parseColor("#000000");
                    //Log.d("0", "color changed to black");
                    palette.setColor(color);
                    //Log.d("0", "color set");
                    palette.setStyle(Paint.Style.FILL);
                    //Log.d("0", "style set");
                    palette.setStrokeWidth(20);
                    //Log.d("0", "width set");
                    RectF rect = new RectF(850, 1350, 1050, 1550);
                    //Log.d("0", "rect set");
                    canvas.drawRect(rect, palette);
                    //Log.d("0", "rect drawn");
                    break;
                case 1:
                    color =Color.parseColor("#FFFFFF");
                    //Log.d("1", "color changed to white");
                    palette.setColor(color);
                    //Log.d("1", "color set");
                    palette.setStyle(Paint.Style.FILL);
                    //Log.d("1", "style set");
                    palette.setStrokeWidth(20);
                    //Log.d("1", "width set");
                    canvas.drawRect(850, 1350, 1050, 1550, palette);
                    //Log.d("1", "rect drawn");
                    break;
                case 2:
                    color = Color.parseColor("#BBBBBB");
                    //Log.d("2", "color changed to grey");
                    palette.setColor(color);
                    //Log.d("2", "color set");
                    palette.setStyle(Paint.Style.FILL);
                    //Log.d("2", "style set");
                    palette.setStrokeWidth(20);
                    //Log.d("2", "width set");
                    canvas.drawRect(850, 1350, 1050, 1550, palette);
                    //Log.d("2", "rect drawn");
                    break;
                case 3:
                    color = Color.parseColor("#F15151");
                    //Log.d("3", "color changed to red");
                    palette.setColor(color);
                    //Log.d("3", "color set");
                    palette.setStyle(Paint.Style.FILL);
                    //Log.d("3", "style set");
                    palette.setStrokeWidth(20);
                    //Log.d("3", "width set");
                    canvas.drawRect(850, 1350, 1050, 1550, palette);
                    //Log.d("3", "rect drawn");
                    break;
                case 4:
                    color = Color.parseColor("#47C254");
                    //Log.d("4", "color changed to green");
                    palette.setColor(color);
                    //Log.d("4", "color set");
                    palette.setStyle(Paint.Style.FILL);
                    //Log.d("4", "style set");
                    palette.setStrokeWidth(20);
                    //Log.d("4", "width set");
                    canvas.drawRect(850, 1350, 1050, 1550, palette);
                    //Log.d("4", "rect drawn");
                    break;
                case 5:
                    color = Color.parseColor("#476EC2");
                    //Log.d("5", "color changed to blue");
                    palette.setColor(color);
                    //Log.d("5", "color set");
                    palette.setStyle(Paint.Style.FILL);
                    //Log.d("5", "style set");
                    palette.setStrokeWidth(20);
                    //Log.d("5", "width set");
                    canvas.drawRect(850, 1350, 1050, 1550, palette);
                    //Log.d("5", "rect drawn");
                    break;
                case 6:
                    color = Color.parseColor("#F0F541");
                    //Log.d("6", "color changed to yellow");
                    palette.setColor(color);
                    //Log.d("6", "color set");
                    palette.setStyle(Paint.Style.FILL);
                    //Log.d("6", "style set");
                    palette.setStrokeWidth(20);
                    //Log.d("6", "width set");
                    canvas.drawRect(850, 1350, 1050, 1550, palette);
                    //Log.d("6", "rect drawn");
                    break;
                case 7:
                    color = Color.parseColor("#875C28");
                    //Log.d("7", "color changed to brown");
                    palette.setColor(color);
                    //Log.d("7", "color set");
                    palette.setStyle(Paint.Style.FILL);
                    //Log.d("7", "style set");
                    palette.setStrokeWidth(20);
                    //Log.d("7", "width set");
                    canvas.drawRect(850, 1350, 1050, 1550, palette);
                    //Log.d("7", "rect drawn");
                    break;
            }

            for(int i = 0; i<paints.size(); i++)
            {
                palette.setColor(paints.get(i).getColor());
                canvas.drawRect(paints.get(i).getXcord(), paints.get(i).getYcord(), paints.get(i).getXcord()+30, paints.get(i).getYcord()+30, palette);
            }
        }
        else if(event==null)
        {
            //initialization
            Log.d("onDraw", "initialization");
            palette = new Paint();
            palette.setColor(color);
            palette.setStyle(Paint.Style.FILL);
            palette.setStrokeWidth(20);
            RectF rect = new RectF(850, 1350, 1050, 1550);
            canvas.drawRect(rect, palette);
            color = Color.parseColor("#000000");
            counter++;
        }
        else
        {
            //painting
            //Log.d("onDraw", "spot");
            palette = new Paint();
            palette.setColor(color);
            palette.setStyle(Paint.Style.FILL);
            palette.setStrokeWidth(20);
            RectF rect = new RectF(850, 1350, 1050, 1550);
            canvas.drawRect(rect, palette);

           for(int i = 0; i<paints.size(); i++)
           {
               palette.setColor(paints.get(i).getColor());
               canvas.drawRect(paints.get(i).getXcord(), paints.get(i).getYcord(), paints.get(i).getXcord()+30, paints.get(i).getYcord()+30, palette);
           }
        }
    }

    public static void addition(MotionEvent e, int x, int y)
    {
        event=e;
        action = event.getAction();
        xstrt=x;
        ystrt=y;

        if(x>=810 && y>=1310){}
        else if (action == MotionEvent.ACTION_DOWN)
        {
            //Log.d("addition", "down");
            Point spot = new Point(x, y, color);
            paints.add(spot);
        }
        else if (action == MotionEvent.ACTION_MOVE)
        {
            //Log.d("addition", "move");
            for(int i = 0; i < event.getHistorySize(); i++)
            {
                Point spot = new Point((int)event.getHistoricalX(i), (int)(event.getHistoricalY(i)-210), color);
                paints.add(spot);
            }
        }
    }
}
