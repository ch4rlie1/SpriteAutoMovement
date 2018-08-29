package sample;

/**
 * This class changes the direction the sprite travels in every second.
 * @author Charlie Cox
 * @version 29/08/2019
 */
public class ChangeDirectionThread extends Thread {
    private Sprite sprite;

    /**
     * Constructor
     * @param s Sprite
     */
    public ChangeDirectionThread(Sprite s) {
       this.sprite = s;
    }

    /**
     * Run method - changes the direction that the sprite travels in
     */
    public void run() {

        while (true) {
            //update the Sprite booleans
            sprite.changeDirection();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
