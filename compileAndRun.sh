javac --module-path $PATH_TO_FX --add-modules javafx.controls MenuFX.java
javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml MenuFX.java
java --module-path $PATH_TO_FX --add-modules javafx.controls MenuFX
