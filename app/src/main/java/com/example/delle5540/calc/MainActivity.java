package com.example.delle5540.calc;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    String firstValue, operand, secondValue, result;


    @BindView(R.id.et_main_display)
    AppCompatEditText etDisplay;

    @BindView(R.id.btn_main_one)
    AppCompatButton btnOne;

    @BindView(R.id.btn_main_two)
    AppCompatButton btnTwo;

    @BindView(R.id.btn_main_three)
    AppCompatButton btnThree;

    @BindView(R.id.btn_main_four)
    AppCompatButton btnFour;

    @BindView(R.id.btn_main_five)
    AppCompatButton btnFive;

    @BindView(R.id.btn_main_six)
    AppCompatButton btnSix;

    @BindView(R.id.btn_main_seven)
    AppCompatButton btnSeven;

    @BindView(R.id.btn_main_eight)
    AppCompatButton btnEight;

    @BindView(R.id.btn_main_nine)
    AppCompatButton btnNine;

    @BindView(R.id.btn_main_zero)
    AppCompatButton btnZero;

    @BindView(R.id.btn_main_plus)
    AppCompatButton btnPlus;

    @BindView(R.id.btn_main_minus)
    AppCompatButton btnMinus;

    @BindView(R.id.btn_main_divide)
    AppCompatButton btnDivide;

    @BindView(R.id.btn_main_multiple)
    AppCompatButton btnMultiple;

    @BindView(R.id.btn_main_clear)
    AppCompatButton btnClear;

    @BindView(R.id.btn_main_equals)
    AppCompatButton btnEquals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnOne.setOnClickListener(view -> {
            MainActivity.this.checkDisplay("1");
            etDisplay.setText("1");
        });
        btnTwo.setOnClickListener(view -> {
            checkDisplay("2");
            etDisplay.setText("2");
        });
        btnThree.setOnClickListener(view -> {
            checkDisplay("3");
            etDisplay.setText("3");
        });
        btnFour.setOnClickListener(view -> {
            checkDisplay("4");
            etDisplay.setText("4");
        });
        btnFive.setOnClickListener(view -> {
            checkDisplay("5");
            etDisplay.setText("5");
        });
        btnSix.setOnClickListener(view -> {
            checkDisplay("6");
            etDisplay.setText("6");
        });
        btnSeven.setOnClickListener(view -> {
            checkDisplay("7");
            etDisplay.setText("7");
        });
        btnEight.setOnClickListener(view -> {
            checkDisplay("8");
            etDisplay.setText("8");
        });
        btnNine.setOnClickListener(view -> {
            checkDisplay("9");
            etDisplay.setText("9");
        });
        btnZero.setOnClickListener(view -> {
            checkDisplay("0");
            etDisplay.setText("0");
        });
        btnClear.setOnClickListener(view -> {
            etDisplay.setText("");
        });
        btnPlus.setOnClickListener(view -> {
            etDisplay.setText("+");
        });
        btnMinus.setOnClickListener(view -> {
            etDisplay.setText("-");
        });
        btnDivide.setOnClickListener(view -> {
            etDisplay.setText("/");
        });
        btnMultiple.setOnClickListener(view -> {
            etDisplay.setText("*");
        });

        btnClear.setOnClickListener(view -> {
            etDisplay.setText("");
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.calc(firstValue, operand, secondValue);
                etDisplay.setText(result);
            }
        });
    }

    private void calc(String fv, String op, String sv) {
        if (op.equals("+")) {
            result = String.valueOf(Integer.valueOf(fv) + Integer.valueOf(sv));
        } else if (op.equals("-")) {
            result = String.valueOf(Integer.valueOf(fv) - Integer.valueOf(sv));
        } else if (op.equals("*")) {
            result = String.valueOf(Integer.valueOf(fv) * Integer.valueOf(sv));
        } else if (op.equals("/")) {
            if(Integer.valueOf(sv) != 0 ) {
                result = String.valueOf(Integer.valueOf(fv) / Integer.valueOf(sv));
            } else {
                Toast.makeText(this, "Error: cannot divide by zero!", Toast.LENGTH_SHORT).show();
                result = "";
            }
        }
    }

    private void checkDisplay(String value) {
        if (etDisplay.getText().toString().equals("-") ||
             etDisplay.getText().toString().equals("+") ||
                etDisplay.getText().toString().equals("*") ||
                etDisplay.getText().toString().equals("/")) {
            operand = etDisplay.getText().toString();
            secondValue = value;
        } else {
            firstValue = value;
        };
    }
}
