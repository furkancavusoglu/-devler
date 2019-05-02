package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.model.User;
import sample.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EditUserController {

    User user;
    int id;
    Connection conn = null;
    @FXML
    private TextField txtSurname;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTelephone;
    @FXML
    private TextField txtPassword;

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
        id = user.getId();
        txtName.setText(user.getFirstName());
        txtSurname.setText(user.getLastName());
        txtUserName.setText(user.getUserName());
        txtPassword.setText(user.getPassword());
        txtEmail.setText(user.getEmail());
        txtTelephone.setText(user.getTelephone());

    }


    public void updateUserData(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        conn = DBUtil.dbConnect();
        String username = txtUserName.getText();
        String password = txtPassword.getText();
        String firstname = txtName.getText();
        String lastname = txtSurname.getText();

        String email = txtEmail.getText();
        String telephone = txtTelephone.getText();

        if (!txtUserName.getText().isEmpty()) {
            conn = DBUtil.dbConnect();
            String query = "UPDATE user SET USER_NAME='" + username + "',PASSWORD='" + password + "' ,FIRST_NAME='" + firstname + "' ,LAST_NAME='" + lastname + "' ,EMAIL='" + email + "' , TELEPHONE='" + telephone + "' WHERE ID=" + id;
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(query);
            if (result == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Güncellendi");
                alert.showAndWait();


            }


            stmt.close();
            DBUtil.dbDisconnect(conn);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("username not null");
            alert.showAndWait();

        }


    }
}
