package com.example.app4;

import android.graphics.Paint;

public class Model
{
    public static Paint paint = new Paint();
    public static Shape[] shapes;

    public Model()
    {
        shapes = new Shape[20];

        for(int i = 0; i<shapes.length; i++)
        {
            shapes[i] = new Shape(i);
        }
    }
}
