package aim_configuration_tool;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Main extends Application {

    private int screenHeight; 
    private int screenWidth;    
    public static ProgressIndicator pi;
    public static Label lblStatus;    
    private Label lblPlayers;
    private Label lblUserID;
    private Label lblRadio;
    private Label lblRespawn;
    private Label lblBluetooth;
    private Label lblBluetoothName;
    private Label lblBluetoothPIN;
    private Label[] lblPlayerName;
    private Label lblRFpower;
    private Label lblRFchannel;
    private Label lblCode;
    private Label lblUTC;
    private Label lblLatitude;
    private Label lblLongitude;
    private Label lblTimeZone;
    private Label lblDisplay;
    private TextField[] txtPlayerName;
    private TextField txtUser;
    private TextField txtCode;
    private TextField txtLatitude;
    private TextField txtLongitude;
    private TextField txtBluetoothName;
    private TextField txtBluetoothPIN;
    private Slider sliderRFpower;
    private Slider sliderRFchannel;
    private Slider sliderUTC;
    private CheckBox cbAltitude;
    private CheckBox cbDistance;
    private CheckBox cbDeadPlayer;
    
    private final String AppName="AIM configuration tool 1.0";
    private int RFpower=0;
    private int RFchannel=1;
    private int UTC=0;
    private double latitude = 0.0;
    private double longitude = 0.0;
    private String userID="";
    private String[] PlayerName;
    private String code = "";
    private String BluetoothName="";
    private int BluetoothPIN;
    private int altitude=1, distance=1, dead_player=1;

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle(AppName);

        javafx.scene.image.Image icon =  new javafx.scene.image.Image("images/icon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setX(0);
        primaryStage.setY(0);  
        
        screenHeight = 720;
        screenWidth = 1300;
                
        ImageView imageFacebook = new ImageView("images/facebook.png");
        imageFacebook.setPreserveRatio(true);
        imageFacebook.setX(screenWidth-105); 
        imageFacebook.setY(300);
        imageFacebook.setFitHeight(100); 
        imageFacebook.setFitWidth(100);
        imageFacebook.setOnMouseClicked(event -> VisitWebpage.facebook());
        
        ImageView imageYoutube = new ImageView("images/youtube.png");
        imageYoutube.setPreserveRatio(true);
        imageYoutube.setX(screenWidth-105); 
        imageYoutube.setY(420);
        imageYoutube.setFitHeight(100); 
        imageYoutube.setFitWidth(100);
        imageYoutube.setOnMouseClicked(event -> VisitWebpage.youtube());
        
        ImageView imageEshop = new ImageView("images/aim.png");
        imageEshop.setPreserveRatio(true);
        imageEshop.setX(screenWidth-400); 
        imageEshop.setY(300);
        imageEshop.setFitHeight(225); 
        imageEshop.setFitWidth(280);
        imageEshop.setOnMouseClicked(event -> VisitWebpage.eshop());
        
        ImageView imageTimeZones = new ImageView("images/time_zones.png");
        imageTimeZones.setPreserveRatio(true);
        imageTimeZones.setX((screenWidth/6)*2.5 - 300); 
        imageTimeZones.setY(300);
        imageTimeZones.setFitHeight(370); 
        imageTimeZones.setFitWidth(800);
        imageTimeZones.setOnMouseClicked(event -> VisitWebpage.time_zones());
        
        ImageView imageGoogleMaps = new ImageView("images/google_maps.png");
        imageGoogleMaps.setPreserveRatio(true);
        imageGoogleMaps.setX((screenWidth/6)*3 - 200); 
        imageGoogleMaps.setY(130);
        imageGoogleMaps.setFitHeight(250); 
        imageGoogleMaps.setFitWidth(200);
        imageGoogleMaps.setOnMouseClicked(event -> VisitWebpage.google_maps());
        
        ImageView imageLatLong = new ImageView("images/lat_long.png");
        imageLatLong.setPreserveRatio(true);
        imageLatLong.setX((screenWidth/6)*4 - 210); 
        imageLatLong.setY(15);
        imageLatLong.setFitHeight(225); 
        imageLatLong.setFitWidth(450);
        imageLatLong.setOnMouseClicked(event -> VisitWebpage.google_maps());
                
        pi = new ProgressIndicator(0.0);
        pi.setLayoutX(screenWidth-50);
        pi.setLayoutY(screenHeight-110);
        
        lblStatus = new Label();
        lblStatus.setText("");
        lblStatus.setFont(Font.font("Arial", 20));
        lblStatus.setLayoutX(screenWidth-185);
        lblStatus.setLayoutY(screenHeight-110);
        lblStatus.setVisible(false);
        
        lblPlayers = new Label();
        lblPlayers.setText("Players");
        lblPlayers.setFont(Font.font("Arial", 30));
        lblPlayers.setLayoutX((screenWidth/6)*1 - 200);
        lblPlayers.setLayoutY(15);
        
        lblRadio = new Label();
        lblRadio.setText("Radio");
        lblRadio.setFont(Font.font("Arial", 30));
        lblRadio.setLayoutX((screenWidth/6)*2 - 200);
        lblRadio.setLayoutY(15);
        
        lblRespawn = new Label();
        lblRespawn.setText("Respawn");
        lblRespawn.setFont(Font.font("Arial", 30));
        lblRespawn.setLayoutX((screenWidth/6)*3 - 200);
        lblRespawn.setLayoutY(15);
        
        lblBluetooth = new Label();
        lblBluetooth.setText("Bluetooth");
        lblBluetooth.setFont(Font.font("Arial", 30));
        lblBluetooth.setLayoutX((screenWidth/6)*6.1 - 200);
        lblBluetooth.setLayoutY(15);
        
        lblTimeZone = new Label();
        lblTimeZone.setText("Time Zone");
        lblTimeZone.setFont(Font.font("Arial", 30));
        lblTimeZone.setLayoutX((screenWidth/6)*3.5 - 290);
        lblTimeZone.setLayoutY(240);
        
        lblUserID = new Label();
        lblUserID.setText("User ID");
        lblUserID.setFont(Font.font("Arial", 20));
        lblUserID.setLayoutX((screenWidth/6)*1 - 200);
        lblUserID.setLayoutY(70);
        
        lblLatitude = new Label();
        lblLatitude.setText("Latitude");
        lblLatitude.setFont(Font.font("Arial", 20));
        lblLatitude.setLayoutX((screenWidth/6)*3 - 200);
        lblLatitude.setLayoutY(70);
        
        lblLongitude = new Label();
        lblLongitude.setText("Longitude");
        lblLongitude.setFont(Font.font("Arial", 20));
        lblLongitude.setLayoutX((screenWidth/6)*3 - 200);
        lblLongitude.setLayoutY(100);
        
        txtLatitude = new TextField();
        txtLatitude.setPromptText("89.123456");
        txtLatitude.setFont(Font.font("Arial", 12));
        txtLatitude.setPrefWidth(100);
        txtLatitude.setLayoutX((screenWidth/6)*3 - 100 );
        txtLatitude.setLayoutY(70);
        txtLatitude.textProperty().addListener((observable, oldValue, newValue) -> {
        	try
        	{
        		latitude = Double.parseDouble(newValue.toString());
        	}        		
        	catch(Exception e)
        	{
        		System.out.println("Latitude: Wrong input");
        	}
            if(latitude>90.0)
            {
            	latitude = 90.0;
            	txtLatitude.setText(Double.toString(latitude));
            }            	
            if(latitude<-90.0)
            {
            	latitude = -90.0;
            	txtLatitude.setText(Double.toString(latitude));
            }
            if(!FileManagementForAIM.readORcreateFile("latit.txt").equals(Double.toString(latitude)))
            	FileManagementForAIM.writeToFile("latit.txt", Double.toString(latitude));            
        });
        
        txtLongitude = new TextField();
        txtLongitude.setPromptText("-178.123456");
        txtLongitude.setFont(Font.font("Arial", 12));
        txtLongitude.setPrefWidth(100);
        txtLongitude.setLayoutX((screenWidth/6)*3 - 100 );
        txtLongitude.setLayoutY(100);
        txtLongitude.textProperty().addListener((observable, oldValue, newValue) -> {
        	try
        	{
        		longitude = Double.parseDouble(newValue.toString());
        	}        		
        	catch(Exception e)
        	{
        		System.out.println("Longitude: Wrong input");
        	}
            if(longitude>180.0)
            {
            	longitude = 180.0;
            	txtLongitude.setText(Double.toString(longitude));
            }
            if(longitude<-180.0)
            {
            	longitude = -180.0;
            	txtLongitude.setText(Double.toString(longitude));
            }
            if(!FileManagementForAIM.readORcreateFile("longit.txt").equals(Double.toString(longitude)))
            	FileManagementForAIM.writeToFile("longit.txt", Double.toString(longitude));            
        });
        
        lblBluetoothName = new Label();
        lblBluetoothName.setText("Name");
        lblBluetoothName.setFont(Font.font("Arial", 20));
        lblBluetoothName.setLayoutX((screenWidth/6)*6.1 - 200);
        lblBluetoothName.setLayoutY(70);
        
        lblBluetoothPIN = new Label();
        lblBluetoothPIN.setText("PIN");
        lblBluetoothPIN.setFont(Font.font("Arial", 20));
        lblBluetoothPIN.setLayoutX((screenWidth/6)*6.1 - 200);
        lblBluetoothPIN.setLayoutY(100);        
        
        txtBluetoothName = new TextField();
        txtBluetoothName.setPromptText("AIM");
        txtBluetoothName.setFont(Font.font("Arial", 12));
        txtBluetoothName.setPrefWidth(100);
        txtBluetoothName.setLayoutX((screenWidth/6)*6.1 - 140 );
        txtBluetoothName.setLayoutY(70);
        txtBluetoothName.textProperty().addListener((observable, oldValue, newValue) -> {
        	BluetoothName = newValue.toString();        	
            if(BluetoothName.length()>10)
            	BluetoothName = BluetoothName.substring(0, 10);
            if(BluetoothName.length()>=3 && !FileManagementForAIM.readORcreateFile("BT_name.txt").equals(BluetoothName))
            	FileManagementForAIM.writeToFile("BT_name.txt", BluetoothName);
            txtBluetoothName.setText(BluetoothName);
        });
        
        txtBluetoothPIN = new TextField();
        txtBluetoothPIN.setPromptText("1234");
        txtBluetoothPIN.setFont(Font.font("Arial", 12));
        txtBluetoothPIN.setPrefWidth(100);
        txtBluetoothPIN.setLayoutX((screenWidth/6)*6.1 - 140 );
        txtBluetoothPIN.setLayoutY(100);
        txtBluetoothPIN.textProperty().addListener((observable, oldValue, newValue) -> {
        	try
        	{
        		if(newValue.toString().length()>=1 && Integer.parseInt(newValue.toString())<1)
        			txtBluetoothPIN.setText("1234");
        		BluetoothPIN = Integer.parseInt(newValue.toString());
        	}        		
        	catch(Exception e)
        	{
        		System.out.println("BluetoothPIN: Wrong input");
        	}
            if(BluetoothPIN<0)
            {
            	BluetoothPIN*=-1;
            	txtBluetoothPIN.setText(Integer.toString(BluetoothPIN));
            }
            if(BluetoothPIN>9999)
            {
            	BluetoothPIN=9999;
            	txtBluetoothPIN.setText(Integer.toString(BluetoothPIN));
            }
            if(BluetoothPIN>=1000 && BluetoothPIN<=9999 && !FileManagementForAIM.readORcreateFile("BT_PIN.txt").equals(Integer.toString(BluetoothPIN)))
            	FileManagementForAIM.writeToFile("BT_PIN.txt", Integer.toString(BluetoothPIN));            
        });
        
        lblRFpower = new Label();
        lblRFpower.setText("Power: -1dBm (0.79mW)");
        lblRFpower.setLayoutX((screenWidth/6)*2 - 200);
        lblRFpower.setLayoutY(90);
        
        lblRFchannel = new Label();
        lblRFchannel.setText("Channel 1 (LPD433 CH1 = 433.075MHz)");
        lblRFchannel.setLayoutX((screenWidth/6)*2 - 200);
        lblRFchannel.setLayoutY(160);
        
        txtUser = new TextField();
        txtUser.setPromptText("a");
        txtUser.setLayoutX((screenWidth/6)*1 - 100);
        txtUser.setLayoutY(70);
        txtUser.setPrefWidth(30);
        txtUser.setFont(Font.font("Arial", 12));
        txtUser.textProperty().addListener((observable, oldValue, newValue) -> {
        	userID = newValue.toString().toLowerCase();
            if(userID.length()>1)
            	userID = userID.substring(0, 1);
            if(!userID.equals("a") && !userID.equals("b") && !userID.equals("c") && !userID.equals("d") && !userID.equals("e") && !userID.equals("f") && !userID.equals("g") && !userID.equals("h") && !userID.equals("i") && !userID.equals("j") &&
            		!userID.equals("k") && !userID.equals("l") && !userID.equals("m") && !userID.equals("n") && !userID.equals("o") && !userID.equals("p") && !userID.equals("q") && !userID.equals("r") && !userID.equals("s") && !userID.equals("t"))
            	userID="a";
            if(userID.length()==1 && !FileManagementForAIM.readORcreateFile("user.txt").equals(userID))
            	FileManagementForAIM.writeToFile("user.txt", userID);
            txtUser.setText(userID);
        });
        
        lblPlayerName = new Label[20];
        txtPlayerName = new TextField[20];
        PlayerName = new String[20];
        for(int i=0; i<20; i++)
        {
        	PlayerName[i] = new String();
        	char initPlayerID = (char) ('a' + i);
        	lblPlayerName[i] = new Label();
            lblPlayerName[i].setText("Player " + initPlayerID);
            lblPlayerName[i].setFont(Font.font("Arial", 20));
            lblPlayerName[i].setLayoutX((screenWidth/6)*1 - 200);
            lblPlayerName[i].setLayoutY( ((screenHeight-150)/20)*i + 100 );
            
            txtPlayerName[i] = new TextField();
            txtPlayerName[i].setPromptText("Player " + initPlayerID);
            txtPlayerName[i].setFont(Font.font("Arial", 12));
            txtPlayerName[i].setPrefWidth(90);
            //txtPlayerName[i].setPrefHeight(20);
            txtPlayerName[i].setLayoutX((screenWidth/6)*1 - 100);
            txtPlayerName[i].setLayoutY( ((screenHeight-150)/20)*i + 100 );
        }
        
        keyStrikeListeners();
        
        sliderRFpower = new Slider();
        sliderRFpower.setMin(0);
        sliderRFpower.setMax(7);
        sliderRFpower.setLayoutX((screenWidth/6)*2 - 200);
        sliderRFpower.setLayoutY(70);
        sliderRFpower.setPrefWidth(200);
        sliderRFpower.valueProperty().addListener((obs, oldval, newVal) ->
        {
        	RFpower = (int) Math.round(newVal.doubleValue());
        	sliderRFpower.setValue((double)RFpower);
        	if(RFpower==0)
        		lblRFpower.setText("Power: -1dBm (0.79mW)");
        	else if(RFpower==1)
        		lblRFpower.setText("Power: 2dBm (1.58mW)");
        	else if(RFpower==2)
        		lblRFpower.setText("Power: 5dBm (3.16mW)");
        	else if(RFpower==3)
        		lblRFpower.setText("Power: 8dBm (6.31mW)");
        	else if(RFpower==4)
        		lblRFpower.setText("Power: 11dBm (12.59mW)");
        	else if(RFpower==5)
        		lblRFpower.setText("Power: 14dBm (25.12mW)");
        	else if(RFpower==6)
        		lblRFpower.setText("Power: 17dBm (50.12mW)");
        	else if(RFpower==7)
        		lblRFpower.setText("Power: 20dBm (100mW)");
        });
        sliderRFpower.setOnMouseReleased(event -> FileManagementForAIM.writeToFile("RF_pwr.txt", Integer.toString(RFpower)));
        
        sliderRFchannel = new Slider();
        sliderRFchannel.setMin(1);
        sliderRFchannel.setMax(5);
        sliderRFchannel.setLayoutX((screenWidth/6)*2 - 200);
        sliderRFchannel.setLayoutY(140);
        sliderRFchannel.setPrefWidth(200);
        sliderRFchannel.valueProperty().addListener((obs, oldval, newVal) ->
        {
        	RFchannel = (int) Math.round(newVal.doubleValue());
        	sliderRFchannel.setValue((double)RFchannel);
        	if(RFchannel==1)
        		lblRFchannel.setText("Channel 1 (LPD433 CH1 = 433.075MHz)");
        	else if(RFchannel==2)
        		lblRFchannel.setText("Channel 2 (LPD433 CH3 = 433.125MHz)");
        	else if(RFchannel==3)
        		lblRFchannel.setText("Channel 3 (LPD433 CH5 = 433.175MHz)");
        	else if(RFchannel==4)
        		lblRFchannel.setText("Channel 4 (LPD433 CH7 = 433.225MHz)");
        	else if(RFchannel==5)
        		lblRFchannel.setText("Channel 5 (LPD433 CH9 = 433.275MHz)");        	
        });
        sliderRFchannel.setOnMouseReleased(event -> FileManagementForAIM.writeToFile("RF_ch.txt", Integer.toString(RFchannel)));
        
        txtCode = new TextField();
        txtCode.setLayoutX((screenWidth/6)*2 - 80);
        txtCode.setLayoutY(200);
        txtCode.setPrefWidth(80);
        txtCode.setPromptText("4 characters");
        txtCode.textProperty().addListener((observable, oldValue, newValue) -> {
        	code = newValue.toString();
            if(code.length()>4)
            	code = code.substring(0, 4);
            if(code.length()==4 && !FileManagementForAIM.readORcreateFile("code.txt").equals(code))
            	FileManagementForAIM.writeToFile("code.txt", code);
            txtCode.setText(code);
        });
        
        lblCode = new Label();
        lblCode.setText("Team Code");
        lblCode.setFont(Font.font("Arial", 20));
        lblCode.setLayoutX((screenWidth/6)*2 - 200);
        lblCode.setLayoutY(200);
        
        lblUTC = new Label();
        lblUTC.setText("UTC = 0");
        lblUTC.setFont(Font.font("Arial", 20));
        lblUTC.setLayoutX((screenWidth/6)*2.5 - 25);
        lblUTC.setLayoutY(300);
        
        sliderUTC = new Slider();
        sliderUTC.setMin(-12);
        sliderUTC.setMax(14);
        sliderUTC.setLayoutX((screenWidth/6)*2.5 - 310);
        sliderUTC.setLayoutY(280);
        sliderUTC.setPrefWidth(660);
        sliderUTC.valueProperty().addListener((obs, oldval, newVal) ->
        {
        	UTC = (int) Math.round(newVal.doubleValue());
        	sliderUTC.setValue((double)UTC);
        	lblUTC.setText("UTC = " + UTC);
        });
        sliderUTC.setOnMouseReleased(event -> FileManagementForAIM.writeToFile("UTC.txt", Integer.toString(UTC)));
        
        lblDisplay = new Label();
        lblDisplay.setText("Display");
        lblDisplay.setFont(Font.font("Arial", 30));
        lblDisplay.setLayoutX((screenWidth/6)*6.1 - 200);
        lblDisplay.setLayoutY(150);
        
        cbAltitude = new CheckBox();
        cbAltitude.setText("Altitude of players");
        cbAltitude.setLayoutX((screenWidth/6)*6.1 - 200);
        cbAltitude.setLayoutY(190);
        cbAltitude.setSelected(true);
        cbAltitude.setOnAction(event -> {  
        	if(cbAltitude.isSelected())
    		{
        		altitude = 1;
        		FileManagementForAIM.writeToFile("disp_A.dat", Integer.toString(altitude));
    		}
        	else
        	{
        		altitude = 0;
        		FileManagementForAIM.writeToFile("disp_A.dat", Integer.toString(altitude));
        	}
        });
        
        cbDistance = new CheckBox();
        cbDistance.setText("Distance of players");
        cbDistance.setLayoutX((screenWidth/6)*6.1 - 200);
        cbDistance.setLayoutY(215);
        cbDistance.setSelected(true);
        cbDistance.setOnAction(event -> {  
        	if(cbDistance.isSelected())
    		{
        		distance = 1;
        		FileManagementForAIM.writeToFile("disp_D.dat", Integer.toString(distance));
    		}
        	else
        	{
        		distance = 0;
        		FileManagementForAIM.writeToFile("disp_D.dat", Integer.toString(distance));
        	}
        });
        
        cbDeadPlayer = new CheckBox();
        cbDeadPlayer.setText("Dead players");
        cbDeadPlayer.setLayoutX((screenWidth/6)*6.1 - 200);
        cbDeadPlayer.setLayoutY(240);
        cbDeadPlayer.setSelected(true);
        cbDeadPlayer.setOnAction(event -> {  
        	if(cbDeadPlayer.isSelected())
    		{
        		dead_player = 1;
        		FileManagementForAIM.writeToFile("disp_DP.dat", Integer.toString(dead_player));
    		}
        	else
        	{
        		dead_player = 0;
        		FileManagementForAIM.writeToFile("disp_DP.dat", Integer.toString(dead_player));
        	}
        });
        
        //create layout and add objects
        Pane pane = new Pane();
        pane.getChildren().add(imageEshop);
        pane.getChildren().add(imageFacebook);
        pane.getChildren().add(imageYoutube);
        pane.getChildren().add(imageTimeZones);
        pane.getChildren().add(imageGoogleMaps);
        pane.getChildren().add(imageLatLong);        
        pane.getChildren().add(pi);
        pane.getChildren().add(lblStatus);        
        pane.getChildren().add(lblPlayers);
        pane.getChildren().add(lblRadio);
        pane.getChildren().add(lblRespawn);
        pane.getChildren().add(lblBluetooth);
        pane.getChildren().add(lblUserID);
        pane.getChildren().add(lblRFpower);
        pane.getChildren().add(lblRFchannel);
        pane.getChildren().add(lblCode);
        pane.getChildren().add(lblUTC);
        pane.getChildren().add(lblTimeZone);
        pane.getChildren().add(lblLatitude);
        pane.getChildren().add(lblLongitude);
        pane.getChildren().add(lblBluetoothName);
        pane.getChildren().add(lblBluetoothPIN);
        pane.getChildren().add(lblDisplay);
        pane.getChildren().add(txtBluetoothName);
        pane.getChildren().add(txtBluetoothPIN);
        pane.getChildren().add(txtLatitude);
        pane.getChildren().add(txtLongitude);
        pane.getChildren().add(txtUser);
        pane.getChildren().add(txtCode);
        pane.getChildren().add(sliderRFpower);
        pane.getChildren().add(sliderRFchannel);
        pane.getChildren().add(sliderUTC);
        pane.getChildren().add(cbAltitude);
        pane.getChildren().add(cbDistance);
        pane.getChildren().add(cbDeadPlayer);
        for(int i=0; i<20; i++)
        {
        	pane.getChildren().add(lblPlayerName[i]);
        	pane.getChildren().add(txtPlayerName[i]);
        }

        Scene scene = new Scene(pane, screenWidth, screenHeight-50);        
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.DECORATED);

        primaryStage.show();
        
        read_all_files();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
    void read_all_files()
    {
    	lblStatus.setText("Reading files:");
    	lblStatus.setVisible(true);
    	double prog=0.0, delta=1.0/42.0;
    	String fileData="none";
    	pi.setProgress(prog);
    	FileManagementForAIM.readORcreateFile("altitude.dat");    	
    	pi.setProgress(prog+=delta);
    	FileManagementForAIM.readORcreateFile("bcklght.dat");    	
    	pi.setProgress(prog+=delta);
    	BluetoothName = FileManagementForAIM.readORcreateFile("BT_name.txt");    	
        if(BluetoothName.length()>10)
        	BluetoothName = BluetoothName.substring(0, 10);
        if(BluetoothName.length()>=3 && !FileManagementForAIM.readORcreateFile("BT_name.txt").equals(BluetoothName))
        	FileManagementForAIM.writeToFile("BT_name.txt", BluetoothName);
        txtBluetoothName.setText(BluetoothName);
    	pi.setProgress(prog+=delta);    	
    	try
    	{
    		BluetoothPIN = Integer.parseInt(FileManagementForAIM.readORcreateFile("BT_PIN.txt"));
    	}        		
    	catch(Exception e)
    	{
    		System.out.println("BluetoothPIN: Wrong input");
    	}
        if(BluetoothPIN<1000)
        	BluetoothPIN=1000;
        else if(BluetoothPIN>9999) 
        	BluetoothPIN=9999;
        if(BluetoothPIN>=1000 && BluetoothPIN<=9999 && !FileManagementForAIM.readORcreateFile("BT_PIN.txt").equals(Integer.toString(BluetoothPIN)))
        	FileManagementForAIM.writeToFile("BT_PIN.txt", Integer.toString(BluetoothPIN));
        txtBluetoothPIN.setText(Integer.toString(BluetoothPIN));
    	pi.setProgress(prog+=delta);
    	code = FileManagementForAIM.readORcreateFile("code.txt");    	
        if(code.length()>4)
        	code = code.substring(0, 4);
        if(code.length()==4 && !FileManagementForAIM.readORcreateFile("code.txt").equals(code))
        	FileManagementForAIM.writeToFile("code.txt", code);
        txtCode.setText(code);
    	pi.setProgress(prog+=delta);
    	altitude = Integer.parseInt(FileManagementForAIM.readORcreateFile("disp_A.dat"));
    	if(altitude != 0)
    	{
    		altitude = 1;
    		cbAltitude.setSelected(true);
    	}
    	else
    	{
    		altitude = 0;
    		cbAltitude.setSelected(false);
    	}
    	pi.setProgress(prog+=delta);
    	distance = Integer.parseInt(FileManagementForAIM.readORcreateFile("disp_D.dat"));
    	if(distance != 0)
    	{
    		distance = 1;
    		cbDistance.setSelected(true);
    	}
    	else
    	{
    		distance = 0;
    		cbDistance.setSelected(false);
    	}
    	pi.setProgress(prog+=delta);
    	dead_player = Integer.parseInt( FileManagementForAIM.readORcreateFile("disp_DP.dat"));
    	if(dead_player != 0)
    	{
    		dead_player = 1;
    		cbDeadPlayer.setSelected(true);
    	}
    	else
    	{
    		dead_player = 0;
    		cbDeadPlayer.setSelected(false);
    	}
    	pi.setProgress(prog+=delta);
    	try
    	{
    		latitude = Double.parseDouble(FileManagementForAIM.readORcreateFile("latit.txt"));
		}        		
		catch(Exception e)
		{
			System.out.println("Latitude: Wrong input");
		}
        if(latitude>90.0)
          	latitude = 90.0;
        if(latitude<-90.0) 
        	latitude = -90.0; 
        if(!FileManagementForAIM.readORcreateFile("latit.txt").equals(Double.toString(latitude)))
        	FileManagementForAIM.writeToFile("latit.txt", Double.toString(latitude));
        txtLatitude.setText(Double.toString(latitude));
    	pi.setProgress(prog+=delta);
    	try
    	{
    		longitude = Double.parseDouble(FileManagementForAIM.readORcreateFile("longit.txt"));
		}        		
		catch(Exception e)
		{
			System.out.println("Longitude: Wrong input");
		}
        if(longitude>180.0)
        	longitude = 180.0;        
        if(longitude<-180.0)        
        	longitude = -180.0;        
        if(!FileManagementForAIM.readORcreateFile("longit.txt").equals(Double.toString(longitude)))
        	FileManagementForAIM.writeToFile("longit.txt", Double.toString(longitude));
        txtLongitude.setText(Double.toString(longitude));
    	pi.setProgress(prog+=delta);    	
    	
        for(int i=0; i<20; i++)
        {
        	char initPlayerID = (char) ('a' + i);
        	fileData=FileManagementForAIM.readORcreateFile("player_" + initPlayerID + ".txt");
        	txtPlayerName[i].setText(fileData);
        	pi.setProgress(prog+=delta);
        }
    	
    	RFchannel=Integer.parseInt(FileManagementForAIM.readORcreateFile("RF_ch.txt"));
    	sliderRFchannel.setValue((double)RFchannel);
    	pi.setProgress(prog+=delta);
    	RFpower=Integer.parseInt(FileManagementForAIM.readORcreateFile("RF_pwr.txt"));
    	sliderRFpower.setValue((double)RFpower);
    	pi.setProgress(prog+=delta);
    	FileManagementForAIM.readORcreateFile("track.dat");    	
    	pi.setProgress(prog+=delta);
    	FileManagementForAIM.readORcreateFile("track_NO.dat");    	
    	pi.setProgress(prog+=delta);
    	userID=FileManagementForAIM.readORcreateFile("user.txt");
    	userID.toLowerCase();
        if(userID.length()>1)
        	userID = userID.substring(0, 1);
        if(!userID.equals("a") && !userID.equals("b") && !userID.equals("c") && !userID.equals("d") && !userID.equals("e") && !userID.equals("f") && !userID.equals("g") && !userID.equals("h") && !userID.equals("i") && !userID.equals("j") &&
        		!userID.equals("k") && !userID.equals("l") && !userID.equals("m") && !userID.equals("n") && !userID.equals("o") && !userID.equals("p") && !userID.equals("q") && !userID.equals("r") && !userID.equals("s") && !userID.equals("t"))
        	userID="a";
        if(userID.length()==1 && !FileManagementForAIM.readORcreateFile("user.txt").equals(userID))
        	FileManagementForAIM.writeToFile("user.txt", userID);        
        txtUser.setText(userID);
    	pi.setProgress(prog+=delta);
    	UTC = Integer.parseInt(FileManagementForAIM.readORcreateFile("UTC.txt"));    	
    	sliderUTC.setValue((double)UTC);
    	pi.setProgress(prog+=delta);
    	FileManagementForAIM.readORcreateFile("x_m_off.dat");    	
    	pi.setProgress(prog+=delta);
    	FileManagementForAIM.readORcreateFile("x_m_rng.dat");    	
    	pi.setProgress(prog+=delta);
    	FileManagementForAIM.readORcreateFile("y_m_off.dat");    	
    	pi.setProgress(prog+=delta);
    	FileManagementForAIM.readORcreateFile("y_m_rng.dat");    	
    	pi.setProgress(prog+=delta);
    	FileManagementForAIM.readORcreateFile("z_m_off.dat");    	
    	pi.setProgress(prog+=delta);
    	FileManagementForAIM.readORcreateFile("z_m_rng.dat");    	
    	pi.setProgress(prog+=delta);
    	
    }

    private void keyStrikeListeners()
    {
        txtPlayerName[0].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[0] = newValue.toString();        	
            if(PlayerName[0].length()>10)
            	PlayerName[0] = PlayerName[0].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_a.txt").equals(PlayerName[0]))
            	FileManagementForAIM.writeToFile("player_a.txt", PlayerName[0]);
            txtPlayerName[0].setText(PlayerName[0]);
        });
        
        txtPlayerName[1].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[1] = newValue.toString();        	
            if(PlayerName[1].length()>10)
            	PlayerName[1] = PlayerName[1].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_b.txt").equals(PlayerName[1]))
            	FileManagementForAIM.writeToFile("player_b.txt", PlayerName[1]);
            txtPlayerName[1].setText(PlayerName[1]);
        });
        
        txtPlayerName[2].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[2] = newValue.toString();        	
            if(PlayerName[2].length()>10)
            	PlayerName[2] = PlayerName[2].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_c.txt").equals(PlayerName[2]))
            	FileManagementForAIM.writeToFile("player_c.txt", PlayerName[2]);
            txtPlayerName[2].setText(PlayerName[2]);
        });
        
        txtPlayerName[3].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[3] = newValue.toString();        	
            if(PlayerName[3].length()>10)
            	PlayerName[3] = PlayerName[3].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_d.txt").equals(PlayerName[3]))
            	FileManagementForAIM.writeToFile("player_d.txt", PlayerName[3]);
            txtPlayerName[3].setText(PlayerName[3]);
        });
        
        txtPlayerName[4].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[4] = newValue.toString();        	
            if(PlayerName[4].length()>10)
            	PlayerName[4] = PlayerName[4].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_e.txt").equals(PlayerName[4]))
            	FileManagementForAIM.writeToFile("player_e.txt", PlayerName[4]);
            txtPlayerName[4].setText(PlayerName[4]);
        });
        
        txtPlayerName[5].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[5] = newValue.toString();        	
            if(PlayerName[5].length()>10)
            	PlayerName[5] = PlayerName[5].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_f.txt").equals(PlayerName[5]))
            	FileManagementForAIM.writeToFile("player_f.txt", PlayerName[5]);
            txtPlayerName[5].setText(PlayerName[5]);
        });
        
        txtPlayerName[6].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[6] = newValue.toString();        	
            if(PlayerName[6].length()>10)
            	PlayerName[6] = PlayerName[6].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_g.txt").equals(PlayerName[6]))
            	FileManagementForAIM.writeToFile("player_g.txt", PlayerName[6]);
            txtPlayerName[6].setText(PlayerName[6]);
        });
        
        txtPlayerName[7].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[7] = newValue.toString();        	
            if(PlayerName[7].length()>10)
            	PlayerName[7] = PlayerName[7].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_h.txt").equals(PlayerName[7]))
            	FileManagementForAIM.writeToFile("player_h.txt", PlayerName[7]);
            txtPlayerName[7].setText(PlayerName[7]);
        });
        
        txtPlayerName[8].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[8] = newValue.toString();        	
            if(PlayerName[8].length()>10)
            	PlayerName[8] = PlayerName[8].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_i.txt").equals(PlayerName[8]))
            	FileManagementForAIM.writeToFile("player_i.txt", PlayerName[8]);
            txtPlayerName[8].setText(PlayerName[8]);
        });
        
        txtPlayerName[9].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[9] = newValue.toString();        	
            if(PlayerName[9].length()>10)
            	PlayerName[9] = PlayerName[9].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_j.txt").equals(PlayerName[9]))
            	FileManagementForAIM.writeToFile("player_j.txt", PlayerName[9]);
            txtPlayerName[9].setText(PlayerName[9]);
        });
        
        txtPlayerName[10].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[10] = newValue.toString();        	
            if(PlayerName[10].length()>10)
            	PlayerName[10] = PlayerName[10].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_k.txt").equals(PlayerName[10]))
            	FileManagementForAIM.writeToFile("player_k.txt", PlayerName[10]);
            txtPlayerName[10].setText(PlayerName[10]);
        });
        
        txtPlayerName[11].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[11] = newValue.toString();        	
            if(PlayerName[11].length()>10)
            	PlayerName[11] = PlayerName[11].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_l.txt").equals(PlayerName[11]))
            	FileManagementForAIM.writeToFile("player_l.txt", PlayerName[11]);
            txtPlayerName[11].setText(PlayerName[11]);
        });
        
        txtPlayerName[12].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[12] = newValue.toString();        	
            if(PlayerName[12].length()>10)
            	PlayerName[12] = PlayerName[12].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_m.txt").equals(PlayerName[12]))
            	FileManagementForAIM.writeToFile("player_m.txt", PlayerName[12]);
            txtPlayerName[12].setText(PlayerName[12]);
        });
        
        txtPlayerName[13].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[13] = newValue.toString();        	
            if(PlayerName[13].length()>10)
            	PlayerName[13] = PlayerName[13].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_n.txt").equals(PlayerName[13]))
            	FileManagementForAIM.writeToFile("player_n.txt", PlayerName[13]);
            txtPlayerName[13].setText(PlayerName[13]);
        });
        
        txtPlayerName[14].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[14] = newValue.toString();        	
            if(PlayerName[14].length()>10)
            	PlayerName[14] = PlayerName[14].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_o.txt").equals(PlayerName[14]))
            	FileManagementForAIM.writeToFile("player_o.txt", PlayerName[14]);
            txtPlayerName[14].setText(PlayerName[14]);
        });
        
        txtPlayerName[15].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[15] = newValue.toString();        	
            if(PlayerName[15].length()>10)
            	PlayerName[15] = PlayerName[15].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_p.txt").equals(PlayerName[15]))
            	FileManagementForAIM.writeToFile("player_p.txt", PlayerName[15]);
            txtPlayerName[15].setText(PlayerName[15]);
        });
        
        txtPlayerName[16].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[16] = newValue.toString();        	
            if(PlayerName[16].length()>10)
            	PlayerName[16] = PlayerName[16].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_q.txt").equals(PlayerName[16]))
            	FileManagementForAIM.writeToFile("player_q.txt", PlayerName[16]);
            txtPlayerName[16].setText(PlayerName[16]);
        });
        
        txtPlayerName[17].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[17] = newValue.toString();        	
            if(PlayerName[17].length()>10)
            	PlayerName[17] = PlayerName[17].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_r.txt").equals(PlayerName[17]))
            	FileManagementForAIM.writeToFile("player_r.txt", PlayerName[17]);
            txtPlayerName[17].setText(PlayerName[17]);
        });
        
        txtPlayerName[18].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[18] = newValue.toString();        	
            if(PlayerName[18].length()>10)
            	PlayerName[18] = PlayerName[18].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_s.txt").equals(PlayerName[18]))
            	FileManagementForAIM.writeToFile("player_s.txt", PlayerName[18]);
            txtPlayerName[18].setText(PlayerName[18]);
        });
        
        txtPlayerName[19].textProperty().addListener((observable, oldValue, newValue) -> {
        	PlayerName[19] = newValue.toString();        	
            if(PlayerName[19].length()>10)
            	PlayerName[19] = PlayerName[19].substring(0, 10);
            if(!FileManagementForAIM.readORcreateFile("player_t.txt").equals(PlayerName[19]))
            	FileManagementForAIM.writeToFile("player_t.txt", PlayerName[19]);
            txtPlayerName[19].setText(PlayerName[19]);
        });
    }
}