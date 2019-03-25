import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.concurrent.Task;

public class Program3Gui extends Application {
    private boolean update100Ticks = false;
    AnimationTimer timer;

    // animation so that the graph will update live while the program is running.
    public void animate(Series moose, Series wolf) {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (Test.simulator.getCurrentWolfs().size() != 0 && Test.simulator.getCurrentMoose().size() != 0) {
                    Test.simulator.tick();
                    System.out.println("Tick Number: " + Test.simulator.tick);
                    System.out.println("There are " + Test.simulator.getCurrentMoose().size() + " Moose");
                    System.out.println("There are " + Test.simulator.getCurrentWolfs().size() + " Wolves\n");
                    if(update100Ticks){
                        if (Test.simulator.tick % 100 == 0) {
                            updateGui(moose, Test.simulator.getCurrentMoose().size(), Test.simulator.tick);
                            updateGui(wolf, Test.simulator.getCurrentWolfs().size(), Test.simulator.tick);
                        }
                    } else {
                        updateGui(moose, Test.simulator.getCurrentMoose().size(), Test.simulator.tick);
                        updateGui(wolf, Test.simulator.getCurrentWolfs().size(), Test.simulator.tick);
                    }

                }
            }
        };
        timer.start();

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
        xAxis2.setTickUnit(1000);
        xAxis.setLabel("Ticks");
        xAxis.setTickUnit(1000);
        yAxisWolf.setLabel("Wolf");
        yAxisWolf.setTickUnit(5);
        yAxisMoose.setLabel("Moose");
        yAxisMoose.setTickUnit(500);


        //create graphs
        LineChart graphMoose = new LineChart(xAxis2, yAxisMoose);
        Series moose = new Series();
        moose.setName("Moose");
        LineChart graphWolf = new LineChart(xAxis, yAxisWolf);
        Series wolf = new Series();
        wolf.setName("Wolf");

        graphMoose.getData().add(moose);
        graphWolf.getData().add(wolf);


        //create 100 tick button (for testing purposes)
        Button tick100 = new Button("100 ticks");
        tick100.setOnAction(event -> {
            int j = 1;
            while (Test.simulator.getCurrentWolfs().size() != 0 && Test.simulator.getCurrentMoose().size() != 0 && j < 101) {
                Test.simulator.tick();
                System.out.println("Tick Number: " + Test.simulator.tick);
                System.out.println("There are " + Test.simulator.getCurrentMoose().size() + " Moose");
                System.out.println("There are " + Test.simulator.getCurrentWolfs().size() + " Wolves\n");
                updateGui(moose, Test.simulator.getCurrentMoose().size(), Test.simulator.tick);
                updateGui(wolf, Test.simulator.getCurrentWolfs().size(), Test.simulator.tick);
                j++;
            }
        });

        //create 1000 tick button (For testing purposes)
        Button tickThousand = new Button("1000 ticks");
        tickThousand.setOnAction(event -> {
            int j = 1;
            while (Test.simulator.getCurrentWolfs().size() != 0 && Test.simulator.getCurrentMoose().size() != 0 && j < 1001) {
                Test.simulator.tick();
                System.out.println("Tick Number: " + Test.simulator.tick);
                System.out.println("There are " + Test.simulator.getCurrentMoose().size() + " Moose");
                System.out.println("There are " + Test.simulator.getCurrentWolfs().size() + " Wolves\n");
                updateGui(moose, Test.simulator.getCurrentMoose().size(), Test.simulator.tick);
                updateGui(wolf, Test.simulator.getCurrentWolfs().size(), Test.simulator.tick);
                j++;
            }
        });

        // create start button uses orginial setup for updating graph (Does not live update)
        Button start = new Button("Start Simulation");
        start.setOnAction(event -> {
            animate(moose, wolf);

        });

        // create stop button to stop simulation
        Button stop = new Button("Stop Simuilation");
        stop.setOnAction(event -> {
            timer.stop();
        });

        // creates checkbox to determine how often the graph updates
        CheckBox per100Tick = new CheckBox("Update every 100 ticks");
        per100Tick.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(per100Tick.isSelected()){
                    update100Ticks = true;
                } else if(!per100Tick.isSelected()){
                    update100Ticks = false;
                }
            }
        });


        // hbox final setup
        hBox.setSpacing(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(start,stop,per100Tick);
        graphMoose.setAnimated(false);
        graphWolf.setAnimated(false);

        // borderpane setup
        borderPane.setBottom(hBox);
        borderPane.setTop(graphMoose);
        borderPane.setCenter(graphWolf);

        // scene and stage setup
        Scene scene = new Scene(borderPane,1200,800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

