package com.scapeshift.zombiebird.gameworld;

import com.scapeshift.zombiebird.gameobjects.Bird;
import com.scapeshift.zombiebird.gameobjects.ScrollHandler;

public class GameWorld {
   private Bird bird;
   private int midPointY;
   private ScrollHandler scrollHandler;

   public GameWorld(int midPointY){
       this.midPointY = midPointY;
       this.bird = new Bird(33, midPointY - 5, 17, 12);

       scrollHandler = new ScrollHandler(midPointY + 66, midPointY);
   }

   public void update(float delta){
       bird.update(delta);
       scrollHandler.update(delta);
   }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScrollHandler() {
        return scrollHandler;
    }
}
