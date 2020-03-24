package Utility;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

// Klasse der kan bruges til at generere dialog bokse. F.eks. errors.

public class DialogBox {
    private Dialog<Boolean> dialog;
    private Label label;
    private Button button;
    private VBox vBox;
    private String message;
    private String title;
    private String buttonText;

    public DialogBox(String title, String message, String buttonText) {
        dialog = new Dialog<>();
        vBox = new VBox();
        button = new Button();
        label = new Label();
        setMessage(message);
        setTitle(title);
        setButtonText(buttonText);
    }

    public void setButtonText(String text) {
        this.buttonText = text;
        button.setText(buttonText);
    }
    public void setTitle(String title) {
        this.title = title;
        dialog.setTitle(title);
    }
    public void setMessage(String message) {
        this.message = message;
        label.setText(message);
    }

    public void show() {

        dialog.getOnCloseRequest();

        label.setPadding(new Insets(10, 20, 20, 20));
        button.setMinSize(75, button.getHeight());

        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label, button);
        dialog.getDialogPane().setContent(vBox);

        button.setOnAction(e -> {
            dialog.close();
            dialog.setResult(Boolean.TRUE);
        });

        // ButtonType bt = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        // dialog.getDialogPane().getButtonTypes().add(bt);
        dialog.showAndWait();
    }
}
