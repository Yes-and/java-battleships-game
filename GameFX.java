import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import CSA.Battlefield;

public class GameFX {
  private Battlefield PlayerField = new Battlefield();
  private Battlefield EnenyField = new Battlefield();
  private final TilePane rootPane;

  public GameFX(Battlefield playerField, Stage primaryStage, TilePane menuRoot) {
    this.PlayerField = playerField;

    rootPane = new TilePane();

    Font font = Font.font("comic sans ms", FontWeight.BOLD, 36);

    Button mainMenuBtn = new Button("Quit to main menu");
    mainMenuBtn.setFont(font);
    mainMenuBtn.setOnAction(actionEvent -> {
      primaryStage.getScene().setRoot(menuRoot);
    });
    rootPane.getChildren().add(mainMenuBtn);
  }
  public TilePane getRootPane() {
    return rootPane;
  }
}
