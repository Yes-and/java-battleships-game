# csa-grasp-4

# This app uses the JavaFX library, which is available from [here](https://gluonhq.com/products/javafx/).

> Welcome to the battleships game! You play against a computer AI to see who sinks the opponents ships first.

* You can check out comments to understand what functions do

# Division of roles
## Adam - Implementing JavaFX, computer AI
## Vojta - Classes and main functions, working with arrays

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

# In-game screenshot

![Ingame](media/ingame.png?raw=true "Ingame")
