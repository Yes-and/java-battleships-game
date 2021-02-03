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
  private Button[][] PlayerBtns = new Button[8][8];
  private Button[][] EnemyBtns = new Button[8][8];
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
        PlayerBtns[x][y] = new Button("X");
        PlayerBtns[x][y].setFont(font);
        playerGridPane.add(PlayerBtns[x][y], x, y);
      }
    }

    rootPane.add(playerGridPane, 0, 2);

    this.SetPlayerTexts();

    Label enemyGridL = new Label("PC grid:");
    enemyGridL.setFont(font);
    rootPane.add(enemyGridL, 3, 1);

    GridPane enemyGridPane = new GridPane();

    for(int x = 0; x < 8; x++){
      for(int y = 0; y < 8; y++){
        EnemyBtns[x][y] = this.createEnemyBtn(x, y);

        EnemyBtns[x][y].setFont(font);

        enemyGridPane.add(EnemyBtns[x][y], x, y);
      }
    }

    rootPane.add(enemyGridPane, 3, 2);

    this.SetEnemyTexts();

    Label statusL = new Label("Your turn - please click on PC grid");
    statusL.setFont(font);
    rootPane.add(statusL, 1, 3);
  }
  private void SetPlayerTexts() {
    for(int x = 0; x < 8; x++){
      for(int y = 0; y < 8; y++){
        this.PlayerBtns[x][y].setText(this.PlayerField.At(x, y) + "");
      }
    }
  }
  private Button createEnemyBtn(int x, int y) {
    Button btn = new Button("X");

    btn.setOnAction(actionEvent -> {
      if(!this.EnemyField.Reveal(x, y)){
        this.PCMove();
      }

      this.SetEnemyTexts();
    });

    return btn;
  }
  private void SetEnemyTexts() {
    for(int x = 0; x < 8; x++){
      for(int y = 0; y < 8; y++){
        int res = this.EnemyField.At(x, y);

        this.EnemyBtns[x][y].setText((res >= 10 ? res : "X") + "");
      }
    }
  }
  public void PCMove() {
    // TODO: If hits, do this.PCMove();
  }
  public GridPane getRootPane() {
    return rootPane;
  }
}
