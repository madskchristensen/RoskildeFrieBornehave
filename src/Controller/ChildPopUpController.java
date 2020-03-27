package Controller;

import Business.*;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.sql.SQLException;

public class ChildPopUpController{
    TableManager tableManager;
    GuardianRepository guardianRep;
    public GridPane pane;

    public void addTable(Guardian guardian){
            try {
                tableManager = new TableManager();
                guardianRep = new GuardianRepository(Main.sceneManager.getUser()[0], Main.sceneManager.getUser()[1]);
                String[] colNames = new String[]{"Fornavn", "Efternavn", "Stue", "Alder"};
                String[] colProps = new String[]{"firstName", "lastName", "classroom", "age"};
                Child[] children = guardianRep.getChildren(guardian);
                pane.add(tableManager.createTable(colNames, colProps, children), 0,0);
            }catch(SQLException e){
                e.printStackTrace();
            }
    }



}
