package com.sin.games.alchemist;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {

    private static final String ALCHEMIST_DATA = Alchemist.class.getName();

    // common settings
    private static final String DATA_MUSIC = "music";
    private static final boolean DATA_MUSIC_DEF = true;

    private static final String DATA_SOUND = "sound";
    private static final boolean DATA_SOUND_DEF = true;

    // game data
    private static final String DATA_DIFFICULT_LEVEL = "difficult_level";
    private static final int DATA_DIFFICULT_LEVEL_DEF = LevelsManager.DIFFICULT_EASY;

    private static final String DATA_EASY_LEVELS = "easy_levels";
    private static final String DATA_EASY_LEVELS_DEF = "ULLLLLLLLLLLLLLLLLLL";

    private static final String DATA_MEDIUM_LEVELS = "medium_levels";
    private static final String DATA_MEDIUM_LEVELS_DEF = "ULLLLLLLLLLLLLLLLLLL";

    private static final String DATA_HARD_LEVELS = "hard_levels";
    private static final String DATA_HARD_LEVELS_DEF = "ULLLLLLLLLLLLLLLLLLL";

    private static final String DATA_CURRENT_LEVEL = "current_level";
    private static final int DATA_CURRENT_LEVEL_DEF = 0;

    private static final String DATA_GAME_STARTED = "game_started";
    private static final boolean DATA_GAME_STARTED_DEF = false;

    private static final String DATA_CURRENT_STEPS = "current_steps";
    private static final int DATA_CURRENT_STEPS_DEF = 0;

    private static final String DATA_GAME_FIELD = "game_field";
    private static final String DATA_GAME_FIELD_DEF =
            "NNNNNNNNNN" +
            "NNNNNNNNNN" +
            "NNNNNNNNNN" +
            "NNNNNNNNNN" +
            "NNNNNNNNNN" +
            "NNNNNNNNNN" +
            "NNNNNNNNNN" +
            "NNNNNNNNNN" +
            "NNNNNNNNNN" +
            "NNNNNNNNNN";

    private static final String[][] DATA_RECORDS = {
            { "record_easy_1" ,"record_medium_1" , "record_hard_1"},
            { "record_easy_2" ,"record_medium_2" , "record_hard_2"},
            { "record_easy_3" ,"record_medium_3" , "record_hard_3"},
            { "record_easy_4" ,"record_medium_4" , "record_hard_4"},
            { "record_easy_5" ,"record_medium_5" , "record_hard_5"},
            { "record_easy_6" ,"record_medium_6" , "record_hard_6"},
            { "record_easy_7" ,"record_medium_7" , "record_hard_7"},
            { "record_easy_8" ,"record_medium_8" , "record_hard_8"},
            { "record_easy_9" ,"record_medium_9" , "record_hard_9"},
            { "record_easy_10" ,"record_medium_10" , "record_hard_10"},
            { "record_easy_11" ,"record_medium_11" , "record_hard_11"},
            { "record_easy_12" ,"record_medium_12" , "record_hard_12"},
            { "record_easy_13" ,"record_medium_13" , "record_hard_13"},
            { "record_easy_14" ,"record_medium_14" , "record_hard_14"},
            { "record_easy_15" ,"record_medium_15" , "record_hard_15"},
            { "record_easy_16" ,"record_medium_16" , "record_hard_16"},
            { "record_easy_17" ,"record_medium_17" , "record_hard_17"},
            { "record_easy_18" ,"record_medium_18" , "record_hard_18"},
            { "record_easy_19" ,"record_medium_19" , "record_hard_19"},
            { "record_easy_20" ,"record_medium_20" , "record_hard_20"},
    };
    private static final int DATA_RECORD_DEF = 0;



    private static SharedPreferences getPrefs(){
        Context context = Alchemist.getContextOfApplication();
        return context.getSharedPreferences(ALCHEMIST_DATA, Context.MODE_PRIVATE);
    }

    public static boolean getMusic(){
        return getPrefs().getBoolean(DATA_MUSIC, DATA_MUSIC_DEF);
    }

    public static boolean putMusic(boolean value){
        return getPrefs()
                .edit()
                .putBoolean(DATA_MUSIC, value)
                .commit();
    }

    public static boolean getSound(){
        return getPrefs().getBoolean(DATA_SOUND, DATA_SOUND_DEF);
    }

    public static boolean putSound(boolean value){
        return getPrefs()
                .edit()
                .putBoolean(DATA_SOUND, value)
                .commit();
    }

    public static int getDifficultLevel(){
        return getPrefs().getInt(DATA_DIFFICULT_LEVEL, DATA_DIFFICULT_LEVEL_DEF);
    }

    public static boolean putDifficultLevel(int value){
        return getPrefs()
                .edit()
                .putInt(DATA_DIFFICULT_LEVEL, value)
                .commit();
    }

    public static boolean getLevel(int difficultLevel, int level){

        String data_name = DATA_EASY_LEVELS;
        String data_defValue = DATA_EASY_LEVELS_DEF;

        switch( difficultLevel ){
            case LevelsManager.DIFFICULT_EASY:
                data_name = DATA_EASY_LEVELS;
                data_defValue = DATA_EASY_LEVELS_DEF;
                break;
            case LevelsManager.DIFFICULT_MEDIUM:
                data_name = DATA_MEDIUM_LEVELS;
                data_defValue = DATA_MEDIUM_LEVELS_DEF;
                break;
            case LevelsManager.DIFFICULT_HARD:
                data_name = DATA_HARD_LEVELS;
                data_defValue = DATA_HARD_LEVELS_DEF;
                break;
        }

        String result = getPrefs().getString(data_name, data_defValue);

        return result.charAt(level) == 'U';
    }

    public static boolean putLevels(int difficultLevel, int level, boolean value){
        String data_name = DATA_EASY_LEVELS;
        String data_defValue = DATA_EASY_LEVELS_DEF;

        switch( difficultLevel ){
            case LevelsManager.DIFFICULT_EASY:
                data_name = DATA_EASY_LEVELS;
                data_defValue = DATA_EASY_LEVELS_DEF;
                break;
            case LevelsManager.DIFFICULT_MEDIUM:
                data_name = DATA_MEDIUM_LEVELS;
                data_defValue = DATA_MEDIUM_LEVELS_DEF;
                break;
            case LevelsManager.DIFFICULT_HARD:
                data_name = DATA_HARD_LEVELS;
                data_defValue = DATA_HARD_LEVELS_DEF;
                break;
        }

        String data=getPrefs().getString(data_name, data_defValue);
        if ( value ){
            data=replaceChar(data, level, 'U');
        } else {
            data=replaceChar(data, level, 'L');
        }

        return getPrefs()
                .edit()
                .putString(data_name, data)
                .commit();
    }

    private static String replaceChar(String str, int index, char replace){
        if (str==null){
            return str;
        } else if (index<0 || index>=str.length()){
            return str;
        }

        char[] chars = str.toCharArray();
        chars[index] = replace;
        return String.valueOf(chars);
    }

    public static boolean getGameStarted(){
        return getPrefs().getBoolean(DATA_GAME_STARTED, DATA_GAME_STARTED_DEF);
    }

    public static boolean putGameStarted(boolean value){
        return getPrefs()
                .edit()
                .putBoolean(DATA_GAME_STARTED, value)
                .commit();
    }

    public static int getCurrentSteps(){
        return getPrefs().getInt(DATA_CURRENT_STEPS, DATA_CURRENT_STEPS_DEF);
    }

    public static boolean putCurrentSteps(int value){
        return getPrefs()
                .edit()
                .putInt(DATA_CURRENT_STEPS, value)
                .commit();
    }

    public static String getGameField(){
        return getPrefs().getString(DATA_GAME_FIELD, DATA_GAME_FIELD_DEF);
    }

    public static boolean putGameField(String value){
        return getPrefs()
                .edit()
                .putString(DATA_GAME_FIELD, value)
                .commit();
    }

    public static int getCurrentLevel(){
        return getPrefs().getInt(DATA_CURRENT_LEVEL, DATA_CURRENT_LEVEL_DEF);
    }

    public static boolean putCurrentLevel(int value){
        return getPrefs()
                .edit()
                .putInt(DATA_CURRENT_LEVEL, value)
                .commit();
    }

    public static int getAchievements(  int difficultLevel, int level ){
        return getPrefs().getInt(DATA_RECORDS[level][difficultLevel], DATA_RECORD_DEF);
    }

    public static boolean putAchievements(int difficultLevel, int level, int value){
        return getPrefs()
                .edit()
                .putInt(DATA_RECORDS[level][difficultLevel], value)
                .commit();
    }


}
