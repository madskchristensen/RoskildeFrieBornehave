import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.sql.*;

public class Main extends Application {
    public static Stage window;

    //Setting size of window
    public Rectangle2D primScreenBounds;
    public double stagesizex;
    public double stagesizey;


    @Override
    public void start(Stage primaryStage) throws Exception {
 /*       try {
            // JDBC jdbc = new JDBC("administrator", "admin_pass");
            Child child;
            Child child2;
            ChildRepository childRepo = new ChildRepository();
            // jdbc.insert("child", new String[]{"first_name", "last_name", "class"}, new String[]{"Jesus", "Immergeil", "jesus"});
            // jdbc.update("child", "first_name", "Kurt", "first_name = \"Bob\"");
            child = childRepo.getById(1);
            child2 = childRepo.getByName("Tim Borison");
            System.out.println(child);
            System.out.println(child2);

        } catch (Exception e) {
            e.printStackTrace();
        }*/




        this.window = primaryStage;
        primScreenBounds = Screen.getPrimary().getVisualBounds();
        stagesizex = primScreenBounds.getWidth() / 2;
        stagesizey = primScreenBounds.getHeight() / 1.5;
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Roskilde Frie Børnehave");
        primaryStage.setScene(new Scene(root, stagesizex, stagesizey));
        primaryStage.show();


        }
    public Stage getPrimaryStage() {
        return window;
    }

    public static void main(String[] args) {
        launch(args);
    }

}


/*
//Debugging kode fra controller /Michael
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Login mainWindowController = new Login();
        mainWindowController.setMainApp(this);
        loader.setController(mainWindowController);
        Parent layout = loader.load();

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
*/
