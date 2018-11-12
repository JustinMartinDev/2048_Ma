package com.example.manon.a2048.adapter;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.util.Log;
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
    private int count=0;

    public GameElementAdapter(Context context){
        this.context = context;//v
    }

    @Override
    public int getCount() {
        return 15;
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
        GameElement gameElement = new GameElement(context);
        count++;
        Log.e("zer", count+"");
        if(position == 15 && nbReal == 0 ) {
            gameElement.setNb(2);
            nbReal++;
            return gameElement.getView();
        }

        if(position == 16 && nbReal == 1 ) {
            gameElement.setNb(2);
            nbReal++;
            return  gameElement.getView();
        }

        int valueRandom = 0;//Random (0, 100)
        if((valueRandom < pourcent) && (nbReal < 2)) {
            Log.e("nbReal", nbReal+"");
            gameElement.setNb(2);
            nbReal++;
        } else {
            gameElement.setNb(0);
        }

        return gameElement.getView();
    }
}
