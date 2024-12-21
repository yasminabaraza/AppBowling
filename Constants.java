public class Constants {
    public static final int INDEX_NAME = 0;
    public static final int INDEX_LAST_NAME = 1;
    public static final int INDEX_AGE = 2;
    public static final int PLAYERS_MATRIX_COLUMNS = 3;
    public static final int THROWS_NUMBER = 10;
    public static final int MAX_POINTS = 10;
    public static final int POINTS_NO_PLAYED = -1;
    public static final int PLAYER_NOT_FOUND = -1;
    public static final String EMPTY_STRING = "";
    public static final String MESSAGE_ASK_PLAYERS_NUMBER = "Quants jugadors hi haurà?";
    public static final String MESSAGE_ASK_INTEGER_VALUE = "Introdueixi un valor enter per l'opció";
    public static final String MESSAGE_NOT_VALID_OPTION = "No s'ha introduït una opció vàlida";
    public static final String MESSAGE_INSERT_NAME = "Introdueixi el nom del jugador";
    public static final String MESSAGE_INSERT_LAST_NAME = "Introdueixi el cognom del jugador";
    public static final String MESSAGE_INSERT_FULL_NAME = "Introdueixi el nom complet del jugador";
    public static final String MESSAGE_INSERT_AGE = "Introdueixi l'edat del jugador";
    public static final String MESSAGE_INSERT_ROUND = "Quina ronda vol puntuar?";
    public static final String MESSAGE_INSERT_POINTS = "Introdueixi els punts per ";
    public static final String MESSAGE_ERROR_NO_INTEGER = "No s'ha introduït un número enter";
    public static final String MESSAGE_ERROR_INCORRECT_PLAYER_NUMBER = "No s'ha introduït un nombre correcte de jugadors";
    public static final String MESSAGE_ERROR_EMPTY_STRING = "S'ha introduït un text buit";
    public static final String MESSAGE_ERROR_NO_VALID_ROUND = "La ronda introduïda no existeix. Introdueixi un valor entre 1 i " + THROWS_NUMBER;
    public static final String MESSAGE_ERROR_NO_VALID_POINTS = "Els punts han de ser un valor entre 0 i " + MAX_POINTS;
    public static final String MESSAGE_ERROR_PLAYER_NOT_FOUND = "El jugador no s'ha trobat";
    public static final String MESSAGE_SEPARATOR = "--------------------------------------------------------------------------------------------------------------";
    public static final String START_MENU_HEADER = "GESTIO IOC BOWLING";
    public static final String START_MENU = """
                                    1) Puntuar ronda.
                                    2) Mostrar classificació.
                                    9) Corregir puntuació,
                                    0) Sortir.
                                    """;
    public final static String ROUNDS_HEADER = "FULL NAME                    AGE         R1   R2   R3   R4   R5   R6   R7   R8   R9   R10";
    public final static String TEMP_LIN = "-----------------------------------------------------------------------------------------";
    public final static String ROUNDS_BOARD_FORMAT = "%-28s  %2s %10s %4s %4s %4s %4s %4s %4s %4s %4s %5s";
    public static final String EMPTY_SPACE = "";
    public static final String MESSAGE_ERROR_HEADER = "ERROR";   
    public final static String TOTALS_HEADER = "FULL NAME                    AGE         POINTS";
    public final static String TOTALS_BOARD_FORMAT = "%-28s  %2s %14d";

                               
}
