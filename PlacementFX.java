import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import CSA.Battlefield;

public class PlacementFX {
  private Battlefield PlayerField = new Battlefield();
  private Button[][] BtnGrid = new Button[8][8];
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
      PlayerField.Randomize();

      this.SetTexts();
    });
    rootPane.getChildren().add(randomizeBtn);

    Button playBtn = new Button("Play!");
    playBtn.setFont(font);
    playBtn.setOnAction(actionEvent -> {
      GameFX game = new GameFX(this.PlayerField, primaryStage, menuRoot);
      primaryStage.getScene().setRoot(game.getRootPane());
    });
    rootPane.getChildren().add(playBtn);

    Label playerGridL = new Label("Your grid:");
    playerGridL.setFont(font);
    rootPane.getChildren().add(playerGridL);

    GridPane playerGridPane = new GridPane();

    for(int x = 0; x < 8; x++){
      for(int y = 0; y < 8; y++){
        BtnGrid[x][y] = new Button("X");
        BtnGrid[x][y].setFont(font);
        playerGridPane.add(BtnGrid[x][y], x, y);
      }
    }

    this.SetTexts();

    rootPane.getChildren().add(playerGridPane);
  }
  private void SetTexts() {
    for(int x = 0; x < 8; x++){
      for(int y = 0; y < 8; y++){
        BtnGrid[x][y].setText(PlayerField.At(x, y) + "");
      }
    }
  }
  public TilePane getRootPane() {
    return rootPane;
  }
}
