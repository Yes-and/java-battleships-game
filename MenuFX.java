import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MenuFX extends Application {
  @Override
  public void start(Stage primaryStage) {
    TilePane root = new TilePane();
    Button startGameBtn = new Button("Start new game");
    Font font = Font.font("comic sans ms", FontWeight.BOLD, 36);
    startGameBtn.setFont(font);
    startGameBtn.setOnAction(actionEvent -> {
      GameFX game = new GameFX(primaryStage, root);
      primaryStage.getScene().setRoot(game.getRootPane());
    });
    Label l = new Label("Welcome to a really bad battleships game!");
    l.setFont(font);
    Scene scene = new Scene(root, 300, 300);
    root.getChildren().add(l);
    root.getChildren().add(startGameBtn);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Button Class Example");
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}
