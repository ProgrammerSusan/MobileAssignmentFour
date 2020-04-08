package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    static int width, height;
    public Model model;
    public View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        model = new Model();
        view = new View(this, width, height);
        setContentView(view);

        shapesTimerTask task = new shapesTimerTask(model, view);
        Timer timer = new Timer();
        timer.schedule(task, 200, 20);
    }

}
