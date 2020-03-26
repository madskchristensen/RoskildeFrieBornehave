package Business;


import Business.Member;
import Business.MemberRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class TableManager{
    private TableView<Member> table;
    private ObservableList<Member> ob;

    public TableView createTable(String[] columnNames, String[] columnProporties, Member[] members){
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
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setItems(ob);
        GridPane.setVgrow(table, Priority.ALWAYS);
        GridPane.setHgrow(table, Priority.ALWAYS);

        return table;
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
}
