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
            ,bDot, bEquals, bMinus, bClear, bSecond;
    TextView inputText, resultText;
    String input="";
    boolean secondFunc = false;
    boolean radianMode = false;
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
        bEquals = findViewById(R.id.button);
        bMinus = findViewById(R.id.button24);
        bClear = findViewById(R.id.button25);
        bSecond = findViewById(R.id.button7);
        //Initializing TextViews
        inputText = findViewById(R.id.textView2);
        inputText.setText("Please Enter");
        resultText = findViewById(R.id.textView4);

        //Initializing onClickListeners
        bSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondFunc = !secondFunc;
                if(secondFunc) {
                    bSeven.setText("SIN");
                    bEight.setText("COS");
                    bNine.setText("TAN");
                    bFour.setText("LN");
                    bFive.setText("PI");
                    bSix.setText("DEG");
                    bOne.setText("^");
                    bTwo.setText("^2");
                    bThree.setText("SQRT");
                }
                else {
                    bSeven.setText("7");
                    bEight.setText("8");
                    bNine.setText("9");
                    bFour.setText("4");
                    bFive.setText("5");
                    bSix.setText("6");
                    bOne.setText("1");
                    bTwo.setText("2");
                    bThree.setText("3");
                }
            }
        });

        bSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secondFunc) {
                    input += "sin(";
                    bSeven.setText("SIN");
                } else {
                    input += "7";
                    bSeven.setText("7");
                }
                evaluate(input);
                inputText.setText(input);
            }
        });
        bEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secondFunc) {
                    input += "cos(";
                    bSeven.setText("COS");
                } else {
                    input += "8";
                    bSeven.setText("8");
                }
                evaluate(input);
                inputText.setText(input);
            }
        });
        bNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secondFunc) {
                    input += "tan(";
                    bSeven.setText("TAN");
                } else {
                    input += "9";
                    bSeven.setText("9");
                }
                evaluate(input);
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
                if (secondFunc) {
                    input += "ln(";
                    bSeven.setText("LN");
                } else {
                    input += "4";
                    bSeven.setText("4");
                }
                evaluate(input);
                inputText.setText(input);
            }
        });
        bFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secondFunc) {
                    input += "pi";
                    bSeven.setText("PI");
                } else {
                    input += "5";
                    bSeven.setText("5");
                }
                evaluate(input);
                inputText.setText(input);
            }
        });
        bSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secondFunc) {
                    //Make sure this changes the calulations
                    if (radianMode) {
                        bSix.setText("RAD");
                    } else {
                        bSix.setText("DEG");
                    }
                    radianMode = !radianMode;
                } else {
                    input += "6";
                    bSeven.setText("6");
                }
                evaluate(input);
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
                if (secondFunc) {
                    input += "^";
                    bSeven.setText("^");
                } else {
                    input += "1";
                    bSeven.setText("1");
                }
                evaluate(input);
                inputText.setText(input);
            }
        });
        bTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secondFunc) {
                    input += "^2";
                    bSeven.setText("^2");
                } else {
                    input += "2";
                    bSeven.setText("2");
                }
                evaluate(input);
                inputText.setText(input);
            }
        });
        bThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secondFunc) {
                    input += "√";
                    bSeven.setText("√");
                } else {
                    input += "3";
                    bSeven.setText("3");
                }
                evaluate(input);
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
                evaluate(input);
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
                double result = expression.calculate();
                if (Double.isNaN(result)) {
                    resultText.setText("INVALID OPERATION");
                } else {
                    resultText.setText(String.valueOf(result));
                }

            }
        });
        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input += " - ";
                inputText.setText(input);
            }
        });
        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = "";
                inputText.setText(input);
                resultText.setText("RESULT");
            }
        });
    }

    public void evaluate(String input) {
        Expression expression = new Expression(input);
        input.replaceAll("√", "^(1/2)");
        double result = expression.calculate();

        if (Double.isNaN(result)) {
            resultText.setText("INVALID OPERATION");
        }
        else {
            resultText.setText(String.valueOf(result));
        }
    }
}
