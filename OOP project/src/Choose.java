import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Choose {
    public static Scene display() {


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(12);

        Button b = new Button("Back");
        GridPane.setConstraints(b, 3, 6);
        b.setOnAction(e -> homescreen.window.setScene(homescreen.scene));

        Label nameLabel = new Label("Subject:");
        GridPane.setConstraints(nameLabel, 2, 1);

        ChoiceBox<String> c1 = new ChoiceBox<String>();
        c1.getItems().addAll("Discrete", "OOP", "LCS");
        GridPane.setConstraints(c1, 3, 1);

        Label typeLable = new Label("Type:");
        GridPane.setConstraints(typeLable, 2, 2);

        ChoiceBox<String> c3 = new ChoiceBox<String>();
        c3.getItems().addAll("MCQ", "FIB", "TF");
        GridPane.setConstraints(c3, 3, 2);

        Label passLabel = new Label("No. of Questions:");
        GridPane.setConstraints(passLabel, 2, 3);

        TextField c2 = new TextField();
        GridPane.setConstraints(c2, 3, 3);

        ChoiceBox<String> c = new ChoiceBox<String>();
        c.getItems().addAll("Answer","Question");
        GridPane.setConstraints(c, 3, 4);

        b = new Button("Generate");
        GridPane.setConstraints(b, 3, 5);

        b.setOnAction(event -> {
            String sub = c1.getValue();
            String qtype = c3.getValue();
            String filename = "F:\\Files\\" + sub + qtype + ".txt";

            int tempn = Integer.parseInt(c2.getText());
            int n = 0;
		int counter = 0;
		//filename += sub + qtype + ".txt";
		try (Scanner read = new Scanner(new File(filename)))
		{
			read.useDelimiter("\n");
			ArrayList<String> data = new ArrayList<String>();
			while(read.hasNext())
			{
				data.add(read.next());
				n++;
			}

			Random random = new Random();
			if(n<tempn) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Not enough questions in the database");
                new Choose();
            }
			int randomInt = random.nextInt(n-tempn);

            File f = new File("F:\\Adocfile.txt");
            f.delete();
            f = new File("F:\\Qdocfile.txt");
            f.delete();

			for(int i = randomInt; i < n; i++)
			{
				counter++;
				String[] arr = (data.get(i)).split("\\*");
				if(c.getValue().equalsIgnoreCase("Answer"))
                {
					//output.append("Ans." + (counter) + ": " + arr[1] + "\n");
					try(BufferedWriter bwa = new BufferedWriter(new FileWriter("F:\\Adocfile.txt", true)))
					{
						String s = "Ans." + Integer.toString(counter) + ": " + arr[1] + "\n\n";
						bwa.write(s + "\n\n");
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
				}
				else
				{

					//output.append("Q." + (counter) + ": " + arr[0] + "\n");
					try(BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\Qdocfile.txt", true)))
					{
						String s = "Q." + Integer.toString(counter) + ": " + arr[0] + "\n\n";
						bw.write(s+"\n\n");
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
				}

				if(counter == tempn)
					break;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		JFrame f = new JFrame();
		JOptionPane.showMessageDialog(f,"Export Successful!");

        });


        grid.getChildren().addAll(nameLabel, c1, passLabel, c2, c, b, c3, typeLable);

        Scene scene = new Scene(grid, 300, 300);

        return scene;
    }
}

