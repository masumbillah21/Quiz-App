package com.masumbillah.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox quesTwoOpt1;
    CheckBox quesTwoOpt3;
    CheckBox quesTwoOpt4;
    CheckBox quesTwoOpt2;
    CheckBox quesFiveOpt1;
    CheckBox quesFiveOpt2;
    CheckBox quesFiveOpt3;
    CheckBox quesFiveOpt4;
    RadioButton quesOneCorrOpt;
    RadioButton quesThreeCorrOpt;
    RadioButton quesFourCorrOpt;
    EditText quesSixAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Assigned corr answer of questions 1 */
        quesOneCorrOpt = findViewById(R.id.q1_corr_ans);

        /* Assigned corr answer of questions 2 */
        quesTwoOpt1 = findViewById(R.id.q2_opt_1);
        quesTwoOpt2 = findViewById(R.id.q2_opt_2);
        quesTwoOpt3 = findViewById(R.id.q2_opt_3);
        quesTwoOpt4 = findViewById(R.id.q2_opt_4);

        /* Assigned corr answer of questions 3 */
        quesThreeCorrOpt = findViewById(R.id.q3_corr_ans);

        /* Assigned corr answer of questions 4 */
        quesFourCorrOpt = findViewById(R.id.q4_corr_ans);

        /* Assigned corr answer of questions 5 */
        quesFiveOpt1 = findViewById(R.id.q5_opt_1);
        quesFiveOpt2 = findViewById(R.id.q5_opt_2);
        quesFiveOpt3 = findViewById(R.id.q5_opt_3);
        quesFiveOpt4 = findViewById(R.id.q5_opt_4);

        /* Assigned corr answer of questions 6 */
        quesSixAns = findViewById(R.id.ques_6_ans);

    }

    public void quizSubmit(View view){
        int finalResult = checkResult();
        String message;

        if (finalResult == 0){
            message = "Sorry! You have not answered any question";
        }
        else if(finalResult <= 2){
            message = "You got " + finalResult + " " +
                    "score(s) out of 6. Need more improvement";
        }
        else{
            message = "Hi, You got " + finalResult + " " +
                    "score(s) out of 6";
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private int checkResult(){

        int scores = 0;
        if (quesOneCorrOpt.isChecked()){
            scores++;
        }
        if(quesTwoOpt1.isChecked() && quesTwoOpt3.isChecked() && quesTwoOpt4.isChecked() && !quesTwoOpt2.isChecked()){
            scores++;
        }
        if (quesThreeCorrOpt.isChecked()){
            scores++;
        }
        if (quesFourCorrOpt.isChecked()){
            scores++;
        }
        if(quesFiveOpt1.isChecked() && quesFiveOpt3.isChecked() && !quesFiveOpt2.isChecked() && !quesFiveOpt4.isChecked()){
            scores++;
        }
        if(quesSixAns.getText().toString().equalsIgnoreCase(getString(R.string.quesSixAns))){

            scores++;
        }

        return scores;
    }
}