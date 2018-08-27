package sample;

public class Sprite {
    private String location = "/Sprite.jpg";
    private int xPos;
    private int yPos;
    private int sceneWidth;
    private int sceneHeight;
    private static final int PICTURESIZE = 30;

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
}
