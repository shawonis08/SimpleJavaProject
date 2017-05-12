package service;

import data.DataBaseConnection;
import model.Member;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseService {
    private DataBaseConnection dataBaseConnection = new DataBaseConnection();
    private Member membre1, member2,member3,member4;


    public boolean MemberRegistration(String uname, String email, String pass){
        membre1 = new Member(email, pass, uname);
        String insert = "INSERT INTO registrations VALUES('" + membre1.getUsername() + "'," + "'" + membre1.getEmail() + "'," + "'" + membre1.getPassword() + "'," + 1 + ");";
        System.out.println(insert);
        int a = 0;
        try {
            a = dataBaseConnection.inupdatedel(insert);

        } catch (NullPointerException e){
            System.out.println("Error");
        }
        if (a == 1) {
            return true;
        }
        else {
            return false;
        }

    }

    public boolean MemberLogin(String uname, String email, String pass) {
        member2 = new Member(email,pass,uname);
        String query = "SELECT id FROM registrations WHERE email='" + member2.getEmail() + "' And  password='" + member2.getPassword() + "';";
        System.out.println(query);
        try {
            ResultSet rs = dataBaseConnection.selectQuery(query);
            if (rs.next()) {
                int a = rs.getInt("id");
                if (a == 1)
                    return true;
                else
                    return false;
            }
        } catch (SQLException e) {
                System.out.println("Error authentication");
        }
        return false;
    }

    public boolean MemberDelete(String email){
        member3 = new Member(email);
        String delete = "DELETE FROM registrations WHERE email ='" + member3.getEmail() +"';";
        System.out.println(delete);
        int a = 0;
        try {
            a = dataBaseConnection.inupdatedel(delete);

        } catch (NullPointerException p){
            System.out.println("Error");
        }
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean MemberUpdate(String email, String pass){
        member4 = new Member(email,pass);
        String update = "UPDATE registrations SET password = '"+ member4.getPassword() +"' WHERE email = '"+ member4.getEmail()+"';";
        System.out.println(update);
        int a = 0;
        try {
            a = dataBaseConnection.inupdatedel(update);

        } catch (NullPointerException t){
            System.out.println("Error");
        }
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }
}
