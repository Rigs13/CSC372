package mod3CTA;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.time.LocalDateTime;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JavaFXMenuExample extends Application{
	
	
	// override start() method for start of application
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// set title of primary stage
		primaryStage.setTitle("Menu Example");
		
		// create a root layout for the scene; use vBox
		VBox root = new VBox();
		// set the alignment of the vbox to top center
		root.setAlignment(Pos.TOP_CENTER);
		// set spacing between children of vbox root
		root.setSpacing(20);
		
		// create menu items
		MenuItem item1 = new MenuItem("Display Date/Time");
		MenuItem item2 = new MenuItem("Save Textbox");
		MenuItem item3 = new MenuItem("Randomize Color!");
		MenuItem item4 = new MenuItem("Exit");
		
		// create Date label
		Label dateLabel = new Label("Date/Time:");
		// create text field that updates with the date/time
		TextField dateText = new TextField();
		// ensure that dateText is not editable by the user
		dateText.setEditable(false);
		
		// create a hue label for menu option 3
		Label hueLabel = new Label("Current Hue: ");
		// create a text field that updates with randomized hue change; option 3 in menu
		TextField hueText = new TextField();
		// ensure that hueText is not editable by user
		hueText.setEditable(false);
		
		// create event handlers for each menu option
		
		// item1 event handling
		item1.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			// override handle() method to create custom action event handling
			@Override
			public void handle(ActionEvent event1) {
				// retrieve and format current date and time
				// formatter for date/time
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				// retrieve date/time
				LocalDateTime now = LocalDateTime.now();
				// combine format with current time
				String currentTime = dtf.format(now);
				// update date text field to current time
				dateText.setText(currentTime);
				
			}
		});
		
		// item2 event handling
		item2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			// override handle() method
			@Override
			public void handle(ActionEvent event2) { 
				// write text fields to a file
				// try and catch block with IOException for writing to file
				try {
					FileWriter fw = new FileWriter("log.txt", true);
					PrintWriter out = new PrintWriter(fw);
					
					// retrieve text field elements
					String dateInput = dateText.getText();
					String hueInput = hueText.getText();
					
					// Print information to the text file
					out.println();
					out.println("Date Update: " + dateInput);
					out.println("Hue Update: " + hueInput);
					out.println();
					
					// close the file
					out.close();
					
				} catch (IOException e) {
					// display Stack trace if IO exception occurs
					e.printStackTrace();
				}
			}
		});
		
		// item3 event handling
		item3.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			// override handle() method
			@Override
			public void handle(ActionEvent event3) {
				// use randomGreenColor() to create an rgb string
				String colorString = randomGreenColor();
				System.out.println(colorString);
				root.setStyle("-fx-background-color: " + colorString);
				hueText.setText(colorString);
			}
		});
		
		item4.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			// override handle() method
			@Override
			public void handle(ActionEvent event4) {
				// Exit program by closing the primary stage
				primaryStage.close();
			}
		});
		
		// create menuButton to add menuItems for drop down
		// null in constructor is space for adding graphic option
		Menu menu = new Menu("Options", null, item1, item2, item3, item4);
		
		// create a menu bar to add the menuButton to
		MenuBar menuBar = new MenuBar();
		// add the menu to the menuBar
		menuBar.getMenus().add(menu);
		
		// set the the width of the menuBar to match the stage
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		
		// create a grid pane to add the labels/text fields to
		GridPane gp = new GridPane();
		// center the grid pane position
		gp.setAlignment(Pos.CENTER);
		// set a vertical gap between rows
		gp.setVgap(20);
		// add labels and text fields
		gp.add(dateLabel, 0, 0);
		gp.add(dateText, 1, 0);
		gp.add(hueLabel, 0, 1);
		gp.add(hueText, 1, 1);
		

		// add the menuBar/grid pane to the root layout
		root.getChildren().add(menuBar);
		root.getChildren().add(gp);
		
		// update hueText to have root style (color)
		hueText.setText(root.getStyle());
		
		// create a scene to add hbox to; size: (200,100)
		Scene scene1 = new Scene(root, 300, 300);
		
		// add scene1 to the primary stage
		primaryStage.setScene(scene1);
		
		// make primaryStage visible
		primaryStage.show();
		
	}
	
	// method for creating random color hues of green
	private String randomGreenColor() {
		
		// create an instance of random
		Random rand = new Random();
		
		// generate a random hue of green (85 to 165 degrees in visual band)
		int hue = rand.nextInt(81) + 85;
		
		// convert to an rgb component
		float[] hsb = new float[] {hue / 360.0f, 1.0f, 1.0f};
		int rgb = java.awt.Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
		
		// extract the rgb components using bitwise shift
		int red = (rgb >> 16) & 0xFF;
		int green = (rgb >> 8) & 0xFF;
		int blue = rgb & 0xFF;
		
		// return the rgb string
		return String.format("rgb(%d, %d, %d)", red, green, blue);
		
		
	}
	
	// main method
	public static void main(String[] args) {
		// launch application
		launch();

	}

}
