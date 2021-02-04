import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import CSA.Battlefield;

// Even more UI
public class WinnerFX {
  private final TilePane rootPane;
  private boolean PlayerWon;

  public WinnerFX(Stage primaryStage, TilePane menuRoot, boolean playerWon) {
    this.PlayerWon = playerWon;

    rootPane = new TilePane();

    Font font = Font.font("comic sans ms", FontWeight.BOLD, 36);

    Image image1 = new Image(playerWon ? "media/youwin.png" : "media/youlose.png", true);
    ImageView view = new ImageView(image1);
    view.getStyleClass().add("midImg");
    view.setFitHeight(900);
    view.setFitWidth(900);
    view.setPreserveRatio(true);

    rootPane.getChildren().add(view);

    // Label winnerL = new Label(playerWon ? "You won!" : "You lost!");
    // winnerL.setFont(font);
    // rootPane.getChildren().add(winnerL);

    Button startGameBtn = new Button("Quit to main menu");
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
