import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EventExample extends Application {

	@Override
	public void start(Stage primaryStage) {
		HBox hBox = new HBox();
		Button btnOk = new Button("Ok");
		Button btnCancel = new Button("Cancel");
		Button btnNext = new Button("Next");
		
		hBox.setSpacing(30);
		Okhandler okH = new Okhandler();
		btnOk.setOnAction(okH);
		
		CancelHandler cnH = new CancelHandler();
		btnCancel.setOnAction(cnH);
		
		btnNext.setOnAction(new EventHandler<ActionEvent>() { 
			@Override 
			public void handle(ActionEvent e) {
				System.out.println("Next Button Clicked");
			}
		});
		
		hBox.getChildren().addAll(btnOk, btnCancel, btnNext);
		
		Scene scene = new Scene(hBox, 300, 250);
		primaryStage.setTitle("Show Rectangle");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[]args) {
		
		Application.launch(args);
	}
	
	class CancelHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent e) {
			System.out.println("Cancel Button Clicked");
		}
	}
}