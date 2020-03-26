package Controller;

import Business.*;
import javafx.scene.control.TableView;

import java.sql.SQLException;

public class ChildPopUpController{
    TableManager tableManager;
    GuardianRepository guardianRep;


    /*private void createTable(Guardian guardian){
        try {
            tableManager = new TableManager();
            guardianRep = new GuardianRepository(Main.sceneManager.getUser()[0], Main.sceneManager.getUser()[1]);
            String[] colNames = new String[]{"Fornavn", "Efternavn", "Addresse", "Telefon"};
            String[] colProps = new String[]{"firstName", "lastName", "address", "phoneNumber"};
            Guardian[]  guards = guardianRep.get(guardian);
            TableView table = tableManager.createTable(colNames, colProps, guards);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            grid.add(table,0, 0);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }*/
}
