package com.example.manon.a2048;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    RelativeLayout fenetre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GestureDetector gestureDector = new GestureDetector(this, this);
        gestureDector.setOnDoubleTapListener(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fenetre = findViewById(R.id.fenetre);
        int[][] matrice = new int[4][4];
        for(int i = 0 ; i< 4 ; i++){
            for( int y = 0 ; y< 4 ; y++) matrice[i][y] = 1;
        }
        afficherMatrice();
    }

    public void afficherMatrice(){

        Display ecran = getWindowManager().getDefaultDisplay();
        int largueur = ecran.getWidth();
        int longCarre = largueur/ 5;
        for(int i = 0 ; i< 4 ; i++){
            for( int y = 0 ; y< 4 ; y++){
                ImageView cas = new ImageView(this);

                cas.setX(i * longCarre);
                cas.setY(y * longCarre);

                cas.setBackgroundResource(R.drawable.vide);

                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(longCarre , longCarre);
                cas.setLayoutParams(params);

                fenetre.addView(cas);

            }
        }

    }

    public boolean onTouchEvent(MotionEvent event){
        return super.onTouchEvent(event);
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
