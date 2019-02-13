import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;


public class ButtonTest extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage1) {
        final int[] count = {0};
        Button button1 = new Button("Click Me");
        button1.setOnAction(e -> {
            count[0]++;
            System.out.println("Button was Clicked " + count[0] + " times");
        });

        Pane root = new Pane();
        root.getChildren().add(button1);
        Scene scene = new Scene(root, 800, 600);

        stage1.setTitle("Button Viewer");
        stage1.setScene(scene);
        stage1.show();
    }
}
