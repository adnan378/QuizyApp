package com.example.quizy;

import static com.example.quizy.MainActivity.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class DashboardActivity extends AppCompatActivity {
    CountDownTimer countDownTimer;
    int timerValue=20;
    ProgressBar progressBar;
    ArrayList<ModelClass> allQuestionList;
    ModelClass modelClass;
    int index=0;
    TextView cardQuestion,cardOptionA,cardOptionB,cardOptionC,cardOptionD;
    CardView cardQ,cardA,cardB,cardC,cardD;
    int correctCount=0;
    int wrongCount=0;
    LinearLayout nextbtn;
    CardView cardView;
   // Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        Hooks();

        allQuestionList=list;
       // Collections.shuffle(allQuestionList);
        modelClass=list.get(index);

        setAllData();
        OptionClickA(cardView);
        OptionClickB(cardView);
        OptionClickC(cardView);
        OptionClickD(cardView);

        nextbtn.setClickable(false);
        countDownTimer=new CountDownTimer(20000,1000){

            @Override
            public void onTick(long l) {
                timerValue=timerValue-1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog=new Dialog(DashboardActivity.this);
            }
        }.start();
        setAllData();


    }

    private void setAllData() {
        cardQuestion.setText(modelClass.getQuestion());
        cardOptionA.setText(modelClass.getoA());
        cardOptionB.setText(modelClass.getoB());
        cardOptionC.setText(modelClass.getoC());
        cardOptionD.setText(modelClass.getoD());



    }

    private void Hooks() {
        progressBar=findViewById(R.id.progressTimer);
        cardQ=findViewById(R.id.cardQ);
        cardA=findViewById(R.id.cardA);
        cardB=findViewById(R.id.cardB);
        cardC=findViewById(R.id.cardC);
        cardD=findViewById(R.id.cardD);

        cardQuestion=findViewById(R.id.cardQuestion);
        cardOptionA=findViewById(R.id.cardOptionA);
        cardOptionB=findViewById(R.id.cardOptionB);
        cardOptionC=findViewById(R.id.cardOptionC);
        cardOptionD=findViewById(R.id.cardOptionD);

        nextbtn=findViewById(R.id.nextBtn);



    }
    
    public void correct(CardView cardView){
        cardView.setBackgroundColor(getResources().getColor(R.color.green,null));
        disableButton();
        //nextbtn.setClickable(false);

        nextbtn.setOnClickListener(new View.OnClickListener() {
               public void onClick(View view) {
                   enableButton();
                   nextbtn.setClickable(false);
                   correctCount++;
                   if (index < 9) {
                       index++;
                       modelClass = list.get(index);
                       setAllData();
                       resetColor();
                   } else {
                       GameWon();
                   }
               }

    });
       // nextbtn.setClickable(true);

    }
    public void wrong(CardView cardView){
        cardView.setBackgroundColor(getResources().getColor(R.color.red,null));
        disableButton();
        //nextbtn.setClickable(false);


        nextbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                enableButton();
                nextbtn.setClickable(false);

                wrongCount++;
                if(index<9){
                    index++;
                    modelClass=list.get(index);
                    resetColor();
                    setAllData();
                }else{
                    GameWon();
                }
                
            }
        });
        //nextbtn.setClickable(true);
    }
    //public void getAnswer(){}
    public void GameWon() {
        Intent intent =new Intent(DashboardActivity.this, WonActivity.class);
        intent.putExtra("correct",correctCount);
        intent.putExtra("wrong",wrongCount);
        startActivity(intent);
    }
    public void enableButton(){
        cardA.setClickable(true);
        cardB.setClickable(true);
        cardC.setClickable(true);
        cardD.setClickable(true);
    }
    public void disableButton(){
        cardA.setClickable(false);
        cardB.setClickable(false);
        cardC.setClickable(false);
        cardD.setClickable(false);
    }
    public void resetColor(){
        cardA.setBackgroundColor(getResources().getColor(R.color.white,null));
        cardB.setBackgroundColor(getResources().getColor(R.color.white,null));
        cardC.setBackgroundColor(getResources().getColor(R.color.white,null));
        cardD.setBackgroundColor(getResources().getColor(R.color.white,null));
    }

    public void OptionClickA(CardView cardView) {
       // nextbtn.setClickable(true);
        cardA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (modelClass.getoA().equals(modelClass.getAns())) {
                    correct(cardA);
                    // cardA.setBackgroundColor(getResources().getColor(R.color.green,null));

                } else {
                    wrong(cardA);

                }
            }
        });
    }
    public void OptionClickB(CardView cardView) {
        //nextbtn.setClickable(true);
        cardB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (modelClass.getoB().equals(modelClass.getAns())) {
                    correct(cardB);
                    // cardA.setBackgroundColor(getResources().getColor(R.color.green,null));

                } else {
                    wrong(cardB);
                    //resetColor();
                }
            }
        });
    }
    public void OptionClickC(CardView cardView) {
        //nextbtn.setClickable(true);
        cardC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (modelClass.getoC().equals(modelClass.getAns())) {
                    //  cardA.setBackgroundColor(getResources().getColor(R.color.green,null));
                    correct(cardC);

                } else {
                    wrong(cardC);
                    //resetColor();
                }
            }
        });
    }
    public void OptionClickD(CardView cardView) {
        //nextbtn.setClickable(true);
        cardD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(modelClass.getoD().equals(modelClass.getAns())){
                    correct(cardD);
                   // cardA.setBackgroundColor(getResources().getColor(R.color.green,null));

                }else{
                    wrong(cardD);
                    //resetColor();
                }
            }
        });

    }


}