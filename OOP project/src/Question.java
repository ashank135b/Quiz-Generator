import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class Question {

    public static void modify(String sub, String type) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(12);

        Label l3 = new Label("Question No.:");
        GridPane.setConstraints(l3, 2, 3);

        TextField t = new TextField();
        GridPane.setConstraints(t, 3, 3);


        Button b1 = new Button("Select");
        GridPane.setConstraints(b1, 3, 4);

        b1.setOnAction(event -> {
            if (type.equals("MCQ")) {
                modifymcq(sub, type, t.getText());
            } else {
                modifyrest(sub, type, t.getText());
            }
        });


        grid.getChildren().addAll( l3,  t, b1);

        Scene scene = new Scene(grid, 300, 300);
        homescreen.window.setScene(scene);
    }

    public static void modifymcq(String sub, String type, String line) {
        String filename = "F:\\Files\\";
        filename += sub + type + ".txt";
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(12);

        Label l1 = new Label("Question:");
        GridPane.setConstraints(l1, 2, 1);
        Label l2 = new Label("Option1:");
        GridPane.setConstraints(l2, 2, 2);
        Label l3 = new Label("Option2:");
        GridPane.setConstraints(l3, 2, 3);
        Label l4 = new Label("Option3:");
        GridPane.setConstraints(l4, 2, 4);
        Label l5 = new Label("Answer:");
        GridPane.setConstraints(l5, 2, 5);

        TextField t1 = new TextField();
        GridPane.setConstraints(t1, 3, 1);
        TextField t2 = new TextField();
        GridPane.setConstraints(t2, 3, 2);
        TextField t3 = new TextField();
        GridPane.setConstraints(t3, 3, 3);
        TextField t4 = new TextField();
        GridPane.setConstraints(t4, 3, 4);
        TextField t5 = new TextField();
        GridPane.setConstraints(t5, 3, 5);

        Button b = new Button("Modify");
        GridPane.setConstraints(b, 3, 6);

        grid.getChildren().addAll(l1,l2,l3,l4,l5,t1,t2,t3,t4,t5,b);

        String finalFilename = filename;
        b.setOnAction(event -> {

            try (Scanner read = new Scanner(new File(finalFilename))) {
                int n = 0;
                read.useDelimiter("\n");
                ArrayList<String> data = new ArrayList<String>();
                while (read.hasNext()) {
                    data.add(read.next());
                    n++;
                }
                int num = Integer.parseInt(line);
                data.remove(num - 1);
                String q = t1.getText();
                String op1 = t2.getText();
                String op2 = t3.getText();
                String op3 = t4.getText();
                String ans = t5.getText();
                String content = q + " " + op1 + " " + op2 + " " + op3 + "*" + ans + "\n";
                data.add(num - 1, content);
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(finalFilename))) {
                    for (int i = 0; i < n; i++) {
                        bw.write(data.get(i) + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            homescreen.window.setScene(AdminWindow.scene);

        });

        Scene scene = new Scene(grid, 300, 300);
        homescreen.window.setScene(scene);
    }

    public static void modifyrest(String sub, String type, String line) {
        String filename = "F:\\Files\\";
        filename += sub + type + ".txt";
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(12);

        Label l1 = new Label("Question:");
        GridPane.setConstraints(l1, 2, 1);
        Label l2 = new Label("Answer:");
        GridPane.setConstraints(l2, 2, 2);

        TextField t1 = new TextField();
        GridPane.setConstraints(t1, 3, 1);
        TextField t2 = new TextField();
        GridPane.setConstraints(t2, 3, 2);

        Button b = new Button("Modify");
        GridPane.setConstraints(b, 3, 3);

        grid.getChildren().addAll(l1,l2,t1,t2,b);

        String finalFilename = filename;
        b.setOnAction(event -> {

            try (Scanner read = new Scanner(new File(finalFilename))) {
                int n = 0;
                read.useDelimiter("\n");
                ArrayList<String> data = new ArrayList<String>();
                while (read.hasNext()) {
                    data.add(read.next());
                    n++;
                }
                int num = Integer.parseInt(line);
                data.remove(num - 1);
                String q = t1.getText();
                String ans = t2.getText();
                String content = q + "*" + ans + "\n";
                data.add(num - 1, content);
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(finalFilename))) {
                    for (int i = 0; i < n; i++) {
                        bw.write(data.get(i) + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            homescreen.window.setScene(AdminWindow.scene);

        });

        Scene scene = new Scene(grid, 300, 300);
        homescreen.window.setScene(scene);
    }

    public static void delete(String sub, String type) {
        String filename = "F:\\Files\\";
        filename += sub + type + ".txt";
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(12);

        Label l3 = new Label("Question No.:");
        GridPane.setConstraints(l3, 2, 2);

        TextField t = new TextField();
        GridPane.setConstraints(t, 3, 2);

        Button b1 = new Button("Submit");
        GridPane.setConstraints(b1, 3, 4);

        String finalFilename = filename;
        String finalFilename1 = filename;
        b1.setOnAction(event -> {
            try (Scanner read = new Scanner(new File(finalFilename))) {
                int n = 0;
                read.useDelimiter("\n");
                ArrayList<String> data = new ArrayList<String>();
                while (read.hasNext()) {
                    data.add(read.next());
                    n++;
                }
                int num = Integer.parseInt(t.getText());
                data.remove(num - 1);
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(finalFilename1))) {
                    for (int i = 0; i < n - 1; i++) {
                        bw.write(data.get(i) + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            homescreen.window.setScene(AdminWindow.scene);

        });


        grid.getChildren().addAll( l3, t, b1);

        Scene scene = new Scene(grid, 300, 300);
        homescreen.window.setScene(scene);
    }

    public static void insertmcq(String sub, String type) {
        String filename = "F:\\Files\\";
        filename += sub + type + ".txt";
        GridPane grid = new GridPane();
        System.out.println(filename);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(12);

        Label l1 = new Label("Question:");
        GridPane.setConstraints(l1, 2, 1);
        Label l2 = new Label("Option 1:");
        GridPane.setConstraints(l2, 2, 2);
        Label l3 = new Label("Option 2:");
        GridPane.setConstraints(l3, 2, 3);
        Label l4 = new Label("Option 3:");
        GridPane.setConstraints(l4, 2, 4);
        Label l5 = new Label("Answer:");
        GridPane.setConstraints(l5, 2, 5);


        TextField t1 = new TextField();
        GridPane.setConstraints(t1, 3, 1);
        TextField t2 = new TextField();
        GridPane.setConstraints(t2, 3, 2);
        TextField t3 = new TextField();
        GridPane.setConstraints(t3, 3, 3);
        TextField t4 = new TextField();
        GridPane.setConstraints(t4, 3, 4);
        TextField t5 = new TextField();
        GridPane.setConstraints(t5, 3, 5);

        Button b = new Button("Submit");
        GridPane.setConstraints(b, 3, 6);

        String finalFilename = filename;
        b.setOnAction(event -> {
            String q = t1.getText();
            String op1 = t2.getText();
            String op2 = t3.getText();
            String op3 = t4.getText();
            String ans = t5.getText();
            String content = q + " " + op1 + " " + op2 + " " + op3 + "*" + ans + "\n";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(finalFilename, true))) {
                bw.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
            homescreen.window.setScene(AdminWindow.scene);
        });

        grid.getChildren().addAll(l1, l2, l3, l4, l5, t1, t2, t3, t4, t5, b);


        Scene scene = new Scene(grid, 300, 300);
        homescreen.window.setScene(scene);
    }

    public static void insertrest(String sub, String type) {
        String filename = "F:\\Files\\";
        filename += sub + type + ".txt";
        System.out.println(sub + type);
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(12);

        Label l1 = new Label("Question:");
        GridPane.setConstraints(l1, 2, 1);
        Label l2 = new Label("Answer:");
        GridPane.setConstraints(l2, 2, 2);

        TextField t1 = new TextField();
        GridPane.setConstraints(t1, 3, 1);
        TextField t2 = new TextField();
        GridPane.setConstraints(t2, 3, 2);


        Button b = new Button("Submit");
        GridPane.setConstraints(b, 3, 3);

        String finalFilename = filename;
        b.setOnAction(event -> {
            String q = t1.getText();
            String ans = t2.getText();

            String content = q + "*" + ans + "\n";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(finalFilename, true))) {
                bw.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
            homescreen.window.setScene(AdminWindow.scene);
        });

        grid.getChildren().addAll(l1, l2, t1, t2, b);


        Scene scene = new Scene(grid, 300, 300);
        homescreen.window.setScene(scene);
    }
}