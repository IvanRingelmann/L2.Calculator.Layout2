package com.example.l2calculatorlayout2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView resultTextView;
    private Button number1Button;
    private Button number2Button;
    private Button number3Button;
    private Button number4Button;
    private Button number5Button;
    private Button number6Button;
    private Button number7Button;
    private Button number8Button;
    private Button number9Button;
    private Button number0Button;
    private Button number000Button;
    private Button resultButton;
    private Button minusButton;
    private Button plusButton;
    private Button dotButton;
    private Button splitButton;
    private Button multiplyButton;
    private Button percentButton;
    private Button deleteButton;
    private Button lastActivityButton;

    private CalculatorModel calculatorModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorModel = new CalculatorModel();

        initViews();
        initListeners();
    }

    private void initListeners() {
        number1Button.setOnClickListener(v -> updateInput(InputSymbol.NUM_1));
        number2Button.setOnClickListener(v -> updateInput(InputSymbol.NUM_2));
        number3Button.setOnClickListener(v -> updateInput(InputSymbol.NUM_3));
        number4Button.setOnClickListener(v -> updateInput(InputSymbol.NUM_4));
        number5Button.setOnClickListener(v -> updateInput(InputSymbol.NUM_5));
        number6Button.setOnClickListener(v -> updateInput(InputSymbol.NUM_6));
        number7Button.setOnClickListener(v -> updateInput(InputSymbol.NUM_7));
        number8Button.setOnClickListener(v -> updateInput(InputSymbol.NUM_8));
        number9Button.setOnClickListener(v -> updateInput(InputSymbol.NUM_9));
        number0Button.setOnClickListener(v -> updateInput(InputSymbol.NUM_0));
        number000Button.setOnClickListener(v -> updateInput(InputSymbol.NUM_000));
        resultButton.setOnClickListener(v -> updateInput(InputSymbol.OP_RESULT));
        minusButton.setOnClickListener(v -> updateInput(InputSymbol.OP_MINUS));
        plusButton.setOnClickListener(v -> updateInput(InputSymbol.OP_PLUS));
        dotButton.setOnClickListener(v -> updateInput(InputSymbol.DOT));
        splitButton.setOnClickListener(v -> updateInput(InputSymbol.OP_SPLIT));
        multiplyButton.setOnClickListener(v -> updateInput(InputSymbol.OP_MULTIPLY));
        percentButton.setOnClickListener(v -> updateInput(InputSymbol.OP_PERSENT));
        deleteButton.setOnClickListener(v -> updateInput(InputSymbol.DELETE));
        lastActivityButton.setOnClickListener(v -> showResultScreen());
    }

    private void showResultScreen() {
        List<InputSymbol> inputSymbolList = calculatorModel.getInput();
        String result = convertInputSymbolsToString(inputSymbolList);
        ResultActivity.TransferObject transferObject = new ResultActivity.TransferObject(result);

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(ResultActivity.RESULT_EXTRA_KEY, transferObject);
        startActivity(intent);
    }

    private void updateInput(InputSymbol inputSymbol) {
        calculatorModel.onClickButton(inputSymbol);
        List<InputSymbol> inputSymbolList = calculatorModel.getInput();
        resultTextView.setText(convertInputSymbolsToString(inputSymbolList));

    }

    private void initViews() {
        resultTextView = findViewById(R.id.result_number_view);
        number1Button = findViewById(R.id.button_number_one);
        number2Button = findViewById(R.id.button_number_two);
        number3Button = findViewById(R.id.button_number_three);
        number4Button = findViewById(R.id.button_number_four);
        number5Button = findViewById(R.id.button_number_five);
        number6Button = findViewById(R.id.button_number_six);
        number7Button = findViewById(R.id.button_number_seven);
        number8Button = findViewById(R.id.button_number_eight);
        number9Button = findViewById(R.id.button_number_nine);
        number0Button = findViewById(R.id.button_number_null);
        number000Button = findViewById(R.id.button_number_triple_null);
        resultButton = findViewById(R.id.button_action_result);
        minusButton = findViewById(R.id.button_action_minus);
        plusButton = findViewById(R.id.button_action_plus);
        dotButton = findViewById(R.id.button_number_dot);
        splitButton = findViewById(R.id.button_action_split);
        multiplyButton = findViewById(R.id.button_action_multiply);
        percentButton = findViewById(R.id.button_action_percent);
        deleteButton = findViewById(R.id.button_action_delete);
        lastActivityButton = findViewById(R.id.button_action_show_last_activity);

    }

    private String convertInputSymbolsToString(List<InputSymbol> inputSymbolList) {
        final StringBuilder sb = new StringBuilder();
        for (InputSymbol inputSymbol : inputSymbolList) {
            switch (inputSymbol) {
                case NUM_0:
                    sb.append("0");
                    break;
                case NUM_000:
                    sb.append("000");
                    break;
                case NUM_1:
                    sb.append("1");
                    break;
                case NUM_2:
                    sb.append("2");
                    break;
                case NUM_3:
                    sb.append("3");
                    break;
                case NUM_4:
                    sb.append("4");
                    break;
                case NUM_5:
                    sb.append("5");
                    break;
                case NUM_6:
                    sb.append("6");
                    break;
                case NUM_7:
                    sb.append("7");
                    break;
                case NUM_8:
                    sb.append("8");
                    break;
                case NUM_9:
                    sb.append("9");
                    break;
                case DOT:
                    sb.append(".");
                    break;
                case OP_PLUS:
                    sb.append("+");
                    break;
                case OP_MINUS:
                    sb.append("-");
                    break;
                case OP_SPLIT:
                    sb.append("/");
                    break;
                case OP_PERSENT:
                    sb.append("%");
                    break;
                case OP_MULTIPLY:
                    sb.append("*");
                    break;
                default:
                    sb.append("@");
                    break;

            }

        }
        return sb.toString();
    }

}