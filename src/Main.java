
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent login = FXMLLoader.load(getClass().getResource("resources/Main.fxml"));

        Scene root = new Scene(login);
        primaryStage.setTitle("BIBLIOTECA - UFPI");
        primaryStage.setScene(root);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
