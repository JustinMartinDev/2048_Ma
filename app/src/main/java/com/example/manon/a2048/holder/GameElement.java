package com.example.manon.a2048.holder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.example.manon.a2048.R;

public class GameElement {
    int nb;
    int numColor=2;
    ColorDrawable background;
    Context context;

    public GameElement(Context context){
        background = new ColorDrawable(context.getResources().getColor(R.color.color2Card));
        this.context = context;
    }

    public int getNb() {
        return nb;
    }

    public ColorDrawable getBackground() {
        return background;
    }

    @SuppressLint("ResourceAsColor")
    public void refreshColor(){
        if(nb==0) background.setColor(Color.GRAY);
        else {
            numColor = numColor *2;
            String nomColor = "color" + numColor + "card";
            background.setColor(getColorByName(nomColor));
        }
    }

    private int getColorByName(String aString) {
        String packageName = context.getPackageName();
        int resId = context.getResources().getIdentifier(aString, "colors", packageName);
        return context.getColor(resId);
    }

    public void refreshGridPane(){
        /* Todo  */

    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public boolean fusionAvailable(GameElement item) {
        if(nb == 0) return true;
        if(nb == item.nb) return true;
        return false;
    }

    public void fusion(GameElement item) {
       item.setNb(item.getNb() + this.nb);
       item.refreshColor();
       this.nb = 0;
       refreshColor();
    }
}
