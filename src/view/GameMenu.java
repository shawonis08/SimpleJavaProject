package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CustomButton;



public class GameMenu {

    private  CustomButton update,delete,logout;
    private Stage stage;
    private Scene scene;



    public GameMenu() {

        stage = new Stage();


        update = new CustomButton(175,275,"Update Data",18);
        update.setPrefWidth(190);
        update.setPrefHeight(50);

        update.setOnAction(e->{
            ((Node)(e.getSource())).getScene().getWindow().hide();
            new Update();
        });

        delete = new CustomButton(175,375,"Delete Data",18);
        delete.setPrefWidth(190);
        delete.setPrefHeight(50);

        delete.setOnAction(e->{
            ((Node)(e.getSource())).getScene().getWindow().hide();
            new Delete();
        });


        logout = new CustomButton(175,475,"Logout",18);
        logout.setPrefWidth(190);
        logout.setPrefHeight(50);

        logout.setOnAction(e->{
            ((Node)(e.getSource())).getScene().getWindow().hide();
            new MainmenuRelock();
        });


        Group root = new Group(update,delete,logout);
        scene = new Scene(root,500,600);
        stage.setScene(scene);
        stage.show();


    }
}
