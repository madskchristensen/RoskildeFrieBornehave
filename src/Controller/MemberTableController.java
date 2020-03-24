package Controller;

import Business.GuardianRepository;
import Business.Member;
import Business.MemberRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.lang.reflect.Field;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MemberTableController {
    @FXML TableView table;


    public void create(URL url, ResourceBundle resourceBundle) {
        try {
            MemberRepository memberGen = new GuardianRepository("employee", "password");
            Field[] fields = memberGen.getClass().getFields();
            System.out.println(fields.toString());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
