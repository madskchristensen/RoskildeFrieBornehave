import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class RepositoryTestClass {
    @Test
    public void mytestclass(){
        try{
            ChildRepository cr = new ChildRepository("administrator", "admin_pass");
            Child[] children = cr.getMembers("a" +
                    "");
            System.out.println(children.length);
            for(Child c: children) {
                System.out.println(c.toString());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
