package buttonHandling;

//import bla.JNIHello;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import srnGui.Main;
import start.JNIHello;

public class CreateAccount {

	public static void setOnAction(Button button) {

		button.setOnAction(event -> {
			System.out.println("Java: create account action detected!");
			JNIHello.helloJNI();

			Button createAccountButton = new Button("CREATE ACCOUNT");
			Button cancelButton = new Button("CANCEL");
			VBox vBox = new VBox();
			
			HBox hBox = new HBox();
			hBox.getChildren().addAll(createAccountButton, cancelButton);
						
			vBox.setSpacing(8);
	        vBox.setPadding(new Insets(10,10,10,10));
	        vBox.getChildren().addAll(
	                new Label("Enter new Username"),
	                new TextField(),
	                new Label("Enter Password"),
	                new PasswordField(),
	                new Label("Enter Password Again"),
	                new PasswordField(),
	                hBox);
	        
			StackPane createAccountLayout = new StackPane();
			createAccountLayout.getChildren().addAll(vBox);
	
			Scene newScene = new Scene(createAccountLayout, Main.getMainScene().getWidth(), Main.getMainScene().getHeight());
			Main.getMainStage().setScene(newScene);
			CreateAccount.setReturn(cancelButton);
		});
	} 
	
	public static void setReturn(Button button) {
		button.setOnAction(event -> {
			Main.getMainStage().setScene(Main.getMainScene());
		});		
	}

}
