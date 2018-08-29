package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Main class which initialises the scene and sprites.
 * @author Charlie Cox
 * @version 29/09/2018
 */
public class Main extends Application {
    private int width=500;//width and height of the scene
    private int height=500;
    private Sprite sprite;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //creating the sprite object
        sprite = new Sprite(width, height);

        //putting the sprite in the starting position (centre of the scene)
        sprite.drawPlayer();

        //group to put the player image into
        Group playArea = new Group(sprite.imageView);

        //putting everything onto the scene
        Scene scene = new Scene(playArea, width, height, Color.GREEN);

        //displaying the stage
        primaryStage.setTitle("Automatic Sprite Movement");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        //program stops running when closed
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });

        //timer
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                sprite.updateLocation();//moves and redraws the player on the scene.
            }
        };
        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
