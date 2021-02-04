import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

import CSA.Battlefield;

public class GameFX {
  private Battlefield PlayerField = new Battlefield();
  private Battlefield EnemyField = new Battlefield();
  private Button[][] PlayerBtns = new Button[8][8];
  private Button[][] EnemyBtns = new Button[8][8];
  private Label playerGridL;
  private Label enemyGridL;
  private final GridPane rootPane;
  private Stage PrimaryStage;
  private int PCX = -1;
  private int PCY = -1;
  TilePane MenuRoot;

  public GameFX(Battlefield playerField, Stage primaryStage, TilePane menuRoot) {
    this.MenuRoot = menuRoot;
    this.PlayerField = playerField;
    this.PrimaryStage = primaryStage;

    rootPane = new GridPane();

    Font font = Font.font("comic sans ms", FontWeight.BOLD, 18);

    Button mainMenuBtn = new Button("Quit to main menu");
    mainMenuBtn.setFont(font);
    mainMenuBtn.setOnAction(actionEvent -> {
      primaryStage.getScene().setRoot(menuRoot);
    });
    rootPane.add(mainMenuBtn, 1, 0);

    this.playerGridL = new Label("Your grid (x ship blocks undiscovered):");
    this.playerGridL.setFont(font);
    rootPane.add(this.playerGridL, 0, 1);

    GridPane playerGridPane = new GridPane();

    for(int x = 0; x < 8; x++){
      for(int y = 0; y < 8; y++){
        PlayerBtns[x][y] = new Button("");
        PlayerBtns[x][y].getStyleClass().add("shipBtn");
        PlayerBtns[x][y].setFont(font);
        playerGridPane.add(PlayerBtns[x][y], x, y);
      }
    }

    rootPane.add(playerGridPane, 0, 2);

    this.enemyGridL = new Label("PC grid (x ship blocks undiscovered):");
    this.enemyGridL.setFont(font);
    rootPane.add(this.enemyGridL, 3, 1);

    GridPane enemyGridPane = new GridPane();

    for(int x = 0; x < 8; x++){
      for(int y = 0; y < 8; y++){
        EnemyBtns[x][y] = this.createEnemyBtn(x, y);

        EnemyBtns[x][y].setFont(font);

        enemyGridPane.add(EnemyBtns[x][y], x, y);
      }
    }

    rootPane.add(enemyGridPane, 3, 2);

    Label statusL = new Label("Your turn - please click on PC grid");
    statusL.setFont(font);
    rootPane.add(statusL, 1, 3);

    this.SetTexts();
  }
  private Button createEnemyBtn(int x, int y) {
    Button btn = new Button("");
    btn.getStyleClass().add("shipBtn");

    btn.setOnAction(actionEvent -> {
      if(this.EnemyField.Reveal(x, y)){
        this.PCMove();
      }

      this.SetTexts();
    });

    return btn;
  }
  private void SetTexts() {
    int PShips = 0;
    int EShips = 0;

    for(int x = 0; x < 8; x++){
      for(int y = 0; y < 8; y++){
        int resE = this.EnemyField.At(x, y);
        if(resE > 0 && resE < 10){
          EShips++;
        }
        Image img = new Image(this.IntToImg(resE));
        ImageView view = new ImageView(img);
        this.EnemyBtns[x][y].setGraphic(view);

        int resP = this.PlayerField.At(x, y);
        if(resP > 0 && resP < 10){
          PShips++;
        }
        Image img2 = new Image(this.IntToImg(resP));
        ImageView view2 = new ImageView(img2);
        this.PlayerBtns[x][y].setGraphic(view2);
      }
    }

    if(PShips == 0) DeclareWinner(false);
    if(EShips == 0) DeclareWinner(true);
    this.enemyGridL.setText("PC grid (" + EShips + " ship blocks undiscovered):");
    this.playerGridL.setText("Your grid (" + PShips + " ship blocks undiscovered):");
  }
  private String IntToImg(int res) {
    if(res == 10) return "media/water.png";
    if(res > 10) return "media/ship.png";

    return "media/question.png";
    // return (res >= 10 ? res : "X")
  }
  public void PCMove() {
    int hitX = (int) Math.floor(Math.random() * 8);
    int hitY = (int) Math.floor(Math.random() * 8);

    System.out.println(this.PlayerField.At(hitX, hitY));
    if(this.PlayerField.Reveal(hitX, hitY)){
      this.SetTexts();
    }else{
      this.SetTexts();

      this.PCMove();
    }
  }
  public void DeclareWinner(boolean IsPlayer) {
    System.out.println((IsPlayer ? "Player" : "Computer") + " won!");

    WinnerFX winner = new WinnerFX(this.PrimaryStage, this.MenuRoot, IsPlayer);
    this.PrimaryStage.getScene().setRoot(winner.getRootPane());
  }
  public GridPane getRootPane() {
    return rootPane;
  }
}
