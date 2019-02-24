import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Cars extends Application {

    public void start(Stage primaryStage) throws Exception {


        Group root = new Group();

        //load images
        Image red = new Image("file:red.png");
        Image green = new Image("file:GreenCar.png");
        //resizes images
        ImageView redCar = new ImageView(red);
        redCar.setPreserveRatio(true);
        redCar.setY(450);
        redCar.setX(650);
        redCar.setFitWidth(120);

        ImageView greenCar = new ImageView(green);
        greenCar.setPreserveRatio(true);
        greenCar.setY(100);
        greenCar.setX(50);
        greenCar.setFitWidth(120);
        root.getChildren().addAll(redCar,greenCar);


        Timeline moveGreen = new Timeline();
        moveGreen.getKeyFrames().add(new KeyFrame(Duration.millis(5000), new KeyValue(greenCar.translateXProperty(), 600)));
        Timeline moveRed = new Timeline();
        moveRed.getKeyFrames().add(new KeyFrame(Duration.millis(5000), new KeyValue(redCar.translateXProperty(), -600)));

        Scene scene = new Scene(root,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cars that move");
        primaryStage.show();
        moveRed.play();
        moveGreen.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
