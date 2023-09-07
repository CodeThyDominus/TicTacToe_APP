package com.deucalion.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int flag=0;
    int count=0;

    AppCompatButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    AppCompatButton nGame;

    String b1,b2,b3,b4,b5,b6,b7,b8,b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findId();

    }

    public void findId(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        nGame = findViewById(R.id.nGame);

    }

    public void newGame(){

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        btn1.setBackgroundColor(getResources().getColor(R.color.defaultButtonColor));
        btn2.setBackgroundColor(getResources().getColor(R.color.defaultButtonColor));
        btn3.setBackgroundColor(getResources().getColor(R.color.defaultButtonColor));
        btn4.setBackgroundColor(getResources().getColor(R.color.defaultButtonColor));
        btn5.setBackgroundColor(getResources().getColor(R.color.defaultButtonColor));
        btn6.setBackgroundColor(getResources().getColor(R.color.defaultButtonColor));
        btn7.setBackgroundColor(getResources().getColor(R.color.defaultButtonColor));
        btn8.setBackgroundColor(getResources().getColor(R.color.defaultButtonColor));
        btn9.setBackgroundColor(getResources().getColor(R.color.defaultButtonColor));

        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);


        flag=0;
        count=0;

    }

    public void delay(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                newGame();
            }
        }, 2000);
    }

    private void disableButton() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }

    private void applyStrikeAnimation(AppCompatButton... buttons) {
        for (AppCompatButton button : buttons) {
            button.startAnimation(AnimationUtils.loadAnimation(this, R.anim.strike_animation));
        }
    }

    public void check(View view){

        AppCompatButton btnCurrent = (AppCompatButton) view;

        if(btnCurrent.getText().toString().equals("")) {
            count++;

            if (flag == 0) {
                btnCurrent.setText("X");
                btnCurrent.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.btn_x));
                flag = 1;
            } else {
                btnCurrent.setText("O");
                btnCurrent.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.btn_o));
                flag = 0;
            }

            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    Toast.makeText(this, "Winner is : " + b1, Toast.LENGTH_SHORT).show();
                    applyStrikeAnimation(btn1,btn2,btn3);
                    disableButton();
                    delay();
                } else if (b4.equals(b5) && b5.equals(b6) && !b6.equals("")) {
                    Toast.makeText(this, "Winner is : " + b5, Toast.LENGTH_SHORT).show();
                    applyStrikeAnimation(btn4,btn5,btn6);
                    disableButton();
                    delay();
                } else if (b7.equals(b8) && b8.equals(b9) && !b9.equals("")) {
                    Toast.makeText(this, "Winner is : " + b7, Toast.LENGTH_LONG).show();
                    applyStrikeAnimation(btn7,btn8,btn9);
                    disableButton();
                    delay();
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    Toast.makeText(this, "Winner is : " + b1, Toast.LENGTH_LONG).show();
                    applyStrikeAnimation(btn1,btn4,btn7);
                    disableButton();
                    delay();
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    Toast.makeText(this, "Winner is : " + b2, Toast.LENGTH_LONG).show();
                    applyStrikeAnimation(btn2,btn5,btn8);
                    disableButton();
                    delay();
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    Toast.makeText(this, "Winner is : " + b3, Toast.LENGTH_LONG).show();
                    applyStrikeAnimation(btn3,btn6,btn9);
                    disableButton();
                    delay();
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    Toast.makeText(this, "Winner is : " + b1, Toast.LENGTH_LONG).show();
                    applyStrikeAnimation(btn1,btn5,btn9);
                    disableButton();
                    delay();
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    Toast.makeText(this, "Winner is : " + b3, Toast.LENGTH_LONG).show();
                    applyStrikeAnimation(btn3,btn5,btn7);
                    disableButton();
                    delay();
                } else if (count==9){
                    Toast.makeText(this, "Draw, No Winner", Toast.LENGTH_LONG).show();
                    delay();
                }

            }
        }

        nGame.setOnClickListener(v->newGame());

    }


}