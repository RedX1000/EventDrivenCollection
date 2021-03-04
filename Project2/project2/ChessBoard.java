package project2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessBoard extends Application
{
    final GridPane board = new GridPane();
    
    @Override
    public void start(Stage primaryStage)
    {
        //Uncomment the method calls to test your methods
        
        colorBoard();
        setupBoard();

        Scene scene = new Scene(board, 320, 320);
        primaryStage.setTitle("Chess Board");
        primaryStage.minWidthProperty().bind(scene.heightProperty().divide(1));
		primaryStage.minHeightProperty().bind(scene.widthProperty().divide(1));
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public void colorBoard()
    {
        //TODO complete this method as required in the instructions
    	boolean switcher = true;
    	boolean switcher2 = true;
    	
    	/*StackPane p1 = new StackPane();
    	StackPane p2 = new StackPane();
    	
    	Rectangle white = new Rectangle(40, 40, 40, 40);
    	white.setFill(Color.WHITE);
    	p1.getChildren().add(white);
    	
    	Rectangle gray = new Rectangle(40, 40, 40, 40);
    	gray.setFill(Color.GRAY);
    	p2.getChildren().add(gray);*/
    	
    	//StackPane[][] paneList = new StackPane[8][8];
    	Rectangle[][] recList = new Rectangle[8][8];
    	//System.out.println("Switcher is currently " + switcher);
    	
    	for(int i = 0; i < 8; i++) {
	    	for(int j = 0; j < 8; j++) {
	    		Rectangle rec = new Rectangle(40,40);
	    		rec.heightProperty().bind(board.heightProperty().divide(8));
	    		rec.widthProperty().bind(board.widthProperty().divide(8));
	    		
	    		if(switcher2) {
		    		if(switcher) { // White
		    			rec.setFill(Color.WHITE);
		    			recList[i][j] = rec;
		    			switcher = false;
		    		}
		    		else {
		    			rec.setFill(Color.GRAY);
		    			recList[i][j] = rec;
		    			switcher = true;
		    		}
	    		} 
	    		else {
		    		if(switcher) { // White
		    			rec.setFill(Color.GRAY);
		    			recList[i][j] = rec;
		    			switcher = false;
		    		}
		    		else {
		    			rec.setFill(Color.WHITE);
		    			recList[i][j] = rec;
		    			switcher = true;
		    		}
	    		}
	    		System.out.println("Rectangle set is " + switcher);
	    		board.add(recList[i][j],j,i);
	    	}
	    	if(switcher2)
            	switcher2 = false;
            else
            	switcher2 = true;
    	}
    	//Rectangle Maker doesn't cause Invocation
    	
    	//for(int i = 0; i < 8; i++)
	    	//for(int j = 0; j < 8; j++) {
	    		/*StackPane sp = new StackPane();
	    		
	    		sp.getChildren().add(recList[i][j]);
				paneList[i][j] = sp;*/
	    		
				/*
	    		if(switcher) { // White
	    			sp.getChildren().add(recList[i]);
	    			paneList = sp;
	    			switcher = true;
	    		}
	    		else { // Gray
	    			paneList[i].getChildren().add(recList[i]);
	    			sp.getChildren().add(recList[i]);
	    			paneList[i] = sp;
	    			switcher = false;
	    		}*/
	    	//}
    	//Adding Rectangles to paneList does not cause Invocation.
    	
    	//int index = 0;
    	//switcher = true;
    	
    	/*
    	for(int col = 0; col < 8; col++) {
            for(int row = 0; row < 8; row++) {
            	
            	StackPane sp = new StackPane();
				
            	if(recList[col][row].getFill().equals(Color.GREEN)) {       
            		sp.getChildren().add(recList[col][row]);
    				paneList[col][row] = sp;
            		System.out.println("Object at "+col+" "+row+" is the color Green");
            	}
            	else {
            		sp.getChildren().add(recList[col][row]);
    				paneList[col][row] = sp;
            		System.out.println("Object at "+col+" "+row+" is the color Chartreuse");
            	}
            }
            
    	}*/
    	
    	//for(int col = 0; col < 8; col++)
            //for(int row = 0; row < 8; row++) {
            	//System.out.println("Row: "+row+ ", Col:"+col);
            	//System.out.println("Switcher is currently " + switcher);
            	
            	//board.add(paneList[row][col],col,row);
            	//board.add(recList[row][col],col,row);
            	
            	/*if(switcher) {
            		board.add(paneList[row][col],col,row);
            		switcher = false;
            	}
            	else {
            		board.add(paneList[row][col],col,row);
            		switcher = true;
            	}*/
            	//index++;
            	
            	/*StackPane p1 = new StackPane();
            	StackPane p2 = new StackPane();
            	
            	Rectangle white = new Rectangle(40, 40, 40, 40);
            	white.setFill(Color.WHITE);
            	p1.getChildren().add(white);
            	
            	Rectangle gray = new Rectangle(40, 40, 40, 40);
            	gray.setFill(Color.GRAY);
            	p2.getChildren().add(gray);*/
            	
                /*if(switcher) { // White
                	board.add(paneList[index],col,row);
                	switcher = true;
                }
                else { // Gray
                	board.add(paneList[index],col,row);
                	switcher = false;
                }
                
                index++;
            
            }*/
    	//board.add(p1, 0, 0);
    	//board.add(p2, 0, 1);
    	//board.add(p1, 0, 2);
    	//board.add(p2, 0, 3);
    	
    	//Try to create a new gridpane
    }

    public void setupBoard()
    {
        //TODO complete this method as required in the instructions
    	
    	System.out.println("Setting up the board");

    	String[] whiteNameTop = {"images/WhiteRook.png","images/WhiteKnight.png","images/WhiteBishop.png","images/WhiteKing.png",
								 "images/WhiteQueen.png","images/WhiteBishop.png","images/WhiteKnight.png","images/WhiteRook.png",
								 "images/WhitePawn.png","images/WhitePawn.png","images/WhitePawn.png","images/WhitePawn.png",
								 "images/WhitePawn.png","images/WhitePawn.png","images/WhitePawn.png","images/WhitePawn.png"};

		String[] blackNameBottom = {"images/BlackPawn.png","images/BlackPawn.png","images/BlackPawn.png","images/BlackPawn.png",
								    "images/BlackPawn.png","images/BlackPawn.png","images/BlackPawn.png","images/BlackPawn.png",
									"images/BlackRook.png","images/BlackKnight.png","images/BlackBishop.png","images/BlackKing.png",
									"images/BlackQueen.png","images/BlackBishop.png","images/BlackKnight.png","images/BlackRook.png"};
		
		
		String[] blackNameTop = {"images/BlackRook.png","images/BlackKnight.png","images/BlackBishop.png","images/BlackQueen.png",
								 "images/BlackKing.png","images/BlackBishop.png","images/BlackKnight.png","images/BlackRook.png",
								 "images/BlackPawn.png","images/BlackPawn.png","images/BlackPawn.png","images/BlackPawn.png",
								 "images/BlackPawn.png","images/BlackPawn.png","images/BlackPawn.png","images/BlackPawn.png"};
		
		
		String[] whiteNameBottom = {"images/WhitePawn.png","images/WhitePawn.png","images/WhitePawn.png","images/WhitePawn.png",
								    "images/WhitePawn.png","images/WhitePawn.png","images/WhitePawn.png","images/WhitePawn.png",
									"images/WhiteRook.png","images/WhiteKnight.png","images/WhiteBishop.png","images/WhiteQueen.png",
									"images/WhiteKing.png","images/WhiteBishop.png","images/WhiteKnight.png","images/WhiteRook.png"};
        
		for(int i = 0; i < 16; i++)
			System.out.println(whiteNameTop[i]);
		
		System.out.println("String list checker is done");
        int topOrBottom = (int) (Math.random() * 100 - 1 + 1) + 1;
        
        System.out.println("Creating arrays");
        StackPane[] paneList = new StackPane[32];
        //Image[] imgList = new Image[32];
        ImageView[] imgVwArr = new ImageView[32];
        System.out.println("Arrays created!");
        //int index = 0;
        System.out.println("Creating images and imageviews now...");
        System.out.println("topOrBottom is: "+topOrBottom+".");
        
        //Try not to do too much in one loop...
        //int k = 0;
        
        try {
	    	for(int i = 0; i < 32; i++) {
	    		//Image img;
	    		ImageView imgVw;
	    		if(topOrBottom % 2 == 0) {
		    		if(i < 16)
		    			imgVw = new ImageView(new Image(whiteNameTop[i]));
		    		else
		    			imgVw = new ImageView(new Image(blackNameBottom[(i % 16)]));
	    		}
	    		else {
		    		if(i < 16)
		    			imgVw = new ImageView(new Image(blackNameTop[i]));
		    		else
		    			imgVw = new ImageView(new Image(whiteNameBottom[(i % 16)]));
	    		}
	    		//imgVw.setFitHeight().bind(board.heightProperty().divide(8));
	    		//imgVw.setFitWidth().bind(board.widthProperty().divide(8));
	    		//imgVw.heightPropert();
	    		//imgVw.widthProperty();
	    		imgVw.fitWidthProperty().bind(board.widthProperty().divide(8));
	    		imgVw.fitHeightProperty().bind(board.heightProperty().divide(8));
	    		imgVwArr[i] = imgVw;
	    	}
    	System.out.println("Created images and imageviews");
        }catch(Exception e) {
        	System.out.println("Issues in making images");
        }
        
    	/*for(int i = 0; i < 32; i++) {
    		ImageView imgVw = new ImageView(imgList[i]);
    		imgVwArr[i] = imgVw;
    	}
    	System.out.println("Created imageviews");*/
    	
    	for(int i = 0; i < 32; i++) {
    		StackPane sp = new StackPane();
    		sp.getChildren().add(imgVwArr[i]);
    		paneList[i] = sp;
    	}
    	System.out.println("Added panes to stackpane");

		System.out.println("Adding panes to the board!");
    	int index = 0;
    	for(int i = 0; i < 8; i++) {
    		for(int j = 0; j < 8; j++) {
    			
    			//StackPane sp = new StackPane();
    			
    			//sp.getChildren().add(imgVwArr[index]);
    			//board.add(paneList[index],j,i);
    					
    			//StackPane spL = new StackPane();
    			//StackPane spR = new StackPane();
    			
    			if(i < 2) {
    				board.add(paneList[index],j,i);
    				index++;
    			}
    				
    			else if(i > 5) {
    				board.add(paneList[index],j,i);
    				index++;
    			}
    			//index++;
    		}
    		//index = 7;
    	}
    	System.out.println("Added pane to grid");
		
		/*System.out.println("Making Image");
		Image img = new Image("images/WhitePawn.png");
		System.out.println("Image Made. ImageView");
		ImageView imgVw = new ImageView(img);
		System.out.println("ImageView Made. StackPane");
		StackPane sp = new StackPane();
		System.out.println("StackPane Made. adding to StackPane");
		sp.getChildren().add(imgVw);
		System.out.println("adding to board");
		board.add(sp, 1, 0);*/

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}