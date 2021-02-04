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

    Font font = Font.font("comic sans ms", FontWeight.BOLD, 36);

    Button startGameBtn = new Button("Start new game");
    startGameBtn.setFont(font);
    startGameBtn.setOnAction(actionEvent -> {
      PlacementFX placement = new PlacementFX(primaryStage, root);
      primaryStage.getScene().setRoot(placement.getRootPane());
    });

    Button quitBtn = new Button("Quit");
    quitBtn.setFont(font);
    quitBtn.setOnAction(actionEvent -> {
      System.exit(1);
    });

    Label l = new Label("Welcome to a really bad battleships game!");
    l.setFont(font);
    Scene scene = new Scene(root, 300, 300);
    scene.getStylesheets().add("stylesheet.css");
    root.getChildren().add(l);
    root.getChildren().add(startGameBtn);
    root.getChildren().add(quitBtn);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Button Class Example");
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}
