package CSA;

public class Battlefield {
    
    private int[][] DefaultBattlefield = {{0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0}};

    private int[][] PopulatedBattlefield = new int[8][8];

    private int[][] SpottedBattlefield = new int [8][8];

    private int[][] EnemiesBattlefield = new int [8][8];

    public Battlefield() {

    }

    // Get player's battlefield
    public int[][] GetOwnShip() {
        return this.PopulatedBattlefield;
    }

    // Get the confirmed hits/misses
    public int[][] GetSpotShip() {
        return this.SpottedBattlefield;
    }

    // Ship setter for player's battlefield
    public void SetOwnShip(int [][] grid) {
        this.PopulatedBattlefield = grid;
    }

    // Create a new ship
    public int[][] MakeShip(int[][] grid, int length, int ID) {

        Boolean isHorizontal = Math.random() > 0.5;

        int x = (int)Math.floor(Math.random() * (8 - (isHorizontal ? length : 0)));
        int y = (int)Math.floor(Math.random()* (8 - (!isHorizontal ? length : 0)));

        for(int i = 0; i < length; i++) {
            if(isHorizontal) x++;
            else {
                y++;
            }

            grid[x][y] = ID;
        }

        return grid;

    }

    // Show own battlefield in console
    public void toStringOwnB() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                System.out.println(this.PopulatedBattlefield[x][y]);
            }
        }
    }


}