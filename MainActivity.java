package com.example.charlie_epstein;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber1, etNumber2;
    private Button btnPlus, btnMinus;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        tvResult = findViewById(R.id.tvResult);


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });
    }

    private void calculate(char operation) {
        String input1 = etNumber1.getText().toString().trim();
        String input2 = etNumber2.getText().toString().trim();


        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "נא להזין שני מספרים", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);
            double result = 0;

            if (operation == '+') {
                result = num1 + num2;
            } else if (operation == '-') {
                result = num1 - num2;
            }


            if (result == (long) result) {
                tvResult.setText("תוצאה: " + (long) result);
            } else {
                tvResult.setText("תוצאה: " + result);
            }

        } catch (NumberFormatException e) {
            Toast.makeText(this, "קלט לא תקין", Toast.LENGTH_SHORT).show();
        }
    }
}