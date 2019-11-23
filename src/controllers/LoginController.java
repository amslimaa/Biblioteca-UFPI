package controllers;

import animatefx.animation.ZoomIn;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;


public class LoginController {


    ObservableList<String> LocatarioTipo = FXCollections.observableArrayList("Aluno", "Professor", "TecAdministrativo");


    @FXML
    private ChoiceBox CadChoiceBox = null;

    @FXML
    private Pane pnlLogin = null;

    @FXML
    private Pane pnlCad = null;

    @FXML
    private Object btnBack = null;

    @FXML
    private Circle btnClose = null;
    @FXML
    private Button btnCad = null;


    @FXML
    public void initialize(){
        CadChoiceBox.setValue("Vinculo");
        CadChoiceBox.setItems(LocatarioTipo);

    }

    public void handleButtonAction(ActionEvent event) {
        if(event.getSource().equals(btnCad)){
            new ZoomIn(pnlCad).play();
            pnlCad.toFront();
        }

    }

    public void handleMouseEvent(MouseEvent event) {
        if(event.getSource() == btnClose){
            System.exit(0);
        }
        if(event.getSource() .equals(btnBack)){
            new ZoomIn(pnlLogin).play();
            pnlLogin.toFront();
        }
    }



}