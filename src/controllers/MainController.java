package controllers;
import Connections.dao.*;
import animatefx.animation.ZoomIn;
import biblioteca.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;


import java.util.ArrayList;
import java.util.List;

public class MainController {
    @FXML
    private Button btnEmprestimos = null;


    @FXML
    private Spinner<Integer> spinerQtd = null;
    SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,1);

    @FXML
    private  DatePicker  cadDatePublicacao = null;
    @FXML
    ObservableList<String> LocatarioTipo = FXCollections.observableArrayList("Aluno", "Professor", "TecAdministrativo");

    @FXML
    private AnchorPane userHomeAnchor;

    @FXML
    private Pane homePane;

    @FXML
    private Circle btnMin1;

    @FXML
    private Circle btnCloseHome;

    @FXML
    private ImageView btnLogout;

    @FXML
    private Label welcomeLabel;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private Pane pnlCad;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfMatricula;

    @FXML
    private PasswordField pwField;

    @FXML
    private Button cadLocatario;

    @FXML
    private ChoiceBox<String> CadChoiceBox;

    @FXML
    private ImageView btnBack;

    @FXML
    private Pane pnlLogin;

    @FXML
    private TextField inputMatLogin;

    @FXML
    private PasswordField pwInput;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCad;

    @FXML
    private Circle btnMin;

    @FXML
    private Circle btnClose;

    @FXML
    private AnchorPane adminAnchorPane;

    @FXML
    private Pane reservasPane;

    @FXML
    private Pane emprestimosPane;

    @FXML
    private Pane usuariosPane;

    @FXML
    private Pane acervoPane;

    @FXML
    private Pane cadLivroPane;

    @FXML
    private TextField cadCodLivro;

    @FXML
    private Button btnCadLivro;

    @FXML
    private TextField cadTitulo;

    @FXML
    private TextField cadAutor;




    @FXML
    private ImageView backCad;

    @FXML
    private Pane acervoList;

    @FXML
    private TableView<Livro> acervoTabela;

    @FXML
    private TableView<Locatario> tvUsuarios;


    @FXML
    private Button btnNovoLivro;

    @FXML
    private Button btnAcervo,btnDoEmprestimos;

    @FXML
    private Button btnUser;

    @FXML
    private Pane pnEmprestimos= null;
    @FXML
    private Pane pnLivros = null;

    @FXML
    private Button btnReservas;

    @FXML
    private Circle btnMin11;

    @FXML
    private Circle btnCloseAdm;

    @FXML
    private ImageView btnLogoutAdmin;
    @FXML
    private TableView<Livro> tvUserLivros;
    @FXML
    private Button btnEmprestimo = null;
    @FXML
    private Button btnUsersAcervo =null;

    Locatario locatarioLogado;

    public List<Locatario> getLocatarios(){
        LocatarioDAO dao = new LocatarioDAO();
        List<Locatario> locatarios = new ArrayList<>();
        locatarios.addAll(dao.buscar());
        return locatarios;
    }



    @FXML
    public void initialize(){
        CadChoiceBox.setValue("Vinculo");
        CadChoiceBox.setItems(LocatarioTipo);
        spinerQtd.setValueFactory(svf);

        initAcervo();
        initTvUsuarios();
    }

    public void initTvUsuarios(){
        TableColumn<Locatario, String> colMatricula = new TableColumn("Matrícula");
        colMatricula.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMatricula()));

        TableColumn<Locatario, String> colNome = new TableColumn("Nome");
        colNome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));

        TableColumn<Locatario, String> colSenha = new TableColumn("Senha");
        colSenha.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSenha()));

        TableColumn<Locatario, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTipo()));


        tvUsuarios.getColumns().addAll(colMatricula,colNome,colSenha);

        tvUsuarios.getItems().addAll(getLocatarios());
    }

    public void initAcervo(){
        TableColumn<Livro, Integer> colCodigo = new TableColumn("Código");
        colCodigo.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCodigo()).asObject() );

        TableColumn<Livro, String> colTitulo = new TableColumn("Título");
        colTitulo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitulo()));

        TableColumn<Livro, String> colAutor = new TableColumn("Autor");
        colAutor.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAutor()));

        TableColumn<Livro, Integer> colAno = new TableColumn("Ano");
        colAno.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getAno()).asObject());

        TableColumn<Livro, Integer> colQtd = new TableColumn("Qtd");
        colQtd.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getQuanditade()).asObject());

        acervoTabela.getColumns().addAll(colCodigo,colTitulo,colAutor,colAno,colQtd);
        tvUserLivros.getColumns().addAll(colCodigo,colTitulo,colAutor,colAno,colQtd);

        LivroDAO dao = new LivroDAO();
        acervoTabela.getItems().addAll(dao.buscar());
        tvUserLivros.getItems().addAll(dao.buscar());
    }

    public void handleButtonAction(ActionEvent event) {

        if (event.getSource().equals(btnUsersAcervo)){
            new ZoomIn(pnLivros).play();
            pnLivros.toFront();
        }

        if(event.getSource().equals(btnEmprestimos)){
            new ZoomIn(pnEmprestimos).play();
            pnEmprestimos.toFront();
        }

        if(event.getSource().equals(btnDoEmprestimos)){
            Livro livro = tvUserLivros.getSelectionModel().getSelectedItem();

            Emprestimo emprestimo = new Emprestimo(livro, locatarioLogado);
            System.out.println(emprestimo);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Emprestimo");
            alert.setHeaderText("Emprestimo relizado com sucesso!");
            alert.setContentText(emprestimo.toString()
                    /*"Livro:"+emprestimo.+"\n"+
                            "Quandidade: "+ spinerQtd.getValue()+"\n"+
                            "Ano: "+ ano+"\n"+
                            "Titulo: "+cadTitulo.getText()+"\n"+
                            "Autor: "+ cadAutor.getText()*/
            );
            alert.showAndWait();
        }

        if(event.getSource().equals(btnNovoLivro)){
            new ZoomIn(cadLivroPane).play();
            cadLivroPane.toFront();
        }

        if (event.getSource().equals(btnCadLivro)){
            LivroDAO dao = new  LivroDAO();
            String date =  cadDatePublicacao.getValue().toString();
            String[] dateV = date.split("-");
            int ano = Integer.parseInt(dateV[0]);
            dao.inserir(new Livro(
                    Integer.parseInt(cadCodLivro.getText()),
                    spinerQtd.getValue(),
                    ano,
                    cadTitulo.getText(),
                    cadAutor.getText()
            ));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Acervo");
            alert.setHeaderText("Livro cadastrado com sucesso!");
            alert.setContentText(
                    "Código:"+cadCodLivro.getText()+"\n"+
                    "Quandidade: "+ spinerQtd.getValue()+"\n"+
                    "Ano: "+ ano+"\n"+
                    "Titulo: "+cadTitulo.getText()+"\n"+
                    "Autor: "+ cadAutor.getText()
            );
            alert.showAndWait();
            acervoTabela.getItems().add(new Livro(
                    Integer.parseInt(cadCodLivro.getText()),
                    spinerQtd.getValue(),
                    ano,
                    cadTitulo.getText(),
                    cadAutor.getText()
            ));
            tvUserLivros.getItems().add(new Livro(
                    Integer.parseInt(cadCodLivro.getText()),
                    spinerQtd.getValue(),
                    ano,
                    cadTitulo.getText(),
                    cadAutor.getText()
            ));
            new ZoomIn(acervoList).play();
            acervoList.toFront();
        }

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
            List<Locatario> locatarios = getLocatarios();
            System.out.println(locatarios.toString());
            if(inputMatLogin.getText().equals("root")){
                if( pwInput.getText().equals("root")){
                    new ZoomIn(adminAnchorPane).play();
                    adminAnchorPane.toFront();
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Usuario");
                    alert.setHeaderText(null);
                    alert.setContentText("Senha inválida");
                    alert.showAndWait();
                }
            }
            for (Locatario locatario : locatarios) {
                if (locatario.getMatricula().equals(inputMatLogin.getText()) ){
                    if(locatario.getSenha().equals(pwInput.getText())){
                        new ZoomIn(userHomeAnchor).play();
                        userHomeAnchor.toFront();
                        welcomeLabel.setText("Bem vindo "+locatario.getNome());
                        locatarioLogado = locatario;
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

                dao.inserir(new Locatario(
                    tfMatricula.getText(),
                    tfNome.getText(),
                    pwField.getText(),
                    CadChoiceBox.getValue())
                );
            tvUsuarios.getItems().add( new Locatario(
                    tfMatricula.getText(),
                    tfNome.getText(),
                    pwField.getText(),
                    CadChoiceBox.getValue())
            );


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Acervo");
            alert.setHeaderText(null);
            alert.setContentText("Usuário cadastrado.");
            alert.showAndWait();
            new ZoomIn(pnlLogin).play();
            pnlLogin.toFront();
        }
    }
    public void handleMouseEvent(MouseEvent event) {
        if(event.getSource().equals(backCad)){
            new ZoomIn(acervoList).play();
            acervoList.toFront();
        }
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