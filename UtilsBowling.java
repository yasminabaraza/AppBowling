import java.util.Arrays;

public class UtilsBowling {
    
    public static void insertPlayerNames(String[][] playersData, int rowNumber, String name, String lastName, int age) {
        // if the array is null, we return
        if (playersData == null) {
            return;
        }
        // if the row number is not valid, we return
        if (rowNumber < 0 || rowNumber >= playersData.length) {
            return;
        }
        // if the name is null or empty, we return
        if (name == null || name.isEmpty()) {
            return;
        }
        // if the last name is null or empty, we return
        if (lastName == null || lastName.isEmpty()) {
            return;
        }
        // if the age is less than 0, we return
        if (age < 0) {
            return;
        }
        // insert the data in the array
        playersData[rowNumber][Constants.INDEX_NAME] = name;
        playersData[rowNumber][Constants.INDEX_LAST_NAME] = lastName;
        playersData[rowNumber][Constants.INDEX_AGE] = String.valueOf(age);
    }

    public static void setRoundPoints(int[][] pointsMatrix, int rowIndex, int round, int points) {
        // if the array is null, we return
        if (pointsMatrix == null) {
            return;
        }
        // if the row index is not valid, we return
        if (rowIndex < 0 || rowIndex >= pointsMatrix.length) {
            return;
        }
        // if the round is not valid, we return
        if (round < 1 || round > Constants.THROWS_NUMBER) {
            return;
        }
        // if the points are not valid, we return
        if (points < 0 || points > Constants.MAX_POINTS) {
            return;
        }
        // set the points in the array
        pointsMatrix[rowIndex][round - 1] = points;
    }

    public static int lookForPlayer(String[][] playersMatrix, String playerFullName) {
        // if the array is null, we return -1
        if (playersMatrix == null) {
            return Constants.PLAYER_NOT_FOUND;
        }
        // if the player name is null or empty, we return -1
        if (playerFullName == null || playerFullName.isEmpty()) {
            return Constants.PLAYER_NOT_FOUND;
        }
        // the player name has to be split in two parts. If it's not possible, we return -1
        String[] parts = playerFullName.split(" ");
        if (parts.length != 2) {
            return Constants.PLAYER_NOT_FOUND;
        }
        // look for the player in the array
        for (int i = 0; i < playersMatrix.length; i++) {
            if (playersMatrix[i][Constants.INDEX_NAME].equalsIgnoreCase(parts[0]) && 
                playersMatrix[i][Constants.INDEX_LAST_NAME].equalsIgnoreCase(parts[1])) {
                return i;
            }
        }
        return Constants.PLAYER_NOT_FOUND;
    }

    public static int[] calculateTotalPointsArray(int[][] pointsMatrix) {
        // if the array is null, we return null
        if (pointsMatrix == null) {
            return null;
        }
        // we create an array with the same length as the number of rows
        int[] totalPointsArray = new int[pointsMatrix.length];
        // we calculate the total points for each row
        for (int i = 0; i < pointsMatrix.length; i++) {
            totalPointsArray[i] = calculateRowPoints(pointsMatrix[i]);
        }
        return totalPointsArray;
    }

    public static int[] getOrderedIndexArrayWithTotalPoints(int[] totalPointsArray) {
        // if the array is null, we return null
        if (totalPointsArray == null) {
            return null;
        }
        // we create an array with the same length as the array
        int[] indexes = new int[totalPointsArray.length];
        // we initialize the array with the indexes
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        // we create a copy of the original array
        int[] tempPointsArray = Arrays.copyOf(totalPointsArray, totalPointsArray.length);
        // we sort the array using the bubble algorithm
        for (int i = 0; i < tempPointsArray.length - 1; i++) {
            for (int j = 0; j < tempPointsArray.length - 1; j++) {
                if (tempPointsArray[j] < tempPointsArray[j + 1]) {
                    int temp = tempPointsArray[j];
                    tempPointsArray[j] = tempPointsArray[j + 1];
                    tempPointsArray[j + 1] = temp;
                    temp = indexes[j];
                    indexes[j] = indexes[j + 1];
                    indexes[j + 1] = temp;
                }
            }
        }        
        return indexes;
    }

    private static int calculateRowPoints(int[] matrixRow) {
       int total = 0;
        for (int i = 0; i < matrixRow.length; i++) {
            if (matrixRow[i] != -1)  {
                total += matrixRow[i];
            }
        }
        return total;
    }
}
