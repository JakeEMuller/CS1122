// IMPORTS
// These are some classes that may be useful for completing the project.
// You may have to add others.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.web.WebHistory;
import javafx.stage.Stage;
import javafx.concurrent.Worker.State;
import javafx.scene.text.Text;

/**
 * The main class for Week6Lab. Week6Lab constructs the JavaFX window and
 * handles interactions with the dynamic components contained therein.
 */
public class WebBrowser extends Application {
    // INSTANCE VARIABLES
    // These variables are included to get you started.
    private Stage stage = null;
    private BorderPane borderPane = null;
    private WebView view = null;
    private WebEngine webEngine = null;
    private WebHistory webHistory = null;
    private Text statusbar = null;
    private TextField URLfield = null;
    private Button help = null;
    private Button search = null;
    private Button forward = null;
    private Button back = null;


    // HELPER METHODS

    /**
     * Retrieves the value of a command line argument specified by the index.
     *
     * @param index - position of the argument in the args list.
     * @return The value of the command line argument.
     */
    private String getParameter(int index) {
        Parameters params = getParameters();
        List<String> parameters = params.getRaw();
        return !parameters.isEmpty() ? parameters.get(index) : "";
    }

    /**
     * Creates a WebView which handles mouse and some keyboard events, and
     * manages scrolling automatically, so there's no need to put it into a ScrollPane.
     * The associated WebEngine is created automatically at construction time.
     *
     * @return browser - a WebView container for the WebEngine.
     */
    private WebView makeHtmlView() {
        view = new WebView();
        webEngine = view.getEngine();
        return view;
    }

    /**
     * Generates the status bar layout and text field.
     *
     * @return statusbarPane - the HBox layout that contains the statusbar.
     */
    private HBox makeStatusBar() {
        HBox statusbarPane = new HBox();
        statusbarPane.setPadding(new Insets(5, 4, 5, 4));
        statusbarPane.setSpacing(10);
//        statusbarPane.setStyle("-fx-background-color: #336699;");
        statusbar = new Text();
        HBox.setHgrow(statusbar, Priority.ALWAYS);
        statusbarPane.getChildren().addAll(statusbar);
        return statusbarPane;
    }

    //make toolbar
    private HBox makeToolBar() {
        webHistory = webEngine.getHistory();
        HBox toolbar = new HBox(5);
        toolbar.setAlignment(Pos.CENTER);
        Label URLLabel = new Label("URL");
        back = new Button("<--");
        back.setOnAction(e -> {
            if (webHistory.getCurrentIndex() != 0) {
                int his = webHistory.getCurrentIndex();
                webHistory.go(-1);
            }
        });
        //forward button
        forward = new Button("-->");
        forward.setOnAction(e -> {
//          webEngine.executeScript("history.back()");
            int his = webHistory.getCurrentIndex();
            webHistory.go(+1);
        });
        //Search function
        URLfield = new TextField();
        toolbar.setHgrow(URLfield, Priority.ALWAYS);
        URLfield.setOnAction(e -> {
            if (URLfield.getText().contains("http://")) {
                webEngine.load(URLfield.getText());
            } else if (URLfield.getText().contains("www.") | URLfield.getText().contains("WWW.")) {
                webEngine.load("http://" + URLfield.getText());
            } else {
                String[] words = URLfield.getText().split(" ");
                String word = "";
                for (int i = 0; i < words.length; i++) {
                    word = word + "+" + words[i];
                }
                String cutDown = word.substring(1, word.length());
//                System.out.println(cutDown);
                webEngine.load("https://www.google.com/search?q=" + cutDown);
            }

        });
        search = new Button("Search");
        search.setOnAction(e -> {
            webEngine.load(URLfield.getText());
        });
        //help button
        help = new Button("?");
        help.setOnAction(e -> {
            webEngine.loadContent("" +
                    "<HTML>" +
                        "<HEAD>" +
                            "<TITLE>Help!</TITLE>" +
                        "</HEAD>" +
                        "<H1>This is a help page!</H1>" +
                        "<BODY>please type a correctly formated URL into the search bar (Example: http://www.mtu.edu )</BODY>");
        });

        toolbar.getChildren().addAll(back, forward, URLLabel, URLfield, search, help);
        return toolbar;
    }

    // REQUIRED METHODS

    /**
     * The main entry point for all JavaFX applications. The start method is
     * called after the init method has returned, and after the system is ready
     * for the application to begin running.
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     *
     * @param primaryStage - the primary stage for this application, onto which
     *                     the application scene can be set.
     */
    @Override
    public void start(Stage primaryStage) {
        // Build your window here.
        borderPane = new BorderPane();
        view = makeHtmlView();
        webEngine.setOnStatusChanged(event -> {
            statusbar.setText(event.getData());
        });
        HBox statusHBox = makeStatusBar();

        borderPane.setCenter(view);
        borderPane.setBottom(statusHBox);
        borderPane.setTop(makeToolBar());
        //sets button url search
        webEngine.load("http://www.google.com");
        statusbar.setText("This is the statusBar");

        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {
                    public void changed(ObservableValue ov, State oldState, State newState) {
                        if (newState == State.SUCCEEDED) {
                            URLfield.setText(webEngine.getLocation());
                            primaryStage.setTitle("CS1122 Web Browser: " + webEngine.getLocation());
                        }
                    }
                });

        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CS1122 Web Browser");
        primaryStage.show();
    }

    /**
     * The main( ) method is ignored in JavaFX applications.
     * main( ) serves only as fallback in case the application is launched
     * as a regular Java application, e.g., in IDEs with limited FX
     * support.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}