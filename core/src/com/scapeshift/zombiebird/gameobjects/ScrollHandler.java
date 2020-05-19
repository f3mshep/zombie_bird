package com.scapeshift.zombiebird.gameobjects;

public class ScrollHandler {

    private Grass frontGrass, backGrass;
    private Background firstBg, lastBg;
    private Pipe pipe1, pipe2, pipe3;

    public static final int SCROLL_SPEED=-59;
    public static final int BACKGROUND_SCROLL=-10;
    public static final int PIPE_GAP = 49;

    public ScrollHandler(float yPos, int midPointY){
        frontGrass = new Grass(0, yPos, 143, 11, SCROLL_SPEED);
        backGrass = new Grass(frontGrass.getTailX(), yPos, 143, 11, SCROLL_SPEED);

        firstBg = new Background(0, midPointY + 23, 136, 43, BACKGROUND_SCROLL);
        lastBg = new Background(firstBg.getTailX(), midPointY + 23, 136, 43, BACKGROUND_SCROLL);

        pipe1 = new Pipe(210, 0, 22, 60, SCROLL_SPEED);
        pipe2 = new Pipe(pipe1.getTailX() + PIPE_GAP, 0, 22, 70, SCROLL_SPEED);
        pipe3 = new Pipe(pipe2.getTailX() + PIPE_GAP, 0, 22, 60, SCROLL_SPEED);
    }

    public void update(float delta){
        frontGrass.update(delta);
        backGrass.update(delta);

        firstBg.update(delta);
        lastBg.update(delta);

        pipe1.update(delta);
        pipe2.update(delta);
        pipe3.update(delta);

        if (pipe1.isScrolledLeft){
            pipe1.reset(pipe3.getTailX() + PIPE_GAP);
        } else if (pipe2.isScrolledLeft()){
            pipe2.reset(pipe1.getTailX() + PIPE_GAP);
        } else if (pipe3.isScrolledLeft()){
            pipe3.reset(pipe2.getTailX() + PIPE_GAP);
        }

        if (frontGrass.isScrolledLeft()){
            frontGrass.reset(backGrass.getTailX());
        } else if (backGrass.isScrolledLeft()){
            backGrass.reset(frontGrass.getTailX());
        }

        if (firstBg.isScrolledLeft()){
            firstBg.reset(lastBg.getTailX());
        } else if (lastBg.isScrolledLeft()){
            lastBg.reset(firstBg.getTailX());
        }
    }

    public Grass getFrontGrass() {
        return frontGrass;
    }

    public Grass getBackGrass() {
        return backGrass;
    }

    public Pipe getPipe1() {
        return pipe1;
    }

    public Pipe getPipe2() {
        return pipe2;
    }

    public Pipe getPipe3() {
        return pipe3;
    }

    public Background getFirstBg() {
        return firstBg;
    }

    public Background getLastBg() {
        return lastBg;
    }
}
