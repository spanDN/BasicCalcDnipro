package com.example.delle5540.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    String firstValue, operand, secondValue, result;

    @BindView(R.id.tv_first_operand)
    TextView tvFirst;

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

    @BindView(R.id.btn_main_clr)
    AppCompatButton btnClr;

    @BindView(R.id.btn_main_equal)
    AppCompatButton btnEqual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDisplay.setText(etDisplay.getText().toString() + "1");
                etDisplay.setSelection(etDisplay.getText().length());
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDisplay.setText(etDisplay.getText().toString() + "2");
                etDisplay.setSelection(etDisplay.getText().length());
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDisplay.setText(etDisplay.getText().toString() + "3");
                etDisplay.setSelection(etDisplay.getText().length());
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDisplay.setText(etDisplay.getText().toString() + "4");
                etDisplay.setSelection(etDisplay.getText().length());
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDisplay.setText(etDisplay.getText().toString() + "5");
                etDisplay.setSelection(etDisplay.getText().length());
            }
        });
        btnSix.setOnClickListener( (View v) -> {
            etDisplay.setText(etDisplay.getText().toString() + "6");
            etDisplay.setSelection(etDisplay.getText().length());
        });
        btnSeven.setOnClickListener( (View v) -> {
            etDisplay.setText(etDisplay.getText().toString() + "7");
            etDisplay.setSelection(etDisplay.getText().length());
        });
        btnEight.setOnClickListener( (View v) -> {
            etDisplay.setText(etDisplay.getText().toString() + "8");
            etDisplay.setSelection(etDisplay.getText().length());
        });
        btnNine.setOnClickListener( (View v) -> {
            etDisplay.setText(etDisplay.getText().toString() + "9");
            etDisplay.setSelection(etDisplay.getText().length());
        });
        btnZero.setOnClickListener( (View v) -> {
            etDisplay.setText(etDisplay.getText().toString() + "0");
            etDisplay.setSelection(etDisplay.getText().length());
        });
        /* remove last character from the edit text field */
        btnClr.setOnClickListener( (View v) -> {
            int nLenght = etDisplay.getText().toString().length();
            String contentOfEditText = etDisplay.getText().toString();
            if(nLenght > 0) {
                etDisplay.setText(contentOfEditText.substring(0, nLenght - 1));
            } else {
                firstValue = "";
                operand = "";
                tvFirst.setText("");
            }
        });
        btnClr.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etDisplay.setText("");
                firstValue = "";
                operand = "";
                tvFirst.setText("");
                return true;
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenAnyOperationButtomIsPressed( "+" );
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenAnyOperationButtomIsPressed( "-" );
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenAnyOperationButtomIsPressed( "/" );
            }
        });
        btnMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenAnyOperationButtomIsPressed( "*" );
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Perform calculation only when all needed information was entered. */
                if(!firstValue.isEmpty() &&
                        !operand.isEmpty() &&
                        !etDisplay.getText().toString().isEmpty()) {
                    if( calc(firstValue, operand, etDisplay.getText().toString() )){
                        etDisplay.setText(result);
                        tvFirst.setText("");
                        firstValue = "";
                        operand = "";
                    }
                }
            }
        });
        etDisplay.setKeyListener(null); /* Disable editing EditText field by using keyboard */
    }

    private void whenAnyOperationButtomIsPressed(String currentOperand )
    {
        if(!etDisplay.getText().toString().isEmpty()) {
            firstValue = etDisplay.getText().toString();
            tvFirst.setText(firstValue + "  " + currentOperand + "  ");
            operand = currentOperand;
            etDisplay.setText("");
        }
    }

    /* Listener for equal button */
    /* -------------------------------------------------------------------- */
    private boolean calc(String fv, String op, String sv )
    {
        boolean bRet = true;

        if (op.equals("+")) {
            result = String.valueOf(Integer.valueOf(fv) + Integer.valueOf(sv));
        } else if (op.equals("-")) {
            result = String.valueOf(Integer.valueOf(fv) - Integer.valueOf(sv));
        } else if (op.equals("*")) {
            result = String.valueOf(Integer.valueOf(fv) * Integer.valueOf(sv));
        } else if (op.equals("/")) {
            if(Integer.valueOf(sv) > 0) {
                result = String.valueOf(Integer.valueOf(fv) / Integer.valueOf(sv));
            }  else {
                Toast.makeText(this, "Error: You cannot divide by 0", Toast.LENGTH_SHORT).show();
                bRet = false;
            }
        }
        return bRet;
    }
/*
// SEVERAL EXAMPLES OF ADD OnClicLIstener
/////////////////////////////////////////////////////////////////
// ButterKnife
    @OnClick(R.id.btn_main_two)
    public void onClickTwo() {
        Toast.makeText(MainActivity.this, "Two pressed", Toast.LENGTH_LONG).show();
    }
/////////////////////////////////////////////////////////////////
// Lambda and separate onClick class
    public View.OnClickListener onClick = view -> {
        Toast.makeText(MainActivity.this, " view id " + view.getId(), Toast.LENGTH_LONG).show();
    };
    btnTwo.setOnClickListener(onClick);
//////////////////////////////////////////////////
// Lambda only
    btnThree.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Three pressed", Toast.LENGTH_LONG).show());
//////////////////////////////////////////////////
// Classic
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDisplay.setText(etDisplay.getText().toString() + "2");
                etDisplay.setSelection(etDisplay.getText().length());
            }
        });
*/
//////// END of example onClickListener /////////////////////////////////////////////////////////

    /* ----------- NOT USED!!! --------------------------------
    private void checkDisplay(String value) {
        if(etDisplay.getText().toString().equals("-") ||
                etDisplay.getText().toString().equals("+") ||
                etDisplay.getText().toString().equals("*") ||
                etDisplay.getText().toString().equals("/") ) {
            operand = etDisplay.getText().toString();
            secondValue = value;
        } else {
            firstValue = etDisplay.getText().toString();
        }
    }
    -------------- NOT USED ------------------------------------*/
}
