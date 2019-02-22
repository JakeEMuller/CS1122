import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class HangMan extends Application {
    private String guessWord = "Hello world";


    public void start(Stage primaryStage) throws Exception{

        //BorderPane setup
        BorderPane borderPane = new BorderPane();
        BorderPane bottomPane = new BorderPane();

        //formats line for
        HBox wordGuesser = new HBox();
        Button test = new Button("test");

        //Group and lines
        Group root = new Group();
        Line base = new Line(25,700,125,700);
        base.setStroke(Color.BLACK);
        base.setStrokeWidth(5);
        Line stand = new Line(75,700,75,400);
        stand.setStroke(Color.BLACK);
        stand.setStrokeWidth(5);
        Line top = new Line(75,400,180,400);
        top.setStroke(Color.BLACK);
        top.setStrokeWidth(5);
        Line hanger = new Line(180,400,180,450);
        hanger.setStroke(Color.BLACK);
        hanger.setStrokeWidth(5);

        //hidden head man
        Circle head = new Circle(30);
        head.setCenterY(470);
        head.setCenterX(180);
        head.setStroke(Color.BLACK);
        Line body = new Line(180,470,180,600);
        body.setStroke(Color.BLACK);
        body.setStrokeWidth(5);
        Line leftLeg = new Line(180,600,210,650);
        leftLeg.setStrokeWidth(5);
        leftLeg.setStroke(Color.BLACK);
        Line rightLeg = new Line(180,600,150,650);
        rightLeg.setStroke(Color.BLACK);
        rightLeg.setStrokeWidth(5);
        Line lArm = new Line(180,550,150,570);
        lArm.setStrokeWidth(5);
        lArm.setStroke(Color.BLACK);
        Line rArm = new Line(180,550,210,570);
        rArm.setStroke(Color.BLACK);
        rArm.setStrokeWidth(5);
        root.getChildren().addAll(base,stand,top,hanger,head,body,leftLeg,rightLeg,lArm,rArm);


        //HBox setup and button formats
        HBox hbox = new HBox(15);
        Label guessLabel = new Label("    Enter a Letter");
        TextField guessField = new TextField();

        //Adds Button
        Button guessButton = new Button("Guess");
        guessButton.setOnAction(e ->{
            char guess = guessField.getText().toCharArray()[0];
            System.out.println(guess);
        });


        //formats HBox
        hbox.getChildren().addAll(guessLabel,guessField,guessButton);

        //sets up borderPane

        borderPane.setBottom(bottomPane);
        bottomPane.setBottom(hbox);
        bottomPane.setTop(wordGuesser);
        borderPane.setCenter(root);

        //basic scene format
        Scene scene = new Scene(borderPane,600,700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
