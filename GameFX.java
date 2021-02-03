import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import CSA.Battlefield;

public class GameFX {
  private Battlefield PlayerField = new Battlefield();
  private Battlefield EnemyField = new Battlefield();
  private final GridPane rootPane;

  public GameFX(Battlefield playerField, Stage primaryStage, TilePane menuRoot) {
    this.PlayerField = playerField;

    rootPane = new GridPane();

    Font font = Font.font("comic sans ms", FontWeight.BOLD, 18);

    Button mainMenuBtn = new Button("Quit to main menu");
    mainMenuBtn.setFont(font);
    mainMenuBtn.setOnAction(actionEvent -> {
      primaryStage.getScene().setRoot(menuRoot);
    });
    rootPane.add(mainMenuBtn, 1, 0);

    Label playerGridL = new Label("Your grid:");
    playerGridL.setFont(font);
    rootPane.add(playerGridL, 0, 1);

    GridPane playerGridPane = new GridPane();

    for(int x = 0; x < 8; x++){
      for(int y = 0; y < 8; y++){
        Button shipBtn = new Button(PlayerField.At(x, y) + "");
        shipBtn.setFont(font);
        playerGridPane.add(shipBtn, x, y);
      }
    }

    rootPane.add(playerGridPane, 0, 2);

    Label enemyGridL = new Label("PC grid:");
    enemyGridL.setFont(font);
    rootPane.add(enemyGridL, 3, 1);

    GridPane enemyGridPane = new GridPane();

    for(int x = 0; x < 8; x++){
      for(int y = 0; y < 8; y++){
        Button shipBtn = new Button(EnemyField.At(x, y) + "");
        shipBtn.setFont(font);
        shipBtn.setOnAction(actionEvent -> {
        });
        enemyGridPane.add(shipBtn, x, y);
      }
    }

    rootPane.add(enemyGridPane, 3, 2);

    Label statusL = new Label("Your turn - please click on PC grid");
    statusL.setFont(font);
    rootPane.add(statusL, 1, 3);
  }
  public GridPane getRootPane() {
    return rootPane;
  }
}
