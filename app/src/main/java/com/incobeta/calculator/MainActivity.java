package com.incobeta.calculator;

import android.icu.math.BigDecimal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    //necessary variables
    private TextView display;
    private TextView topDisplay;

    private String displayText = "";
    private String topDisplayText = "";
    private double firstNumber;
    private double secondNumber;
    private String operation = "";

    private boolean hasPeriod = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.display);
        topDisplay = (TextView) findViewById(R.id.topDisplay);

        display.setText("");
        topDisplay.setText("");
    }


    public void onClick(View view) {
        //insert switch to cater for all buttons pressed
        switch (view.getId()) {
            case R.id.one:
                displayText += 1;
                display.setText(displayText);
                topDisplayText += 1;
                topDisplay.setText(topDisplayText);
                break;
            case R.id.two:
                displayText += 2;
                display.setText(displayText);
                topDisplayText += 2;
                topDisplay.setText(topDisplayText);
                break;
            case R.id.three:
                displayText += 3;
                display.setText(displayText);
                topDisplayText += 3;
                topDisplay.setText(topDisplayText);
                break;
            case R.id.four:
                displayText += 4;
                display.setText(displayText);
                topDisplayText += 4;
                topDisplay.setText(topDisplayText);
                break;
            case R.id.five:
                displayText += 5;
                display.setText(displayText);
                topDisplayText += 5;
                topDisplay.setText(topDisplayText);
                break;
            case R.id.six:
                displayText += 6;
                display.setText(displayText);
                topDisplayText += 6;
                topDisplay.setText(topDisplayText);
                break;
            case R.id.seven:
                displayText += 7;
                display.setText(displayText);
                topDisplayText += 7;
                topDisplay.setText(topDisplayText);
                break;
            case R.id.eight:
                displayText += 8;
                display.setText(displayText);
                topDisplayText += 8;
                topDisplay.setText(topDisplayText);
                break;
            case R.id.nine:
                displayText += 9;
                display.setText(displayText);
                topDisplayText += 9;
                topDisplay.setText(topDisplayText);
                break;
            case R.id.zero:
                displayText += 0;
                display.setText(displayText);
                topDisplayText += 0;
                topDisplay.setText(topDisplayText);
                break;
            case R.id.clear:
                displayText = "";
                display.setText(displayText);
                topDisplayText = "";
                topDisplay.setText(topDisplayText);
                break;
            case R.id.backspace:
                displayText = displayText.substring(0, displayText.length() - 1);
                display.setText(displayText);
                topDisplayText = topDisplayText.substring(0, topDisplayText.length() - 1);
                topDisplay.setText(topDisplayText);
                break;

            //operations
            case R.id.plus:
                if (!displayText.isEmpty() || displayText != null) {
                    //do cool stuff
                    firstNumber = Double.parseDouble(display.getText().toString());
                    display.setText("");
                    operation = "plus";
                    topDisplayText = displayText + " + ";
                    topDisplay.setText(topDisplayText);
                    displayText = "";
                }
                else {
                    Toast.makeText(this, "No number to add to", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.minus:
                if (!displayText.isEmpty() || displayText != null) {
                    //do cool stuff
                    firstNumber = Double.parseDouble(display.getText().toString());
                    display.setText("");
                    operation = "minus";
                    topDisplayText = displayText + " - ";
                    topDisplay.setText(topDisplayText);
                    displayText = "";
                }
                else {
                    Toast.makeText(this, "No number to minus to", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.multiply:
                if (!displayText.isEmpty() || displayText != null) {
                    //do cool stuff
                    firstNumber = Double.parseDouble(display.getText().toString());
                    display.setText("");
                    operation = "multiply";
                    topDisplayText = displayText + " x ";
                    topDisplay.setText(topDisplayText);
                    displayText = "";
                }
                else {
                    Toast.makeText(this, "No number to multiply to", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.divide:
                if (!displayText.isEmpty() || displayText != null) {
                    //do cool stuff
                    firstNumber = Double.parseDouble(display.getText().toString());
                    display.setText("");
                    operation = "divide";
                    topDisplayText = displayText + " / ";
                    topDisplay.setText(topDisplayText);
                    displayText = "";
                }
                else {
                    Toast.makeText(this, "No number to divide to", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.percentage:
                if (!displayText.isEmpty() || displayText != null) {
                    //do cool stuff
                    firstNumber = Double.parseDouble(display.getText().toString());
                    String text = String.format(Locale.getDefault(), "%.2f", firstNumber / 100);
                    display.setText(text);
                    topDisplay.setText(text);
                    displayText = text;
                    topDisplayText = text;

                }
                else {
                    Toast.makeText(this, "No number to compute", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.period:
                String currentValue = display.getText().toString();
                String newValue = currentValue.concat(".");
                display.setText(newValue);
                topDisplayText = topDisplayText.concat(".");
                topDisplay.setText(topDisplayText);
                displayText = newValue;
                hasPeriod = true;
                break;
            case R.id.equals:
                if (!display.getText().toString().isEmpty()) {
                    secondNumber = Double.parseDouble(display.getText().toString());
                    double result = 0;
                    switch (operation) {
                        case "plus":
                            result = firstNumber + secondNumber;
                            Log.i("NUMBER: ", "" + firstNumber);
                            Log.i("NUMBER2: ", "" + secondNumber);
                            Log.i("NUMBER RESULT: ", "" + result);
                            break;
                        case "minus":
                            result = firstNumber - secondNumber;
                            break;
                        case "multiply":
                            result = firstNumber * secondNumber;
                            break;
                        case "divide":
                            result = firstNumber / secondNumber;
                            break;
                    }

                    //perform diplay operation
                    if (hasDecimal(result)) {
                        display.setText(String.format(Locale.getDefault(), "%.5f",result));
                        topDisplay.setText(String.format(Locale.getDefault(), "%.5f", result));

                    }
                    else {
                        display.setText(String.format(Locale.getDefault(), "%.0f", result));
                        topDisplay.setText(String.format(Locale.getDefault(), "%.0f", result));
                    }
                    topDisplayText = Double.toString(result);
                    displayText = Double.toString(result);
                    hasPeriod = false;

                }
                else {
                    Toast.makeText(this, "No number was entered", Toast.LENGTH_SHORT).show();
                }
            break;
        }

    }

    private boolean hasDecimal(double number) {
        boolean decimalFound = false;
        String numberString = Double.toString(number);
        String [] digitsArray = numberString.split("\\D");

        Log.i("LENGTH: ", "" +digitsArray.length);

        Log.i("NUMBER TO COMPARE: ", numberString);
        Log.i("NUMBER TO COMPARE: ", digitsArray[0]);
        Log.i("NUMBER TO COMPARE2: ", digitsArray[1]);
        //loop through the decimal part and check for a number
        for (int i = 0; i < digitsArray[1].length(); i++) {
            if (digitsArray[1].charAt(i) != '0') {
                decimalFound = true;
            }
        }

        return decimalFound;
    }
}
