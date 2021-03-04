import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Okhandler implements EventHandler<ActionEvent>{
	
	@Override
	public void handle(ActionEvent e) {
		
		System.out.println("Ok Button Clicked");
	}
}
