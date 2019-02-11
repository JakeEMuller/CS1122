import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class InClassFeb22 extends Application{

    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene( root, 800, 600);
        for(int i = 0 ; i < 10; i++ ){
            double startX = Math.random() * primaryStage.getMaxWidth();
            double endX = Math.random() * primaryStage.getMaxWidth();
            double startY = Math.random() * primaryStage.getMaxHeight();
            double endY = Math.random() * primaryStage.getMaxHeight();
        }
        Line testLine = new Line(0,50,45,450);
        testLine.setStroke(Color.BLACK);
        testLine.setStrokeWidth(10);
        root.getChildren().add(testLine);

        primaryStage.setTitle("My JavaFx Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
