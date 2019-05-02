package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    static boolean answer;
    public static boolean display(String title,String message){
        Stage window =new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label1=new Label(message);

        Button yesButton=new Button("yes");
        Button noButton=new Button("no");

        yesButton.setOnAction(e-> {
            answer=true;
            window.close();
        });
        noButton.setOnAction(e->{
            answer=false;
            window.close();
        });

        VBox pane= new VBox(10);
        pane.getChildren().addAll(label1,yesButton,noButton);
        pane.setAlignment(Pos.CENTER);
        Scene scene= new Scene(pane);
        window.setScene(scene);
        window.showAndWait();
        return answer;
    }
}
