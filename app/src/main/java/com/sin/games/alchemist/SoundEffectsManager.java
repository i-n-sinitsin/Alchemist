package com.sin.games.alchemist;

import android.content.Context;
import android.media.MediaPlayer;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

public class SoundEffectsManager {

    // player for bgr music
    private static MediaPlayer mp = null;

    private static final float leftVolumn = 0.8f;
    private static final float rightVolumn =  0.8f;

    private boolean soundPoolLoaded;
    private SoundPool soundPool;

    private static final int MAX_STREAMS=100;

    private int soundIdButtonClick;
    private int soundIdSwitchClick;
    private int soundIdFieldClick;
    private int soundIdFieldChange;
    private int soundIdCongratulation;

    public static void playBackgroundMusic()
    {
        stopBackgroundMusic();

        if ( Prefs.getMusic() )
        {
            Context context = Alchemist.getContextOfApplication();
            mp = MediaPlayer.create( context, R.raw.background );
            mp.setLooping( true );
            mp.setVolume( leftVolumn, rightVolumn );
            mp.start();
        }
    }

    public static void stopBackgroundMusic()
    {
        if ( mp != null )
        {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    private void initSounds() {
        // Android API >= 21
        if ( Build.VERSION.SDK_INT >= 21 ) {
            AudioAttributes audioAttrib = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            SoundPool.Builder builder = new SoundPool.Builder();
            builder.setAudioAttributes(audioAttrib).setMaxStreams(MAX_STREAMS);

            this.soundPool = builder.build();
        } else {
            this.soundPool = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
        }
        // When SoundPool load complete.
        this.soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                soundPoolLoaded = true;
            }
        });

        Context context = Alchemist.getContextOfApplication();

        soundIdButtonClick = this.soundPool.load(context, R.raw.button_click,1);
        soundIdSwitchClick = this.soundPool.load(context, R.raw.switch_click, 1);
        soundIdFieldClick = this.soundPool.load(context, R.raw.field_click, 1);
        soundIdFieldChange = this.soundPool.load(context, R.raw.field_change, 1);
        soundIdCongratulation = this.soundPool.load(context, R.raw.congratulation,1);
    }

    public void playSoundBtnClick()  {
        if(this.soundPoolLoaded && Prefs.getSound() ) {
            int streamId = this.soundPool.play(this.soundIdButtonClick,leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSoundSwitchClick()  {
        if(this.soundPoolLoaded && Prefs.getSound() ) {
            int streamId = this.soundPool.play(this.soundIdSwitchClick,leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSoundFieldClick()  {
        if(this.soundPoolLoaded && Prefs.getSound() ) {
            int streamId = this.soundPool.play(this.soundIdFieldClick,leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSoundFieldChange()  {
        if(this.soundPoolLoaded && Prefs.getSound() ) {
            int streamId = this.soundPool.play(this.soundIdFieldChange,leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }


    public void playSoundCongratulation()  {
        if(this.soundPoolLoaded && Prefs.getSound() ) {
            int streamId = this.soundPool.play(this.soundIdCongratulation,leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    // make Singletone
    private static volatile SoundEffectsManager instance = null;

    private SoundEffectsManager(){
        initSounds();
    }

    public static SoundEffectsManager getInstance(){
        if ( instance == null ){
            synchronized ( SoundEffectsManager.class ){
                if ( instance == null ){
                    instance = new SoundEffectsManager();
                }
            }
        }
        return instance;
    }

}
