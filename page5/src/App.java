import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*; 
import javafx.stage.Stage;
public class App extends Application{
   
    @Override
public void start(Stage primaryStage){
     Parent root;
    try {
        root = FXMLLoader.load(getClass().getResource("page5.fxml"));
        Scene scene = new Scene(root,600,400);
        primaryStage.setTitle("situation de stock");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();

    } catch (IOException e) {
        
        e.printStackTrace();
    }
    
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    }