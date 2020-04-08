package com.example.app4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class View extends android.view.View
{
    public Shape[] shapes;
    public Paint paint = Model.paint;
    public static int sizex,sizey;
    public Model mod = new Model();

    public View(Context context, int xsize, int ysize)
    {
        super(context);
        sizex=xsize;
        sizey=ysize;
    }

    public void onDraw(Canvas canvas)
    {
        paint.setColor(Color.parseColor("#000000"));
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, sizex, sizey, paint);
        shapes = Model.shapes;

        for(int i = 0; i<shapes.length; i++)
        {
            paint.setColor(shapes[i].color);
            if (shapes[i].name.equals("circle"))
                canvas.drawCircle(shapes[i].x, shapes[i].y, shapes[i].r, paint);
            else
                canvas.drawRect(shapes[i].x, shapes[i].y, shapes[i].xend, shapes[i].yend, paint);

            Shape.move(shapes[i]);
        }
    }
}
