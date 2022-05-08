package buttonHandling;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import srnGui.Main;

public class UserPage {
	private static TextField field;
	private static ArrayList<HBox> hboxList;

	public static void setOnAction(Button button) {
		button.setOnAction(event -> {
			if(UserPage.validateLogin()) {
				Button cancelButton = new Button("LOGOUT");
				Button openButton = new Button("open file (nur ein Beispiel)");

				/**
				 * In der hboxList soll später mal für jedes Element des "Schlüsselbunds"
				 * ein hBox element angelegt werde. Das Element hat den Namen der Datei sowie 
				 * einen Button zum editieren und einen zum download.
				 * Die liste wird später (zum Stand der doku in z.59 durchiteriert und jedes Element 
				 * in ober-VBox geschrieben.
				 */
				hboxList = new ArrayList<>();
				for(int i = 0; i<9; i++) {	
					Text text = new Text("File" + (i+1));
					Button edit = new Button("edit File");
					Button download = new Button("download");	
					HBox box = new HBox(text, edit, download);
					box.setPadding(new Insets(7,7,7,7));
					box.setSpacing(8);
					hboxList.add(box);
				}
				
				VBox vBox = new VBox();

				vBox.setSpacing(8);
				vBox.setPadding(new Insets(10,10,10,10));
				field = new TextField();
				vBox.getChildren().addAll(
						cancelButton,
						new Label(""),
						field,
						openButton);

					for(HBox box: hboxList) {
						vBox.getChildren().add(box);
					}

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
