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

public class Login {

    private  Text email,password,msg, warn;
    private  TextField emailfield;
    private  PasswordField passwordField;
    private  CustomButton login,register;
    private  Stage stage;
    private Scene scene;


    public Login (){

        stage = new Stage();
        ;

        email = new Text(80,230,"Email");
        email.setFont(Font.font("Times New Roman",18));

        emailfield = new TextField();
        emailfield.setLayoutX(77);
        emailfield.setLayoutY(260);
        emailfield.setPrefWidth(300);


        password = new Text(80,320,"Password");
        password.setFont(Font.font("Times New Roman",18));

        passwordField = new PasswordField();
        passwordField.setLayoutX(77);
        passwordField.setLayoutY(335);
        passwordField.setPrefWidth(300);

        login = new CustomButton(80,379,"Login","Times New Roman",14);
        login.setPrefHeight(30);
        login.setPrefWidth(78);

        warn = new Text(80,550,"username or password not valid");
        warn.setFont(Font.font("Times New Roman",18));
        warn.setVisible(false);


        login.setOnAction(e->{
            if(check()==false || login() == false){
                ((Node)(e.getSource())).getScene().getWindow().hide();
                new Login();
                new WarningMessage();

            }
            if(check()==true && login()==true) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                new GameMenu();
            }
        });

        msg = new Text(77,450,"If you don't have any account click Registration");
        msg.setFont(Font.font("Times New Roman",16));

        register = new CustomButton(80,479,"Register","Times New Roman",14);
        register.setPrefHeight(30);
        register.setPrefWidth(78);

        register.setOnAction(e->{
            ((Node)(e.getSource())).getScene().getWindow().hide();
            new Registration();
        });


        Group root = new Group(email,emailfield,password,passwordField,login,msg,register,warn);
        scene = new Scene(root,500,600);
        stage.setScene(scene);
        stage.show();
    }

    public boolean login(){
        String u,p;
        u = emailfield.getText();
        p =  passwordField.getText();
        DataBaseService db = new DataBaseService();
        return db.MemberLogin(u,u,p);
    }

    public boolean check(){
        if(emailfield.getText().isEmpty() && passwordField.getText().isEmpty()){
            return false;
        }
        else
            return true;
    }
}
