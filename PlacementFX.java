import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import CSA.Battlefield;

public class PlacementFX {
  private Battlefield PlayerField = new Battlefield();
  private final TilePane rootPane;

  public PlacementFX(Stage primaryStage, TilePane menuRoot) {
    rootPane = new TilePane();

    Font font = Font.font("comic sans ms", FontWeight.BOLD, 36);

    Button startGameBtn = new Button("Quit to main menu");
    startGameBtn.setFont(font);
    startGameBtn.setOnAction(actionEvent -> {
      primaryStage.getScene().setRoot(menuRoot);
    });
    rootPane.getChildren().add(startGameBtn);

    Button randomizeBtn = new Button("Randomize again");
    randomizeBtn.setFont(font);
    randomizeBtn.setOnAction(actionEvent -> {
      // primaryStage.getScene().setRoot(menuRoot);
      PlayerField.Randomize();
      System.out.println("Field stringified:");
      System.out.println(PlayerField.toString());
    });
    rootPane.getChildren().add(randomizeBtn);

    Button playBtn = new Button("Play!");
    playBtn.setFont(font);
    playBtn.setOnAction(actionEvent -> {
      GameFX game = new GameFX(this.PlayerField, primaryStage, menuRoot);
      primaryStage.getScene().setRoot(game.getRootPane());
    });
    rootPane.getChildren().add(playBtn);
  }
  public TilePane getRootPane() {
    return rootPane;
  }
}
