package buttonHandling;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import srnGui.Main;

public class UserPage {
	private static TextField field;
	public static void setOnAction(Button button) {

		button.setOnAction(event -> {
			if(UserPage.validateLogin()) {
				Button cancelButton = new Button("LOGOUT");
				Button openButton = new Button("open file");
				VBox vBox = new VBox();

				vBox.setSpacing(8);
				vBox.setPadding(new Insets(10,10,10,10));
				field = new TextField();
				vBox.getChildren().addAll(
						new Label(""),
						field,
						openButton,
						cancelButton);

				StackPane createAccountLayout = new StackPane();
				createAccountLayout.getChildren().addAll(vBox);

				Scene newScene = new Scene(createAccountLayout, Main.getMainScene().getWidth(), Main.getMainScene().getHeight());
				Main.getMainStage().setScene(newScene);
				CreateAccount.setReturn(cancelButton); //onClickMethode wird in CREATEACCOUNT Klasse definiert
				UserPage.openFile(openButton);
			}
			else {
				System.out.println("");
			}

		});
	}

	public static boolean validateLogin() {
		return true; 
	}

	public static void openFile(Button button) {
		button.setOnAction(event -> {
			String text = field.getText();
			File file = new File(text);
			if(!file.exists()) {
				System.out.println("File does not exists");
			}			
			else if(!Desktop.isDesktopSupported()){
				System.out.println("Desktop is not supported");
			}
			else {
				EventQueue.invokeLater(()->{
					try {
						Desktop.getDesktop().open(file);
						/**
						 * Öffnen des defaul text-editors:
						 * -> klappt unter Linux(ubuntu) (windows noch nicht getestet
						 * -> allerding wird immer eine Fehlermeldung rausgegeben:
						 * 		Gdk-WARNING **
						 * 		XSetErrorHandler() called with a GDK error trap pushed. Don't do that.
						 */
					} catch (IOException e) {
						System.out.println("Fehler!");
					}
				});
			}	});		
	}
}
