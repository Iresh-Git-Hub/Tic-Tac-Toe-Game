package lk.edu.game.fxtictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("/view/TicTocToeView.fxml"));
       stage.setScene(new Scene(root));
       stage.setTitle("TicTacToe");
       stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}