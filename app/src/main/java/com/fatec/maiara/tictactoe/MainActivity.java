package com.fatec.maiara.tictactoe;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private final int PLAYER_1 = 1;
    private final int PLAYER_2 = 2;
    private int turn = PLAYER_1;




    private void reset(){
        Button but00 = findViewById(R.id.but00);
        Button but01 = findViewById(R.id.but01);
        Button but02 = findViewById(R.id.but02);
        Button but10 = findViewById(R.id.but10);
        Button but11 = findViewById(R.id.but11);
        Button but12 = findViewById(R.id.but12);
        Button but20 = findViewById(R.id.but20);
        Button but21 = findViewById(R.id.but21);
        Button but22 = findViewById(R.id.but22);

        but01.setBackgroundColor(Color.TRANSPARENT);
        but00.setBackgroundColor(Color.TRANSPARENT);
        but02.setBackgroundResource(0);
        but10.setBackgroundResource(0);
        but11.setBackgroundResource(0);
        but12.setBackgroundResource(0);
        but20.setBackgroundResource(0);
        but21.setBackgroundResource(0);
        but22.setBackgroundResource(0);

        turn = PLAYER_1;
    }

    private void verificar(View view){
        int clicado = view.getId();
        Button but00 = findViewById(R.id.but00);
        Button but01 = findViewById(R.id.but01);
        Button but02 = findViewById(R.id.but02);
        if(clicado == R.id.but00){
            if(turn==1){
                but00.setBackgroundResource(R.drawable.iconjake);
                but01.setBackgroundResource(R.drawable.iconjake);
                but02.setBackgroundResource(R.drawable.iconjake);
            }else{
                but00.setBackgroundResource(R.drawable.iconfinn);
                but01.setBackgroundResource(R.drawable.iconfinn);
                but02.setBackgroundResource(R.drawable.iconfinn);
            }


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void resetGame(View view){reset();}

    public void Jogada(View view){
            if(turn==1){
                view.setBackgroundResource(R.drawable.iconfinn1);
                turn=PLAYER_2;
            }else{
                view.setBackgroundResource(R.drawable.iconjake1);
                turn=PLAYER_1;
            }
             verificar(view);

    }
}
