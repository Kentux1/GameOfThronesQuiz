package example.android.com.gameofthronesquiz;

import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.button;
import static android.R.attr.duration;
import static android.R.attr.right;
import static android.R.id.edit;

public class MainActivity extends AppCompatActivity {
    int correctAnswers = 0;
    //correct answers variable declaration
    RadioButton starkQ1;
    EditText starkWordsQ2;
    CheckBox robertQ3;
    CheckBox joffreyQ3;
    RadioButton robertQ4;
    RadioButton targaryenQ5;
    CheckBox hodor1Q6;
    CheckBox hodor2Q6;
    CheckBox hodor3Q6;
    CheckBox hodor4Q6;
    RadioButton hearMeRoarQ7;
    CheckBox renlyQ8;
    CheckBox tommenQ8;
    CheckBox joffreyQ8;
    EditText daenerysQ9;
    EditText numberOfDragonsQ10;
    //wrong aswers and groups variable declaration (to use in the method that resets the quiz)
    CheckBox jonSnowQ3;
    CheckBox jaimeQ3;
    RadioGroup groupQ1;
    RadioGroup groupQ4;
    RadioGroup groupQ5;
    RadioGroup groupQ7;
    CheckBox stannisQ8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find view of the correct answer of question #1
        starkQ1 = (RadioButton) findViewById(R.id.stark);
        //Find view of the correct answer of question #2
        starkWordsQ2 = (EditText) findViewById(R.id.winteriscoming);
        //Find views of the correct answers of question #3
        robertQ3 = (CheckBox) findViewById(R.id.checkbox1);
        joffreyQ3 = (CheckBox) findViewById(R.id.checkbox3);
        //Find view of the correct answer of question #4
        robertQ4 = (RadioButton) findViewById(R.id.robert);
        //Find view of the correct answer of question #5
        targaryenQ5 = (RadioButton) findViewById(R.id.targaryen);
        //Find views of the correct answers of question #6
        hodor1Q6 = (CheckBox) findViewById(R.id.hodor1);
        hodor2Q6 = (CheckBox) findViewById(R.id.hodor2);
        hodor3Q6 = (CheckBox) findViewById(R.id.hodor3);
        hodor4Q6 = (CheckBox) findViewById(R.id.hodor4);
        //Find view of the correct answer of question #7
        hearMeRoarQ7 = (RadioButton) findViewById(R.id.hearmeroar);
        //Find views of the correct answers of question #8
        renlyQ8 = (CheckBox) findViewById(R.id.renly);
        tommenQ8 = (CheckBox) findViewById(R.id.tommen);
        joffreyQ8 = (CheckBox) findViewById(R.id.joffrey);
        //Find view of the correct answer of question #9
        daenerysQ9 = (EditText) findViewById(R.id.daenerys);
        //Find view of the correct answer of question #10
        numberOfDragonsQ10 = (EditText) findViewById(R.id.numberofdragons);
        //Find views of the wrong answers and radio groups(for reset purposes)
        jonSnowQ3 = (CheckBox) findViewById(R.id.checkbox2);
        jaimeQ3 = (CheckBox) findViewById(R.id.checkbox4);
        groupQ1 = (RadioGroup) findViewById(R.id.group_q_1);
        groupQ4 = (RadioGroup) findViewById(R.id.group_q_4);
        groupQ5 = (RadioGroup) findViewById(R.id.group_q_5);
        groupQ7 = (RadioGroup) findViewById(R.id.group_q_7);
        stannisQ8 = (CheckBox) findViewById(R.id.stannis);
    }
    public void submitAnswers(View view) {
        //Adds 1 to the correctAnswers if the right option is clicked
        boolean answerQ1 = starkQ1.isChecked();
        if (answerQ1) {
            correctAnswers = correctAnswers +1;
        }
        String answerQ2 = starkWordsQ2.getText().toString().trim();
        String starkWords = getString(R.string.winteriscoming);
        if (answerQ2.equalsIgnoreCase(starkWords)){
            correctAnswers = correctAnswers + 1;
        }
        boolean answer1Q3 = robertQ3.isChecked();
        boolean answer2Q3 = joffreyQ3.isChecked();
        boolean answer3Q3 = jonSnowQ3.isChecked();
        boolean answer4Q3 = jaimeQ3.isChecked();
        if (answer1Q3 && answer2Q3 && !answer3Q3 && !answer4Q3) {
            correctAnswers = correctAnswers + 1;
        }
        boolean answerQ4 = robertQ4.isChecked();
        if (answerQ4) {
            correctAnswers = correctAnswers + 1;
        }
        boolean answerQ5 = targaryenQ5.isChecked();
        if (answerQ5) {
            correctAnswers = correctAnswers + 1;
        }
        boolean answer1Q6 = hodor1Q6.isChecked();
        boolean answer2Q6 = hodor2Q6.isChecked();
        boolean answer3Q6 = hodor3Q6.isChecked();
        boolean answer4Q6 = hodor4Q6.isChecked();
        if (answer1Q6 || answer2Q6 || answer3Q6 || answer4Q6) {
            correctAnswers = correctAnswers + 1;
        }
        boolean answerQ7 = hearMeRoarQ7.isChecked();
        if (answerQ7) {
            correctAnswers = correctAnswers +1;
        }
        boolean answer1Q8 = renlyQ8.isChecked();
        boolean answer2Q8 = joffreyQ8.isChecked();
        boolean answer3Q8 = tommenQ8.isChecked();
        if (answer1Q8 && answer2Q8 && answer3Q8) {
            correctAnswers = correctAnswers + 1;
        }
        String answerQ9 = daenerysQ9.getText().toString().trim();
        String daenerys = getString(R.string.daenerys);
        if (answerQ9.equalsIgnoreCase(daenerys)){
            correctAnswers = correctAnswers + 1;
        }
        String answerQ10 = numberOfDragonsQ10.getText().toString().trim();
        String numberOfDragons = getString(R.string.number_of_dragons);
        if (answerQ10.equalsIgnoreCase(numberOfDragons)){
            correctAnswers = correctAnswers + 1;
        }
        String correctAnswersToast = null;
        if (correctAnswers == 0) {
            correctAnswersToast = correctAnswers + " answers right??? Go to the wall!!!";
        }
        if (correctAnswers > 0 && correctAnswers < 4) {
            correctAnswersToast = "You answered " + correctAnswers + " right, winter is coming for you.";
        }
        if (correctAnswers > 3 && correctAnswers< 7) {
            correctAnswersToast = "You answered " + correctAnswers + " right, you might survive in Westeros...";
        }
        if (correctAnswers > 6 && correctAnswers < 10) {
            correctAnswersToast = "You answered " + correctAnswers + " right. What, are you a maester?";
        }
        if (correctAnswers == 10) {
            correctAnswersToast = "You answered " + correctAnswers + " right. Yup, you're definitely a maester.";
        }
        Toast.makeText(this, correctAnswersToast, Toast.LENGTH_LONG).show();
        correctAnswers = 0;
    }
    public void resetQuiz(View view) {
        groupQ1.clearCheck();
        starkWordsQ2.setText("");
        starkWordsQ2.setHint(R.string.hint1);
        robertQ3.setChecked(false);
        joffreyQ3.setChecked(false);
        jonSnowQ3.setChecked(false);
        jaimeQ3.setChecked(false);
        groupQ4.clearCheck();
        groupQ5.clearCheck();
        hodor1Q6.setChecked(false);
        hodor2Q6.setChecked(false);
        hodor3Q6.setChecked(false);
        hodor4Q6.setChecked(false);
        groupQ7.clearCheck();
        renlyQ8.setChecked(false);
        joffreyQ8.setChecked(false);
        tommenQ8.setChecked(false);
        stannisQ8.setChecked(false);
        daenerysQ9.setText("");
        daenerysQ9.setHint(R.string.hint2);
        numberOfDragonsQ10.setText("");
        numberOfDragonsQ10.setHint(R.string.hint3);
        ScrollView scroll_view = (ScrollView) findViewById(R.id.scrollview);
        scroll_view.fullScroll(ScrollView.FOCUS_UP);
        starkWordsQ2.clearFocus();
        daenerysQ9.clearFocus();
        numberOfDragonsQ10.clearFocus();
    }
}
