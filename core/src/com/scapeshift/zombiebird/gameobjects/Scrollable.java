package com.scapeshift.zombiebird.gameobjects;

import com.badlogic.gdx.math.Vector2;

public abstract class Scrollable {

    private Vector2 position, velocity;
    int width, height;
    boolean isScrolledLeft;

    public Scrollable(float x, float y, int width, int height, float scrollSpeed) {
        position = new Vector2(x,y);
        velocity = new Vector2(scrollSpeed, 0);
        this.width = width;
        this.height = height;
        this.isScrolledLeft = false;
    }

    public void update(float delta){
        position.add(velocity.cpy().scl(delta));

        if (position.x + width < 0){
            isScrolledLeft = true;
        }
    }

    public void reset(float newX){
        position.x = newX;
        isScrolledLeft = false;
    }

    public float getTailX(){
        return position.x + width;
    }

    public float getX(){
        return position.x;
    }

    public float getY(){
        return position.y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isScrolledLeft() {
        return isScrolledLeft;
    }
}
