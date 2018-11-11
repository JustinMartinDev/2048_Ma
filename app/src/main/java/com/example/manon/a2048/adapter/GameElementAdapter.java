package com.example.manon.a2048.adapter;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.manon.a2048.holder.GameElement;

public class GameElementAdapter extends BaseAdapter{

    private final Context context;
    private int nbReal=0;
    private float pourcent = 2f/16f;

    public GameElementAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT
        );

        GameElement gameElement = new GameElement(context);
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLACK);
        textView.setLayoutParams(lp);

        if(position == 15 && nbReal == 0 ){
            gameElement.setNb(15);
        }
        if(position == 16 && nbReal == 0 ){
            gameElement.setNb(16);
        }
         //condition pos = 15 et nb = 0 alors 15 = element
        //condition pos = 16 et nb = 1 alors 16 = element

        int valueRandom = 0;//Random (0, 100)
        if((valueRandom < pourcent && nbReal < 2) ||
                position==15 && nbReal == 0 ||
                position==16 && nbReal == 1){
            gameElement.setNb(2);
            gameElement.refreshColor();
            textView.setText(String.valueOf(gameElement.getNb()));
        }
        else {
            gameElement.setNb(0);
            gameElement.refreshColor();
        }

        textView.setBackground(gameElement.getBackground());
        return textView;
    }
}
