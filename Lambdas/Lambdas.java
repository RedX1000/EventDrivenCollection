import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class Lambdas extends Application {

	Circle cir = new Circle(30);
	
	@Override
	public void start(Stage primaryStage) {
		
		BorderPane bp = new BorderPane();
		StackPane sp = new StackPane();
		HBox buttons = new HBox();
		buttons.setSpacing(15);
		
		sp.getChildren().add(cir);
		
		Button btnEnlarge = new Button("Enlarge");
		Button btnShrink = new Button("Shrink");
		buttons.getChildren().addAll(btnEnlarge, btnShrink);
		buttons.setAlignment(Pos.CENTER);
		bp.setBottom(buttons);
		bp.setCenter(sp);
		
		btnEnlarge.setOnAction((e) -> enlarge());
		
		
		/*(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(cir.getRadius() != 100)
					cir.setRadius(cir.getRadius() + 5);
			}
		});*/
		
		btnShrink.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(cir.getRadius() != 5)
					cir.setRadius(cir.getRadius() - 5);
			}
		});
		
		Scene scene = new Scene(bp, 500, 400);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Lambdas");
		primaryStage.show();
	}
	
	public void enlarge() {
		cir.setRadius(cir.getRadius() + 5);
	}
	
	
	public static void main(String[]args){
		Application.launch(args);
	}
}
