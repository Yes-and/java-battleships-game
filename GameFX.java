import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameFX {
  private final TilePane rootPane;

  public GameFX(Stage primaryStage, TilePane menuRoot) {
    rootPane = new TilePane();

    Button startGameBtn = new Button("Quit to main menu");
    Font font = Font.font("comic sans ms", FontWeight.BOLD, 36);
    startGameBtn.setFont(font);
    startGameBtn.setOnAction(actionEvent -> {
      primaryStage.getScene().setRoot(menuRoot);
    });
    rootPane.getChildren().add(startGameBtn);
  }
  public TilePane getRootPane() {
    return rootPane;
  }
}
