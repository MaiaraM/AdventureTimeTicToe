package com.fatec.maiara.tictactoe.activies;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.fatec.maiara.tictactoe.R;

import java.lang.reflect.Array;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String PLAYER_1 = "Finn";
    private static final String PLAYER_2 = "Jake";
    private String turn = PLAYER_1;
    private Button[][] arrayBut;

    private void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arrayBut[j][i].setBackgroundResource(0);
                arrayBut[j][i].setTag("1");
            }
        }
        turn = PLAYER_1;
    }

    private boolean verificaCelula(Button b1, Button b2, Button b3, Object string) {
        System.out.println("Linha:" + b1.getTag() + ";" + b2.getTag() + ";" + b3.getTag());
        return b1.getTag().equals(string) && b2.getTag().equals(b1.getTag()) && b3.getTag().equals(b2.getTag());
    }

    private void win(Button b1, Button b2, Button b3, View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_cell);
        try {
            b1.startAnimation(animation);
            b2.startAnimation(animation);
            b3.startAnimation(animation);
            if (view.getTag().equals("Finn")) {
                view.setBackgroundResource(R.drawable.iconfinn1);
                Thread.sleep(300);
                b1.setBackgroundResource(R.drawable.iconfinn);
                b2.setBackgroundResource(R.drawable.iconfinn);
                b3.setBackgroundResource(R.drawable.iconfinn);
            } else {
                view.setBackgroundResource(R.drawable.iconjake1);
                Thread.sleep(300);
                b1.setBackgroundResource(R.drawable.iconjake);
                b2.setBackgroundResource(R.drawable.iconjake);
                b3.setBackgroundResource(R.drawable.iconjake);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void verificar(View view) {
        try {
            if (verificaCelula(arrayBut[0][0], arrayBut[0][1], arrayBut[0][2], view.getTag())) {
                win(arrayBut[0][0], arrayBut[0][1], arrayBut[0][2], view);
            }
            if (verificaCelula(arrayBut[1][0], arrayBut[1][1], arrayBut[1][2], view.getTag())) {
                win(arrayBut[1][0], arrayBut[1][1], arrayBut[1][2], view);
            }
            if (verificaCelula(arrayBut[2][0], arrayBut[2][1], arrayBut[2][2], view.getTag())) {
                win(arrayBut[2][0], arrayBut[2][1], arrayBut[2][2], view);
            }
            if (verificaCelula(arrayBut[0][0], arrayBut[1][0], arrayBut[2][0], view.getTag())) {
                win(arrayBut[0][0], arrayBut[1][0], arrayBut[2][0], view);
            }
            if (verificaCelula(arrayBut[0][1], arrayBut[1][1], arrayBut[2][1], view.getTag())) {
                win(arrayBut[0][1], arrayBut[1][1], arrayBut[2][1], view);
            }
            if (verificaCelula(arrayBut[0][2], arrayBut[1][2], arrayBut[2][2], view.getTag())) {
                win(arrayBut[0][2], arrayBut[1][2], arrayBut[2][2], view);
            }
            if (verificaCelula(arrayBut[0][0], arrayBut[1][1], arrayBut[2][2], view.getTag())) {
                win(arrayBut[0][0], arrayBut[1][1], arrayBut[2][2], view);
            }
            if (verificaCelula(arrayBut[0][2], arrayBut[1][1], arrayBut[2][0], view.getTag())) {
                win(arrayBut[0][2], arrayBut[1][1], arrayBut[2][0], view);


            } else {
                System.out.println("Fracasso!");
            }
        } catch (Exception e) {
            System.out.println("Erro 2 " + e);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayBut = new Button[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String name = "but" + i + j;
                int resId = getResources().getIdentifier(name, "id", getPackageName());
                arrayBut[j][i] = findViewById(resId);
            }
        }

    }

    public void resetGame(View view) {
        reset();
    }

    public void Jogada(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        String test = (String) view.getTag();
        try {
            if (test.equals("1")) {
                if (turn.equals("Finn")) {
                    view.setAnimation(animation);
                    view.startAnimation(animation);
                    view.setBackgroundResource(R.drawable.iconfinn1);
                    view.setTag("Finn");
                    turn = PLAYER_2;
                } else {
                    view.setAnimation(animation);
                    view.startAnimation(animation);
                    view.setBackgroundResource(R.drawable.iconjake1);
                    view.setTag("Jake");
                    turn = PLAYER_1;
                }
                verificar(view);
            }
        } catch (Exception e) {
            System.out.println(e + "!");
        }


    }
}
