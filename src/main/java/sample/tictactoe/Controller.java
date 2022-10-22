package sample.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.util.Objects;

public class Controller {

    @FXML
    public AnchorPane pane;

    @FXML
    public Label name;

    @FXML
    private Button bReplay;

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

    public boolean checkDiagonals(String symbol) {
        return checkLine(label1, label5, label9, symbol) || checkLine(label3, label5, label7, symbol);
    }

    public boolean checkVerticals(String symbol) {
        return checkLine(label1, label4, label7, symbol) || checkLine(label2, label5, label8, symbol) || checkLine(label3, label6, label9, symbol);
    }

    public boolean checkHorizontals(String symbol) {
        return checkLine(label1, label2, label3, symbol) || checkLine(label4, label5, label6, symbol) || checkLine(label7, label8, label9, symbol);
    }

    public String checkWin() {
        if (checkDiagonals("✕") || checkVerticals("✕") || checkHorizontals("✕"))
            return "P1";

        else if (checkDiagonals("🞅") || checkVerticals("🞅") || checkHorizontals("🞅"))
            return "P2";

        else return "";
    }

    public boolean checkDraw() {
        return !Objects.equals(label1.getText(), "") && !Objects.equals(label2.getText(), "") && !Objects.equals(label3.getText(), "") &&
               !Objects.equals(label4.getText(), "") && !Objects.equals(label5.getText(), "") && !Objects.equals(label6.getText(), "") &&
               !Objects.equals(label7.getText(), "") && !Objects.equals(label8.getText(), "") && !Objects.equals(label9.getText(), "");
    }

    public void checkResult() {
        if (Objects.equals(checkWin(), "P1")) {
            result.setText("Player 1 Win");
            access = false;
        }
        else if (Objects.equals(checkWin(), "P2")) {
            result.setText("Player 2 Win");
            access = false;
        }
        else if (checkDraw()) {
            result.setText("Draw");
            access = false;
        }
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

        bReplay.setVisible(true);

        checkResult();
    }

    @FXML
    void onResetButtonClicked() {
        bReplay.setVisible(false);
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

    public void onLabel1Clicked() {
        getTurn(label1);
    }

    public void onLabel2Clicked() {
        getTurn(label2);
    }

    public void onLabel3Clicked() {
        getTurn(label3);
    }

    public void onLabel4Clicked() {
        getTurn(label4);
    }

    public void onLabel5Clicked() {
        getTurn(label5);
    }

    public void onLabel6Clicked() {
        getTurn(label6);
    }

    public void onLabel7Clicked() {
        getTurn(label7);
    }

    public void onLabel8Clicked() {
        getTurn(label8);
    }

    public void onLabel9Clicked() {
        getTurn(label9);
    }
}