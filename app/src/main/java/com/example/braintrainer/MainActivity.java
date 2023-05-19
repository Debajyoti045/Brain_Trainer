package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button playButton;
    TextView countTextView;
    int howManyCorrect=0;
    int getHowManyQuestion=0;
    TextView appreciate;
    int location;
    Button gobutton;
    TextView questionText;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    Button but1;
    Button but2;
    Button but3;
    Button but4;
    TextView timer;
    public void start(View view){
       gobutton.setVisibility(View.INVISIBLE);
       timer.setVisibility(View.VISIBLE);
       countTextView.setVisibility(View.VISIBLE);
        randomnogenerator();
        questionText.setVisibility(View.VISIBLE);
        but1.setVisibility(View.VISIBLE);
        but2.setVisibility(View.VISIBLE);
        but3.setVisibility(View.VISIBLE);
        but4.setVisibility(View.VISIBLE);
        Timer();
    }
    public void chooseAnswer(View view){
        getHowManyQuestion++;
        String tag = view.getTag().toString();
        if(location==Integer.parseInt(tag)){
            howManyCorrect++;
            appreciate.setText("CORRECT!!");
        }
        else{
            appreciate.setText("WRONG!!");
        }
        appreciate.setVisibility(View.VISIBLE);
        answers.clear();
        randomnogenerator();
    }
    public void Timer(){
        new CountDownTimer(30000 + 100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(Integer.toString((int) (millisUntilFinished/1000)));
            }

            @Override
            public void onFinish() {
                playButton.setVisibility(View.VISIBLE);
                appreciate.setText("DONE!");
                but1.setEnabled(false);
                but2.setEnabled(false);
                but3.setEnabled(false);
                but4.setEnabled(false);
            }
        }.start();
    }
    public void again(View view){
        but1.setEnabled(true);
        but2.setEnabled(true);
        but3.setEnabled(true);
        but4.setEnabled(true);
        howManyCorrect=0;
        getHowManyQuestion = 0;
        countTextView.setText(getHowManyQuestion + "/" + howManyCorrect);
        timer.setText("30s");
        answers.clear();
        playButton.setVisibility(View.INVISIBLE);
        randomnogenerator();
        Timer();
    }
    public void randomnogenerator(){
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        questionText.setText(a + "+" + b);
        location = rand.nextInt(4);
        for(int i=0;i<4;i++){
            if(i==location)  answers.add(a+b);
            else{
                int incorrect = rand.nextInt(41);
                while(incorrect==a+b){
                    incorrect = rand.nextInt(41);
                }
                answers.add(incorrect);
            }
        }
        but1.setText(Integer.toString(answers.get(0)));
        but2.setText(Integer.toString(answers.get(1)));
        but3.setText(Integer.toString(answers.get(2)));
        but4.setText(Integer.toString(answers.get(3)));
        countTextView.setText(howManyCorrect + "/" + getHowManyQuestion);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gobutton = findViewById(R.id.goButton);
        questionText =  findViewById(R.id.questionTextView);
        but1 = findViewById(R.id.button2);
        but2 = findViewById(R.id.button3);
        but3 = findViewById(R.id.button4);
        but4 = findViewById(R.id.button5);
        appreciate = findViewById(R.id.doneTextView);
        countTextView = findViewById(R.id.countingTextView);
        playButton = findViewById(R.id.playAgainButton);
        timer = findViewById(R.id.timerTextView);
    }
}