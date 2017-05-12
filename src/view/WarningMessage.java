package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class WarningMessage {
    private Label warning;
    private Stage stage;
    private Scene scene;

    public WarningMessage(){

        stage = new Stage();

        warning = new Label("Invalid Username or Password.Please try again!!");
        warning.setLayoutX(16);
        warning.setLayoutY(27);
        warning.prefHeight(72);
        warning.prefWidth(458);
        warning.setFont(Font.font("Times New Roman",22));

        Group root = new Group(warning);
        scene = new Scene(root,480,60);
        stage.setScene(scene);
        stage.show();
    }
}
