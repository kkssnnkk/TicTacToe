package sample.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

public class HelloController {

    @FXML
    private Button bReset;

    @FXML
    private Label result;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;

    @FXML
    private Label label8;

    @FXML
    private Label label9;

    String turn = "P1";

    boolean access = true;

    public boolean checkLine(Label label1, Label label2, Label label3, String symbol) {
        return Objects.equals(label1.getText(), symbol) && Objects.equals(label2.getText(), symbol) && Objects.equals(label3.getText(), symbol);
    }

    public void checkDiagonals(String text, String symbol) {
        if (checkLine(label1, label5, label9, symbol) || checkLine(label3, label5, label7, symbol)) {
            result.setText(text);
            access = false;
            bReset.setVisible(true);
        }
    }

    public void checkVerticals(String text, String symbol) {
        if (checkLine(label1, label4, label7, symbol) || checkLine(label2, label5, label8, symbol) || checkLine(label3, label6, label9, symbol)) {
            result.setText(text);
            access = false;
            bReset.setVisible(true);
        }
    }

    public void checkHorizontals(String text, String symbol) {
        if (checkLine(label1, label2, label3, symbol) || checkLine(label4, label5, label6, symbol) || checkLine(label7, label8, label9, symbol)) {
            result.setText(text);
            access = false;
            bReset.setVisible(true);
        }
    }

    public void checkWin() {
        checkDiagonals("Player 1 Win", "✕");
        checkVerticals("Player 1 Win", "✕");
        checkHorizontals("Player 1 Win", "✕");

        checkDiagonals("Player 2 Win", "🞅");
        checkVerticals("Player 2 Win", "🞅");
        checkHorizontals("Player 2 Win", "🞅");
    }

    public void getTurn(Label label) {
        if (Objects.equals(label.getText(), "✕") || Objects.equals(label.getText(), "🞅") || !access) {
            return;
        }
        else if (Objects.equals(turn, "P1")) {
            label.setText("✕");
            turn = "P2";
        }
        else {
            label.setText("🞅");
            turn = "P1";
        }

        checkWin();
    }

    @FXML
    void onResetButtonClicked(MouseEvent event) {
        bReset.setVisible(false);
        access = true;
        result.setText("");
        label1.setText("");
        label2.setText("");
        label3.setText("");
        label4.setText("");
        label5.setText("");
        label6.setText("");
        label7.setText("");
        label8.setText("");
        label9.setText("");
    }

    public void onLabel1Clicked(MouseEvent mouseEvent) {
        getTurn(label1);
    }

    public void onLabel2Clicked(MouseEvent mouseEvent) {
        getTurn(label2);
    }

    public void onLabel3Clicked(MouseEvent mouseEvent) {
        getTurn(label3);
    }

    public void onLabel4Clicked(MouseEvent mouseEvent) {
        getTurn(label4);
    }

    public void onLabel5Clicked(MouseEvent mouseEvent) {
        getTurn(label5);
    }

    public void onLabel6Clicked(MouseEvent mouseEvent) {
        getTurn(label6);
    }

    public void onLabel7Clicked(MouseEvent mouseEvent) {
        getTurn(label7);
    }

    public void onLabel8Clicked(MouseEvent mouseEvent) {
        getTurn(label8);
    }

    public void onLabel9Clicked(MouseEvent mouseEvent) {
        getTurn(label9);
    }
}