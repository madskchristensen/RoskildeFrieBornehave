import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SceneManager {
    private Stage primaryStage;
    private FXMLLoader loader;
    private HashMap<String, Parent> sceneList;
    private String currentScene;
    private String currentTitle;
    private String previousScene;
    private String previousTitle;

    //Setting size of window
    private Rectangle2D primScreenBounds;
    private double stagesizex;
    private double stagesizey;

    public void getPreviousScene() throws IOException {
        switchScene(previousScene, previousTitle);
    }


    public Parent getCurrentScene() throws IOException {
        return sceneList.get(currentScene);
    }

    public void setSize(double x, double y) {
        stagesizex = x;
        stagesizey = y;
    }

    public double getSizeX() {
        return this.stagesizex;
    }

    public double getSizeY() {
        return this.stagesizey;
    }

    public SceneManager(Stage primaryStage) {
        this(primaryStage, Screen.getPrimary().getVisualBounds().getWidth() / 2, Screen.getPrimary().getVisualBounds().getHeight() / 1.5);
    }

    public SceneManager(Stage primaryStage, double stagesizex, double stagesizey) {
        this.primaryStage = primaryStage;
        loader = new FXMLLoader();
        sceneList = new HashMap<>();
        this.stagesizex = stagesizex;
        this.stagesizey = stagesizey;
    }

    public void switchScene(String sceneName, String title) throws IOException {
        previousScene = currentScene;
        previousTitle = currentTitle;

        if(!sceneList.containsKey(sceneName)) {
            sceneList.put(sceneName, FXMLLoader.load(getClass().getResource(sceneName)));
        }

        currentScene = sceneName;
        currentTitle = title;
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(sceneList.get(sceneName), stagesizex, stagesizey));
        primaryStage.show();
    }
}