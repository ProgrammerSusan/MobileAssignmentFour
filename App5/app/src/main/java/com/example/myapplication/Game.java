package com.example.myapplication;

public class Game {
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

    public Game() {
        initializeGame();
    }

    public void update() {
        moveBird();

        if (fired)
            moveBullet();

        if (sceneClear())
            initializeGame();
    }

    public void fire() {
        fired = true;
    }

    public double getBirdX() {
        return birdX;
    }

    public double getBirdY() {
        return birdY;
    }

    public double getBulletX() {
        return bulletX;
    }

    public double getBulletY() {
        return bulletY;
    }

    public double getGunX() {
        return gunX;
    }

    public double getGunY() {
        return gunY;
    }

    public double getRadius() {
        return radius;
    }

    private void moveBird() {
        if (!hit)
        {
            birdY = birdY - birdSpeed;
            hit = decideHit();
        }
        else{
            this.hit = decideHit();
            birdY = -2000;
        }
    }

    private void moveBullet() {
        bulletX = bulletX + bulletSpeed * Math.cos(bulletAngle * Math.PI / 180);
        bulletY = bulletY + bulletSpeed * Math.sin(bulletAngle * Math.PI / 180);
    }

    private boolean decideHit() {
        double distance = Math.sqrt((birdX - bulletX) * (birdX - bulletX) +
                (birdY - bulletY) * (birdY - bulletY));

        return distance <= distanceThreshold;
    }

    private boolean sceneClear() {
        return (hit ||(birdX < 0 || birdY < 0)) && bulletX > 1800;
    }

    private void initializeGame() {
        double sceneWidth = 1800;
        double sceneHeight = 1000;
        double gunLength = 200;
        double gunAngle = 0;

        this.birdX = sceneWidth - 600 - 400 * Math.random();
        this.birdY = sceneHeight;
        this.birdSpeed = 10 + 10 * Math.random();

        this.gunX = gunLength;
        this.gunY = Math.random() * 450;

        this.bulletX = gunX;
        this.bulletY = gunY;
        this.bulletSpeed = 40;
        this.bulletAngle = gunAngle;

        this.radius = 50;
        this.distanceThreshold = 100;

        this.fired = false;
        this.hit = false;
    }
}