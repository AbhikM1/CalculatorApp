package com.example.calcapp;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button bSeven, bEight, bNine, bDiv, bFour,bFive, bSix, bMultiply, bOne, bTwo, bThree, bPlus, bZero
            ,bDot, bEquals, bMinus;
    TextView inputText, resultText;
    String input="";
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initializing Buttons
        bSeven = findViewById(R.id.button9);
        bEight = findViewById(R.id.button10);
        bNine = findViewById(R.id.button11);
        bDiv = findViewById(R.id.button12);
        bFour = findViewById(R.id.button13);
        bFive = findViewById(R.id.button14);
        bSix = findViewById(R.id.button15);
        bMultiply = findViewById(R.id.button16);
        bOne = findViewById(R.id.button17);
        bTwo = findViewById(R.id.button18);
        bThree = findViewById(R.id.button19);
        bPlus = findViewById(R.id.button20);
        bZero = findViewById(R.id.button21);
        bDot = findViewById(R.id.button22);
        bEquals = findViewById(R.id.button23);
        bMinus = findViewById(R.id.button24);
        //Initializing TextViews
        inputText = findViewById(R.id.textView2);
        inputText.setText("Please Enter");
        resultText = findViewById(R.id.textView4);

        //Initializing onClickListeners
        bSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += "7";
                inputText.setText(input);
            }
        });
        bEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += "8";
                inputText.setText(input);
            }
        });
        bNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += "9";
                inputText.setText(input);
            }
        });

        bDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += " / ";
                inputText.setText(input);
            }
        });
        bFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += "4";
                inputText.setText(input);
            }
        });
        bFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += "5";
                inputText.setText(input);
            }
        });
        bSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += "6";
                inputText.setText(input);
            }
        });
        bMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += " * ";
                inputText.setText(input);
            }
        });
        bOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += "1";
                inputText.setText(input);
            }
        });
        bTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += "2";
                inputText.setText(input);
            }
        });
        bThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += "3";
                inputText.setText(input);
            }
        });
        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += " + ";
                inputText.setText(input);
            }
        });
        bZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += "0";
                inputText.setText(input);
            }
        });
        bDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += ".";
                inputText.setText(input);
            }
        });
        bEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Expression expression = new Expression(input);
                String result = String.valueOf(expression.calculate());
                resultText.setText(result);

            }
        });
        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += " - ";
                inputText.setText(input);
            }
        });

    }
}