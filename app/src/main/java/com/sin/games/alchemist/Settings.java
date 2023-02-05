package com.sin.games.alchemist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Settings extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private boolean playSounds = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        // set fullscreen
        this.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Switch switchMusic = (Switch) findViewById( R.id.switch_music );
        if ( switchMusic != null ) {
            switchMusic.setOnCheckedChangeListener(this);
        }

        Switch switchSound = (Switch) findViewById( R.id.switch_sound );
        if ( switchSound != null ) {
            switchSound.setOnCheckedChangeListener( this );
        }

        playSounds = false;
        updateSwitchStates();
        playSounds = true;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    public void onCheckedChanged( CompoundButton btnView, boolean isChecked ){
        SoundEffectsManager sem = SoundEffectsManager.getInstance();
        switch ( btnView.getId() )
        {
            case R.id.switch_music:
                if (playSounds){
                    sem.playSoundSwitchClick();
                }
                Prefs.putMusic( isChecked );
                break;
            case R.id.switch_sound:
                if (playSounds){
                    sem.playSoundSwitchClick();
                }
                Prefs.putSound( isChecked );
                break;
        }
    }

    private void updateSwitchStates()
    {
        Switch switchMusic = (Switch) findViewById( R.id.switch_music );
        if ( switchMusic != null ){
            switchMusic.setChecked( Prefs.getMusic() );
        }

        Switch switchSound = (Switch) findViewById( R.id.switch_sound );
        if ( switchSound != null ){
            switchSound.setChecked( Prefs.getSound() );
        }
    }

}
