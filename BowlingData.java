public class BowlingData {
    String[][] playersData;
    int[][] pointsMatrix;

    public void initializePoints(int playersNumber) {
        // if the number of players is less than 1, we return
        if (playersNumber < 1) {
            return;
        }
        // we create the array with playersNumber rows and THROWS_NUMBER columns
        pointsMatrix = new int[playersNumber][Constants.THROWS_NUMBER];
        // initialize the array with 0
        for (int i = 0; i < pointsMatrix.length; i++) {
            for (int j = 0; j < pointsMatrix[i].length; j++) {
                pointsMatrix[i][j] = Constants.POINTS_NO_PLAYED;
            }
        };
    } 

    public void initializePlayers(int playersNumber) {
        // if the number of players is less than 1, we return
        if (playersNumber < 1) {
            return;
        }
        // we create the array with playersNumber rows and PLAYERS_MATRIX_COLUMNS columns
        playersData = new String[playersNumber][Constants.PLAYERS_MATRIX_COLUMNS];
        // initialize the array with empty strings
        for (int i = 0; i < playersData.length; i++) {
            for (int j = 0; j < playersData[i].length; j++) {
                playersData[i][j] = Constants.EMPTY_STRING;
            }
        }
    }
}
