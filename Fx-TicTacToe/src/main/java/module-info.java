module lk.edu.game.fxtictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    opens lk.edu.game.fxtictactoe to javafx.fxml;
    exports lk.edu.game.fxtictactoe;
}