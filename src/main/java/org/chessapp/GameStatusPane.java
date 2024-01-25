package org.chessapp;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GameStatusPane extends VBox {
    public static Text status;

    public GameStatusPane(){
        status = new Text("Ongoing");
        getChildren().add(status);
    }
    public Text getStatus() {
        return status;
    }

    public static void setText(String text){
        status.setText(text);
    }
}
