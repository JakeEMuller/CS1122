import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Problem1 extends Application {

    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 500);

        //draws the sky
        Rectangle sky = new Rectangle();
        sky.setX(0);
        sky.setY(0);
        sky.setHeight(1200);
        sky.setWidth(1200);
        sky.setStroke(Color.SKYBLUE);
        sky.setFill(Color.SKYBLUE);
        root.getChildren().add(sky);

        //draws the sun
        Circle sun = new Circle();
        sun.setCenterX(150);
        sun.setCenterY(250);
        sun.setRadius(125);
        sun.setStroke(Color.STEELBLUE);
        sun.setFill(Color.YELLOW);
        root.getChildren().add(sun);

        //draws the grass
        Rectangle grass = new Rectangle();
        grass.setX(0);
        grass.setY(350);
        grass.setWidth(600);
        grass.setHeight(200);
        grass.setFill(Color.GREEN);
        root.getChildren().add(grass);

        //draws tree stump
        Rectangle trunk = new Rectangle(90,280,30,120);
        trunk.setStroke(Color.BROWN);
        trunk.setFill(Color.BROWN);
        root.getChildren().add(trunk);
        //draws tree top
        Polygon tree = new Polygon();
        tree.getPoints().setAll(
                70.,330.,
                140.,330.,
                105.,180.
        );
        tree.setStroke(Color.BLACK);
        tree.setFill(Color.LAWNGREEN);
        root.getChildren().add(tree);


        //draws base of the house
        Rectangle house = new Rectangle();
        house.setX(320);
        house.setY(275);
        house.setHeight(125);
        house.setWidth(170);
        house.setStroke(Color.BLACK);
        house.setFill(Color.WHITE);
        root.getChildren().add(house);

        //draws the door
        Rectangle door = new Rectangle();
        door.setX(335);
        door.setY(295);
        door.setWidth(50);
        door.setHeight(90);
        door.setStroke(Color.BLACK);
        door.setFill(Color.RED);
        root.getChildren().add(door);

        //draws the Roof
        Polygon roof = new Polygon();
        roof.getPoints().setAll(
                300.,275.,
                510.,275.,
                405.,225.
        );
        roof.setStroke(Color.BLACK);
        roof.setFill(Color.BLACK);
        root.getChildren().add(roof);

        //draws the window
        Rectangle window = new Rectangle();
        window.setX(410);
        window.setY(295);
        window.setWidth(50);
        window.setHeight(50);
        window.setStroke(Color.BLACK);
        window.setFill(Color.SKYBLUE);
        root.getChildren().add(window);
        //vertical pane for window
        Line vertPane = new Line();
        vertPane.setStartX(435);
        vertPane.setStartY(345);
        vertPane.setEndX(435);
        vertPane.setEndY(295);
        vertPane.setStroke(Color.BLACK);
        root.getChildren().add(vertPane);
        //horizontal pane for window
        Line horPane = new Line();
        horPane.setStartX(410);
        horPane.setEndX(460);
        horPane.setStartY(320);
        horPane.setEndY(320);
        horPane.setStroke(Color.BLACK);
        root.getChildren().add(horPane);

        stage.setTitle("House");
        stage.setScene( scene );
        stage.show();
    }
}
