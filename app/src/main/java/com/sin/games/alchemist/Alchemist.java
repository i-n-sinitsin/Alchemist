package com.sin.games.alchemist;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

//AdMob
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class Alchemist extends AppCompatActivity implements View.OnTouchListener {

    private static Context contextOfApplication;

    public static Context getContextOfApplication(){
        return contextOfApplication;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // remember application context
        contextOfApplication = getApplicationContext();

        // return right theme
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        // set fullscreen
        this.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // set no title
        //this.requestWindowFeature( Window.FEATURE_NO_TITLE );

        ImageView imgBtnPlay = (ImageView) findViewById(R.id.imgBtnPlay);
        imgBtnPlay.setOnTouchListener(this);

        ImageView imgBtnLevels = (ImageView) findViewById(R.id.imgBtnLevels);
        imgBtnLevels.setOnTouchListener(this);

        ImageView imgBtnSettings = (ImageView) findViewById(R.id.imgBtnSettings);
        imgBtnSettings.setOnTouchListener(this);

        ImageView imgBtnHelp = (ImageView) findViewById(R.id.imgBtnHelp);
        imgBtnHelp.setOnTouchListener(this);

        ImageView imgBtnAbout = (ImageView) findViewById(R.id.imgBtnAbout);
        imgBtnAbout.setOnTouchListener(this);

        SoundEffectsManager sem = SoundEffectsManager.getInstance();
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        // return right state of buttons
        ImageView imgBtnPlay = (ImageView) findViewById(R.id.imgBtnPlay);
        imgBtnPlay.setImageResource(R.drawable.menu_btn_play_up);

        ImageView imgBtnLevels = (ImageView) findViewById(R.id.imgBtnLevels);
        imgBtnLevels.setImageResource(R.drawable.menu_btn_levels_up);

        ImageView imgBtnSettings = (ImageView) findViewById(R.id.imgBtnSettings);
        imgBtnSettings.setImageResource(R.drawable.menu_btn_settings_up);

        ImageView imgBtnHelp = (ImageView) findViewById(R.id.imgBtnHelp);
        imgBtnHelp.setImageResource(R.drawable.menu_btn_help_up);

        ImageView imgBtnAbout = (ImageView) findViewById(R.id.imgBtnAbout);
        imgBtnAbout.setImageResource(R.drawable.menu_btn_about_up);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setTitle("Message")
                .setMessage("Do you want to exit game?")
                .setNegativeButton("NO", null)
                .setPositiveButton("YES", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        Alchemist.super.onBackPressed();
                    }
                }).create().show();

    }

    public boolean onTouch( View view, MotionEvent motion){
        switch( view.getId() ){
            case R.id.imgBtnPlay:
                if ( motion.getAction() == MotionEvent.ACTION_UP )
                {
                    ImageView imgBtn = (ImageView) findViewById(R.id.imgBtnPlay);
                    imgBtn.setImageResource(R.drawable.menu_btn_play_down);

                    SoundEffectsManager sem = SoundEffectsManager.getInstance();
                    sem.playSoundBtnClick();

                    Intent intent = new Intent(this, Game.class);
                    startActivity(intent);
                }
                break;
            case R.id.imgBtnLevels:
                if ( motion.getAction() == MotionEvent.ACTION_UP )
                {
                    ImageView imgBtn = (ImageView) findViewById(R.id.imgBtnLevels);
                    imgBtn.setImageResource(R.drawable.menu_btn_levels_down);

                    SoundEffectsManager sem = SoundEffectsManager.getInstance();
                    sem.playSoundBtnClick();

                    Levels.callingFromGame = false;
                    Intent intent = new Intent(this, Levels.class);
                    startActivity(intent);
                }
                break;
            case R.id.imgBtnSettings:
                if ( motion.getAction() == MotionEvent.ACTION_UP )
                {
                    ImageView imgBtn = (ImageView) findViewById(R.id.imgBtnSettings);
                    imgBtn.setImageResource(R.drawable.menu_btn_settings_down);

                    SoundEffectsManager sem = SoundEffectsManager.getInstance();
                    sem.playSoundBtnClick();

                    Intent intent = new Intent(this, Settings.class);
                    startActivity(intent);
                }
                break;
            case R.id.imgBtnHelp:
                if ( motion.getAction() == MotionEvent.ACTION_UP )
                {
                    ImageView imgBtn = (ImageView) findViewById(R.id.imgBtnHelp);
                    imgBtn.setImageResource(R.drawable.menu_btn_help_down);

                    SoundEffectsManager sem = SoundEffectsManager.getInstance();
                    sem.playSoundBtnClick();

                    Intent intent = new Intent(this, Help.class);
                    startActivity(intent);
                }
                break;
            case R.id.imgBtnAbout:
                if ( motion.getAction() == MotionEvent.ACTION_UP )
                {
                    ImageView imgBtn = (ImageView) findViewById(R.id.imgBtnAbout);
                    imgBtn.setImageResource(R.drawable.menu_btn_about_down);

                    SoundEffectsManager sem = SoundEffectsManager.getInstance();
                    sem.playSoundBtnClick();

                    Intent intent = new Intent(Alchemist.this, About.class);
                    startActivity(intent);
                }
                break;
        }
        return true;
    }
}
