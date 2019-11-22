import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent login = FXMLLoader.load(getClass().getResource("../resources/loginUflib.fxml"));

        Scene loginform = new Scene(login);

        primaryStage.setTitle("BIBLIOTECA - UFPI");
        primaryStage.setScene(loginform);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
