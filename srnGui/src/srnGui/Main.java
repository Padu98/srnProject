package srnGui;
import buttonHandling.CreateAccount;
import buttonHandling.UserPage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Main extends Application{	
	private Button loginButton;
	private Button createAccountButton;
    private StackPane rootLayout = new StackPane();
    private static Stage stage;
    private static Scene scene;
	
	public static void main(String [] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
        scene = new Scene(rootLayout,400,600);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("SRN GUI");
        primaryStage.setAlwaysOnTop(true);	
        stage = primaryStage;
	}
	 
    @Override
    public void init() {
        VBox vBox = new VBox();
        loginButton = new Button("LOGIN");
        createAccountButton = new Button("CREATE ACCOUNT");

        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(
                new Label("Your Username"),
                new TextField(),
                new Label("Your Password"),
                new PasswordField(),
                loginButton,
                createAccountButton);
        rootLayout.getChildren().addAll(vBox);
        
        CreateAccount.setOnAction(createAccountButton);  //initialisiert die Handler Methode des übergebenen Objects
        UserPage.setOnAction(loginButton);
        
    }
    
    public static Stage getMainStage() {
    	return stage;
    }
    
    public static Scene getMainScene() {
    	return scene;
    }

}
