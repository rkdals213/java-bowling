package bowling.domain;

public class Frame {
    private int frameNumber;
    private Balls balls;

    public Frame(int frameNumber) {
        this.frameNumber = frameNumber;
        this.balls = new Balls(isLastFrame());
    }

    public void addBall(int pin) {
       balls.add(pin);
    }

    private boolean isLastFrame() {
        return frameNumber == Frames.LAST_FRAME;
    }

    public int getScore() {
        return balls.score();
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public boolean isAddAble() {
        return addAblePinCount() > Ball.ZERO_PIN_COUNT;
    }

    public int addAblePinCount() {
        return balls.addAblePinCount();
    }

    public String getResult() {
        return balls.getResult();
    }
}