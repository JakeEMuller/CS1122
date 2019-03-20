import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.concurrent.Task;

public class Program3Gui extends Application {
    static int i = 0;

    //runs a tick in a Thread so i does not interfree with data
    public int[] runTicks() {
        int[] data = new int[3];
        Task<Integer> test = new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                Test.simulator.tick();
                System.out.println("Tick Number: " + i);
                System.out.println("There are " + Test.simulator.getCurrentMoose().size() + " Moose");
                System.out.println("There are " + Test.simulator.getCurrentWolfs().size() + " Wolves\n");
                //slot 0 is ticks, 2 is moose population, 3 is wolf population
                data[0] = i;
                data[1] = Test.simulator.getCurrentMoose().size();
                data[2] = Test.simulator.getCurrentWolfs().size();
                return null;
            }
        };
        Thread thread = new Thread(test);
        thread.setDaemon(true);
        thread.start();
        i++;
        return data;
    }

    //used to add Data points to the Gui
    public void updateGui(Series series, int pop, int tick) {
        Data<Number, Number> temp = new Data<>(tick, pop);
        series.getData().add(temp);
    }

    public void start(Stage primaryStage) throws Exception {
        Test test = new Test();
        test.main(null);
        BorderPane borderPane = new BorderPane();

        //make hbox
        HBox hBox = new HBox();


        //creates the axis for chart
        NumberAxis yAxisMoose = new NumberAxis();
        NumberAxis yAxisWolf = new NumberAxis();
        NumberAxis xAxis = new NumberAxis();
        NumberAxis xAxis2 = new NumberAxis();
        xAxis2.setLabel("Ticks");
        xAxis.setLabel("Ticks");
        yAxisWolf.setLabel("Wolf");
        yAxisMoose.setLabel("Moose");


        //create graphs
        LineChart graphMoose = new LineChart(xAxis2, yAxisMoose);
        Series moose = new Series();
        moose.setName("Moose");
        LineChart graphWolf = new LineChart(xAxis, yAxisWolf);
        Series wolf = new Series();
        wolf.setName("Wolf");

        graphMoose.getData().add(moose);
        graphWolf.getData().add(wolf);

        //run

        //create 100 tick button
        Button tick100 = new Button("100 ticks");
        tick100.setOnAction(event -> {
            int j = 1;
            while (Test.simulator.getCurrentWolfs().size() != 0 && Test.simulator.getCurrentMoose().size() != 0 && j < 101) {
                Test.simulator.tick();
                System.out.println("Tick Number: " + i);
                System.out.println("There are " + Test.simulator.getCurrentMoose().size() + " Moose");
                System.out.println("There are " + Test.simulator.getCurrentWolfs().size() + " Wolves\n");
                if (i % 100 == 0) {
                    updateGui(moose, Test.simulator.getCurrentMoose().size(), i);
                    updateGui(wolf, Test.simulator.getCurrentWolfs().size(), i);
                }
                j++;
                i++;
            }
        });

        //create 1000 tick button
        Button tickThousand = new Button("1000 ticks");
        tickThousand.setOnAction(event -> {
            int j = 1;
            while (Test.simulator.getCurrentWolfs().size() != 0 && Test.simulator.getCurrentMoose().size() != 0 && j < 1001) {
                Test.simulator.tick();
                System.out.println("Tick Number: " + i);
                System.out.println("There are " + Test.simulator.getCurrentMoose().size() + " Moose");
                System.out.println("There are " + Test.simulator.getCurrentWolfs().size() + " Wolves\n");
                if (i % 100 == 0) {
                    updateGui(moose, Test.simulator.getCurrentMoose().size(), i);
                    updateGui(wolf, Test.simulator.getCurrentWolfs().size(), i);
                }
                j++;
                i++;
            }
        });

        // create start button uses orginial setup for updating graph (Does not live update)
        Button start = new Button("Start Simulation");

        start.setOnAction(event -> {
            while (Test.simulator.getCurrentWolfs().size() != 0 && Test.simulator.getCurrentMoose().size() != 0) {
                Test.simulator.tick();
                System.out.println("Tick Number: " + i);
                System.out.println("There are " + Test.simulator.getCurrentMoose().size() + " Moose");
                System.out.println("There are " + Test.simulator.getCurrentWolfs().size() + " Wolves\n");
                if (i % 100 == 0) {
                    updateGui(moose, Test.simulator.getCurrentMoose().size(), i);
                    updateGui(wolf, Test.simulator.getCurrentWolfs().size(), i);
                }
                i++;
            }
        });

        // uses new runTicks method, in hopes that thread would allow graph to update. (doesnt live update)
        Button startButton = new Button("start time");
        startButton.setOnAction(event -> {
            while (Test.simulator.getCurrentWolfs().size() != 0 && Test.simulator.getCurrentMoose().size() != 0) {
                int[] data = runTicks();
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    System.out.println("Thread sleep error");
                }
                if (i % 100 == 0) {
                    updateGui(moose, data[1], data[0]);
                    updateGui(wolf, data[2], data[0]);
                }
            }
        });


        hBox.setSpacing(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(start,startButton, tick100, tickThousand);

        borderPane.setBottom(hBox);
        borderPane.setTop(graphMoose);
        borderPane.setCenter(graphWolf);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
        graphMoose.setAnimated(false);
        graphWolf.setAnimated(false);

    }
}

