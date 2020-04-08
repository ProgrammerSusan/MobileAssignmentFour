package com.example.app4;

import android.graphics.Color;

public class Shape
{
    int x, y, r, xend, yend, color, speed, rand;
    static int width=MainActivity.width, height= MainActivity.height;
    char direction;
    String name;

    public Shape(int i)
    {
        rand = (int) (Math.random()*100);

        r = (int)(Math.random()*100);
        while (r <= (50)) { r = (int) (Math.random() * 100); }

        x = (int) (Math.random() * 1000)+210;
        while (x >= (width-r)) { x = (int) (Math.random() * 1000)+210; }

        y = (int) (Math.random() * 1000)+210;
        while (y >= (height-r)) { y = (int) (Math.random() * 1000)+210; }

        xend=x+r;
        yend=y+r;

        speed = (int)(Math.random()*10+1);

        if (rand % 7 == 0)
            color = Color.parseColor("#F3A7A7");
        else if (rand % 6 == 0)
            color = Color.parseColor("#F4C3EB");
        else if (rand % 5 == 0)
            color = Color.parseColor("#C3C5F4");
        else if (rand % 4 == 0)
            color = Color.parseColor("#C3EDF4");
        else if (rand % 3 == 0)
            color = Color.parseColor("#C1FFB2");
        else if (rand % 2 == 0)
            color = Color.parseColor("#F9FD80");
        else
            color = Color.parseColor("#FDB980");

        if (rand < 25)
            direction = 'n';
        else if (rand > 25 && rand < 50)
            direction = 's';
        else if (rand > 50 && rand < 75)
            direction = 'w';
        else
            direction = 'e';


        if (i < 9)
            name="circle";
        else
            name="square";
    }

    public static void move(Shape s)
    {
        int sy = s.y;
        int sx = s.x;
        char direction = s.direction;
        int speed = s.speed;
        String name = s.name;

        if(name == "circle")
        {
            switch (direction)
            {
                case 'n':
                    if (sy+speed>=0)
                        s.y = sy - speed;
                    else
                        s.y=height;
                    break;
                case 's':
                    if (sy-speed<=height)
                        s.y = sy + speed;
                    else
                        s.y=0;
                    break;
                case 'w':
                    if (sx-speed>=0)
                        s.x = sx - speed;
                    else
                        s.x=width;
                    break;
                case 'e':
                    if(sx+speed<=width)
                        s.x = sx + speed;
                    else
                        s.x=0;
                    break;
            }
        }
        else
        {
            int yend = s.yend;
            int xend = s.xend;
            int r = s.r;

            switch (direction)
            {
                case 's':
                    if (sy+speed<=height)
                    {
                        s.y = sy + speed;
                        s.yend = yend + speed;
                    }
                    else
                    {
                        s.y=0;
                        s.yend=r;
                    }
                    break;
                case 'n':
                    if(sy-speed>=0)
                    {
                        s.y = sy - speed;
                        s.yend = yend - speed;
                    }
                    else
                    {
                        s.y = height-r;
                        s.yend=height;
                    }
                    break;
                case 'w':
                    if(sx-speed>=0)
                    {
                        s.x = sx - speed;
                        s.xend = xend - speed;
                    }
                    else
                    {
                        s.x = width - r;
                        s.xend = width;
                    }
                    break;
                case 'e':
                    if (sx+speed<=width)
                    {
                        s.x = sx + speed;
                        s.xend = xend + speed;
                    }
                    else
                    {
                        s.x=0;
                        s.xend = r;
                    }
                    break;
            }

        }
    }
}
