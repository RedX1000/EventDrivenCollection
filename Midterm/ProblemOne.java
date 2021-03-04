import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProblemOne extends Application {
	
	int i = 0;
	int j = 0;
	
	public void start(Stage primaryStage) {
		
		BorderPane bp = new BorderPane();
		Text desc = new Text("Click the primary or secondary mouse button");
		Text recTxt = new Text("Rectangles: 0");
		Text cirTxt = new Text("Circles: 0");
		VBox vb = new VBox();
		vb.getChildren().addAll(desc, recTxt, cirTxt);
		vb.setAlignment(Pos.CENTER);
		bp.setBottom(vb);
		
		bp.setOnMousePressed( e -> {
			if(e.getButton() == MouseButton.PRIMARY) {
				Circle cir = new Circle(e.getX(), e.getY(), 20);
				cir.setFill(Color.RED);
				cir.setStroke(Color.RED);
				bp.getChildren().add(cir);
				i++;
				cirTxt.setText("Circles: "+ i);
			}
			else if(e.getButton() == MouseButton.SECONDARY) {
				Rectangle rec = new Rectangle(e.getX(), e.getY(), 30, 20);
				rec.setFill(Color.BLACK);
				rec.setStroke(Color.BLACK);
				bp.getChildren().add(rec);
				j++;
				recTxt.setText("Rectangles: "+ j);
			}
		});
		
		Scene scene = new Scene(bp, 600, 450);
		primaryStage.setTitle("Midterm Project");
    	primaryStage.setScene(scene);
    	primaryStage.show();
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}