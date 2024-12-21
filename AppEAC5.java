

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author IOC
 */
public class AppEAC5 {


    public static void main(String[] args) {
        AppEAC5 bowlingApp = new AppEAC5();
        bowlingApp.start();
    }

    public void start() {
        // ask for the number of players
        int playersNumber = UtilsIO.askForInteger(Constants.MESSAGE_ASK_PLAYERS_NUMBER, Constants.MESSAGE_ERROR_NO_INTEGER);
        // if the number of players is less than 1, we return
        if (playersNumber < 1) {
            UtilsIO.showError(Constants.MESSAGE_ERROR_INCORRECT_PLAYER_NUMBER);
            return;
        }
        // initialize the players data and the points matrix
        BowlingData bowlingData = new BowlingData();
        bowlingData.initializePlayers(playersNumber);
        bowlingData.initializePoints(playersNumber);
        // ask the user for the player names
        for (int i = 0; i < bowlingData.playersData.length; i++) {
            var name = UtilsIO.askForString(i + 1 + "/" + bowlingData.playersData.length + " - " + Constants.MESSAGE_INSERT_NAME, Constants.MESSAGE_ERROR_EMPTY_STRING);
            var lastName = UtilsIO.askForString(i + 1 + "/" + bowlingData.playersData.length + " - " + Constants.MESSAGE_INSERT_LAST_NAME, Constants.MESSAGE_ERROR_EMPTY_STRING);
            var age = UtilsIO.askForInteger(i + 1 + "/" + bowlingData.playersData.length + " - " + Constants.MESSAGE_INSERT_AGE, Constants.MESSAGE_ERROR_NO_INTEGER);
            UtilsBowling.insertPlayerNames(bowlingData.playersData, i, name, lastName, age);
        }
        // show the menu. Don't exit until the user wants to
        boolean exitLoop = false;
        while (!exitLoop) {
            UtilsIO.showMenu(Constants.START_MENU);
            int option = UtilsIO.askForInteger(Constants.MESSAGE_ASK_INTEGER_VALUE, Constants.MESSAGE_ERROR_NO_INTEGER);
            switch (option) {
                case 1: {
                    // set the points for a round
                    askForRoundPoints(bowlingData.playersData, bowlingData.pointsMatrix);
                    UtilsIO.showRounds(bowlingData.playersData, bowlingData.pointsMatrix);
                    break;
                }
                //
                case 2: {
                    // show the totals
                    showTotalPoints(bowlingData.playersData, bowlingData.pointsMatrix);
                    break;
                }
                case 9: {
                    // correct the points for a round
                    correctPlayerPoints(bowlingData.playersData, bowlingData.pointsMatrix);
                    break;
                }
                case 0: {
                    // exit the program
                    exitLoop = true;
                    break;
                }
                default: {
                    // show an error message if the option is not valid
                    UtilsIO.showError(Constants.MESSAGE_NOT_VALID_OPTION);
                    break;
                }
            }
        }
    }

    private void showTotalPoints(String[][] playersData, int[][] pointsMatrix) {
       // calculate the total points for each player
        int[] totalPoints = UtilsBowling.calculateTotalPointsArray(pointsMatrix);
        // calculate the index array with the order of the players
        int[] indexArray = UtilsBowling.getOrderedIndexArrayWithTotalPoints(totalPoints);
        // show the ordered list
        UtilsIO.showOrderedPointsList(playersData, totalPoints, indexArray);
    }

    private void correctPlayerPoints(String[][] playersData, int[][] pointsMatrix) {
        // ask the user for the player to correct
        String playerName = UtilsIO.askForString(Constants.MESSAGE_INSERT_FULL_NAME, Constants.MESSAGE_ERROR_EMPTY_STRING);
        int playerIndex = UtilsBowling.lookForPlayer(playersData, playerName);
        // if the player is not found, we return
        if (playerIndex == -1) {
            UtilsIO.showError(Constants.MESSAGE_ERROR_PLAYER_NOT_FOUND);
            return;
        }
        // ask for the round to correct
        int round = UtilsIO.askForInteger(Constants.MESSAGE_INSERT_ROUND, Constants.MESSAGE_ERROR_NO_INTEGER);
        // it the round is not valid, we return
        if (round < 1 || round > Constants.THROWS_NUMBER) {
            UtilsIO.showError(Constants.MESSAGE_ERROR_NO_VALID_ROUND);
            return;
        }
        // ask for the points for the round
        int playerPoints = UtilsIO.askForInteger(Constants.MESSAGE_INSERT_POINTS + playersData[playerIndex][Constants.INDEX_NAME] + " " + playersData[playerIndex][Constants.INDEX_LAST_NAME], Constants.MESSAGE_ERROR_NO_INTEGER);
        // if the points are not valid, we return
        if (playerPoints < 0 || playerPoints > Constants.MAX_POINTS) {
            UtilsIO.showError(Constants.MESSAGE_ERROR_NO_VALID_POINTS);
            return;
        }
        // set the points in the matrix
        UtilsBowling.setRoundPoints(pointsMatrix, playerIndex, round, playerPoints);
        UtilsIO.showRounds(playersData, pointsMatrix);
    }

    private void askForRoundPoints(String[][] playersData, int[][] pointsMatrix) {
        // ask for the round to set the points
        int round = UtilsIO.askForInteger(Constants.MESSAGE_INSERT_ROUND, Constants.MESSAGE_ERROR_NO_INTEGER);
        // it the round is not valid, we return
        if (round < 1 || round > Constants.THROWS_NUMBER) {
            UtilsIO.showError(Constants.MESSAGE_ERROR_NO_VALID_ROUND);
            return;
        }
        // ask for the points for each player
        for (int i = 0; i < playersData.length; i++) {
            int playerPoints = UtilsIO.askForInteger(Constants.MESSAGE_INSERT_POINTS + playersData[i][Constants.INDEX_NAME] + " " + playersData[i][Constants.INDEX_LAST_NAME], Constants.MESSAGE_ERROR_NO_INTEGER);
            while (playerPoints < 0 || playerPoints > Constants.MAX_POINTS) {
                UtilsIO.showError(Constants.MESSAGE_ERROR_NO_VALID_POINTS);
                playerPoints = UtilsIO.askForInteger(Constants.MESSAGE_INSERT_POINTS + playersData[i][Constants.INDEX_NAME] + " " + playersData[i][Constants.INDEX_LAST_NAME], Constants.MESSAGE_ERROR_NO_INTEGER);
            }
            UtilsBowling.setRoundPoints(pointsMatrix, i, round, playerPoints);
        }
    }


}