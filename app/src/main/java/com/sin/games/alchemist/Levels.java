package com.sin.games.alchemist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class Levels extends AppCompatActivity implements View.OnTouchListener {

    public static boolean callingFromGame = false;

    private int currentLevel = 0;
    private int currentDifficultLevel = 0;

    private int selectLevel = 0;
    private int selectDifficultLevel = 0;

    private static final int[] idsLvlImageView = {
            R.id.imgLvl_1,
            R.id.imgLvl_2,
            R.id.imgLvl_3,
            R.id.imgLvl_4,
            R.id.imgLvl_5,
            R.id.imgLvl_6,
            R.id.imgLvl_7,
            R.id.imgLvl_8,
            R.id.imgLvl_9,
            R.id.imgLvl_10,
            R.id.imgLvl_11,
            R.id.imgLvl_12,
            R.id.imgLvl_13,
            R.id.imgLvl_14,
            R.id.imgLvl_15,
            R.id.imgLvl_16,
            R.id.imgLvl_17,
            R.id.imgLvl_18,
            R.id.imgLvl_19,
            R.id.imgLvl_20
    };

    private static final int IMAGE_VIEW_ID_NOT_FOUND = -1;

    public final int indexByViewId( int id ){
        int index = IMAGE_VIEW_ID_NOT_FOUND;

        for(int i=0;i<idsLvlImageView.length;i++){
            if ( id == idsLvlImageView[i] ){
                index = i;
                break;
            }
        }

        return index;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);

        // set fullscreen
        this.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView imgDifficultEasy = (ImageView) findViewById( R.id.imgDifficult_easy);
        imgDifficultEasy.setOnTouchListener( this );

        ImageView imgDifficultMedium = (ImageView) findViewById( R.id.imgDifficult_medium);
        imgDifficultMedium.setOnTouchListener( this );

        ImageView imgDifficultHard = (ImageView) findViewById( R.id.imgDifficult_hard);
        imgDifficultHard.setOnTouchListener( this );
    }

    @Override
    public void onBackPressed() {
        if ( callingFromGame ){
            finish();
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        currentLevel = Prefs.getCurrentLevel();
        currentDifficultLevel = Prefs.getDifficultLevel();

        updateDifficultLevel();
    }

    private void updateDifficultLevel(){

        ImageView imgDifficultEasy = (ImageView) findViewById( R.id.imgDifficult_easy);
        if ( imgDifficultEasy != null ){
            if ( currentDifficultLevel == LevelsManager.DIFFICULT_EASY ){
                imgDifficultEasy.setImageResource( R.drawable.difficult_easy_on);
            } else {
                imgDifficultEasy.setImageResource( R.drawable.difficult_easy_off );
            }
        }

        ImageView imgDifficultMedium = (ImageView) findViewById( R.id.imgDifficult_medium);
        if ( imgDifficultMedium != null ){
            if ( currentDifficultLevel == LevelsManager.DIFFICULT_MEDIUM ){
                imgDifficultMedium.setImageResource( R.drawable.difficult_medium_on );
            } else {
                imgDifficultMedium.setImageResource( R.drawable.difficult_medium_off );
            }
        }

        ImageView imgDifficultHard = (ImageView) findViewById( R.id.imgDifficult_hard);
        if ( imgDifficultHard != null ){
            if ( currentDifficultLevel == LevelsManager.DIFFICULT_HARD ){
                imgDifficultHard.setImageResource( R.drawable.difficult_hard_on );
            } else {
                imgDifficultHard.setImageResource( R.drawable.difficult_hard_off );
            }
        }

        updatetLevels();
    }

    private void updatetLevels(){
        for(int i=0; i<idsLvlImageView.length; i++){
            ImageView imglevel = (ImageView) findViewById( idsLvlImageView[i] );
            if ( imglevel != null ){
                if ( Prefs.getLevel( currentDifficultLevel, i) ){
                    imglevel.setOnTouchListener( this );
                    imglevel.setImageResource( R.drawable.symbol_gold );
                } else {
                    imglevel.setOnTouchListener( null );
                    imglevel.setImageResource( R.drawable.symbol_plumbum );
                }
            }

        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent event){
        if ( event.getAction() == MotionEvent.ACTION_UP ){
            SoundEffectsManager sem = SoundEffectsManager.getInstance();

            switch ( view.getId() ){
                case R.id.imgDifficult_easy:

                    sem.playSoundBtnClick();

                    currentDifficultLevel = LevelsManager.DIFFICULT_EASY;
                    updateDifficultLevel();
                    break;
                case R.id.imgDifficult_medium:

                    sem.playSoundBtnClick();

                    currentDifficultLevel = LevelsManager.DIFFICULT_MEDIUM;
                    updateDifficultLevel();
                    break;
                case R.id.imgDifficult_hard:

                    sem.playSoundBtnClick();

                    currentDifficultLevel = LevelsManager.DIFFICULT_HARD;
                    updateDifficultLevel();
                    break;
            }

            int imgViewLevel = indexByViewId( view.getId() );
            if ( imgViewLevel != IMAGE_VIEW_ID_NOT_FOUND ){
                if ( currentDifficultLevel == Prefs.getDifficultLevel() && currentLevel == imgViewLevel )
                {
                    // nothing to do
                } else {
                    currentLevel = imgViewLevel;

                    Prefs.putDifficultLevel(currentDifficultLevel);
                    Prefs.putCurrentLevel(currentLevel);
                    Prefs.putGameStarted( false );
                    Prefs.putCurrentSteps( 0 );
                }

                sem.playSoundBtnClick();

                if ( !callingFromGame ){
                    Intent intent = new Intent(this, Game.class);
                    startActivity(intent);
                }

                finish();
                return true;
            }

        }

        return true;
    }

}
