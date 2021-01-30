package ecs.fullerton.edu.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import android.view.View.OnClickListener;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class MainActivity extends AppCompatActivity
implements OnClickListener {

    //The Deque class will be holding the stack.
    Deque<Double> stack = new ArrayDeque<Double>();
    String inputString = "";
    //This array holds the first four positions in the stack.
    double[] firstFourStackElements = new double[50];
    //The first four elements in the stack will be put into these variable that will be displayed in the textView widgets.
    String zeroElementString = "";
    String firstElementString = "";
    String secondElementString = "";
    String thirdElementString = "";

    //These variables will deal with the arithmetic.
    double operand1;
    double operand2;
    double answer;

    //Keeps track of how many decimals the user has inputted.
    int decimalCount = 0;

    //Defines the sharedValue object.
    private SharedPreferences savedValues;

    //Declaring the variables for the widgets.
    private TextView stackThirdPosTextView;
    private TextView stackSecondPosTextView;
    private TextView stackFirstPosTextView;
    private TextView stackZeroPosTextView;
    private TextView inputStringTextView;

    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;
    private Button divButton;

    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button multButton;

    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button minButton;

    private Button decimalButton;
    private Button zeroButton;
    private Button enterButton;
    private Button plusButton;

    private Button dropButton;
    private Button delButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get references to the widgets.
        stackThirdPosTextView = (TextView) findViewById(R.id.stackThirdPosTextView);
        stackSecondPosTextView = (TextView) findViewById(R.id.stackSecondPosTextView);
        stackFirstPosTextView = (TextView) findViewById(R.id.stackFirstPosTextView);
        stackZeroPosTextView = (TextView) findViewById(R.id.stackZeroPosTextView);
        inputStringTextView = (TextView) findViewById(R.id.inputStringTextView);

        sevenButton = (Button) findViewById(R.id.sevenButton);
        eightButton = (Button) findViewById(R.id.eightButton);
        nineButton = (Button) findViewById(R.id.nineButton);
        divButton = (Button) findViewById(R.id.divButton);

        fourButton = (Button) findViewById(R.id.fourButton);
        fiveButton = (Button) findViewById(R.id.fiveButton);
        sixButton = (Button) findViewById(R.id.sixButton);
        multButton = (Button) findViewById(R.id.multButton);

        oneButton = (Button) findViewById(R.id.oneButton);
        twoButton = (Button) findViewById(R.id.twoButton);
        threeButton = (Button) findViewById(R.id.threeButton);
        minButton = (Button) findViewById(R.id.minButton);

        decimalButton = (Button) findViewById(R.id.decimalButton);
        zeroButton = (Button) findViewById(R.id.zeroButton);
        enterButton = (Button) findViewById(R.id.enterButton);
        plusButton = (Button) findViewById(R.id.plusButton);

        dropButton = (Button) findViewById(R.id.dropButton);
        delButton = (Button) findViewById(R.id.delButton);

        //Setting the listeners.
        sevenButton.setOnClickListener(this);
        eightButton.setOnClickListener(this);
        nineButton.setOnClickListener(this);
        divButton.setOnClickListener(this);

        fourButton.setOnClickListener(this);
        fiveButton.setOnClickListener(this);
        sixButton.setOnClickListener(this);
        multButton.setOnClickListener(this);

        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        minButton.setOnClickListener(this);

        decimalButton.setOnClickListener(this);
        zeroButton.setOnClickListener(this);
        enterButton.setOnClickListener(this);
        plusButton.setOnClickListener(this);

        dropButton.setOnClickListener(this);
        delButton.setOnClickListener(this);

        //Gets the SharedPreferences object.
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    //*******************************************************
    //Event handler for buttons
    //*******************************************************
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sevenButton:
                inputString += "7";
                displayInputStringAndStack();
                break;
            case R.id.eightButton:
                inputString += "8";
                displayInputStringAndStack();
                break;
            case R.id.nineButton:
                inputString += "9";
                displayInputStringAndStack();
                break;
            case R.id.divButton:
                if(stack.size() >= 2) {
                    //Pop off the last two operands inputted into the stack.
                    operand1 = stack.pop();
                    operand2 = stack.pop();

                    //Calculate the answer.
                    answer = (operand2 / operand1);

                    //Pushes the answer back onto the stack.
                    stack.push(answer);
                    //Update the stack output to show the recent two operands are gone.
                    displayInputStringAndStack();
                }
                break;

            case R.id.fourButton:
                inputString += "4";
                displayInputStringAndStack();
                break;
            case R.id.fiveButton:
                inputString += "5";
                displayInputStringAndStack();
                break;
            case R.id.sixButton:
                inputString += "6";
                displayInputStringAndStack();
                break;
            case R.id.multButton:
                if(stack.size() >= 2) {
                    //Pop off the last two operands inputted into the stack.
                    operand1 = stack.pop();
                    operand2 = stack.pop();

                    //Calculate the answer.
                    answer = (operand2 * operand1);

                    //Pushes the answer back onto the stack.
                    stack.push(answer);
                    //Update the stack output to show the recent two operands are gone.
                    displayInputStringAndStack();
                }
                break;

            case R.id.oneButton:
                inputString += "1";
                displayInputStringAndStack();
                break;
            case R.id.twoButton:
                inputString += "2";
                displayInputStringAndStack();
                break;
            case R.id.threeButton:
                inputString += "3";
                displayInputStringAndStack();
                break;
            case R.id.minButton:
                if(stack.size() >= 2) {
                    //Pop off the last two operands inputted into the stack.
                    operand1 = stack.pop();
                    operand2 = stack.pop();

                    //Calculate the answer.
                    answer = (operand2 - operand1);

                    //Pushes the answer back onto the stack.
                    stack.push(answer);
                    //Update the stack output to show the recent two operands are gone.
                    displayInputStringAndStack();
                }
                break;

            case R.id.decimalButton:
                if(decimalCount < 1) {
                    inputString += ".";
                    decimalCount++;
                    displayInputStringAndStack();
                }
                break;
            case R.id.zeroButton:
                inputString += "0";
                displayInputStringAndStack();
                break;
            case R.id.enterButton:
                if(!inputString.isEmpty()) {
                    //Convert inputString to type double.
                    double inputNumber = Double.parseDouble(inputString);

                    //Add the type double number to the stack.
                    stack.push(inputNumber);
                    //Make the inputString NULL again so that the user can enter in another input.
                    inputString = "";
                    displayInputStringAndStack();
                    decimalCount = 0;
                }
                break;
            case R.id.plusButton:
                if(stack.size() >= 2) {
                    //Pop off the last two operands inputted into the stack.
                    operand1 = stack.pop();
                    operand2 = stack.pop();

                    //Calculate the answer.
                    answer = (operand2 + operand1);

                    //Pushes the answer back onto the stack.
                    stack.push(answer);
                    //Update the stack output to show the recent two operands are gone.
                    displayInputStringAndStack();
                }

                break;

            case R.id.dropButton:
                if(stack.size() > 0) {
                    //Removes the last object that was pushed onto the stack.
                    stack.pop();
                    displayInputStringAndStack();
                }
                break;
            case R.id.delButton:
                if(!inputString.isEmpty()) {

                    //If the character about to be deleted is a decimal, decrease the count so the user can input another one.
                    if(inputString.endsWith(".")){
                        decimalCount--;
                    }
                    inputString = removeLastChar(inputString);
                    displayInputStringAndStack();
                }
                break;
        }
    }

    public void displayInputStringAndStack() {
        //Refresh the output elements.
        zeroElementString = "";
        firstElementString = "";
        secondElementString = "";
        thirdElementString = "";

        //Refresh the array incase any numbers changed.
        for(int j = 0; j < 4; j++){
            firstFourStackElements[j] = 0;
        }

        //Gets the elements in the stack and puts them in an array to more easily access and display the first four in the stack.
        int i = 0;
        for(Iterator itr = stack.iterator(); itr.hasNext(); i++)  {
            firstFourStackElements[i] = (double) itr.next();
        }

        //Display what numbers the user has inputted into the calculator so far.
        inputStringTextView.setText(inputString);

        //Displays the first four elements in the stack.
        zeroElementString = Double.toString(firstFourStackElements[0]);
        stackZeroPosTextView.setText(zeroElementString);

        firstElementString = Double.toString(firstFourStackElements[1]);
        stackFirstPosTextView.setText(firstElementString);

        secondElementString = Double.toString((firstFourStackElements[2]));
        stackSecondPosTextView.setText(secondElementString);

        thirdElementString = Double.toString((firstFourStackElements[3]));
        stackThirdPosTextView.setText(thirdElementString);
    }

    public static String removeLastChar(String str) { return str.substring(0, str.length() - 1); }

    @Override
    public void onPause(){
        //Save the instance variables.
        Editor editor = savedValues.edit();
        editor.putString("inputString", inputString);
        editor.putString("stackString", stack.toString());
        editor.putInt("decimalCount", decimalCount);


        editor.commit();

        super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();

        //Get the instance variables.
        inputString = savedValues.getString("inputString", "");
        //Retrieve the stack from memory.
        //stack.push(Double.valueOf(savedValues.getString("stackString", "")));
        decimalCount = savedValues.getInt("decimalCount", 1);
    }
}
