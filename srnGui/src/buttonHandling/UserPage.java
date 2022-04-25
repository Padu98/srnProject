package buttonHandling;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import srnGui.Main;

public class UserPage {
	public static void setOnAction(Button button) {
		
		button.setOnAction(event -> {
			if(UserPage.validateLogin()) {
				Button cancelButton = new Button("LOGOUT");
				VBox vBox = new VBox();
				
							
				vBox.setSpacing(8);
		        vBox.setPadding(new Insets(10,10,10,10));
		        vBox.getChildren().addAll(
		                new Label(""),
		               cancelButton);
		        
				StackPane createAccountLayout = new StackPane();
				createAccountLayout.getChildren().addAll(vBox);
		
				Scene newScene = new Scene(createAccountLayout, Main.getMainScene().getWidth(), Main.getMainScene().getHeight());
				Main.getMainStage().setScene(newScene);
				CreateAccount.setReturn(cancelButton); //onClickMethode wird in CREATEACCOUNT Klasse definiert
			}
			else {
				System.out.println("");
			}

		});
	}
	
	public static boolean validateLogin() {
		return true; 
	}

}
