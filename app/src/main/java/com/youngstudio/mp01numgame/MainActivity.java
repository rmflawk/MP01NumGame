package com.youngstudio.mp01numgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3;
    Button btn;
    TextView tvup,tvdown;

    int com100,com10,com1;
    int user100,user10,user1;

    RatingBar r1,r2;

    int strike=0, ball=0;
    String s="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        et1= findViewById(R.id.et1);
        et2= findViewById(R.id.et2);
        et3= findViewById(R.id.et3);
        btn= findViewById(R.id.btn);
        tvup= findViewById(R.id.tvup);
        tvdown= findViewById(R.id.tvdown);
        r1= findViewById(R.id.r1);
        r2= findViewById(R.id.r2);

        Random rnd= new Random();

        while(true) {
            com100= rnd.nextInt(9)+1;
            com10= rnd.nextInt(9)+1;
            com1= rnd.nextInt(9)+1;
            if(com100!=com10 && com100 != com1 && com10 != com1)break;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    Editable ea1 = et1.getText();
                    String s1 = ea1.toString();
                    user100 = Integer.parseInt(s1);

                    Editable ea2 = et2.getText();
                    String s2 = ea2.toString();
                    user10 = Integer.parseInt(s2);


                    Editable ea3 = et3.getText();
                    String s3 = ea3.toString();
                    user1 = Integer.parseInt(s3);

                if(user100==com100) strike++;
                else if(user100==com10 || user100==com1) ball++;

                if(user10==com10) strike++;
                else if(user10==com100 || user10==com1) ball++;

                if(user1==com1) strike++;
                else if(user1==com100 || user1==com10) ball++;

                if(strike==3) {
                    s += strike + "strike" + ball + "ball\n";
                    s += "정답입니다 \n";
                    s += "새로운 숫자를 생성합니다.";
                    tvdown.setText(s);
                    s = "";
                    Random rnd = new Random();
                    while(true) {
                        com100= rnd.nextInt(9)+1;
                        com10= rnd.nextInt(9)+1;
                        com1= rnd.nextInt(9)+1;
                        if(com100!=com10 && com100 != com1 && com10 != com1)break;
                    }
                    throw new Exception();
                    //
                }

                s += strike + "strike" + ball + "ball\n";
                r1.setRating(strike);
                r2.setRating(ball);

                tvdown.setText(s  );

                }catch(Exception e ){}

                ball= 0;
                strike= 0;
                et1.setText("");
                et2.setText("");
                et3.setText("");

            }
        });

    }//ononCreate
}//class
