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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main class which initialises the scene and sprites.
 * @author Charlie Cox
 * @version 29/09/2018
 */
public class Main extends Application {
    private int width=500;//width and height of the scene
    private int height=500;
    private Sprite[] sprites;

    @Override
    public void start(Stage primaryStage) throws Exception {
        sprites = new Sprite[10];//how many sprites you desire
        Group playArea = new Group();//to put images onto

        //creating the thread pool
        ExecutorService pool = Executors.newCachedThreadPool();

        //creating sprite objects
        for (int i = 0; i<sprites.length; i++){
            sprites[i] = new Sprite(width, height);
            sprites[i].drawPlayer();
            playArea.getChildren().addAll(sprites[i].imageView);
        }

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

        //put all sprites into the pool
        for(int i = 0; i<sprites.length; i++)
            pool.submit(new ChangeDirectionThread(sprites[i]));

        //timer
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //sprite.updateLocation();//moves and redraws the player on the scene.
                for(int i = 0; i<sprites.length; i++) {
                    sprites[i].updateLocation();
                }
            }
        };
        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
