package controller;

import javafx.scene.control.Button;
import model.*;
import utility.TableManager;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import repository.ChildRepository;
import repository.GuardianRepository;

import java.sql.SQLException;

public class ChildPopUpController{
    public GridPane pane;
    public MenuButton addButton;
    public Button deleteButton;
    private ChildRepository childRep;
    private TableManager tableManager;
    private GuardianRepository guardianRep;
    private Guardian guardian;

    public void addTable(Guardian guardian){
            try {
                this.guardian = guardian;
                tableManager = new TableManager();
                guardianRep = new GuardianRepository(Main.sceneManager.getUser()[0], Main.sceneManager.getUser()[1]);
                String[] colNames = new String[]{"Fornavn", "Efternavn", "Stue", "Alder"};
                String[] colProps = new String[]{"firstName", "lastName", "classroom", "age"};
                Child[] children = guardianRep.getChildren(guardian);
                pane.add(tableManager.createTable(colNames, colProps, children), 0,0);

                childRep = new ChildRepository(Main.sceneManager.getUser()[0], Main.sceneManager.getUser()[1]);
                Child[] child = childRep.getAllMembers();
                for(Child c: child){
                    if(!contains(children, c)) {
                        MenuItem menuItem = new MenuItem(c.getId() + " " + c.getFirstName() + " " + c.getLastName() + "\n " + c.getClassroom() + " Stue");
                        menuItem.setOnAction(event -> {
                            try {
                                guardianRep.connect(guardian, c);
                                tableManager.updateTable(guardianRep.getChildren(guardian));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        });
                        addButton.getItems().add(menuItem);
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


    public void delete(ActionEvent actionEvent) {
        try {
            childRep.deleteMember((Child) tableManager.getSelected());
            tableManager.updateTable(guardianRep.getChildren(guardian));
        }catch(SQLException sql){
            sql.printStackTrace();
        }
    }
}
