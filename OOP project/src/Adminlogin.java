import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Adminlogin {

    static Stage window;

    public static void display() {

        window = new Stage();

        window.setTitle("Login");
        window.initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(12);


        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 2, 1);


        TextField nameInput = new TextField("Admin1");
        GridPane.setConstraints(nameInput, 3, 1);


        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 2, 2);


        PasswordField passInput = new PasswordField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 3, 2);

        window.setOnCloseRequest(e -> closeprog());

        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 3, 3);


        loginButton.setOnAction(e -> {
            if(passInput.getText().equals("password")&&nameInput.getText().equals("Admin1"))
            {
                window.close();
            }
            else
            {
                passInput.clear();
                Label msg = new Label("Wrong Username or Password");
                msg.setTextFill(Color.rgb(210, 39, 30));
                GridPane.setConstraints(msg,3,4);
                grid.getChildren().add(msg);
            }
        });


        //loginButton.setOnAction(e -> window.close());



        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);

        Scene scene = new Scene(grid, 300, 150);
        window.setScene(scene);
        window.show();
    }
    public static void closeprog(){
        homescreen.window.setScene(homescreen.scene);
        window.close();
    }
}
