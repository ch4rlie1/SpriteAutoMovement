package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private int width=500;//width and height of the scene
    private int height=500;
    private ImageView imageView;
    private Sprite sprite;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //creating the player object
        sprite = new Sprite(width, height);

        //using the sprite object to load an image into an imageview and ensuring it is the correct size.
        Image image = new Image(getClass().getResource(sprite.getLocation()).toExternalForm());
        imageView = new ImageView(image);
        imageView.setPreserveRatio(false);
        imageView.setFitWidth(sprite.getPICTURESIZE());
        imageView.setFitHeight(sprite.getPICTURESIZE());
        imageView.setCache(true);//to improve performance

        //putting the sprite in the starting position (centre of the scene)
        drawPlayer();

        //group to put the player image into
        Group playArea = new Group(imageView);

        //putting everything onto the scene
        Scene scene = new Scene(playArea, width, height, Color.GREEN);

        //displaying the stage
        primaryStage.setTitle("Automatic Sprite Movement");
        primaryStage.setScene(scene);
        primaryStage.show();

        //timer
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                sprite.move();
                sprite.updateMove();
                drawPlayer();

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        };
        timer.start();
    }

    public void drawPlayer() {
        imageView.relocate(sprite.getxPos(), sprite.getyPos());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
