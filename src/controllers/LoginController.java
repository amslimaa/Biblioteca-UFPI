package controllers;

import DAO.LocatarioDAO;
import animatefx.animation.ZoomIn;
import biblioteca.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private Button cadLocatario = null;
    @FXML
    private TextField tfNome = new TextField();
    private TextField tfMatricula = new TextField();
    private PasswordField pwSenha = new PasswordField();



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

        if(event.getSource().equals(cadLocatario)){
            /*LocatarioDAO dao = new LocatarioDAO();
            *//*String nome = tfNome.getText();
            int matriculate = 20;
            String password = "123123";
            String tips = (String) CadChoiceBox.getValue();*//*

            dao.inserir(new Professor(1515,"Pedro","123","Aluno"));

            System.out.println("Cadastro efetuado com Sucesso!");*/

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