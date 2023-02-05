package com.sin.games.alchemist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Achievements extends AppCompatActivity {

    private final int[][] txtViewIds = {
            {R.id.ach_txt_lvl_1_user, R.id.ach_txt_lvl_1_best},
            {R.id.ach_txt_lvl_2_user, R.id.ach_txt_lvl_2_best},
            {R.id.ach_txt_lvl_3_user, R.id.ach_txt_lvl_3_best},
            {R.id.ach_txt_lvl_4_user, R.id.ach_txt_lvl_4_best},
            {R.id.ach_txt_lvl_5_user, R.id.ach_txt_lvl_5_best},
            {R.id.ach_txt_lvl_6_user, R.id.ach_txt_lvl_6_best},
            {R.id.ach_txt_lvl_7_user, R.id.ach_txt_lvl_7_best},
            {R.id.ach_txt_lvl_8_user, R.id.ach_txt_lvl_8_best},
            {R.id.ach_txt_lvl_9_user, R.id.ach_txt_lvl_9_best},
            {R.id.ach_txt_lvl_10_user, R.id.ach_txt_lvl_10_best},
            {R.id.ach_txt_lvl_11_user, R.id.ach_txt_lvl_11_best},
            {R.id.ach_txt_lvl_12_user, R.id.ach_txt_lvl_12_best},
            {R.id.ach_txt_lvl_13_user, R.id.ach_txt_lvl_13_best},
            {R.id.ach_txt_lvl_14_user, R.id.ach_txt_lvl_14_best},
            {R.id.ach_txt_lvl_15_user, R.id.ach_txt_lvl_15_best},
            {R.id.ach_txt_lvl_16_user, R.id.ach_txt_lvl_16_best},
            {R.id.ach_txt_lvl_17_user, R.id.ach_txt_lvl_17_best},
            {R.id.ach_txt_lvl_18_user, R.id.ach_txt_lvl_18_best},
            {R.id.ach_txt_lvl_19_user, R.id.ach_txt_lvl_19_best},
            {R.id.ach_txt_lvl_20_user, R.id.ach_txt_lvl_20_best}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.achievements);

        for(int i = 0; i < LevelsManager.LEVELS_AMOUNT; i++){

            TextView txtLevelsHeader = (TextView)findViewById( R.id.ach_txt_levels );
            switch ( Prefs.getDifficultLevel() ){
                case LevelsManager.DIFFICULT_EASY:
                    txtLevelsHeader.setText( "Levels\n(Easy)" );
                    break;
                case LevelsManager.DIFFICULT_MEDIUM:
                    txtLevelsHeader.setText( "Levels\n(Medium)" );
                    break;
                case LevelsManager.DIFFICULT_HARD:
                    txtLevelsHeader.setText( "Levels\n(Hard)" );
                    break;
            }

            TextView txtUserRecord = (TextView)findViewById( txtViewIds[i][0] );
            TextView txtBestRecord = (TextView)findViewById( txtViewIds[i][1] );

            int diffLevl = Prefs.getDifficultLevel();

            if ( Prefs.getLevel(diffLevl, i) )
            {
                int userRecord = Prefs.getAchievements( diffLevl, i );

                if ( userRecord == 0 ) {
                    txtUserRecord.setText( "---" );
                } else {
                    txtUserRecord.setText( Integer.toString( userRecord ) );
                }

                int bestRecord = LevelsManager.getLevelSolution( diffLevl, i ).length() / 2;
                if ( userRecord < bestRecord )
                {
                    bestRecord = userRecord;
                }
                txtBestRecord.setText( Integer.toString( bestRecord ) );

            } else {
                txtUserRecord.setText( "lock" );
                txtBestRecord.setText( "lock");
            }

        }

    }
}
