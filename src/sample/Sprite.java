package sample;

public class Sprite {
    private String location = "/Sprite.jpg";
    private int xPos;
    private int yPos;
    private int sceneWidth;
    private int sceneHeight;
    private static final int PICTURESIZE = 30;
    boolean up, down, left, right;
    private int speed = 2;

    public Sprite(int sceneWidth, int sceneHeight) {
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;

        this.xPos = (sceneWidth/2)-(PICTURESIZE /2);
        this.yPos = (sceneHeight/2)-(PICTURESIZE /2);
    }

    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }

    public String getLocation() {
        return this.location;
    }

    public int getSceneWidth() {
        return this.sceneWidth;
    }

    public int getSceneHeight() {
        return this.sceneHeight;
    }

    public int getPICTURESIZE() {
        return this.PICTURESIZE;
    }

    /**
     * Directions - 0=left, 1=upleft, 2=up, 3=upright, 4=right, 5=downright, 6=down, 7=downleft
     */
    public void move() {
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
                left = false;
                right = true;
                up = false;
                down = true;
                break;
            }
        }
    }

    public void updateMove() {
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
        public void updateUp () {
            //checks whether it is at the end of the screen or not
            if (this.yPos - speed < 0) {
                return;
            } else {
                this.yPos -= speed;
            }
        }

        /**
         * Updates the y position so the player moves down the screen but does not leave the screen.
         */
        public void updateDown() {
             if (this.yPos + speed + PICTURESIZE > this.sceneHeight) {
                return;
            } else {
                this.yPos+=speed;
            }
        }

        /**
         * Updates the x position so the player moves left along the screen but does not leave the screen.
         */
        public void updateLeft() {
            if(this.xPos-speed<0) {
                return;
            } else {
                this.xPos-=speed;
            }
        }

        /**
         * Updates the x position so the player moves right along the screen but does not leave the screen.
         */
        public void updateRight() {
            if(this.xPos+speed+PICTURESIZE>this.sceneWidth) {
                return;
            } else {
                this.xPos+=speed;
            }
        }
    }
