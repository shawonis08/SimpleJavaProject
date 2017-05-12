package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.CustomButton;
import service.DataBaseService;

public class Delete {
    private Text email, password;
    private TextField emailfield;
    private PasswordField passwordField;
    private CustomButton confirm;
    private Stage stage;
    private Scene scene;
    private DataBaseService dataBaseService;

    public Delete(){
        stage = new Stage();


        email = new Text(72, 300, "Existing Email");
        email.setFont(Font.font("Times New Roman", 18));

        emailfield = new TextField();
        emailfield.setLayoutX(72);
        emailfield.setLayoutY(320);
        emailfield.setPrefWidth(300);


        confirm = new CustomButton(72, 450, "confirm Delete", "Times New Roman", 14);
        confirm.setPrefHeight(30);
        confirm.setPrefWidth(150);

        confirm.setOnAction(e->{
            delete();
            ((Node)(e.getSource())).getScene().getWindow().hide();
            new Login();
        });


        Group root = new Group(email, emailfield, confirm);
        scene = new Scene(root, 500, 600);
        stage.setScene(scene);
        stage.show();

    }
    public void delete(){
        String e;
        e = emailfield.getText();
        DataBaseService db = new DataBaseService();
        db.MemberDelete(e);
    }
}
