import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {
	
	Circle cir;
	Rectangle rec;
	@Override
	public void start(Stage primaryStage) {

		cir = new Circle(150, 150, 155);
		cir.setFill(Color.TRANSPARENT);
		cir.setStroke(Color.RED);
		
		rec = new Rectangle(40,40, Color.CHOCOLATE);
		
		Pane pane = new Pane();
		pane.getChildren().addAll(cir, rec);
		
		Scene scene = new Scene(pane, 400, 400);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(new Duration(5000));
		pt.setPath(cir);
		pt.setNode(rec);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setInterpolator(Interpolator.LINEAR);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.play();
		
		scene.setOnMouseClicked( e -> {
			if(pt.getStatus() == Animation.Status.RUNNING)
				pt.pause();
			else if(pt.getStatus() == Animation.Status.PAUSED)
				pt.play();
		});
		
		
		
		primaryStage.setTitle("Animations");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	
	public static void main(String[] args)
	{
	    launch(args);
	}

}