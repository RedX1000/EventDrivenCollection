package finalprojectpkg;

import javafx.application.*;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.*;

import java.math.*;

public class Calculator extends Application{

	private Scene scene;
	private BorderPane calcPane = new BorderPane();

	BigDecimal bdOne = BigDecimal.ZERO;
	BigDecimal bdTwo = BigDecimal.ZERO;

	BigDecimal bdTotal = BigDecimal.ZERO;

	final BigDecimal ONE = BigDecimal.ONE;
	final BigDecimal TWO = new BigDecimal("2");

	boolean[] operation = new boolean[6];


	Text txtAnswer = new Text("0");
	HBox hbAnswer = new HBox();

	TextField tfCurrValue = new TextField();
	HBox hbCurrValue = new HBox();

	VBox vbTop = new VBox();
	String[] sNumbers = {"7","8","9","+","%","Clear","4","5","6","-","x!","x\u00B2","1","2","3",
						 "*","\u00B2\u221A","x\u00B3","0",".","\u00F7","\u00B3\u221A","x\u207F"};

	Button[] btnNumbers = new Button[23];

	Button btnEquals = new Button("=");
	HBox hbEquals = new HBox();

	StackPane[] spButtons = new StackPane[23];

	@Override
	public void start(Stage primaryStage) {

		scene = new Scene(calcPane, 470, 300);
		setUpTop();
		setUpGrid();
		setUpBottom();
		buttonFunctions();

		primaryStage.setTitle("Calculator Final Project");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void setUpTop() {
		txtAnswer.setFont(Font.font(20));
		hbAnswer.getChildren().add(txtAnswer);
		hbAnswer.setAlignment(Pos.CENTER_LEFT);
		hbAnswer.setPadding(new Insets(10));

		tfCurrValue.setPrefWidth(scene.getWidth() - 25);
		hbCurrValue.getChildren().add(tfCurrValue);
		hbCurrValue.setAlignment(Pos.CENTER_LEFT);

		vbTop.getChildren().addAll(hbAnswer, hbCurrValue);

		hbCurrValue.setPadding(new Insets(0, 0, 10, 12));

		hbAnswer.setPrefWidth(430);
		hbCurrValue.setPrefWidth(430);
		vbTop.setPrefWidth(465);

		calcPane.setTop(vbTop);
	}

	public void setUpGrid() {
		GridPane gp = new GridPane();

		for(int i = 0; i < 4; i++){
			RowConstraints row = new RowConstraints((scene.getHeight() - vbTop.getHeight() - 10)/7);
			gp.getRowConstraints().add(row);
		}
		for(int i = 0; i < 6; i++){
			ColumnConstraints col = new ColumnConstraints(((scene.getWidth()-5)/6));
			gp.getColumnConstraints().add(col);
		}

		for (int i = 0; i < sNumbers.length; i++) {
			Button btn = new Button(sNumbers[i]);
			if (i == 22 || i == 21 || i == 20)
				btn.setStyle("-fx-background-color: RGB(255, 133, 71)");
				// Yes, it's the exact same orange in your Demo.
			else if (i % 6 == 3 || i % 6 == 4 || i % 6 == 5)
				btn.setStyle("-fx-background-color: RGB(255, 133, 71)");

			if(i != 18)
				btn.setPrefWidth(((scene.getWidth() - 150)/6));
			else
				btn.setPrefWidth(((scene.getWidth() - 80)/3));

			btnNumbers[i] = btn;
		}

		for(int i = 0; i < btnNumbers.length; i++){
			StackPane sp = new StackPane();
			sp.getChildren().add(btnNumbers[i]);
			spButtons[i] = sp;
		}

		int index = 0;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 6; j++) {
				if(index == 23)
					break;

				if(index == 18) {
					gp.add(spButtons[index], j, i, 2, 1);
					j++;
				}
				else
					gp.add(spButtons[index], j, i);
				index++;
			}

		calcPane.setCenter(gp);
	}

	public void setUpBottom() {
		btnEquals.setPrefWidth(scene.getWidth() - 25);
		btnEquals.setStyle("-fx-background-color: RGB(255, 133, 71)");
		hbEquals.getChildren().add(btnEquals);
		hbEquals.setAlignment(Pos.TOP_LEFT);
		hbEquals.setPadding(new Insets(0,0,10,12));


		calcPane.setBottom(hbEquals);

	}

