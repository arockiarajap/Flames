/**
 * 
 */
package com;

import java.io.File;

import com.datastructures.FlamesEngine;
import com.datastructures.Person;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * App - is the trigger point for this JAVAFX application
 * 
 * @author Arockia
 *
 */
public class App extends Application {

	FlamesEngine flamesEngine;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("FLAMES : A Funny Relationship Game");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(20);
		grid.setPadding(new Insets(30, 25, 25, 25));

		Label maleName = new Label("Your Good name:");
		maleName.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 14));
		grid.add(maleName, 0, 0);
		TextField maleFirstName = new TextField();
		maleFirstName.setPromptText("First Name");
		grid.add(maleFirstName, 1, 0);
		TextField maleMiddleName = new TextField();
		maleMiddleName.setPromptText("Middle Name");
		grid.add(maleMiddleName, 3, 0);
		TextField maleLastName = new TextField();
		maleLastName.setPromptText("Last Name");
		grid.add(maleLastName, 4, 0);

		Label femaleName = new Label("Your Partner name:");
		femaleName.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 14));
		grid.add(femaleName, 0, 1);
		TextField femaleFirstName = new TextField();
		femaleFirstName.setPromptText("First Name");
		grid.add(femaleFirstName, 1, 1);
		TextField femaleMiddleName = new TextField();
		femaleMiddleName.setPromptText("Middle Name");
		grid.add(femaleMiddleName, 3, 1);
		TextField femaleLastName = new TextField();
		femaleLastName.setPromptText("Last Name");
		grid.add(femaleLastName, 4, 1);

		Button goOn = new Button("Go on!!");
		Button newNamesBtn = new Button("New Names Again!!");
		HBox hbBtn = new HBox(30);
		hbBtn.setAlignment(Pos.BOTTOM_CENTER);
		hbBtn.getChildren().add(goOn);
		hbBtn.getChildren().add(newNamesBtn);
		grid.add(hbBtn, 1, 2);

		Text headerLable = new Text();
		headerLable.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		headerLable.setText(" ");
		grid.add(headerLable, 0, 4, 4, 2);

		goOn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				if (!headerLable.getText().equals(" ")) {
					headerLable.setText(" ");
					grid.getChildren().remove(10);
				}
				flamesEngine = new FlamesEngine();
				Person male = new Person(maleFirstName.getText(), maleMiddleName.getText(), maleLastName.getText());
				Person female = new Person(femaleFirstName.getText(), femaleMiddleName.getText(),
						femaleLastName.getText());
				flamesEngine.setMale(male);
				flamesEngine.setFemale(female);
				String relationShip = flamesEngine.process();
				headerLable.setText("The RelationShip Which You Both May Fit In");
				File file = new File(relationShip);
				Image image = new Image(file.toURI().toString());
				ImageView imageView = new ImageView(image);
				imageView.setFitHeight(300);
				imageView.setFitWidth(300);
				grid.add(imageView, 1, 5, 4, 4);
			}
		});

		newNamesBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				if (!headerLable.getText().equals(" ")) {
					headerLable.setText(" ");
					grid.getChildren().remove(10);
					maleFirstName.setText("");
					maleMiddleName.setText("");
					maleLastName.setText("");
					femaleFirstName.setText("");
					femaleMiddleName.setText("");
					femaleLastName.setText("");
					maleFirstName.requestFocus();
				}
			}
		});

		final Scene scene = new Scene(grid, 850, 550, Color.BEIGE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
