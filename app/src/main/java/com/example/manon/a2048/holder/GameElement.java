package com.example.manon.a2048.holder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.manon.a2048.R;

public class GameElement {

    static LayoutInflater layoutInflater;
    static float height;
    int nb;
    ColorDrawable background;

    Context context;

    public GameElement(Context context){
        background = new ColorDrawable(context.getResources().getColor(R.color.color2card));
        this.context = context;
        layoutInflater = (
                LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static void initHeightElement(int width, Context context){
        height = (width/4) - (2*convertDipToPixels(5, context));
    }

    private static int convertDipToPixels(float dips, Context context) {
        return (int) (dips * context.getResources().getDisplayMetrics().density + 0.5f);
    }

    public int getNb() {
        return nb;
    }

    public ColorDrawable getBackground() {
        return background;
    }

    @SuppressLint("ResourceAsColor")
    private void refreshColor(){
        if(nb==0) background.setColor(Color.GRAY);
        else {
            String nomColor = "color" + nb + "card";
            background.setColor(getColorByName(nomColor));
        }
        Log.e("lel", this.nb+"");
    }

    private int getColorByName(String aString) {
        String packageName = context.getPackageName();
        int resId = context.getResources().getIdentifier(aString, "color", packageName);
        return context.getColor(resId);
    }

    public void refreshGridPane(){
        /* Todo  */

    }

    public void setNb(int nb) {
        this.nb = nb;
        refreshColor();
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

    public View getView(){
        View gameElementView = layoutInflater.inflate(R.layout.game_element_holder, null, false);
        TextView gameElementText = gameElementView.findViewById(R.id.gameElementText);

        gameElementText.setText(String.valueOf(this.getNb()));
        gameElementText.setBackground(getBackground());
        gameElementText.setHeight((int)height);
        return gameElementText;
    }
}
