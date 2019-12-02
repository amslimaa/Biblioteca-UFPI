package controllers;

import Connections.dao.AlunoDAO;
import Connections.dao.LocatarioDAO;
import Connections.dao.ProfessorDAO;
import Connections.dao.TecAdministrativoDAO;
import animatefx.animation.ZoomIn;
import biblioteca.Aluno;
import biblioteca.Locatario;
import biblioteca.Professor;
import biblioteca.TecAdministrativo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.List;

public class MainController {


    ObservableList<String> LocatarioTipo = FXCollections.observableArrayList("Aluno", "Professor", "TecAdministrativo");

    @FXML
    private Label welcomeLabel = null;

    @FXML
    private ChoiceBox CadChoiceBox = null;

    @FXML
    private Pane pnlLogin,pnlCad = null;

    @FXML
    private Object btnBack,btnLogout,btnLogoutAdmin = null;

    @FXML
    private Circle btnClose,btnCloseHome,btnCloseAdm = null;

    @FXML
    private Button btnCad,cadLocatario,btnLogin = null;

    @FXML
    private TextField tfNome,tfMatricula,pwField,inputMatLogin,pwInput = null;


    @FXML
    public void initialize(){
        CadChoiceBox.setValue("Vinculo");
        CadChoiceBox.setItems(LocatarioTipo);

    }


    @FXML
    AnchorPane userHomeAnchor,loginPane,adminAnchorPane = null;


    @FXML
    Pane acervoPane,usuariosPane,emprestimosPane,reservasPane = null;

    @FXML
    private Button btnAcervo,btnUser,btnEmprestimos,btnReservas  = null;

    public void handleButtonAction(ActionEvent event) {
        if(event.getSource().equals(btnReservas)){
            new ZoomIn(reservasPane).play();
            reservasPane.toFront();
        }
        if(event.getSource().equals(btnEmprestimos)){
            new ZoomIn(emprestimosPane).play();
            emprestimosPane.toFront();
        }
        if(event.getSource().equals(btnAcervo)){
            new ZoomIn(acervoPane).play();
            acervoPane.toFront();
        }
        if(event.getSource().equals(btnUser)){
            new ZoomIn(usuariosPane).play();
            usuariosPane.toFront();
        }
        if(event.getSource().equals(btnLogin)){
            AlunoDAO alunoDAO = new AlunoDAO();
            List<Aluno> alunos = alunoDAO.buscar();
            ProfessorDAO professorDAO = new ProfessorDAO();
            List<Professor> professores = professorDAO.buscar();
            TecAdministrativoDAO tecAdministrativoDAO = new TecAdministrativoDAO();
            List<TecAdministrativo> tecAdministrativos = tecAdministrativoDAO.buscar();
            List<Locatario> locatarios = new ArrayList<Locatario>();
            locatarios.addAll(alunos);
            locatarios.addAll(professores);
            locatarios.addAll(tecAdministrativos);



            if(inputMatLogin.getText().equals("root")){
                if( pwInput.getText().equals("root")){
                    new ZoomIn(adminAnchorPane).play();
                    adminAnchorPane.toFront();
                }
            }
            for (Locatario locatario : locatarios) {
                if (locatario.getMatricula().equals(inputMatLogin.getText()) ){
                    if(locatario.getSenha().equals(pwInput.getText())){
                        new ZoomIn(userHomeAnchor).play();
                        userHomeAnchor.toFront();
                        welcomeLabel.setText("Bem vindo "+locatario.getNome());
                    }else{
                        System.out.println("Usuário ou senha inválida.");
                    }
                }
            }

        }
        if(event.getSource().equals(btnCad)){
            new ZoomIn(pnlCad).play();
            pnlCad.toFront();
        }

        if(event.getSource().equals(cadLocatario)){

            LocatarioDAO dao = new LocatarioDAO();
            if(CadChoiceBox.getValue().equals("Aluno")){
                dao.inserir(new Aluno(
                    tfMatricula.getText(),
                    tfNome.getText(),
                    pwField.getText()
                    ),
                    CadChoiceBox.getValue().toString()) ;
            }
            if(CadChoiceBox.getValue().equals("Professor")) {
                dao.inserir(new Professor(
                    tfMatricula.getText(),
                    tfNome.getText(),
                    pwField.getText()
                    ),
                    CadChoiceBox.getValue().toString()) ;
            }
            if(CadChoiceBox.getValue().equals("TecAdministrativo")){
                dao.inserir(new TecAdministrativo(
                    tfMatricula.getText(),
                    tfNome.getText(),
                    pwField.getText()
                    ),
                    CadChoiceBox.getValue().toString()) ;
            }

            System.out.println("Cadastro Realisado com sucesso!");
            new ZoomIn(pnlLogin).play();
            pnlLogin.toFront();
        }
    }
    public void handleMouseEvent(MouseEvent event) {
        if(event.getSource() == btnLogoutAdmin){
            new ZoomIn(loginPane).play();
            pwInput.setText("");
            loginPane.toFront();
        }
        if(event.getSource() == btnLogout){
            new ZoomIn(loginPane).play();
            pwInput.setText("");
            loginPane.toFront();
        }
        if(event.getSource() == btnCloseHome|| event.getSource() == btnClose ||  event.getSource().equals(btnCloseAdm)){
            System.exit(0);
        }

        if(event.getSource() .equals(btnBack)){
            new ZoomIn(pnlLogin).play();
            pwInput.setText("");
            pnlLogin.toFront();
        }
    }



}