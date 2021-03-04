import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MouseEvents extends Application {
	
	int x = 0; //Must be a final or instance variable...
	@Override
	public void start(Stage primaryStage) {
		
		//int x = 0; //...but not a local variable for a Lambda
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 350, 250);
		CustomColors[] cols = CustomColors.values();
		//Write a mouse tracker. Details in slide.
		//Also search up enums later.
		
		//Midterm
		//First part will be writing a JavaFX program
		//You can bring in a 8.5 x 11" cheat sheet both sides, handwritten only.
		
		Text txt = new Text(20,20,"Programming is fun");
		
		pane.getChildren().add(txt);
		
		scene.setOnKeyPressed/*MouseDragged*/(e -> {
			if(e.getCode() == KeyCode.DOWN) {
				txt.setY(txt.getY() + 10);
			}
			if(e.getCode() == KeyCode.UP) {
				txt.setY(txt.getY() - 10);
			}
			if(e.getCode() == KeyCode.RIGHT) {
				txt.setX(txt.getX() + 10);
				Color c = Color.valueOf(cols[x % cols.length] + "");
				x++;
				txt.setFill(c);
			}
			if(e.getCode() == KeyCode.LEFT) {
				txt.setX(txt.getX() - 10);
				//txt.setFill(Color.RED);
			}
			
			//else if(e.getCode() == KeyCode.UP)
			//txt.setY(e.getY());
			//This does not work on a StackPane
		});
		
		
        primaryStage.setTitle("Mouse Events");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	
	public static void main(String[] args)
	{
	    launch(args);
	}
}