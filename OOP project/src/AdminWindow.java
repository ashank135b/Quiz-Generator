import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;

import static javax.script.ScriptEngine.FILENAME;

public class AdminWindow {

    public static String filename;
    public static Scene scene;

    public static Scene display() {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(12);

        Label l1 = new Label("Choose Subject:");
        GridPane.setConstraints(l1, 2, 1);
        Label l2 = new Label("Choose fucnction:");
        GridPane.setConstraints(l2, 2, 2);
        Label l3 = new Label("Choose Pattern:");
        GridPane.setConstraints(l3, 2, 3);

        ChoiceBox<String> c1 = new ChoiceBox<String>();
        c1.getItems().addAll("Discrete", "OOP", "LCS");
        GridPane.setConstraints(c1, 3, 1);

        ChoiceBox<String> c2 = new ChoiceBox<String>();
        c2.getItems().addAll("Insert", "Modify", "Delete");
        GridPane.setConstraints(c2, 3, 2);

        ChoiceBox<String> c3 = new ChoiceBox<String>();
        c3.getItems().addAll("MCQ", "FIB", "TF");
        GridPane.setConstraints(c3, 3, 3);

        Button b = new Button("Back");
        b.setOnAction(e -> homescreen.window.setScene(homescreen.scene));
        GridPane.setConstraints(b, 3, 5);

        Button b1 = new Button("Proceed");
        GridPane.setConstraints(b1, 3, 4);


        b1.setOnAction(e -> {
            String sub, func, type;
            sub = c1.getValue();
            func = c2.getValue();
            type = c3.getValue();
            if (func.equals("Insert")) {
                if (type.equals("MCQ"))
                    Question.insertmcq(sub, type);
                else
                    Question.insertrest(sub, type);
            }
            if(func.equals("Delete"))
            {
                Question.delete(sub,type);
            }
            if(func.equals("Modify"))
            {
                Question.modify(sub,type);
            }

        });

        grid.getChildren().addAll(l1, l2, l3, c1, c2, c3, b, b1);

        scene = new Scene(grid, 300, 300);

        return scene;
    }
}