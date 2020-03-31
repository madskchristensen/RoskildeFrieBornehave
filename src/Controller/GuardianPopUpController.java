package Controller;

import Business.*;
import Utility.TableManager;
import javafx.scene.layout.GridPane;

import java.sql.SQLException;

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
            pane.add(tableManager.createTable(colNames, colProps, guards),0,0);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
