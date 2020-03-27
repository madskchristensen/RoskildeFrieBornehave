package Controller;

import Business.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GuardianPopUpController{
    private TableManager tableManager;
    private ChildRepository childRep;
    public GridPane pane;

    public void addTable(Child child){
        try {
            tableManager = new TableManager();
            childRep = new ChildRepository(Main.sceneManager.getUser()[0], Main.sceneManager.getUser()[1]);
            String[] colNames = new String[]{"Fornavn", "Efternavn", "Addresse", "Telefon"};
            String[] colProps = new String[]{"firstName", "lastName", "address", "phoneNumber"};
            Guardian[]  guards = childRep.getGuardians(child);
            TableView table = tableManager.createTable(colNames, colProps, guards);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            pane.add(table,0,0);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
