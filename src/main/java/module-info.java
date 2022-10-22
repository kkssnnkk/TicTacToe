module sample.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens sample.tictactoe to javafx.fxml;
    exports sample.tictactoe;
}