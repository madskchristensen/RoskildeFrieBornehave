package Controller;

import Business.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GuardianPopUpController extends PopUp{
    private TableManager tableManager;
    private ChildRepository childRep;

    GuardianPopUpController(Child child){
        super("Værger");
        try {
            tableManager = new TableManager();
            childRep = new ChildRepository(Main.sceneManager.getUser()[0], Main.sceneManager.getUser()[1]);
            String[] colNames = new String[]{"Fornavn", "Efternavn", "Addresse", "Telefon"};
            String[] colProps = new String[]{"firstName", "lastName", "address", "phoneNumber"};
            Guardian[]  guards = childRep.getGuardians(child);
            grid.add(tableManager.createTable(colNames, colProps, guards),0, 0);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
