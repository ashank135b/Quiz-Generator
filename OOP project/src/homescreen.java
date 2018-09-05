import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static javafx.application.Application.launch;



public class homescreen extends Application {

    static Stage window;
    static Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Quiz");
        Button b1 = new Button("Take Quiz");
        Button b2 = new Button("Admin Login");
        Button b3 = new Button("Close");

        Label label = new Label("Welcome");
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label,b1,b2,b3);
        scene = new Scene(layout,300,300);

        b1.setOnAction(e -> window.setScene(Choose.display()));
        b2.setOnAction(e -> {
            window.setScene(AdminWindow.display());
            Adminlogin.display();
        });
        b3.setOnAction(e -> window.close());

        window.setScene(scene);
        window.setTitle("Questionnaire");
        window.show();

        login.display();
    }
}
