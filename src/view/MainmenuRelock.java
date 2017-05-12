package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CustomButton;

public class MainmenuRelock {
    private Stage stage;
    private CustomButton custombutton;
    private Scene scene;

    public MainmenuRelock(){

        stage = new Stage();

        custombutton = new CustomButton(150, 248, "Managment", 24);
        custombutton.setPrefWidth(220);
        custombutton.setPrefHeight(68);

        Group root = new Group(custombutton);
        scene = new Scene(root, 500, 600);
        stage.setScene(scene);
        stage.show();

        custombutton.setOnAction(e -> {
            ((Node) (e.getSource())).getScene().getWindow().hide();
            new Login();
        });


    }
}
