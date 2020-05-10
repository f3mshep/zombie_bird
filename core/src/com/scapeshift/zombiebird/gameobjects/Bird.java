package com.scapeshift.zombiebird.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Bird {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation;
    private int width;
    private int height;

    public Bird(int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x,y);
        velocity = new Vector2(0,0);
        acceleration = new Vector2(0, 460);
    }

    public void update(float delta){
        velocity.add(acceleration.cpy().scl(delta));

        if (velocity.y > 200){
            velocity.y = 200;
        }

        position.add(velocity.cpy().scl(delta));

        //Rotate counterclock
        if (velocity.y < 0) {
            rotation -= 600 * delta;

            if (rotation < -20){
                rotation = -20;
            }
        }

        // Rotate clockwise
        if (isFalling()){
            rotation += 480 * delta;
            if (rotation > 90) {
                rotation = 90;
            }
        }
    }

    public boolean isFalling(){
        return velocity.y > 110;
    }

    public boolean shouldNotFlap(){
        return velocity.y > 70;
    }

    public void onClick(){
        velocity.y = -140;
    }

    public float getX(){
        return position.x;
    }

    public float getY(){
        return position.y;
    }

    public float getRotation() {
        return rotation;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
