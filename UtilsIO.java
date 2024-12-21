import java.util.Scanner;

public class UtilsIO {

    public static void showMenu(String menuText) {
        // if the menu text is null or empty, we return
        if (menuText == null || menuText.isEmpty()) {
            return;
        }
        // show the menu
        System.out.println(Constants.EMPTY_SPACE);
        System.out.println(Constants.MESSAGE_SEPARATOR);
        System.out.println(Constants.START_MENU_HEADER);
        System.out.println(Constants.MESSAGE_SEPARATOR);
        System.out.println(menuText);
        System.out.println(Constants.EMPTY_SPACE);
    }

    public static void showError(String textError) {
        // if the error text is null or empty, we return
        if (textError == null || textError.isEmpty()) {
            return;
        }
        // show the error message
        System.out.println(Constants.EMPTY_SPACE);
        System.out.println(Constants.MESSAGE_SEPARATOR);
        System.out.println(Constants.MESSAGE_ERROR_HEADER);
        System.out.println(Constants.MESSAGE_SEPARATOR);
        System.out.println(textError);
        System.out.println(Constants.EMPTY_SPACE);
    }

    public static String askForString(String message, String errorMessage){
    Scanner scanner = new Scanner(System.in, "Cp850");
        System.out.println(message);
        String inputText = scanner.nextLine();
        while (inputText.isEmpty()){
            System.out.println(errorMessage);
            System.out.println(message);
            inputText = scanner.nextLine();
        }
        return inputText;
    }
    
    public static int askForInteger(String message, String errorMessage) {
        Scanner scan = new Scanner(System.in);
        int inputInt;
        boolean correct;
        do {
            System.out.print(message + "\n");
            correct = scan.hasNextInt();
            if (!correct) {
                scan.next();
                System.out.println(errorMessage);
            }
        } while (!correct);
        inputInt = scan.nextInt();
        scan.nextLine();
        return inputInt;
    }
    
    public static void showRounds(String[][] playersData, int[][] pointsMatrix) {
        // if any of the arrays is null, we return
        if (playersData == null || pointsMatrix == null) {
            return;
        }
        // if the number of rows in the arrays is different, we return
        if (playersData.length != pointsMatrix.length) {
            return;
        }
        // if the number of rows is 0, we return
        if (playersData.length == 0 || pointsMatrix.length == 0) {
            return;
        }
        System.out.println(Constants.EMPTY_SPACE);
        System.out.println(Constants.TEMP_LIN);
        System.out.println(Constants.ROUNDS_HEADER);
        System.out.println(Constants.TEMP_LIN);
        for (int i = 0; i < playersData.length; i++) {
            System.out.printf(Constants.ROUNDS_BOARD_FORMAT, 
                                playersData[i][Constants.INDEX_NAME] + " " + playersData[i][Constants.INDEX_LAST_NAME], 
                                playersData[i][Constants.INDEX_AGE],
                                pointsOrDash(pointsMatrix[i][0]),
                                pointsOrDash(pointsMatrix[i][1]), 
                                pointsOrDash(pointsMatrix[i][2]), 
                                pointsOrDash(pointsMatrix[i][3]), 
                                pointsOrDash(pointsMatrix[i][4]), 
                                pointsOrDash(pointsMatrix[i][5]), 
                                pointsOrDash(pointsMatrix[i][6]), 
                                pointsOrDash(pointsMatrix[i][7]), 
                                pointsOrDash(pointsMatrix[i][8]), 
                                pointsOrDash(pointsMatrix[i][9]));
            System.out.println();
        }
        System.out.println(Constants.EMPTY_SPACE);
    }

    private static String pointsOrDash(int points) {
        return points == Constants.POINTS_NO_PLAYED ? "-" : String.valueOf(points);
    }   

    public static void showOrderedPointsList(String[][] playersData, int[] totalPoints, int[] indexArray) {
        // if any of the arrays is null, we return
        if (playersData == null || totalPoints == null || indexArray == null) {
            return;
        }
        // if the number of rows in the arrays is different, we return
        if (playersData.length != totalPoints.length || playersData.length != indexArray.length) {
            return;
        }
        // if the number of rows is 0, we return
        if (playersData.length == 0 || totalPoints.length == 0 || indexArray.length == 0) {
            return;
        }
        // show the ordered list
        System.out.println(Constants.EMPTY_SPACE);
        System.out.println(Constants.TEMP_LIN);
        System.out.println(Constants.TOTALS_HEADER);
        System.out.println(Constants.TEMP_LIN);
        // show the list of players with the total points
        for (int i = 0; i < indexArray.length; i++) {
            System.out.printf(Constants.TOTALS_BOARD_FORMAT, 
                                playersData[indexArray[i]][Constants.INDEX_NAME] + " " + playersData[indexArray[i]][Constants.INDEX_LAST_NAME], 
                                playersData[indexArray[i]][Constants.INDEX_AGE],
                                totalPoints[indexArray[i]]);
            System.out.println();
        }
        System.out.println(Constants.EMPTY_SPACE);
    }
}
