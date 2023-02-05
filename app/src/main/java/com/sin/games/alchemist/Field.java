package com.sin.games.alchemist;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

public class Field {

    private FieldContent content;
    private ImageView imgView;

    private AnimationDrawable animEmtyToGold;
    private AnimationDrawable animGoldToEmpty;
    private AnimationDrawable animEmtyToPlumbum;
    private AnimationDrawable animPlumbumToEmpty;
    private AnimationDrawable animGoldToPlumbum;
    private AnimationDrawable animPlumbumToGold;

    Field( ImageView imgView )
    {
        this.imgView = imgView;

        ImageView imgAnim1 = new ImageView(Alchemist.getContextOfApplication());
        imgAnim1.setBackgroundResource( R.drawable.anim_empty_to_gold );
        animEmtyToGold = (AnimationDrawable)imgAnim1.getBackground();

        ImageView imgAnim2 = new ImageView(Alchemist.getContextOfApplication());
        imgAnim2.setBackgroundResource( R.drawable.anim_gold_to_empty );
        animGoldToEmpty = (AnimationDrawable)imgAnim2.getBackground();

        ImageView imgAnim3 = new ImageView(Alchemist.getContextOfApplication());
        imgAnim3.setBackgroundResource( R.drawable.anim_empty_to_plumbum );
        animEmtyToPlumbum = (AnimationDrawable)imgAnim3.getBackground();

        ImageView imgAnim4 = new ImageView(Alchemist.getContextOfApplication());
        imgAnim4.setBackgroundResource( R.drawable.anim_plumbum_to_empty );
        animPlumbumToEmpty = (AnimationDrawable)imgAnim4.getBackground();

        ImageView imgAnim5 = new ImageView(Alchemist.getContextOfApplication());
        imgAnim5.setBackgroundResource( R.drawable.anim_gold_to_plumbum );
        animGoldToPlumbum = (AnimationDrawable)imgAnim5.getBackground();

        ImageView imgAnim6 = new ImageView(Alchemist.getContextOfApplication());
        imgAnim6.setBackgroundResource( R.drawable.anim_plumbum_to_gold );
        animPlumbumToGold = (AnimationDrawable)imgAnim6.getBackground();

        reset();
    }

    public final void reset(){
        this.content = FieldContent.NONE;
        imgView.setImageResource(R.drawable.field_empty);
    }

    public final void setNone(){
        if ( this.content == FieldContent.GOLD ){
            imgView.setImageDrawable(animGoldToEmpty);
            animGoldToEmpty.start();
        }
        if ( this.content == FieldContent.PLUMBUM ){
            imgView.setImageDrawable(animPlumbumToEmpty);
            animPlumbumToEmpty.start();
        }

        this.content = FieldContent.NONE;
    }

    public final void setGold(){
        if ( this.content == FieldContent.NONE ){
            imgView.setImageDrawable(animEmtyToGold);
            animEmtyToGold.start();
        }
        if ( this.content == FieldContent.PLUMBUM ){
            imgView.setImageDrawable(animPlumbumToGold);
            animPlumbumToGold.start();
        }

        this.content = FieldContent.GOLD;
        //imgView.setImageResource(R.drawable.field_gold);
    }

    public final void setPlumbum(){
        if ( this.content == FieldContent.NONE ){
            imgView.setImageDrawable(animEmtyToPlumbum);
            animEmtyToPlumbum.start();
        }
        if ( this.content == FieldContent.GOLD ){
            imgView.setImageDrawable(animGoldToPlumbum);
            animGoldToPlumbum.start();
        }

        this.content = FieldContent.PLUMBUM;
        //imgView.setImageResource(R.drawable.field_plumbum);
    }

    public enum FieldContent {
        NONE
        , GOLD
        , PLUMBUM
    }

}
