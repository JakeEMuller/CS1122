import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;


public class ChangeFont extends Application {

    public void start(Stage primaryStage) {
        // sets up border pane
        BorderPane borderPane = new BorderPane();


        //set up text tester
        TextArea tester = new TextArea();
        tester.setText("adoifuakjshygoeaup9sdlkgahsre[0");
        Font check = new Font(10);
        System.out.println(check.getFamilies().toString());


        //set up font face menu
        Menu face = new Menu("Face");
        List<String> faces = check.getFamilies();
        for (int i = 0; i != faces.size(); i++) {
            String type = faces.get(i);
            MenuItem temp = new MenuItem(type);
            temp.setOnAction(event -> {
                tester.setFont(Font.font(type,tester.getFont().getSize()));
            });
            face.getItems().add(temp);
        }
        //set up font size menu
        Menu size = new Menu("Size");
        MenuItem small = new MenuItem("Small");
        small.setOnAction(event -> {
            tester.setFont(new Font(10));
        });
        MenuItem medium = new MenuItem("Medium");
        medium.setOnAction(event -> {
            tester.setFont(new Font(25));
        });
        MenuItem big = new MenuItem("Big");
        big.setOnAction(event -> {
            tester.setFont(new Font(50));
        });
        size.getItems().addAll(small, medium, big);


        //st up font style
        Menu style = new Menu("Style");
        MenuItem bold = new MenuItem("Bold");
        bold.setOnAction(event -> {
            tester.setFont(Font.font(tester.getFont().getName(), FontWeight.BOLD, tester.getFont().getSize()));
        });
        MenuItem regular = new MenuItem("regular");
        regular.setOnAction( event -> {
                tester.setFont(Font.font(tester.getFont().getName(), FontPosture.REGULAR, tester.getFont().getSize()));
        });
        MenuItem italics = new MenuItem("Italics");
        italics.setOnAction(event -> {
            tester.setFont(Font.font(tester.getFont().getName(), FontPosture.ITALIC, tester.getFont().getSize()));
        });
        style.getItems().addAll(regular, bold, italics);
        //main menus setup
        Menu file = new Menu("File");
        file.show();

        Menu font = new Menu("Font");
        font.getItems().addAll(face, size, style);
        font.show();


        // set up menuBar
        MenuBar topBar = new MenuBar();
        topBar.getMenus().addAll(file, font);


        //creates dropdown font chooser
        VBox vBox = new VBox(topBar);

        //sets up borderPane

        borderPane.setCenter(tester);
        borderPane.setTop(vBox);


        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Change font");
        primaryStage.show();


    }
}
