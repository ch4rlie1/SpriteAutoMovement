package sample;

/**
 * This class changes the direction the sprite travels in every second.
 * @author Charlie Cox
 * @version 29/08/2019
 */
public class ChangeDirectionThread implements Runnable {
    private Sprite sprite;

        /**
     * Constructor
     * @param s Sprite
     */
    public ChangeDirectionThread(Sprite s) {
       this.sprite = s;
    }

    /**
     * Run method - changes the direction that the sprite travels in once a second
     */
    public void run() {
        while (true) {
            //update the Sprite booleans
            try {
                sprite.changeDirection();
                Thread.sleep(Math.round(100+(900*Math.random())));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
