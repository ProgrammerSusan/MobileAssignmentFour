package com.example.app3;

import android.graphics.Color;

public class Point
{
    public int xcord;
    public int ycord;
    public int color;

    public Point (int x, int y, int col)
    {
        xcord=x;
        ycord=y;
        color=col;
    }

    public int getXcord() { return xcord; }

    public int getYcord() { return ycord; }

    public int getColor() { return color; }
}
