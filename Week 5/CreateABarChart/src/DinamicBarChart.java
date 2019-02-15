import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DinamicBarChart extends Application {

    public void start(Stage primaryStage) throws Exception{
        //set up formating
        BorderPane borderPane = new BorderPane();
        HBox inputs = new HBox();


        //create barchart
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        final BarChart<String , Number> barChart = new BarChart<>(xAxis,yAxis);
        barChart.setTitle("bar Chart Data");
        xAxis.setLabel("Name");
        yAxis.setLabel("Value");

        //sets up text fields
        Label nameLabel = new Label("Name");
        TextField nameField = new TextField();
        Label valueLabel = new Label("Value");
        TextField valueField = new TextField();

        //adds a button and functionality
        Button addButton = new Button("Add");
        addButton.setOnAction(e ->{
            String name = nameField.getText();
            Double value = Double.valueOf(valueField.getText());
            Data<String,Number> temp = new Data<String,Number>(name,value);
            Series series = new Series();
            series.getData().add(temp);
            series.setName(name);
            barChart.getData().add(series);
        });


        //formats HBox
        inputs.getChildren().addAll(nameLabel,nameField,valueLabel,valueField,addButton);



        //sets up borderPane format
        borderPane.setTop(inputs);
        borderPane.setCenter(barChart);

        //basic scene format
        Scene scene = new Scene(borderPane,800,600);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
