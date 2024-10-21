package lk.edu.game.fxtictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.*;

enum Symbol {
    X , O
}

public class TicTacController implements Initializable {

    private int playerTurn = 0;
    private ArrayList<Button>buttons;

    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Label winnerLbl;

    @FXML
    public void restartGame(ActionEvent event) {
        buttons.forEach(button -> {
            button.setText("");
            button.setDisable(false);
            winnerLbl.setText("");
            playerTurn = 0;
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        winnerLbl.setText("");
        try {
            // add buttons in array list
            buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));

            buttons.forEach(button -> {
                button.setOnAction((ActionEvent event) -> {
                    if (playerTurn % 2 == 0) {
                        button.setText(Symbol.X.toString());
                        button.setDisable(true);
                        findWinner();
                        playerTurn = 1;
                        // AI Player
                        aiMove();
                    }
                });
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // AI move logic
    private void aiMove() {
        Random random = new Random();
        List<Button> emptyButtons = new ArrayList<>();
        // add button.settext("") buttons in new array.
        buttons.forEach(button -> {
            if (button.getText().isEmpty()) {
                emptyButtons.add(button);
            }
        });

        // randomy list eke size ekata random range eka select wenawa.
        if (!emptyButtons.isEmpty()) {
            Button aiButton = emptyButtons.get(random.nextInt(emptyButtons.size()));
            aiButton.setText(Symbol.O.toString());
            aiButton.setDisable(true);
            findWinner();
            playerTurn = 0;
        }
    }

    public void findWinner() {
        try {
            for (int i = 0; i <= 8; i++) {
               String line = "";
               switch (i){
                 case 0:
                     line = button1.getText() + button2.getText() + button3.getText();
                     break;
                 case 1:
                     line = button4.getText() + button5.getText() + button6.getText();
                     break;
                 case 2:
                     line = button7.getText() + button8.getText() + button9.getText();
                     break;
                 case 3:
                     line = button1.getText() + button5.getText() + button9.getText();
                     break;
                 case 4:
                     line = button3.getText() + button5.getText() + button7.getText();
                     break;
                 case 5:
                     line = button1.getText() + button4.getText() + button7.getText();
                     break;
                 case 6:
                     line = button3.getText() + button6.getText() + button9.getText();
                     break;
                 case 7:
                     line = button2.getText() + button5.getText() + button8.getText();
                     break;
                 default:
                     break;
               }
                if (line.equals(Symbol.X.toString()+Symbol.X.toString()+Symbol.X.toString())) {
                    disableAllButtons();
                    winnerLbl.setText("Human");
                }else if (line.equals(Symbol.O.toString()+Symbol.O.toString()+Symbol.O.toString())) {
                    disableAllButtons();
                    winnerLbl.setText("AI Player");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disableAllButtons() {
        buttons.forEach(button -> {
            button.setDisable(true);
        });
    }
}