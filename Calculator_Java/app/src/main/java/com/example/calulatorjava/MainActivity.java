package com.example.calulatorjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calcoperations.Evaluation;


public class MainActivity extends AppCompatActivity {


    TextView tv_input,tv_output;
    Button btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,btnZero;
    Button btnAdd,btnSub,btnMul,btnDiv,btnSin,btnCos,btnTan,btnDec,btnDel,btnEql;
    String operator;
    Double operand1,operand2;
    boolean decimalPoint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitViews();
        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator==null){
                    tv_output.setText("");
                    tv_input.setText("");
                }
                else{
                    if(operator =="+" || operator =="-" || operator == "*" || operator == "/"){
                        operand2 = Double.parseDouble(tv_input.getText().toString());
                        tv_output.setText( Evaluation.evaluateEquation(operand1,operand2,operator) + "");
                        operator = null;
                    }
                    else if(operator == "sin" || operator == "cos" || operator == "tan"){
                        tv_output.setText(Evaluation.evaluateEquation(operand1,operator)+ "");
                        operator = null;
                    }
                }
            }
        });

    }

    private void InitViews(){
        tv_input = findViewById(R.id.tv_input);
        tv_output = findViewById(R.id.tv_output);
        //Numbers
        btnOne = findViewById(R.id.btn_one);
        btnTwo = findViewById(R.id.btn_two);
        btnThree = findViewById(R.id.btn_three);
        btnFour = findViewById(R.id.btn_four);
        btnFive = findViewById(R.id.btn_five);
        btnSix = findViewById(R.id.btn_six);
        btnSeven = findViewById(R.id.btn_seven);
        btnEight= findViewById(R.id.btn_eight);
        btnNine = findViewById(R.id.btn_nine);
        btnZero = findViewById(R.id.btn_zero);
        //Operators
        btnAdd = findViewById(R.id.btn_addition);
        btnSub = findViewById(R.id.btn_subtraction);
        btnMul = findViewById(R.id.btn_multiplication);
        btnDiv = findViewById(R.id.btn_division);
        btnSin = findViewById(R.id.btn_sin);
        btnCos = findViewById(R.id.btn_cos);
        btnTan = findViewById(R.id.btn_three);
        //Actions
        btnDec = findViewById(R.id.btn_decimal);
        btnDel = findViewById(R.id.btn_delete);
        btnEql = findViewById(R.id.btn_eval);
    }

    public void clickHandlerOperands(View view) {
        // Do stuff
        switch(view.getId()){
            case R.id.btn_one:
                tv_input.setText(tv_input.getText() + "1");
                break;
            case R.id.btn_two:
                tv_input.setText(tv_input.getText() + "2");
                break;
            case R.id.btn_three:
                tv_input.setText(tv_input.getText() + "3");
                break;
            case R.id.btn_four:
                tv_input.setText(tv_input.getText() + "4");
                break;
            case R.id.btn_five:
                tv_input.setText(tv_input.getText() + "5");
                break;
            case R.id.btn_six:
                tv_input.setText(tv_input.getText() + "6");
                break;
            case R.id.btn_seven:
                tv_input.setText(tv_input.getText() + "7");
                break;
            case R.id.btn_eight:
                tv_input.setText(tv_input.getText() + "8");
                break;
            case R.id.btn_nine:
                tv_input.setText(tv_input.getText() + "9");
                break;
            case R.id.btn_zero:
                tv_input.setText(tv_input.getText() + "0");
                break;
            case R.id.btn_decimal:
                if (!decimalPoint) {
                    if (tv_input.getText().equals("")) {
                        tv_input.setText("0.");
                    } else {
                        tv_input.setText(tv_input.getText() + ".");
                    }
                    decimalPoint = true;
                }
                break;
            case R.id.btn_delete:
                if (tv_input.getText().equals("")) {
                    tv_input.setText(null);
                } else {
                    int len = tv_input.getText().length();
                    String s = tv_input.getText().toString();
                    if (s.charAt(len - 1) == '.') {
                        decimalPoint = false;
                        tv_input.setText(tv_input.getText().subSequence(0, tv_input.getText().length() - 1));
                    } else {
                        tv_input.setText(tv_input.getText().subSequence(0, tv_input.getText().length() - 1));
                    }
                }
                break;
        }
    }

    public void clickHandlerOperators(View view){
        operand1 = Double.parseDouble(tv_input.getText().toString());
        decimalPoint = false;
        tv_input.setText("");
        switch (view.getId()){
            case R.id.btn_addition:
                operator = "+";
                break;
            case R.id.btn_subtraction:
                operator = "-";
                break;
            case R.id.btn_multiplication:
                operator = "*";
                break;
            case R.id.btn_division:
                operator = "/";
                break;
            case R.id.btn_sin:
                operator = "sin";
                break;
            case R.id.btn_cos:
                operator = "cos";
                break;
            case R.id.btn_tan:
                operator = "tan";
                break;
        }
    }


}
