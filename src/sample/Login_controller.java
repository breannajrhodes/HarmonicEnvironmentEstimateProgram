package sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import  javafx.scene.text.Text;

public class Login_controller {

    @FXML
    private TextField txtfield_username;

    @FXML
    private PasswordField txtfield_password;

    @FXML
    private Button btn_login;

    @FXML
    public Button reset_pass_btn;

    @FXML
    public Text login_error_text;

    @FXML
    void login(MouseEvent event) throws SQLException {
        String username = "";
        String password = "";
        Database_Accessor accessor = new Database_Accessor();
        ResultSet rs;

        if(txtfield_username.getText().equals("") || txtfield_password.getText().equals("")){
            login_error_text.setText("Incorrect Username or Password");
        }else{
            username = txtfield_username.getText();
            password = txtfield_password.getText();
            Main.current_user = new User(username, password);
            txtfield_username.clear();
            txtfield_password.clear();
            rs = accessor.access_database("SELECT username, password FROM "
                + "login");
            while (rs.next()){
                String user = rs.getString("username");
                String pass = rs.getString("password");

                if (username.equalsIgnoreCase(user) && password.equals(pass)){
                    // Set current user in main using the username and password
                    User myUser = new User(username, password);
                    Main.current_user = myUser;
                    login_error_text.setText("Incorrect Username or Password");
                    Main.createNewScene(event, "Existing_client_table_screen.fxml");
                }
                else {
                    login_error_text.setText("Incorrect username or password.");
                }
            }
        }

    }

    @FXML
    void resetPassword(MouseEvent reset) throws SQLException{
        Main.createNewScene(reset, "password_reset.fxml");
    }
}
