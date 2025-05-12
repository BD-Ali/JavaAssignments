//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[][] maze = {
                {1,1,0},
                {1,1,0},
                {0,1,1},
        };
        System.out.println(numOfPaths(maze,0,0));
    }
    public static int numOfPaths(int[][] maze, int i, int j) {
        if ( i > maze[0].length - 1 || j > maze[0].length - 1 || maze[i][j] == 0) {
            return 0;
        }
        if ((maze[0].length - 1) == i & (maze[0].length - 1) == j & maze[i][j] == 1) {
            return 1;
        }
        else
            return numOfPaths(maze, i + 1, j) + numOfPaths(maze, i, j + 1);
    }
}