	public void buttonFunctions() {
		/*

		For reference:

		String[] sNumbers = {"7","8","9","+","%","Clear","4","5","6","-","x!","x\u00B2",
							 "1","2","3","*","\u00B2\u221A","x\u00B3","0",".","\u00F7","\u00B3\u221A","x\u207F"};

		-------------------------------------------------------------

		Okay, here's the array index for each button:

		-0   = Number 7		-10  = Factorial	-20  = Divide
		-1   = Number 8		-11  = Squared		-21  = Cubed Root
		-2   = Number 9		-12  = Number 1		-22  = To the Nth Power
		-3   = Plus			-13  = Number 2
		-4   = Modulus		-14  = Number 3
		-5   = Clear		-15  = Multiply
		-6   = Number 4		-16  = Square Root
		-7   = Number 5		-17  = Cubed
		-8   = Number 6		-18  = Number 0
		-9   = Minus 		-19  = Decimal Point

		Here are the operations for the boolean array indices:

		-0 	 = Plus
		-1 	 = Minus
		-2 	 = Multiply
		-3 	 = Divide
		-4 	 = Modulus
		-5 	 = Nth Power

		Hopefully this wont get too confusing... right?

		-------------------------------------------------------------

		*/

		// Events are labeled twice because it's easier to
		// read them when they're collapsed when using IntelliJ.

		Text txtToss = new Text("");
		Pane pane = new Pane();
		pane.getChildren().add(txtToss);
		pane.setLayoutX(5000);
		pane.setLayoutY(5000);
		calcPane.setRight(pane);
		pane.requestFocus();

		btnNumbers[18].setOnAction(e -> { // Number Zero
			tfCurrValue.setText(tfCurrValue.getText() + "0");
		}); // Number Zero
		btnNumbers[12].setOnAction(e -> { // Number One
			tfCurrValue.setText(tfCurrValue.getText() + "1");
		}); // Number One
		btnNumbers[13].setOnAction(e -> { // Number Two
			tfCurrValue.setText(tfCurrValue.getText() + "2");
		}); // Number Two
		btnNumbers[14].setOnAction(e -> { // Number Three
			tfCurrValue.setText(tfCurrValue.getText() + "3");
		}); // Number Three
		btnNumbers[6].setOnAction(e -> { // Number Four
			tfCurrValue.setText(tfCurrValue.getText() + "4");
		}); // Number Four
		btnNumbers[7].setOnAction(e -> { // Number Five
			tfCurrValue.setText(tfCurrValue.getText() + "5");
		}); // Number Five
		btnNumbers[8].setOnAction(e -> { // Number Six
			tfCurrValue.setText(tfCurrValue.getText() + "6");
		}); // Number Six
		btnNumbers[0].setOnAction(e -> { // Number Seven
			tfCurrValue.setText(tfCurrValue.getText() + "7");
		}); // Number Seven
		btnNumbers[1].setOnAction(e -> { // Number Eight
			tfCurrValue.setText(tfCurrValue.getText() + "8");
		}); // Number Eight
		btnNumbers[2].setOnAction(e -> { // Number Nine
			tfCurrValue.setText(tfCurrValue.getText() + "9");
		}); // Number Nine

		// ----------------------------------------------------------

		btnNumbers[19].setOnAction(e -> { // Decimal
			tfCurrValue.setText(tfCurrValue.getText() + ".");
		}); // Decimal

		// ----------------------------------------------------------

		btnNumbers[3].setOnAction(e -> { // Plus
			BigDecimal curr = new BigDecimal(tfCurrValue.getText());
			bdOne = curr;
			operation[0] = true;
			tfCurrValue.setText("");
		}); // Plus
		btnNumbers[9].setOnAction(e -> { // Minus
			BigDecimal curr = new BigDecimal(tfCurrValue.getText());
			bdOne = curr;
			operation[1] = true;
			tfCurrValue.setText("");
		}); // Minus
		btnNumbers[15].setOnAction(e -> { // Multiply
			BigDecimal curr = new BigDecimal(tfCurrValue.getText());
			bdOne = curr;
			operation[2] = true;
			tfCurrValue.setText("");
		}); // Multiply
		btnNumbers[20].setOnAction(e -> { // Divide
			BigDecimal curr = new BigDecimal(tfCurrValue.getText());
			bdOne = curr;
			operation[3] = true;
			tfCurrValue.setText("");
		}); // Divide
		btnNumbers[4].setOnAction(e -> { // Modulus
			BigDecimal curr = new BigDecimal(tfCurrValue.getText());
			bdOne = curr;
			operation[4] = true;
			tfCurrValue.setText("");
		}); // Modulus

		// ----------------------------------------------------------

		btnNumbers[5].setOnAction(e -> { // Clear
			tfCurrValue.setText("");
			txtAnswer.setText("0");
			for(int i = 0; i < operation.length; i++)
				operation[i] = false;
		}); // Clear

		// ----------------------------------------------------------

		btnNumbers[11].setOnAction(e -> { // Squared
			BigDecimal curr = new BigDecimal(tfCurrValue.getText());
			BigDecimal result = curr.pow(2);
			bdTotal = result;
			if(bdTotal.toString().length() > 25){
				Text txtOne = new Text(curr+"\u00B2 = ");
				Text txtTwo = new Text(bdTotal.toString());
				TextFlow txtFl = new TextFlow(txtOne, txtTwo);
				Scene currScene = new Scene(txtFl, 400, 300);
				Stage currStage = new Stage();
				currStage.setScene(currScene);
				currStage.show();
				txtAnswer.setText("Too Big! Check the Popup!");
			}
			else
				txtAnswer.setText(curr+"\u00B2 = "+bdTotal);
			tfCurrValue.setText("");
		}); // Squared
		btnNumbers[17].setOnAction(e -> { // Cubed
			BigDecimal curr = new BigDecimal(tfCurrValue.getText());
			BigDecimal result = curr.pow(3);
			bdTotal = result;
			if(bdTotal.toString().length() > 25){
				Text txtOne = new Text(curr+"\u00B3 = ");
				Text txtTwo = new Text(bdTotal.toString());
				TextFlow txtFl = new TextFlow(txtOne, txtTwo);
				Scene currScene = new Scene(txtFl, 300, 300);
				Stage currStage = new Stage();
				currStage.setScene(currScene);
				currStage.show();
				txtAnswer.setText("Too Big! Check the Popup!");
			}
			else
				txtAnswer.setText(curr+"\u00B3 = "+bdTotal);
			tfCurrValue.setText("");
		}); // Cubed
		btnNumbers[22].setOnAction(e -> { // Nth Power
			BigDecimal curr = new BigDecimal(tfCurrValue.getText());
			bdOne = curr;
			operation[5] = true;
			tfCurrValue.setText("");
		}); // Nth power

		// ----------------------------------------------------------

		btnNumbers[10].setOnAction(e -> { // Factorial
			BigDecimal curr = new BigDecimal(tfCurrValue.getText());
			BigDecimal result = BigDecimal.ONE;
			BigDecimal index = BigDecimal.ONE;
			while(!index.toString().equals(curr.toString())){
				result = result.multiply(index);
				index = index.add(ONE);
			}
			result = result.multiply(index);
			bdTotal = result;
			if(bdTotal.toString().length() > 25){
				Text txtOne = new Text(curr+"! = ");
				Text txtTwo = new Text(bdTotal.toString());
				TextFlow txtFl = new TextFlow(txtOne, txtTwo);
				Scene currScene = new Scene(txtFl, 400, 300);
				Stage currStage = new Stage();
				currStage.setScene(currScene);
				currStage.show();
				txtAnswer.setText("Too Big! Check the Popup!");
			}
			else
				txtAnswer.setText(curr+"! = "+bdTotal);
			tfCurrValue.setText("");
		}); // Factorial

		// ----------------------------------------------------------

		btnNumbers[16].setOnAction(e -> { // Square Root

			/*

			Figure out how to get the square root without sqrt
			Ask Jose about this tomorrow
			Okay, he told me that the square root and cube root formula is as follows:
			n ^ 1/2 and n ^ 1/3 respectively
			So now I gotta implement that :^(
			...
			Okay, So i don't need to use a big decimal <3
			I've put in a try/catch for when a number is too big
			So ye, this is in the bag now.

			*/

			BigDecimal curr = new BigDecimal(tfCurrValue.getText());
			if(curr.signum() < 0)
				txtAnswer.setText("Negatives don't have square roots.");
			else {
				try {
					String sCurr = curr.toString();
					Double dblCurr = new Double(sCurr);
					double dCurr = dblCurr.parseDouble(sCurr);

					double result = Math.sqrt(dCurr);
					BigDecimal bdF = new BigDecimal(result);
					bdTotal = bdF;

					if (bdTotal.toString().length() > 25) {
						Text txtOne = new Text(curr + "\u00B2\u221A = ");
						Text txtTwo = new Text(bdTotal.toString());
						TextFlow txtFl = new TextFlow(txtOne, txtTwo);
						Scene currScene = new Scene(txtFl, 400, 300);
						Stage currStage = new Stage();
						currStage.setScene(currScene);
						currStage.show();
						txtAnswer.setText("Too Big! Check the Popup!");
					} else
						txtAnswer.setText(curr + "\u00B2\u221A = " + bdTotal);
				} catch (Exception f) {
					txtAnswer.setText("Try a smaller number...");
				}
			}
			tfCurrValue.setText("");
		}); // Square Root
		btnNumbers[21].setOnAction(e -> { // Cubed Root
			BigDecimal curr = new BigDecimal(tfCurrValue.getText());
			if(curr.signum() < 0)
				txtAnswer.setText("Negatives don't have cubed roots.");
			else {
				try {
					String sCurr = curr.toString();
					Double dblCurr = new Double(sCurr);
					double dCurr = dblCurr.parseDouble(sCurr);

					double result = Math.cbrt(dCurr);
					BigDecimal bdF = new BigDecimal(result);
					bdTotal = bdF;

					if (bdTotal.toString().length() > 25) {
						Text txtOne = new Text(curr + "\u00B3\u221A = ");
						Text txtTwo = new Text(bdTotal.toString());
						TextFlow txtFl = new TextFlow(txtOne, txtTwo);
						Scene currScene = new Scene(txtFl, 400, 300);
						Stage currStage = new Stage();
						currStage.setScene(currScene);
						currStage.show();
						txtAnswer.setText("Too Big! Check the Popup!");
					} else
						txtAnswer.setText(curr + "\u00B3\u221A = " + bdTotal);
				} catch (Exception f) {
					txtAnswer.setText("Try a smaller number...");
				}
			}
			tfCurrValue.setText("");
		}); // Cubed Root

		// ----------------------------------------------------------

		btnEquals.setOnAction(e -> { // Equals
			BigDecimal curr = new BigDecimal(tfCurrValue.getText());
			bdTwo = curr;

			if(operation[0]) // Plus
				bdTotal = bdOne.add(bdTwo);
			else if(operation[1]) // Minus
				bdTotal = bdOne.subtract(bdTwo);
			else if(operation[2]) // Multiply
				bdTotal = bdOne.multiply(bdTwo);
			else if(operation[3]) { // Divide
				BigDecimal result = bdOne.divide(bdTwo, MathContext.DECIMAL128);
				bdTotal = result;
			}
			else if(operation[4]) // Modulus
				bdTotal = bdOne.remainder(bdTwo);
			else if(operation[5]){ // Nth Power
				BigDecimal result = new BigDecimal(bdOne.toString());
				BigDecimal index = BigDecimal.ONE;
				while(!index.toString().equals(bdTwo.toString())){
					result = result.multiply(bdOne);
					index = index.add(ONE);
				}
				bdTotal = result;
			}
			else
				System.out.println("Something went wrong");

			Text txtOne = new Text("");

			if(operation[0]) // Plus
				txtOne = new Text(bdOne+" + " + bdTwo + " = ");
			else if(operation[1]) // Minus
				txtOne = new Text(bdOne+" - " + bdTwo + " = ");
			else if(operation[2]) // Multiply
				txtOne = new Text(bdOne+" * " + bdTwo + " = ");
			else if(operation[3]) // Divide
				txtOne = new Text(bdOne+" \u00F7 " + bdTwo + " = ");
			else if(operation[4]) // Modulus
				txtOne = new Text(bdOne+" % " + bdTwo + " = ");
			else if(operation[5]) // Nth Power
				txtOne = new Text(bdOne+"^" + bdTwo + " = ");

			if(bdTotal.toString().length() > 25){

				Text txtTwo = new Text(bdTotal.toString());
				TextFlow txtFl = new TextFlow(txtOne, txtTwo);
				Scene currScene = new Scene(txtFl, 300, 300);
				Stage currStage = new Stage();
				currStage.setScene(currScene);
				currStage.show();
				txtAnswer.setText("Too Big! Check the Popup!");
			}
			else
				txtAnswer.setText(txtOne.getText() + "" + bdTotal);

			tfCurrValue.setText("");

			for(int i = 0; i < operation.length; i++)
				operation[i] = false;

		}); // Equals

		// ----------------------------------------------------------

		// And here's some of the extra stuff...

		calcPane.setOnKeyPressed(e -> { // Extras

			/* Top Numbers */

			if(e.getCode() == KeyCode.NUMPAD0)
				tfCurrValue.setText(tfCurrValue.getText() + "0");
			else if(e.getCode() == KeyCode.NUMPAD1)
				tfCurrValue.setText(tfCurrValue.getText() + "1");
			else if(e.getCode() == KeyCode.NUMPAD2)
				tfCurrValue.setText(tfCurrValue.getText() + "2");
			else if(e.getCode() == KeyCode.NUMPAD3)
				tfCurrValue.setText(tfCurrValue.getText() + "3");
			else if(e.getCode() == KeyCode.NUMPAD4)
				tfCurrValue.setText(tfCurrValue.getText() + "4");
			else if(e.getCode() == KeyCode.NUMPAD5)
				tfCurrValue.setText(tfCurrValue.getText() + "5");
			else if(e.getCode() == KeyCode.NUMPAD6)
				tfCurrValue.setText(tfCurrValue.getText() + "6");
			else if(e.getCode() == KeyCode.NUMPAD7)
				tfCurrValue.setText(tfCurrValue.getText() + "7");
			else if(e.getCode() == KeyCode.NUMPAD8)
				tfCurrValue.setText(tfCurrValue.getText() + "8");
			else if(e.getCode() == KeyCode.NUMPAD9)
				tfCurrValue.setText(tfCurrValue.getText() + "9");
			else if(e.getCode() == KeyCode.DECIMAL)
				tfCurrValue.setText(tfCurrValue.getText() + ".");

			// Mathematical operators

			else if(e.getCode() == KeyCode.ADD) {
				BigDecimal curr = new BigDecimal(tfCurrValue.getText());
				bdOne = curr;
				operation[0] = true;
				tfCurrValue.setText("");
			}
			else if(e.getCode() == KeyCode.SUBTRACT){
				BigDecimal curr = new BigDecimal(tfCurrValue.getText());
				bdOne = curr;
				operation[1] = true;
				tfCurrValue.setText("");
			}
			else if(e.getCode() == KeyCode.MULTIPLY){
				BigDecimal curr = new BigDecimal(tfCurrValue.getText());
				bdOne = curr;
				operation[2] = true;
				tfCurrValue.setText("");
			}
			else if(e.getCode() == KeyCode.DIVIDE){
				BigDecimal curr = new BigDecimal(tfCurrValue.getText());
				bdOne = curr;
				operation[3] = true;
				tfCurrValue.setText("");
			}

			// Equals

			else if(e.getCode() == KeyCode.ENTER){
				BigDecimal curr = new BigDecimal(tfCurrValue.getText());
				bdTwo = curr;

				if(operation[0]) // Plus
					bdTotal = bdOne.add(bdTwo);
				else if(operation[1]) // Minus
					bdTotal = bdOne.subtract(bdTwo);
				else if(operation[2]) // Multiply
					bdTotal = bdOne.multiply(bdTwo);
				else if(operation[3]) { // Divide
					BigDecimal result = bdOne.divide(bdTwo, MathContext.DECIMAL128);
					bdTotal = result;
				}
				else if(operation[4]) // Modulus
					bdTotal = bdOne.remainder(bdTwo);
				else if(operation[5]){ // Nth Power
					BigDecimal result = new BigDecimal(bdOne.toString());
					BigDecimal index = BigDecimal.ONE;
					while(!index.toString().equals(bdTwo.toString())){
						result = result.multiply(bdOne);
						index = index.add(ONE);
					}
					bdTotal = result;
				}
				else
					System.out.println("Something went wrong");

				Text txtOne = new Text("");

				if(operation[0]) // Plus
					txtOne = new Text(bdOne+" + " + bdTwo + " = ");
				else if(operation[1]) // Minus
					txtOne = new Text(bdOne+" - " + bdTwo + " = ");
				else if(operation[2]) // Multiply
					txtOne = new Text(bdOne+" * " + bdTwo + " = ");
				else if(operation[3]) // Divide
					txtOne = new Text(bdOne+" \u00F7 " + bdTwo + " = ");
				else if(operation[4]) // Modulus
					txtOne = new Text(bdOne+" % " + bdTwo + " = ");
				else if(operation[5]) // Nth Power
					txtOne = new Text(bdOne+"^" + bdTwo + " = ");

				if(bdTotal.toString().length() > 25){

					Text txtTwo = new Text(bdTotal.toString());
					TextFlow txtFl = new TextFlow(txtOne, txtTwo);
					Scene currScene = new Scene(txtFl, 300, 300);
					Stage currStage = new Stage();
					currStage.setScene(currScene);
					currStage.show();
					txtAnswer.setText("Too Big! Check the Popup!");
				}
				else
					txtAnswer.setText(txtOne.getText() + "" + bdTotal);

				tfCurrValue.setText("");

				for(int i = 0; i < operation.length; i++)
					operation[i] = false;
			}

		}); // Extras
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
