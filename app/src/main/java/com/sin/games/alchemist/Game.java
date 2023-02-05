package com.sin.games.alchemist;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.Display;
import android.graphics.Point;
import android.os.Handler;
// AdMob
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Game extends AppCompatActivity implements View.OnTouchListener {

    // todo remove
    /*public int step = -1;*/

    private Field fields[][];
    private Level currentLevel = new Level();

    // AdMob
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        // AdMob
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // set fullscreen
        this.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView imgBtnRepeat = (ImageView) findViewById(R.id.imgGameBtnRepeat);
        imgBtnRepeat.setOnTouchListener(this);

        ImageView imgBtnLevels = (ImageView) findViewById(R.id.imgGameBtnLevels);
        imgBtnLevels.setOnTouchListener(this);

        ImageView imgBtnSettings = (ImageView) findViewById(R.id.imgGameBtnSettings);
        imgBtnSettings.setOnTouchListener(this);

        ImageView imgBtnAchievements = (ImageView) findViewById(R.id.imgGameBtnAchievements);
        imgBtnAchievements.setOnTouchListener(this);

        // todo remove this
        /*ImageView imgHack = (ImageView) findViewById(R.id.alchemist_hack);
        imgHack.setOnTouchListener(this);*/

        Auxiliary aux = Auxiliary.getInstance();

        fields = new Field[aux.ROW_AMOUNT][aux.COLUMN_AMOUNT];
        for(int row=0; row<aux.ROW_AMOUNT; row++){
            for( int column=0; column<aux.COLUMN_AMOUNT; column++){
                ImageView imgView = FindImgView(row, column);
                imgView.setOnTouchListener(this);
                fields[row][column] = new Field(imgView);
            }
        }

        // get screen size
        float weightForGameFields = 1.0f;

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize( size );
        float width = size.x;
        float height = size.y;

        if ( width < height ){
            weightForGameFields = 1.0f - width / height;
        } else {
            weightForGameFields = 1.0f - height / width;
        }

        System.out.println(width);
        System.out.println(height);
        System.out.println(weightForGameFields);


        LinearLayout l = (LinearLayout)findViewById( R.id.gameFields );
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                weightForGameFields
                );
        l.setLayoutParams( param );
    }

    private void startLevel()
    {
        // return right state of buttons
        ImageView imgBtnRepeat = (ImageView) findViewById(R.id.imgGameBtnRepeat);
        imgBtnRepeat.setImageResource(R.drawable.game_button_repeat_up);

        ImageView imgBtnLevels = (ImageView) findViewById(R.id.imgGameBtnLevels);
        imgBtnLevels.setImageResource(R.drawable.game_button_levels_up);

        ImageView imgBtnSettings = (ImageView) findViewById(R.id.imgGameBtnSettings);
        imgBtnSettings.setImageResource(R.drawable.game_button_settings_up);

        ImageView imgBtnAchievements = (ImageView) findViewById(R.id.imgGameBtnAchievements);
        imgBtnAchievements.setImageResource(R.drawable.game_button_achievement_up);

        resetFields();

        int currentLvl = Prefs.getCurrentLevel();
        int currentDifficultLvl = Prefs.getDifficultLevel();

        ImageView imgDiffLevel = (ImageView) findViewById(R.id.imgDifficultLevel);
        switch( currentDifficultLvl )
        {
            case LevelsManager.DIFFICULT_EASY:
                imgDiffLevel.setImageResource(R.drawable.txt_easy);
                break;
            case LevelsManager.DIFFICULT_MEDIUM:
                imgDiffLevel.setImageResource(R.drawable.txt_medium);
                break;
            case LevelsManager.DIFFICULT_HARD:
                imgDiffLevel.setImageResource(R.drawable.txt_hard);
                break;
        }

        TextView textLevel = (TextView) findViewById(R.id.tvCurrentLevel);
        textLevel.setText( Integer.toString( currentLvl + 1 ) );

        // read level from prefs or from level manager
        String description = LevelsManager.getLevelDescription( currentDifficultLvl, currentLvl );

        if ( Prefs.getGameStarted() ){
            description = Prefs.getGameField();
        } else {
            Prefs.putCurrentSteps( 0 );
        }

        currentLevel.setFields( description );

        updateFields();
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        SoundEffectsManager sem = SoundEffectsManager.getInstance();
        sem.playBackgroundMusic();

        startLevel();
    }

    @Override
    protected void onPause() {
        super.onPause();

        SoundEffectsManager sem = SoundEffectsManager.getInstance();
        sem.stopBackgroundMusic();
    }

    private void resetFields() {
        Auxiliary aux = Auxiliary.getInstance();

        for(int row=0; row<aux.ROW_AMOUNT; row++){
            for( int column=0; column<aux.COLUMN_AMOUNT; column++){
                fields[row][column].reset();
            }
        }
    }

    private void updateFields()
    {
        Auxiliary aux = Auxiliary.getInstance();

        for(int row=0; row<aux.ROW_AMOUNT; row++){
            for( int column=0; column<aux.COLUMN_AMOUNT; column++){
                switch( currentLevel.getContent(row, column) )
                {
                    case NONE:
                        fields[row][column].setNone();
                        break;
                    case GOLD:
                        fields[row][column].setGold();
                        break;
                    case PLUMBUM:
                        fields[row][column].setPlumbum();
                        break;
                }

            }
        }
    }

    protected void doStep(int row, int column){
        if ( currentLevel.getContent(row, column) == Field.FieldContent.NONE )
            return;

        Auxiliary aux = Auxiliary.getInstance();

        // left direction
        for(int i=column-1; i>=0; i--){
            if ( currentLevel.getContent(row, i) != Field.FieldContent.NONE )
            {
                changeField( row, i);
            } else {
                break;
            }
        }

        // right direction
        for(int i=column+1; i<=aux.COLUMN_AMOUNT; i++){
            if ( currentLevel.getContent(row, i) != Field.FieldContent.NONE )
            {
                changeField( row, i);
            } else {
                break;
            }
        }

        // up direction
        for(int i=row-1; i>=0; i--){
            if ( currentLevel.getContent(i, column) != Field.FieldContent.NONE )
            {
                changeField( i, column);
            } else {
                break;
            }
        }

        // down direction
        for(int i=row+1; i<=aux.ROW_AMOUNT; i++){
            if ( currentLevel.getContent(i, column) != Field.FieldContent.NONE )
            {
                changeField( i, column);
            } else {
                break;
            }
        }

        // center
        if ( currentLevel.getContent(row, column) != Field.FieldContent.NONE )
        {
            changeField( row, column);
        }


        Prefs.putGameStarted( true );
        Prefs.putCurrentSteps( Prefs.getCurrentSteps() + 1 );
        Prefs.putGameField( currentLevel.getFields() );
    }

    private void changeField( int row, int column ){
        switch( currentLevel.getContent(row, column) )
        {
            case GOLD:
                fields[row][column].setPlumbum();
                currentLevel.setContent(Field.FieldContent.PLUMBUM, row, column);
                break;
            case PLUMBUM:
                fields[row][column].setGold();
                currentLevel.setContent(Field.FieldContent.GOLD, row, column);
                break;
        }
    }

    private boolean checkWin(){
        Auxiliary aux = Auxiliary.getInstance();

        for(int row=0; row<aux.ROW_AMOUNT; row++){
            for( int column=0; column<aux.COLUMN_AMOUNT; column++){
                if ( currentLevel.getContent(row, column) == Field.FieldContent.PLUMBUM ){
                    return false;
                }
            }
        }

        Prefs.putGameStarted( false );
        return true;
    }

    private ImageView FindImgView(int row, int column){
        Auxiliary aux = Auxiliary.getInstance();
        ImageView imgView = (ImageView)findViewById(aux.idByPosition(row, column));
        return imgView;
    }

    public boolean onTouch( View view, MotionEvent motion){
        if ( motion.getAction() == MotionEvent.ACTION_UP ) {

            switch( view.getId() ) {
                case R.id.imgGameBtnRepeat: {
                    ImageView imgBtn = (ImageView) findViewById(R.id.imgGameBtnRepeat);
                    imgBtn.setImageResource(R.drawable.game_button_repeat_down);

                    SoundEffectsManager sem = SoundEffectsManager.getInstance();
                    sem.playSoundBtnClick();

                    Prefs.putGameStarted( false );
                    Prefs.putCurrentSteps( 0 );

                    Auxiliary aux = Auxiliary.getInstance();
                    for (int row = 0; row < aux.ROW_AMOUNT; row++) {
                        for (int column = 0; column < aux.COLUMN_AMOUNT; column++) {
                            fields[row][column].setNone();
                        }
                    }

                    final Handler h1 = new Handler();
                    h1.postDelayed(new Runnable() {
                                       @Override
                                       public void run() {
                                           startLevel();
                                       }
                                   }, 525
                    );
                }
                break;
                case R.id.imgGameBtnLevels: {
                    ImageView imgBtn = (ImageView) findViewById(R.id.imgGameBtnLevels);
                    imgBtn.setImageResource(R.drawable.game_button_levels_down);

                    SoundEffectsManager sem = SoundEffectsManager.getInstance();
                    sem.playSoundBtnClick();

                    Levels.callingFromGame = true;
                    Intent intent = new Intent(this, Levels.class);
                    startActivity(intent);
                }
                break;
                case R.id.imgGameBtnSettings: {
                    ImageView imgBtn = (ImageView) findViewById(R.id.imgGameBtnSettings);
                    imgBtn.setImageResource(R.drawable.game_button_settings_down);

                    SoundEffectsManager sem = SoundEffectsManager.getInstance();
                    sem.playSoundBtnClick();

                    Intent intent = new Intent(this, Settings.class);
                    startActivity(intent);
                }
                    break;
                case R.id.imgGameBtnAchievements: {
                    ImageView imgBtn = (ImageView) findViewById(R.id.imgGameBtnAchievements);
                    imgBtn.setImageResource(R.drawable.game_button_achievement_down);

                    SoundEffectsManager sem = SoundEffectsManager.getInstance();
                    sem.playSoundBtnClick();

                    Intent intent = new Intent(this, Achievements.class);
                    startActivity(intent);
                }
                    break;
/*
                case R.id.alchemist_hack:


                    int diffLevl = Prefs.getDifficultLevel();
                    int curLevl = Prefs.getCurrentLevel();

                    String solution = LevelsManager.getLevelSolution(diffLevl, curLevl);

                    step = solution.length() / 2 - 1;

                    final Handler h2 = new Handler();
                    h2.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            hackStep();
                        }
                        }, 1000
                    );

                    break;
*/
                default:

                    Auxiliary aux = Auxiliary.getInstance();
                    Auxiliary.Position position = aux.positionById(view.getId());

                    if ( currentLevel.getContent(position.row, position.column) != Field.FieldContent.NONE ){
                        SoundEffectsManager sem = SoundEffectsManager.getInstance();
                        sem.playSoundFieldClick();
                        sem.playSoundFieldChange();

                        doStep(position.row, position.column);

                        if ( checkWin() )
                        {
                            // unlock next level if needed
                            int currentLvl = Prefs.getCurrentLevel();
                            int currentDifficultLvl = Prefs.getDifficultLevel();

                            Prefs.putAchievements( currentDifficultLvl, currentLvl, Prefs.getCurrentSteps() );

                            if ( currentLvl + 1 < LevelsManager.LEVELS_AMOUNT )
                            {
                                currentLvl = currentLvl + 1;
                                Prefs.putCurrentLevel(currentLvl);
                                Prefs.putLevels( currentDifficultLvl, currentLvl, true );
                            } else {
                                if ( currentDifficultLvl + 1 < LevelsManager.DIFFICULT_AMOUNT )
                                {
                                    currentDifficultLvl = currentDifficultLvl + 1;
                                    currentLvl = 0;
                                    Prefs.putCurrentLevel(currentLvl);
                                    Prefs.putDifficultLevel(currentDifficultLvl);
                                    Prefs.putLevels( currentDifficultLvl, currentLvl, true );
                                }
                            }

                            final Handler h1 = new Handler();
                            h1.postDelayed(new Runnable() {
                                               @Override
                                               public void run() {
                                                   // show congratulations
                                                   SoundEffectsManager sem = SoundEffectsManager.getInstance();
                                                   sem.playSoundCongratulation();

                                                   Intent intent = new Intent(Game.this, Congratulation.class);
                                                   startActivity(intent);
                                               }
                                           }, 1000
                            );
                        }
                    }




                    break;
            }

        }
        return true;
    }


