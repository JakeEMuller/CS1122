import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Gui extends Application {


    public void start(Stage stage) throws Exception {

        BorderPane borderPane = new BorderPane();


        Scene scene = new Scene(borderPane);
        stage.setTitle("DnD player maker");
        stage.setScene(scene);
        stage.show();







    }


}
