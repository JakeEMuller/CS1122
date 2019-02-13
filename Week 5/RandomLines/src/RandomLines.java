import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class RandomLines extends Application {
    public void start(Stage stage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root, 600, 500);

        for(int i = 0; i < 25; i++){
            double R =  (Math.random());
            double G =  (Math.random());
            double B =  (Math.random());
            int startX = (int) (Math.random() * scene.getWidth());
            int endX = (int) (Math.random() * scene.getWidth());
            int startY = (int) (Math.random() * scene.getHeight());
            int endY = (int) (Math.random() * scene.getHeight());
            Line testLine = new Line(startX,startY,endX,endY);
            testLine.setStroke(Color.color(R,G,B));
            testLine.setStrokeWidth((Math.random()*10+1));
            root.getChildren().add(testLine);
        }

        stage.setTitle("Random Lines");
        stage.setScene( scene );
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
