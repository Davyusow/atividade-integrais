package com.example.atividadeintegrais.view;

import java.lang.reflect.*;

import com.example.atividadeintegrais.controller.Conversor;
import com.example.atividadeintegrais.model.Funcao;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TelaInicial extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AtividadeIntegrais");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        Scene scene = new Scene(grid,300,275);
        primaryStage.setScene(scene);

        Text tituloDaCena = new Text("Bem Vindo!");
        grid.add(tituloDaCena,0,0,2,1);

        Label expressao = new Label("Função: ");
        grid.add(expressao,0,1);

        TextField expressaoTexto = new TextField();
        grid.add(expressaoTexto,1,1);

        Button botao = new Button("confirmar");
        grid.add(botao,1,2);
        botao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Funcao funcao = new Funcao(expressaoTexto.getText(),"x",4);
                double resultado = Conversor.converterParaDouble(funcao);
                System.out.println("Resultado: " + resultado);
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Resultado: " + resultado);
                alert.showAndWait();
            }
        });

        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
