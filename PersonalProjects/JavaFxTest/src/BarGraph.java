import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

import javafx.stage.Stage;


public class BarGraph extends Application {

    public void start(Stage stage) throws Exception{
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        final BarChart<String , Number > barChart = new BarChart<String,Number>(xAxis,yAxis);
        barChart.setTitle("Bar Chart Data");

        xAxis.setLabel("Name");
        yAxis.setLabel("Value");
        yAxis.setTickLabelsVisible(false);
        Data<String,Number> dataElement = new Data<String,Number>("Detriot",417);
        Data<String,Number> dataElement2 = new Data<String,Number>("Chicago",310);
        Series series = new Series();
        series.getData().addAll( dataElement,dataElement2 );
        series.setName("Detroit");
        Data<String,Number> dataElement3 = new Data<String,Number>("foo",310);
        Series series2 = new Series();
        series2.getData().addAll( dataElement3);
        series2.setName("foo");


        barChart.getData().addAll(series,series2);

        Scene scene = new Scene(barChart,800,600);
        stage.setScene(scene);
        stage.show();


    }


}
