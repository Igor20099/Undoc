package com.joymaker.unity.questions;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.joymaker.unity.R;
import com.joymaker.unity.questions.Questions;

import java.util.ArrayList;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TestFragment extends Fragment {
    TextView questionTextView,correctAnswerTextView;
    Button answer1,answer2,answer3,answer4,nextQuestion;
    private Questions questions = new Questions();
    private String answer,fullCorrectAnswer;
    private int questionLenght = questions.questions.length;
    Random r;
    private int countAnswer = 0;
    private ArrayList<Integer> numList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_test, container, false);
        r = new Random();

        questionTextView = v.findViewById(R.id.questionTextView);
        correctAnswerTextView = v.findViewById(R.id.correctAnswerTextView);
        answer1 = v.findViewById(R.id.choiceButton);
        answer2 = v.findViewById(R.id.choiceButton2);
        answer3 = v.findViewById(R.id.choiceButton3);
        answer4 = v.findViewById(R.id.choiceButton4);
        nextQuestion = v.findViewById(R.id.nextQuestion);
        updateQuestion(0);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer2.setEnabled(false);
                answer3.setEnabled(false);
                answer4.setEnabled(false);
                nextQuestion.setVisibility(View.VISIBLE);
                correctAnswerTextView.setVisibility(View.VISIBLE);
                    if(answer1.getText().toString().equals(answer)) {
                        answer1.setBackgroundColor(Color.GREEN);
                        correctAnswerTextView.setTextColor(getResources().getColor(R.color.colorDarkGreen));
                        correctAnswerTextView.setText("Верно. " + fullCorrectAnswer);
                    }

                else {
                    answer1.setBackgroundColor(Color.RED);
                    correctAnswerTextView.setTextColor(Color.RED);
                    correctAnswerTextView.setText("Неверно. " + fullCorrectAnswer);
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer1.setEnabled(false);
                answer3.setEnabled(false);
                answer4.setEnabled(false);
                nextQuestion.setVisibility(View.VISIBLE);
                correctAnswerTextView.setVisibility(View.VISIBLE);
                if(answer2.getText().toString().equals(answer)) {
                    answer2.setBackgroundColor(Color.GREEN);
                    correctAnswerTextView.setTextColor(getResources().getColor(R.color.colorDarkGreen));
                    correctAnswerTextView.setText("Верно. " + fullCorrectAnswer);
                }
                else {
                    answer2.setBackgroundColor(Color.RED);
                    correctAnswerTextView.setTextColor(Color.RED);
                    correctAnswerTextView.setText("Неверно. " + fullCorrectAnswer);
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer2.setEnabled(false);
                answer1.setEnabled(false);
                answer4.setEnabled(false);
                nextQuestion.setVisibility(View.VISIBLE);
                correctAnswerTextView.setVisibility(View.VISIBLE);
                if(answer3.getText().toString().equals(answer)) {
                    answer3.setBackgroundColor(Color.GREEN);
                    correctAnswerTextView.setTextColor(getResources().getColor(R.color.colorDarkGreen));
                    correctAnswerTextView.setText("Верно. " + fullCorrectAnswer);
                }
                else {
                    answer3.setBackgroundColor(Color.RED);
                    correctAnswerTextView.setTextColor(Color.RED);
                    correctAnswerTextView.setText("Неверно. " + fullCorrectAnswer);
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer2.setEnabled(false);
                answer1.setEnabled(false);
                answer3.setEnabled(false);
                nextQuestion.setVisibility(View.VISIBLE);
                correctAnswerTextView.setVisibility(View.VISIBLE);
                if(answer4.getText().toString().equals(answer)) {
                    answer4.setBackgroundColor(Color.GREEN);
                    correctAnswerTextView.setTextColor(getResources().getColor(R.color.colorDarkGreen));
                    correctAnswerTextView.setText("Верно. " + fullCorrectAnswer);
                }
                else {
                    answer4.setBackgroundColor(Color.RED);
                    correctAnswerTextView.setTextColor(Color.RED);
                    correctAnswerTextView.setText("Неверно. " + fullCorrectAnswer);
                }
            }
        });

        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countAnswer++;
                if (countAnswer >= questionLenght) {
                    countAnswer = 0;
                }
                updateQuestion(countAnswer);



                //updateQuestion(r.nextInt(questionLenght));
            }
        });
        
        

        return v;
    }

    private void updateQuestion(int nextInt) {
        answer3.setVisibility(View.VISIBLE);
        answer4.setVisibility(View.VISIBLE);
        nextQuestion.setVisibility(View.INVISIBLE);
        correctAnswerTextView.setVisibility(View.INVISIBLE);

        answer1.setBackgroundColor(Color.LTGRAY);
        answer2.setBackgroundColor(Color.LTGRAY);
        answer3.setBackgroundColor(Color.LTGRAY);
        answer4.setBackgroundColor(Color.LTGRAY);

        answer1.setEnabled(true);
        answer2.setEnabled(true);
        answer3.setEnabled(true);
        answer4.setEnabled(true);



        questionTextView.setText(questions.getQuestion(nextInt));
        answer1.setText(questions.getChoice1(nextInt));
        answer2.setText(questions.getChoice2(nextInt));
        answer3.setText(questions.getChoice3(nextInt));
        answer4.setText(questions.getChoice4(nextInt));

        answer = questions.getCorrectAnswer(nextInt);
        fullCorrectAnswer = questions.getFullCorrectAnswer(nextInt);

        if(answer3.getText() == "") {
            answer3.setVisibility(View.INVISIBLE);
        }
        if(answer4.getText() == "") {
            answer4.setVisibility(View.INVISIBLE);
        }
    }
}
