package com.example.myapplication;

import java.util.Random;

public class Game
{
    private double birdX;
    private double birdY;
    private double birdSpeed;

    private double bulletX;
    private double bulletY;
    private double bulletSpeed;
    private double bulletAngle;

    private double gunX;
    private double gunY;

    private double radius;
    private double distanceThreshold;

    private boolean fired;
    private boolean hit;

    public Game()
    {
        initializeGame();
    }

    public void update()
    {
        moveBird();

        if (fired)
            moveBullet();

        if (sceneClear())
            initializeGame();
    }

    public void fire()
    {
        fired = true;
    }

    public double getBirdX()
    {
        return birdX;
    }

    public double getBirdY()
    {
        return birdY;
    }

    public double getBulletX()
    {
        return bulletX;
    }

    public double getBulletY()
    {
        return bulletY;
    }

    public double getGunX()
    {
        return gunX;
    }

    public double getGunY()
    {
        return gunY;
    }

    public double getRadius()
    {
        return radius;
    }

    private void moveBird()
    {
        if (!hit)
        {
            birdX = birdX - birdSpeed;
            hit = decideHit();
        }
        else
            birdY = birdY - birdSpeed;
    }

    private void moveBullet()
    {
        bulletX = bulletX + bulletSpeed*Math.cos(bulletAngle*Math.PI/180);
        bulletY = bulletY + bulletSpeed*Math.sin(bulletAngle*Math.PI/180);
    }

    private boolean decideHit()
    {
        double distance = Math.sqrt((birdX - bulletX)*(birdX - bulletX) +
                (birdY - bulletY)*(birdY - bulletY));

        return distance <= distanceThreshold;
    }

    private boolean sceneClear()
    {
        return (birdX < 0 || birdY < 0) && bulletY > 1000;
    }

    private void initializeGame()
    {
        Random r = new Random();

        double sceneWidth = 1800;
        double sceneHeight = 1000;
        double gunAngle = 0;

        this.birdX = sceneWidth - 50;
        this.birdY = sceneHeight - 50 - 400 * Math.random();
        this.birdSpeed = 10 + 10 * Math.random();

        this.gunX = 0;
        this.gunY = r.nextInt(450) + 250;

        this.bulletX = gunX + 200;
        this.bulletY = gunY;
        this.bulletSpeed = 20;
        this.bulletAngle = gunAngle;

        this.radius = 50;
        this.distanceThreshold = 100;

        this.fired = false;
        this.hit = false;
    }
}
