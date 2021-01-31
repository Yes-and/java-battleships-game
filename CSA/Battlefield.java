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

}
