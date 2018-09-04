package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Sprite class which contains attributes for its location on the screen,
 * the direction it should be moving, its speed and the image used.
 * @author Charlie Cox
 * @version 29/08/2018
 */
public class Sprite {
    private String location = "/Sprite.jpg";
    private int xPos;
    private int yPos;
    private int sceneWidth;
    private int sceneHeight;
    private static final int PICTURESIZE = 30;
    boolean up, down, left, right;
    private int speed = 2;//TODO make it possible for the user to change the speed
    private ChangeDirectionThread changeDirectionThread;
    ImageView imageView;

    /**
     * Constructor
     * @param sceneWidth The width of the scene being used
     * @param sceneHeight The height of the scene being used
     */
    public Sprite(int sceneWidth, int sceneHeight) {

        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;

        this.xPos = (sceneWidth/2)-(PICTURESIZE /2);
        this.yPos = (sceneHeight/2)-(PICTURESIZE /2);

        Image image = new Image(getClass().getResource(this.location).toExternalForm());
        this.imageView = new javafx.scene.image.ImageView(image);
        imageView.setPreserveRatio(false);
        imageView.setFitWidth(this.PICTURESIZE);
        imageView.setFitHeight(this.PICTURESIZE);
        imageView.setCache(true);//to improve performance
    }

    public void drawPlayer() {
        imageView.relocate(xPos, yPos);
    }

    /**
     * Changes the direction of the sprite by changing the values of the boolean variables
     * left, right, up and down.
     *
     * Directions - 0=left, 1=upleft, 2=up, 3=upright, 4=right, 5=downright, 6=down, 7=downleft
     */
    public synchronized void changeDirection() throws InterruptedException {
        int direction = (int) Math.round(Math.random() * 7);

        switch (direction) {
            case 0: {//left
                System.out.println("left");
                left = true;
                right = false;
                up = false;
                down = false;
                break;
            }
            case 1: {//upleft
                System.out.println("upleft");
                left = true;
                right = false;
                up = true;
                down = false;
                break;
            }
            case 2: {//up
                System.out.println("up");
                left = false;
                right = false;
                up = true;
                down = false;
                break;
            }
            case 3: {//upright
                System.out.println("upright");
                left = false;
                right = true;
                up = true;
                down = false;
                break;
            }
            case 4: {//right
                System.out.println("right");
                left = false;
                right = true;
                up = false;
                down = false;
                break;
            }
            case 5: {//downright
                System.out.println("downright");
                left = false;
                right = true;
                up = false;
                down = true;
                break;
            }
            case 6: { //down
                System.out.println("down");
                left = false;
                right = false;
                up = false;
                down = true;
                break;
            }
            case 7: {//downleft
                System.out.println("downleft");
                left = true;
                right = false;
                up = false;
                down = true;
                break;
            }
        }
    }

    /**
     * Updates the variables containing the location (x and y positions) on the scene.
     */
    public synchronized void updateLocation() {
        if (up)
            updateUp();

        if (down)
            updateDown();

        if (left)
            updateLeft();

        if (right)
            updateRight();
    }
        /**
         * Updates the y position so the player moves up the screen but does not leave the screen.
         */
        public synchronized void updateUp () {
            //checks whether it is at the end of the screen or not
            if (this.yPos - speed < 0) {
                this.yPos -= 0;
                up=false;
                down=true;
            } else {
                this.yPos -= speed;
            }
            drawPlayer();
        }

        /**
         * Updates the y position so the player moves down the screen but does not leave the screen.
         */
        public synchronized void updateDown() {
             if (this.yPos + speed + PICTURESIZE > this.sceneHeight) {
                this.yPos = sceneHeight-PICTURESIZE;
                 down=false;
                 up=true;
            } else {
                this.yPos+=speed;
            }
            drawPlayer();
        }

        /**
         * Updates the x position so the player moves left along the screen but does not leave the screen.
         */
        public synchronized void updateLeft() {
            if(this.xPos-speed<0) {
                this.xPos = 0;
                left=false;
                right=true;
            } else {
                this.xPos-=speed;
            }
            drawPlayer();
        }

        /**
         * Updates the x position so the player moves right along the screen but does not leave the screen.
         */
        public synchronized void updateRight() {
            if(this.xPos+speed+PICTURESIZE>this.sceneWidth) {
                this.xPos = sceneWidth - PICTURESIZE;
                right=false;
                left=true;
            } else {
                this.xPos+=speed;
            }
            drawPlayer();
        }
    }
