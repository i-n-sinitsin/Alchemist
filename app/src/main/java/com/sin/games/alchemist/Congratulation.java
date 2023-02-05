package com.sin.games.alchemist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class Congratulation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.congratulation);

        // set fullscreen
        this.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView solutionUser = (TextView) findViewById( R.id.solutionUser );
        int userSteps = Prefs.getCurrentSteps();
        solutionUser.setText( Integer.toString( userSteps ) + " steps" );

        TextView solutionRecord = (TextView) findViewById( R.id.solutionRecord);
        int record = LevelsManager.getLevelSolution( Prefs.getDifficultLevel(), Prefs.getCurrentLevel() ).length() / 2;
        if ( userSteps < record ){
            record = userSteps;
        }
        solutionRecord.setText( Integer.toString( record ) + " steps" );
    }
}
