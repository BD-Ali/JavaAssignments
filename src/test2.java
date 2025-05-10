public class test2 {
    public static void main(String[] args) {
        boolean[][] flights = {{true, false, true}
                , {false, false, true},
                {true, true, true}};
        boolean[][] newMatrix = new boolean[flights.length + 1][flights[0].length + 1];
        for (int i = 0; i < flights.length; i++) {
            for (int j = 0; j < flights[0].length; j++) {
                newMatrix[i][j] = flights[i][j];
            }
        }
        newMatrix[flights.length + 1] = flights[0];
        for (int i = 0; i < flights.length; i++) {
            System.out.println(newMatrix[i][i]);
        }
    }
}
