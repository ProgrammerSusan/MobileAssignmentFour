package com.example.app4;

import android.util.Log;

import java.util.TimerTask;

public class shapesTimerTask extends TimerTask
{
    public Model model;
    public View view;
    public Shape[] shapes;

    public shapesTimerTask(Model mod, View v)
    {
        this.model=mod;
        this.view=v;
    }

    public void run()
    {
        shapes = Model.shapes;
        for(int i = 0; i<shapes.length; i++)
        {
            Shape.move(shapes[i]);
        }
        view.postInvalidate();
    }
}
