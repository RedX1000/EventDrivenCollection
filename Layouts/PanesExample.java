import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class PanesExample extends Application{

	//February 2nd, 2020; Panes, H and Vgaps, and Insets
	
	@Override
	public void start(Stage primaryStage) {
		
		FlowPane fPane = new FlowPane();
		
		fPane.setStyle("-fx-background-color: gold;");
		//Insets ins = new Insets(10);
		//fPane.setPadding(ins);
		fPane.setHgap(20);
		fPane.setVgap(30);
		fPane.setPadding(new Insets(10));
		
		Image img = new Image("http://www.atchaba.com/CS317_1/US_Flag.png");
		
		ImageView imVw = new ImageView(img);
		imVw.setFitHeight(150);
		imVw.setFitWidth(250);
		
		ImageView imVw2 = new ImageView(img);
		imVw2.setFitHeight(150);
		imVw2.setFitWidth(250);
		
		ImageView imVw3 = new ImageView(img);
		imVw3.setFitHeight(300);
		imVw3.setFitWidth(500);
		
		fPane.getChildren().addAll(imVw, imVw2, imVw3	);
		
		Scene scene = new Scene(fPane, 800, 600);
		
		primaryStage.setTitle("Flow Pane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[]args){
		Application.launch(args);
	}
}
