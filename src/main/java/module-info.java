module com.example.atividadeintegrais {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atividadeintegrais to javafx.fxml;
    exports com.example.atividadeintegrais;
}