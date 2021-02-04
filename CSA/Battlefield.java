package CSA;

public class Battlefield {
  private int[][] Grid = new int[8][8];

  public Battlefield() {
    this.Randomize();
  }

  // Place all ships on the grid randomly
  public void Randomize() {
    this.ClearField();

    this.Grid = this.MakeShip(this.Grid, 2, 1);
    this.Grid = this.MakeShip(this.Grid, 3, 2);
    this.Grid = this.MakeShip(this.Grid, 3, 3);
    this.Grid = this.MakeShip(this.Grid, 4, 4);
    this.Grid = this.MakeShip(this.Grid, 5, 5);
  }

  // Clear all ships from the field
  public void ClearField() {
    this.Grid = new int[][]{{0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0}};
  }

  // Reveal an X Y coordinate
  public boolean Reveal(int x, int y) { // Returns true if dropround
    if(this.Grid[x][y] == 0){ // Hit water
      this.Grid[x][y] = 10;

      return true;
    }else if(this.Grid[x][y] == 10 || this.Grid[x][y] > 10){
      return false;
    }else{
      this.Grid[x][y] += 10;

      return false;
    }
  }

  // Get the grid
  public int[][] GetGrid() {
    return this.Grid;
  }

  // Get a spot
  public int At(int x, int y) {
    return this.Grid[x][y];
  }

  // Create a new ship
  public int[][] MakeShip(int[][] grid, int length, int ID) {
    Boolean isHorizontal = Math.random() > 0.5;

    int x = (int)Math.floor(Math.random() * (8 - (isHorizontal ? length : 0)));
    int y = (int)Math.floor(Math.random()* (8 - (!isHorizontal ? length : 0)));

    for(int i = 0; i < length; i++) {
      if(isHorizontal) x++;
      else y++;

      grid[x][y] = ID;
    }

    return grid;
  }

  // Convert battlefield int[8][8] to readable string
  public String toString() {
    String str = "";

    for (int y = 0; y < 8; y++) {
      for (int x = 0; x < 8; x++) {
        str += this.Grid[x][y];
      }

      str += "\n";
    }

    return str;
  }
}
