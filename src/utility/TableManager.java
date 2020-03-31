package utility;


import model.Member;
import repository.MemberRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.sql.SQLException;


public class TableManager{
    private TableView<Member> table;
    private ObservableList<Member> ob;
    TextField search;
    GridPane gp;

    public GridPane createTable(String[] columnNames, String[] columnProporties, Member[] members){
        gp = new GridPane();
        table = new TableView();

        //makes data readable for table
        ob = FXCollections.observableArrayList();
        for(Member m: members){
            ob.add(m);
        }

        for(int i = 0; i < columnNames.length && i < columnProporties.length; i++){
            //Sets table columns
            TableColumn tc = new TableColumn<>(columnNames[i]);
            tc.setMinWidth(75);
            //populates rows with data
            tc.setCellValueFactory(new PropertyValueFactory<Member, String>(columnProporties[i]));
            table.getColumns().add(tc);
        }
        table.setItems(ob);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        GridPane.setVgrow(table, Priority.ALWAYS);
        GridPane.setHgrow(table, Priority.ALWAYS);



        GridPane.setVgrow(gp, Priority.ALWAYS);

        gp.add(table,0,2);

        return gp;
    }

    public void updateTable(Member[] members){
        ob.clear();
        for(Member m: members){
            ob.add(m);
        }
        table.setItems(ob);
    }

    public Member getSelected(){
        return table.getSelectionModel().getSelectedItem();
    }
    public TextField getSearch(){
        return search;
    }
    public TableView getTable(){
        return table;
    }

    public void addFilters(){
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(new Menu("Stue"));
        gp.add(menuBar,0,1);
    }

    public void addSearch(MemberRepository memRep) {
        search = new TextField();
        GridPane.setHgrow(search, Priority.ALWAYS);
        GridPane.setVgrow(search, Priority.NEVER);
        search.setPromptText("Søg");

        gp.add(search,0,0);
        search.textProperty().addListener((observable) -> {
            try {
                updateTable(memRep.getMembers(search.getText()));
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        });
    }

    public void clearSelection() {
        table.getSelectionModel().clearSelection();
    }
}
