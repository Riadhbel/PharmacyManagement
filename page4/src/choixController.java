//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

//import static java.sql.DriverManager.println;


public class choixController {
    @FXML
    private Button f8;

    @FXML
    private Button fermer;

    @FXML
    private TextField nchifa;

    @FXML
    private TextField nvcm;

    @FXML
    private TableView<tableau> tableau;

    @FXML
    private TableColumn<tableau, String> client;

    @FXML
    private TableColumn<tableau, Integer> nasschifa;

    @FXML
    private TableColumn<tableau, Integer> nasscvm;

    @FXML
    private TableColumn<tableau, Integer> numtlfn;

    @FXML
    private TableColumn<tableau, String> adrs;
    
}  
