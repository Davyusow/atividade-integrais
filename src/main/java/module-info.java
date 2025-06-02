module com.example.atividadeintegrais {
    requires javafx.controls;
    requires javafx.fxml;
    requires exp4j;

    exports com.example.atividadeintegrais.view;


    opens com.example.atividadeintegrais to javafx.fxml;
    exports com.example.atividadeintegrais.controller;
}