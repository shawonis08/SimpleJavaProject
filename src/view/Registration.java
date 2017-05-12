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


public class Registration {
        private  Text username,email,password;
        private  TextField userfield,emailfield;
        private  PasswordField passwordField;
        private  CustomButton register,cancel;
        private  Stage stage;
        private Scene scene;
        private DataBaseService dataBaseService;

    public Registration(){

        stage = new Stage();

        username = new Text(72,230,"Username");
        username.setFont(Font.font("Times New Roman",18));

        userfield = new TextField();
        userfield.setLayoutX(72);
        userfield.setLayoutY(250);
        userfield.setPrefWidth(300);

        email = new Text(72,300,"Email");
        email.setFont(Font.font("Times New Roman",18));

        emailfield = new TextField();
        emailfield.setLayoutX(72);
        emailfield.setLayoutY(320);
        emailfield.setPrefWidth(300);

        password = new Text(72,370,"Password");
        password.setFont(Font.font("Times New Roman",18));

        passwordField = new PasswordField();
        passwordField.setLayoutX(72);
        passwordField.setLayoutY(390);
        passwordField.setPrefWidth(300);

        register = new CustomButton(72,450,"Submit","Times New Roman",14);
        register.setPrefHeight(30);
        register.setPrefWidth(78);

        register.setOnAction(e->{
            if (check()==false){
                ((Node)(e.getSource())).getScene().getWindow().hide();
                new Registration();
            }
            if (check() == true) {
                register();
                ((Node) (e.getSource())).getScene().getWindow().hide();
                new Login();
            }
        });
        cancel = new CustomButton(280,450,"cancel","Times New Roman",14);
        cancel.setPrefHeight(30);
        cancel.setPrefWidth(78);
        cancel.setOnAction(e->{
            ((Node)(e.getSource())).getScene().getWindow().hide();
            new Login();
        });


        Group root = new Group(username,userfield,email,emailfield,password,passwordField,register,cancel);
        scene = new Scene(root,500,600);
        stage.setScene(scene);
        stage.show();

    }
    public void register(){
        String u,e,p;
        u = userfield.getText();
        p =  passwordField.getText();
        e = emailfield.getText();
        DataBaseService db = new DataBaseService();
        db.MemberRegistration(u,e,p);
    }

    public boolean check(){
        if(userfield.getText().isEmpty() || emailfield.getText().isEmpty() || passwordField.getText().isEmpty()){
            return false;
        }
        else
            return true;
    }

}