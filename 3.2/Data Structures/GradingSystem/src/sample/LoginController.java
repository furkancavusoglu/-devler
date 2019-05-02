package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.util.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {

    PreparedStatement pst = null;
    ResultSet resultSet = null;
    Stage prevStage;

    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;

    public void setPrevStage(Stage stage) {
        this.prevStage = stage;
    }

    public void login(ActionEvent actionEvent) {

        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        try {
            Connection conn = DBUtil.dbConnect();
            /*Button button= new Button("Click this");
            button.setOnAction(e-> {
                        boolean result=ConfirmBox.display("Confirmation","Are you confirm?");
                        if(result)
                            window.close();
                    }
            );*/
            String query = "SELECT * FROM user WHERE USER_NAME=? AND PASSWORD=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, userName);
            pst.setString(2, password);
            resultSet = pst.executeQuery();

            if (resultSet.next()) {
                System.out.println("Login Successful");
                showMainView();

            } else {



                /* Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Form Error!");
                alert.setHeaderText(null);
                alert.setContentText("Username or password wrong");
                alert.show();*/
            }
            pst.close();
            resultSet.close();
            DBUtil.dbDisconnect(conn);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private void showMainView() {
        try {

            Pane myPane = FXMLLoader.load(getClass().getResource("view/main.fxml"));
            Scene scene = new Scene(myPane);
            Stage stage = new Stage();
            stage.setTitle("Main Page");

            stage.setScene(scene);

            prevStage.close();
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void btn(ActionEvent actionEvent) throws IOException {
//
//        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("view/main.fxml"));
//
//        Pane myPane = myLoader.load();
//
//        Stage stage = new Stage();
//
//
//
//        stage.setTitle("Login");
//        stage.setScene(new Scene(myPane));
//        stage.show();

      /*  Parent blah = FXMLLoader.load(getClass().getResource("view/main.fxml"));
        Scene scene = new Scene(blah);
        Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();*/


    }

}
