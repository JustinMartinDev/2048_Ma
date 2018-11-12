package com.example.manon.a2048.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.manon.a2048.R;
import com.example.manon.a2048.adapter.GameElementAdapter;
import com.example.manon.a2048.holder.GameElement;

import java.util.Random;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    Display ecran;
    int largeur ,longeur ;

    ListView lvCountry;

    GestureDetector gestureDector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        GestureDetector gestureDector = new GestureDetector(this, this);
        gestureDector.setOnDoubleTapListener(this);
        ecran = getWindowManager().getDefaultDisplay();
        largeur = ecran.getWidth();
        longeur = ecran.getHeight();
        setContentView(R.layout.activity_main);

        GameGridView gameGridView = (GameGridView) findViewById(R.id.gameGridView);

        //adapter = new GameElementAdapter(getApplicationContext());
        GameElement.initHeightElement(largeur, this);
        GameElementAdapter gameElementAdapter = new GameElementAdapter(this);
        gameGridView.setAdapter(gameElementAdapter);
        Log.e("zere", gameGridView.getCount()+"");




        /*
          todo   ecartSDDG = destination.x - source.x
                 if(ecartSDDG > 0)
                    DtoG = true;
                else
                    GtoD = true;

                 ecartSDBH = destination.y - source.y
                 if(ecartSD > 0)
                    BtoH = true;
                else
                    HtoB = true;

                 if(abs(ecartSDBH) > abs(ecartSDDG))
                    if BtoH alors Bas en Haut
                    else if HtoB alors Haut en Baas
                 else
                    if DtoG ....
                    ...


          */

    }

    public void fusion(int indiceStart1, int indiceStop1, int increment1, int indiceStart2, int indiceStop2, int increment2, int voisinIncrement) {
        /*for (int i = indiceStart1; i <= indiceStop1; i += increment1) {
            for (int y = indiceStart2; y <= indiceStop2; y += increment2) {
                if (((GameElement) adapter.getItem(i + y)).fusionAvailable(((GameElement) adapter.getItem(i + y + voisinIncrement)))) {
                    ((GameElement) adapter.getItem(i + y)).fusion(((GameElement) adapter.getItem(i + y + voisinIncrement)));
                }
            }
        }
        adapter.notifyDataSetChanged();
        */
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float downXValue =0f, downYValue = 0f;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                // store the X value when the user's finger was pressed down
                downXValue = event.getX();
                downYValue = event.getY();
                Log.v("", "= " + downYValue);
                break;
            }

            case MotionEvent.ACTION_UP: {
                // Get the X value when the user released his/her finger
                float currentX = event.getX();
                float currentY = event.getY();
                // check if horizontal or vertical movement was bigger

                if (Math.abs(downXValue - currentX) > Math.abs(downYValue - currentY)) {
                    Log.v("", "x");
                    // going backwards: pushing stuff to the right
                    if (downXValue < currentX) {
                        Log.v("", "right");
                       // fusion(16, 4, -4, 4, 0, -1, -1);
                    }

                    // going forwards: pushing stuff to the left
                    if (downXValue > currentX) {
                        Log.v("", "left");

                    }

                } else {
                    Log.v("", "y ");
                }
            }
        }
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}