package com.example.basiccalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    private Button addButton, subtractButton, multiplyButton, divideButton,resetbtn;
    private TextView resultView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Initialize views
        editText1 = findViewById(R.id.editTextNumber1);
        editText2 = findViewById(R.id.editTextNumber2);
        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);
        resultView = findViewById(R.id.resultView);
        resetbtn = findViewById(R.id.resetButton);

        // Set onClickListeners for buttons
        addButton.setOnClickListener(v -> calculate('+'));
        subtractButton.setOnClickListener(v -> calculate('-'));
        multiplyButton.setOnClickListener(v -> calculate('*'));
        divideButton.setOnClickListener(v -> calculate('/'));
        resetbtn.setOnClickListener(v -> calculate('^'));

    }

    private void calculate(char operator) {
        String num1Str = editText1.getText().toString();
        String num2Str = editText2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            resultView.setText("Please enter both numbers.");
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultView.setText("Division by zero is not allowed.");
                    return;
                }
                break;
            case '^':
                editText1.setText("");
                editText2.setText("");
//                resultView.setText(" Made to reset , You can now enter number to Add / Subtract / Multiply / Divide.");
                break;

        }
        resultView.setText("Result: " + result);
    }

}