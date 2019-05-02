package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static void display(String title,String message){
        Stage window =new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label1=new Label(message);
        Button closeButton=new Button("Close the window");
        closeButton.setOnAction(e-> window.close());
        VBox pane= new VBox();
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(label1,closeButton);
        Scene scene= new Scene(pane,100,100);
        window.setScene(scene);
        window.showAndWait();
    }
}
