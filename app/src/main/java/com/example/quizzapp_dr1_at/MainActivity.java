package com.example.quizzapp_dr1_at;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

        private TextView optionA,optionB,optionC,optionD;
        private TextView questionnumber,question,score;
        private TextView chechkout1,checkout2;
        int currentIndex;
        int mscore=0;
        int qn=1;
        ProgressBar progressBar;

        int CurrentQuestion,CurrentOptionA,CurrentOptionB,CurrentOptionC,CurrentOptionD;

        private Button button;

        private answerclass[] questionBank= new answerclass[]
                {
                        new answerclass(R.string.question_1,R.string.question1_A,R.string.question1_B,R.string.question1_C,R.string.question1_D,R.string.answer_1),
                        new answerclass(R.string.question_2,R.string.question_2A,R.string.question_2B,R.string.question_2C,R.string.question_2D,R.string.answer_2),
                        new answerclass(R.string.question_3,R.string.question_3A,R.string.question_3B,R.string.question_3C,R.string.question_3D,R.string.answer_3),






                };

        final int PROGRESS_BAR = (int) Math.ceil(100/questionBank.length);

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            button = (Button) findViewById(R.id.btnInfo);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                            startActivity(intent);
                        }
                    });



            optionA=findViewById(R.id.optionA);
            optionB=findViewById(R.id.optionB);
            optionC=findViewById(R.id.optionC);
            optionD=findViewById(R.id.optionD);

            question = findViewById(R.id.question);
            score=findViewById(R.id.score);
            questionnumber=findViewById(R.id.QuestionNumber);

            chechkout1=findViewById(R.id.selctedoption);
            checkout2=findViewById(R.id.CorrectAnswer);
            progressBar=findViewById(R.id.progress_bar);

            CurrentQuestion=questionBank[currentIndex].getQuestionid();
            question.setText(CurrentQuestion);
            CurrentOptionA=questionBank[currentIndex].getOptionA();
            optionA.setText(CurrentOptionA);
            CurrentOptionB=questionBank[currentIndex].getOptionB();
            optionB.setText(CurrentOptionB);
            CurrentOptionC=questionBank[currentIndex].getOptionC();
            optionC.setText(CurrentOptionC);
            CurrentOptionD=questionBank[currentIndex].getOptionD();
            optionD.setText(CurrentOptionD);

            optionA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(CurrentOptionA);
                    updateQuestion();

                }
            });

            optionB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(CurrentOptionB);
                    updateQuestion();


                }
            });
            optionC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(CurrentOptionC);
                    updateQuestion();


                }
            });
            optionD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    checkAnswer(CurrentOptionD);
                    updateQuestion();

                }
            });












        }

        private void checkAnswer(int userSelection) {

            int correctanswer=questionBank[currentIndex].getAnswerid();

            chechkout1.setText(userSelection);
            checkout2.setText(correctanswer);

            String m= chechkout1.getText().toString().trim();
            String n=checkout2.getText().toString().trim();

            if(m.equals(n))
            {
                Toast.makeText(getApplicationContext(),"ACERTOU!",Toast.LENGTH_SHORT).show();
                mscore=mscore+1;
            }
            else
            {
                Toast.makeText(getApplicationContext(),"ERROU!",Toast.LENGTH_SHORT).show();
            }




        }

        @SuppressLint("SetTextI18n")
        private void updateQuestion() {

            currentIndex=(currentIndex+1)%questionBank.length;

            if(currentIndex==0)
            {

                AlertDialog.Builder alert=new AlertDialog.Builder(this);
                alert.setTitle("Game Over");
                alert.setCancelable(false);
                alert.setMessage("Você acertou " + mscore +" pontos!");
                alert.setPositiveButton("Fechar Aplicação", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                alert.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mscore=0;
                        qn=1;
                        progressBar.setProgress(0);
                        score.setText("Placar" + mscore +"/" +questionBank.length);
                        questionnumber.setText(qn + "/" + questionBank.length +" QUESTÃO");
                    }
                });

                alert.show();

            }



            CurrentQuestion=questionBank[currentIndex].getQuestionid();
            question.setText(CurrentQuestion);
            CurrentOptionA=questionBank[currentIndex].getOptionA();
            optionA.setText(CurrentOptionA);
            CurrentOptionB=questionBank[currentIndex].getOptionB();
            optionB.setText(CurrentOptionB);
            CurrentOptionC=questionBank[currentIndex].getOptionC();
            optionC.setText(CurrentOptionC);
            CurrentOptionD=questionBank[currentIndex].getOptionD();
            optionD.setText(CurrentOptionD);

            qn=qn+1;

            if(qn<=questionBank.length)

            {
                questionnumber.setText(qn + "/" + questionBank.length +" QUESTÃO");
            }
            score.setText("ACERTOS " + mscore +"/" +questionBank.length);
            progressBar.incrementProgressBy(PROGRESS_BAR);


        }



}