/*
    protected void hackStep(){

        int diffLevl = Prefs.getDifficultLevel();
        int curLevl = Prefs.getCurrentLevel();

        String solution = LevelsManager.getLevelSolution(diffLevl, curLevl);

        int row = solution.charAt(step * 2) - '0';
        int column = solution.charAt(step * 2 + 1) - '0';

        SoundEffectsManager sem = SoundEffectsManager.getInstance();
        sem.playSoundFieldClick();
        sem.playSoundFieldChange();

        doStep(row, column);

        if ( checkWin() )
        {
            // unlock next level if needed
            int currentLvl = Prefs.getCurrentLevel();
            int currentDifficultLvl = Prefs.getDifficultLevel();

            Prefs.putAchievements( currentDifficultLvl, currentLvl, Prefs.getCurrentSteps() );

            if ( currentLvl + 1 < LevelsManager.LEVELS_AMOUNT )
            {
                currentLvl = currentLvl + 1;
                Prefs.putCurrentLevel(currentLvl);
                Prefs.putLevels( currentDifficultLvl, currentLvl, true );
            } else {
                if ( currentDifficultLvl + 1 < LevelsManager.DIFFICULT_AMOUNT )
                {
                    currentDifficultLvl = currentDifficultLvl + 1;
                    currentLvl = 0;
                    Prefs.putCurrentLevel(currentLvl);
                    Prefs.putDifficultLevel(currentDifficultLvl);
                    Prefs.putLevels( currentDifficultLvl, currentLvl, true );
                }
            }

            final Handler h1 = new Handler();
            h1.postDelayed(new Runnable() {
                               @Override
                               public void run() {
                                   // show congratulations
                                   SoundEffectsManager sem = SoundEffectsManager.getInstance();
                                   sem.playSoundCongratulation();

                                   Intent intent = new Intent(Game.this, Congratulation.class);
                                   startActivity(intent);
                               }
                           }, 1000
            );
        }

        if ( step > 0 ) {
            step--;

            final Handler h1 = new Handler();
            h1.postDelayed(new Runnable() {

                               @Override
                               public void run() {
                                   hackStep();
                               }
                           }, 700
            );
        }
    }
*/

}
