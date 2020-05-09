package com.scapeshift.zombiebird.gameworld;

import com.scapeshift.zombiebird.gameobjects.Bird;

public class GameWorld {
   private Bird bird;
   private int midPointY;

   public GameWorld(int midPointY){
       this.midPointY = midPointY;
       this.bird = new Bird(33, midPointY - 5, 17, 12);
   }

   public void update(float delta){
       bird.update(delta);
   }

    public Bird getBird() {
        return bird;
    }
}
