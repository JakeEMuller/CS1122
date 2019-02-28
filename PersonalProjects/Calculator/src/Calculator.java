import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class Calculator extends Application {
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");

    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(3);
        BorderPane borderPane = new BorderPane();
        TextField enter = new TextField();
        borderPane.setTop(enter);
        borderPane.setCenter(grid);



        Button button1 = new Button("  1  ");
        button1.setOnAction(e-> {
            enter.setText(enter.getText() + "1");
        });
        Button button2 = new Button("  2  ");
        button2.setOnAction(e-> {
            enter.setText(enter.getText() + "2");
        });
        Button button3 = new Button("  3  ");
        button3.setOnAction(e-> {
            enter.setText(enter.getText() + "3");
        });
        Button button4 = new Button("  4  ");
        button4.setOnAction(e-> {
            enter.setText(enter.getText() + "4");
        });
        Button button5 = new Button("  5  ");
        button5.setOnAction(e-> {
            enter.setText(enter.getText() + "5");
        });
        Button button6 = new Button("  6  ");
        button6.setOnAction(e-> {
            enter.setText(enter.getText() + "6");
        });
        Button button7 = new Button("  7  ");
        button7.setOnAction(e-> {
            enter.setText(enter.getText() + "7");
        });
        Button button8 = new Button("  8  ");
        button8.setOnAction(e-> {
            enter.setText(enter.getText() + "8");
        });
        Button button9 = new Button("  9  ");
        button9.setOnAction(e-> {
            enter.setText(enter.getText() + "9");
        });
        Button button0 = new Button("  0  ");
        button0.setOnAction(e-> {
            enter.setText(enter.getText() + "0");
        });
        Button dot = new Button("  .   ");
        dot.setOnAction(e-> {
            enter.setText(enter.getText() + ".");
        });
        Button multiply = new Button("  X  ");
        multiply.setOnAction(e-> {
            enter.setText(enter.getText() + "*");
        });
        Button divide = new Button("  /   ");
        divide.setOnAction(e-> {
            enter.setText(enter.getText() + "/");
        });
        Button subtract = new Button("  -   ");
        subtract.setOnAction(e-> {
            enter.setText(enter.getText() + "-");
        });
        Button add = new Button("  +  ");
        add.setOnAction(e-> {
            enter.setText(enter.getText() + "+");
        });
        Button equals = new Button("  =  ");
        equals.setOnAction(e-> {
            String infix = enter.getText();
            try {
                int number = (int) engine.eval(infix);
                enter.setText(String.valueOf(number));
            } catch (ScriptException e1) {
                e1.printStackTrace();
            }
        });



        grid.add(button1,1,4);
        grid.add(button2, 2,4);
        grid.add(button3, 3,4);
        grid.add(button4, 1,3);
        grid.add(button5, 2,3);
        grid.add(button6,3,3);
        grid.add(button7,1,2);
        grid.add(button8,2,2);
        grid.add(button9,3,2);
        grid.add(button0,2,5);
        grid.add(dot,3,5);
        grid.add(divide,4,1);
        grid.add(multiply,4,2);
        grid.add(subtract,4,3);
        grid.add(add,4,4);
        grid.add(equals,4,5);

        Scene scene = new Scene(borderPane, 800,600);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
