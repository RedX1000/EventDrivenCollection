import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class JavaFX extends Application{
	
	
	// February, 3rd, 2020, Basics of JavaFX
	// February, 5th, 2020, Colors, Rectangles, and Images
	
	@Override
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		
		
		Image img = new Image("images/US_Flag.png");
		//Image img = new Image("http://www.atchaba.com/CS317_1/Smile.jpeg"); //Holds the image
		ImageView imgVw = new ImageView(img); //Allows viewing of image
		
		imgVw.setFitHeight(200); //Sets height
		imgVw.setFitWidth(200);// Sets width 
		
		
		imgVw.setRotate(180);// Rotates object
		
		pane.getChildren().add(imgVw);
		Rectangle rec = new Rectangle(100, 60);
		rec.setRotate(55);
		
		pane.getChildren().add(rec);
		
		Button btnOk = new Button("Ok");
		Circle cir1 = new Circle(100);
		Circle cir2 = new Circle(60);
		cir2.setFill(Color.RED);
		cir1.radiusProperty().bind(pane.widthProperty().multiply(0.4).add(30));
		pane.getChildren().addAll(cir1, cir2, btnOk);
		
		//pane.getChildren().add(btnOk);
		//pane.getChildren().add(cir2);
		
		//addAll adds them all in order to the stack.
		
		//Order matters, otherwise the button will be
		//underneath the circle.
		
		//Anything that you can see in your GUI is a Node
		
		//For binding, the scene is the Source
		//and the circle is the Target.
		//Changing the Source will change the target.
		
		Scene scene = new Scene(pane, 400, 400);
		
		//Scene must be created first before setting the properties.
		
		imgVw.fitWidthProperty().bind(scene.widthProperty());
		imgVw.fitHeightProperty().bind(scene.heightProperty());
		
		primaryStage.setTitle("Title Of Stage");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[]args){
		Application.launch(args);
	}
	
}
