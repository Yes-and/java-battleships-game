# csa-grasp-4

# YEEEEEEEEEEET

# How to build and run the app:

## (Windows):

Download lib from: https://openjfx.io/ unzip it somewhere and link to it with this setpath:

`set PATH_TO_FX="path\to\javafx-sdk-15.0.1\lib"`

And than to run:

`javac --module-path %PATH_TO_FX% --add-modules javafx.controls MenuFX.java`

`javac --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml MenuFX.java`

`java --module-path %PATH_TO_FX% --add-modules javafx.controls MenuFX`

## (Linux):

`javac --module-path $PATH_TO_FX --add-modules javafx.controls MenuFX.java`

`javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml MenuFX.java`

`java --module-path $PATH_TO_FX --add-modules javafx.controls MenuFX`
