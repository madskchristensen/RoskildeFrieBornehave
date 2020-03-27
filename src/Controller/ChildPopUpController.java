package Controller;

import Business.*;
import javafx.beans.Observable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.sql.SQLException;

public class ChildPopUpController{
    TableManager tableManager;
    GuardianRepository guardianRep;
    public GridPane pane;
    public MenuButton menu;

    public void addTable(Guardian guardian){
            try {
                tableManager = new TableManager();
                guardianRep = new GuardianRepository(Main.sceneManager.getUser()[0], Main.sceneManager.getUser()[1]);
                String[] colNames = new String[]{"Fornavn", "Efternavn", "Stue", "Alder"};
                String[] colProps = new String[]{"firstName", "lastName", "classroom", "age"};
                Child[] children = guardianRep.getChildren(guardian);
                pane.add(tableManager.createTable(colNames, colProps, children), 0,0);

                ChildRepository childRep = new ChildRepository(Main.sceneManager.getUser()[0], Main.sceneManager.getUser()[1]);
                Child[] child = childRep.getAllMembers();
                for(Child c: child){
                    if(!contains(children, c)) {
                        MenuItem menuItem = new MenuItem(c.getId() + " " + c.getFirstName() + " " + c.getLastName() + "\n " + c.getClassroom() + " Stue");
                        menuItem.setOnAction(event -> {
                            try {
                                guardianRep.connect(guardian, c);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        });
                        menu.getItems().add(menuItem);
                    }
                }
            }catch(SQLException sql){
                sql.printStackTrace();
            }
    }

    public boolean contains(Member[] set, Member m) {
        boolean result = false;

        for (Member s: set) {
                if (s == m) {
                    result = true;
                    break;
                }
            }
        return result;
    }

    public void addChild(){
    }


}
