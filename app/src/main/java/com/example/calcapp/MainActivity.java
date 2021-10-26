package com.example.calcapp;

import static java.lang.StrictMath.E;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bSeven, bEight, bNine, bDiv, bFour, bFive, bSix, bMultiply, bOne, bTwo, bThree, bPlus,
            bZero, bDot, bEquals, bMinus, bClear, bChangeSign, bSecond, bPercent, bNegative,
            bSqrt, bInverse, bPower;
    TextView inputText, resultText;
    String input = "";

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
        bPercent = findViewById(R.id.button26);
        bChangeSign = findViewById(R.id.button4);
        bSecond = findViewById(R.id.button7);
        bNegative = findViewById(R.id.button4);
        bSqrt = findViewById(R.id.button5);
        bInverse = findViewById(R.id.button6);
        bPower = findViewById(R.id.button7);
        //Initializing TextViews
        inputText = findViewById(R.id.textView2);
        resultText = findViewById(R.id.textView4);
        //Initializing OnClickListener
        bSeven.setOnClickListener(this);
        bEight.setOnClickListener(this);
        bNine.setOnClickListener(this);
        bDiv.setOnClickListener(this);
        bFour.setOnClickListener(this);
        bFive.setOnClickListener(this);
        bSix.setOnClickListener(this);
        bMultiply.setOnClickListener(this);
        bOne.setOnClickListener(this);
        bTwo.setOnClickListener(this);
        bThree.setOnClickListener(this);
        bPlus.setOnClickListener(this);
        bZero.setOnClickListener(this);
        bDot.setOnClickListener(this);
        bEquals.setOnClickListener(this);
        bMinus.setOnClickListener(this);
        bClear.setOnClickListener(this);
        bPercent.setOnClickListener(this);
        bNegative.setOnClickListener(this);
        bSqrt.setOnClickListener(this);
        bInverse.setOnClickListener(this);
        bPower.setOnClickListener(this);

    }
    //splits the expression into tokens
    public ArrayList<String> tokenize (String input) {
        StringTokenizer expr = new StringTokenizer(input, " ");
        ArrayList<String> tokens = new ArrayList<>();
        while (expr.hasMoreTokens()) {
            String token = expr.nextToken();
            tokens.add(token);
        }
        return tokens;
    }
    //Calculates expressions with order of operations
    public String calculate (String input) {
        try {
            input = input.replaceAll(" ÷ ", " / ");
            input = input.replaceAll(" x ", " * ");
            input = input.replace("^", " ^ ");
            ArrayList<String> tokens = tokenize(input);
            while (tokens.size() > 1) {
                if (tokens.contains("^")) {
                    System.out.println(tokens.toString());
                    int i = tokens.indexOf("^");
                    doOp(tokens, i);
                }
                else if (tokens.contains("*") || tokens.contains("/")) {
                    if (tokens.contains("*")) {
                        int i = tokens.indexOf("*");
                        doOp(tokens, i);
                    } else {
                        int i = tokens.indexOf("/");
                        doOp(tokens, i);
                        if (tokens.contains(String.valueOf(Double.POSITIVE_INFINITY))
                                || tokens.contains(String.valueOf(Double.NEGATIVE_INFINITY))) {
                            return "Cannot Divide by 0";
                        }
                    }
                } else if (tokens.contains("+") || tokens.contains("-")) {
                    System.out.println(tokens.toString());
                    if (tokens.contains("+")) {
                        int i = tokens.indexOf("+");
                        doOp(tokens, i);
                    } else {
                        int i = tokens.indexOf("-");
                        doOp(tokens, i);
                    }
                }
            }


            return String.valueOf(tokens.get(0));
        } catch (Exception E) {
            return "Invalid Expression";
        }

    }
    //formats answer correctly according to inputs
    public static String convertNum (String input){
        if(input.equals("Cannot Divide by 0") || input.equals("Invalid Expression")) {
            return input;
        }
        for (int i = 0; i < input.length(); i++) {
            if (String.valueOf(input.charAt(i)).equals(".")
                    && String.valueOf(input.charAt(i + 1)).equals("0")) {
                return input.substring(0, i);
            }
        }
        return input;
    }
    //Does operations that expression calls for
    public void doOp (ArrayList <String> input,int i){
        double a = Double.parseDouble(input.get(i - 1));
        double b = Double.parseDouble(input.get(i + 1));
        String op = input.get(i);
            switch (op) {
                case "^":
                    input.add(i + 1, String.valueOf(Math.pow(a, b)));
                    break;
                case "*":
                    input.add(i + 1, String.valueOf(a * b));
                    break;
                case "/":
                    input.add(i + 1, String.valueOf(a / b));
                    break;
                case "+":
                    input.add(i + 1, String.valueOf(a + b));
                    break;
                case "-":
                    input.add(i + 1, String.valueOf(a - b));
                    break;
            }
            input.remove(i);
            input.remove(i - 1);
            input.remove(i);
        }

    @Override
    public void onClick (View view){
        switch (view.getId()) {
            case R.id.button9:
                input += "7";
                updateScreen(input);
                break;
            case R.id.button10:
                input += "8";
                updateScreen(input);
                break;
            case R.id.button11:
                input += "9";
                updateScreen(input);
                break;
            case R.id.button12:
                input += " ÷ ";
                inputText.setText(input);
                break;
            case R.id.button13:
                input += "4";
                updateScreen(input);
                break;
            case R.id.button14:
                input += "5";
                updateScreen(input);
                break;
            case R.id.button15:
                input += "6";
                updateScreen(input);
                break;
            case R.id.button16:
                input += " x ";
                inputText.setText(input);
                break;
            case R.id.button17:
                input += "1";
                updateScreen(input);
                break;
            case R.id.button18:
                input += "2";
                updateScreen(input);
                break;
            case R.id.button19:
                input += "3";
                updateScreen(input);
                break;
            case R.id.button24:
                input += " - ";
                inputText.setText(input);
                break;
            case R.id.button21:
                input += "0";
                updateScreen(input);
                break;
            case R.id.button26:
                try {
                    double result = Double.parseDouble(calculate(input));
                    result = result/100.0;
                    String answer = convertNum(String.valueOf(result));
                    inputText.setText(input);
                    resultText.setText(answer);
                }
                catch (NumberFormatException E) {
                    E.printStackTrace();
                }
                break;
            case R.id.button22:
                input += ".";
                inputText.setText(input);
                break;
            case R.id.button20:
                input += " + ";
                inputText.setText(input);
                break;
            case R.id.button25:
                input = "";
                inputText.setText(input);
                resultText.setText("");
                break;
            case R.id.button:
                String answer = convertNum(String.valueOf(calculate(input)));
                if (answer.equals("Cannot Divide by 0") || answer.equals("Invalid Expression")) {
                    input = "";
                    answer="";
                }
                else {
                    input = answer;
                }
                inputText.setText(input);
                resultText.setText(answer);
                break;
            case R.id.button4:
                input += "-";
                inputText.setText(input);
                break;
            case R.id.button5:
                input += "^0.5";
                inputText.setText(input);
                updateScreen(input);
                break;
            case R.id.button6:
                input += "^-1";
                inputText.setText(input);
                updateScreen(input);
                break;
            case R.id.button7:
                input += "^";
                inputText.setText(input);
                break;
        }
    }
    //updates the screen as new inputs are put in
    public void updateScreen (String input){
        inputText.setText(input);
        resultText.setText(convertNum(calculate(input)));
    }

}



