module com.example.atividadeintegrais {
    requires javafx.controls;
    requires javafx.fxml;
    requires exp4j;


    opens com.example.atividadeintegrais to javafx.fxml;
    exports com.example.atividadeintegrais.controller;
}