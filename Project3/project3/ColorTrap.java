package project3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.util.Duration;

public class ColorTrap extends Application
{
    private Scene scene;
    private BorderPane borderPane;
    private Text txtCountDown;
    private Timeline timeline;


    private final int TIMER = 15;
    private int count = 0;
    
    private int scoreValue = 0;
    private String topColor;
	private Text value = new Text(""+scoreValue);
	private ImageView currImgVw;
    
    private Text txt1;
    private Text txt2;
    private Text txt3;
    private Text txt4;
    private Text txt5;
    private Text txt6;
    private Text txt7;

    @Override
    public void start(Stage primaryStage)
    {
        borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: lightgrey");
        scene = new Scene(borderPane, 600, 300);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(600);
        initializeGame();
        startPlay();

        primaryStage.setTitle("Color Trap");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void startPlay()
    {
        chooseTrapWordAndColor();
        colorNameOptions();

        count = TIMER;
        txtCountDown.setText(TIMER + "");
        timeline = new Timeline(new KeyFrame(
                Duration.millis(1000), e -> {


                    if(count >= 0)
                    {
                        txtCountDown.setText(count + "");
                        count--;
                    }
                    else
                    {
                        endOfGame();
                    }
                }));
        timeline.setCycleCount(TIMER + 2);
        timeline.play();

    }
    
    public void endOfGame()
    {
        //TODO complete this method as required.
    	//System.out.println("Ending game");
    	borderPane.setTop(null);
    	borderPane.setCenter(null);
    	borderPane.setBottom(null);
    	
    	Text finalScore = new Text("Your score: " + scoreValue +"\n");
    	finalScore.setFont(Font.font("Comic Sans MS", 40));
    	Button playAgain = new Button("Play again");
    	VBox endCard = new VBox();
    	endCard.setAlignment(Pos.CENTER);
    	endCard.getChildren().addAll(finalScore, playAgain);
    	borderPane.setCenter(endCard);
    	
    	playAgain.setOnAction(e -> {
    		initializeGame();
    		startPlay();
    	});
    	
    }


    public void checkChoice(Text choice)
    {
        //TODO complete this method as required.
    	//System.out.println("Checking choice");
    	Image right = new Image("images/correct.png");
    	Image wrong = new Image("images/wrong.png");
    	
    	//System.out.println(choice.getText() + "_" + topColor + "_");
    	if((choice.getText() + "").equals(topColor + "")) {
    		scoreValue++;
    		value.setText("" + scoreValue);
    		currImgVw.setImage(right);
    		//System.out.println("Right!");
    	}
    	else
    		currImgVw.setImage(wrong);
    		//System.out.println("Wrong!");
    	
    	currImgVw.setFitWidth(45);
    	currImgVw.setFitHeight(45);
    	
    	//System.out.println("Exited Checking.");
    	


        //Do NOT add any code after this comment
        //Choose a new trap word and options list
        chooseTrapWordAndColor();
        colorNameOptions();
    }

    public void chooseTrapWordAndColor()
    {
        //TODO complete this method as required.
    	borderPane.setTop(null);
    	//System.out.println("Creating Top Word in the method");
    	Text top = new Text();
		ColorsEnum[] colors = ColorsEnum.values();
		String colorValue = (colors[(int)(Math.random()*7)]) + "";
		String wordValue = (colors[(int)(Math.random()*7)]) + "";
		
    	top.setFont(Font.font("Comic Sans MS", 60));
    	top.setText("" + wordValue + " ");
    	Color co = Color.valueOf( colorValue + "");
    	top.setFill(co);
    	topColor = colorValue + " ";
    	
    	HBox topH = new HBox(); 
    	topH.getChildren().add(top);
    	topH.setAlignment(Pos.TOP_CENTER);
    	borderPane.setTop(topH);
    	

    }
    
    public void colorNameOptions()
    {
        //TODO complete this method as required.
    	borderPane.setCenter(null);
    	//System.out.println("Creating center words in the method");
    	FlowPane centerFlow = new FlowPane();
    	boolean[] values = new boolean[7];
    	Text[] center = new Text[7];
    	
		ColorsEnum[] colors = ColorsEnum.values();
		int used = 0;
		
    	for(int i = 0; i < 7; i++) {
    		Text txt = new Text();
    		txt.setFont(Font.font("Comic Sans MS", 40));
    		center[i] = txt;
    	}
    	
    	while(used < 7)
    	{
    		int rand = (int)(Math.random()*7);
    		//System.out.println("Random value is: " + rand +". Used is: "+used);
    		if(!values[rand]) {
    			center[used].setText("" + colors[rand]+ " ");
    			used++;
    			values[rand] = true;
    		}
    	}
    	
    	for(int i = 0; i < values.length; i++) 
    		values[i] = false;
    	
    	used = 0;
    	while(used < 7)
    	{
    		int rand = (int)(Math.random()*7);
    		//System.out.println("Random value is: " + rand +". Used is: "+used);
    		if(!values[rand]) {
    			Color c = Color.valueOf((colors[rand]) + "");
    			center[used].setFill(c);
    			used++;
    			values[rand] = true;
    		}
    	}
    	
    	txt1 = center[0];
    	txt2 = center[1];
    	txt3 = center[2];
    	txt4 = center[3];
    	txt5 = center[4];
    	txt6 = center[5];
    	txt7 = center[6];
    	
    	centerFlow.getChildren().addAll(txt1, txt2, txt3, txt4, txt5, txt6, txt7);
    	centerFlow.setAlignment(Pos.CENTER);
    	borderPane.setCenter(centerFlow);
    	
    	txt1.setOnMouseClicked(e -> {
    		checkChoice(txt1);
    	});
    	txt2.setOnMouseClicked(e -> {
    		checkChoice(txt2);
    	});
    	txt3.setOnMouseClicked(e -> {
    		checkChoice(txt3);
    	});
    	txt4.setOnMouseClicked(e -> {
    		checkChoice(txt4);
    	});
    	txt5.setOnMouseClicked(e -> {
    		checkChoice(txt5);
    	});
    	txt6.setOnMouseClicked(e -> {
    		checkChoice(txt6);
    	});
    	txt7.setOnMouseClicked(e -> {
    		checkChoice(txt7);
    	});
    }

    public void initializeGame()
    {
        //TODO complete this method as required.
    	//System.out.println("Initializing game...");
    	borderPane.setBottom(null);
    	
    	scoreValue = 0;
    	Text score = new Text("Score: ");
    	value.setFont(Font.font("Comic Sans MS", 20));
    	score.setFont(Font.font("Comic Sans MS", 20));
    	currImgVw = null;
    	currImgVw = new ImageView(new Image("images/blank.png"));
    	
    	txtCountDown = new Text();
    	txtCountDown.setFont(Font.font("Comic Sans MS", 20));
    	Text timer = new Text("Time left: " );
    	timer.setFont(Font.font("Comic Sans MS", 20));
    	
    	HBox scoreH = new HBox();
    	HBox timerH = new HBox();
    	HBox imgH = new HBox();
    	HBox bottomH = new HBox(170);
    	
    	scoreH.getChildren().addAll(score, value);
    	timerH.getChildren().addAll(timer, txtCountDown);
    	imgH.getChildren().add(currImgVw);
    	
    	scoreH.setAlignment(Pos.BOTTOM_LEFT);
    	timerH.setAlignment(Pos.BOTTOM_RIGHT);
    	imgH.setAlignment(Pos.BOTTOM_CENTER);
    	
    	scoreH.setMaxWidth((Double.MAX_VALUE) / 3);
    	timerH.setMaxWidth((Double.MAX_VALUE) / 3);
    	imgH.setMaxWidth((Double.MAX_VALUE) / 3);
    	
    	bottomH.getChildren().addAll(scoreH, imgH,/*rightWrongH,*/ timerH);
    	bottomH.setAlignment(Pos.BOTTOM_CENTER);
    	bottomH.setMaxWidth(Double.MAX_VALUE);
    	
    	borderPane.setBottom(bottomH);
    	
    	bottomH.minWidthProperty().bind(borderPane.widthProperty());
    	
    	// Try randomizing a number between  0 - 6, and then use a modulus to 
    	// start at any random value in the array.
    	// i.e. start at Math.random()*6 % 7, and you might start at 3 and cycle all the way to 2.
    	// This could work...
    	
    	// Try using a boolean array to check if numbers 1 to 7 have been hit.
    	// For example, boolean[i (3)] is false, which means that the number 4
    	// is open for the taking, while boolean[i (2)] is true, which means that
    	// that value is taken and should not be used.
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}