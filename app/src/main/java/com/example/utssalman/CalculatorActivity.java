package com.example.utssalman;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CalculatorActivity extends AppCompatActivity {

    private EditText editTextPanjang, editTextLebar;
    private TextView textViewHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);

        editTextPanjang = findViewById(R.id.editTextLength);
        editTextLebar = findViewById(R.id.editTextWidth);
        textViewHasil = findViewById(R.id.textView8);
        Button buttonHitung = findViewById(R.id.calculate);
        Button buttonReset = findViewById(R.id.reset);

        buttonHitung.setOnClickListener(v -> calculateArea());

        buttonReset.setOnClickListener(v -> {
            editTextPanjang.setText("");
            editTextLebar.setText("");
            textViewHasil.setText("");
        });

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setSelectedItemId(R.id.calculator);

        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
                return true;
            } else return itemId == R.id.calculator;
        });
    }

    private void calculateArea() {
        String lengthStr = editTextPanjang.getText().toString();
        String widthStr = editTextLebar.getText().toString();

        double panjang = Double.parseDouble(lengthStr);
        double lebar = Double.parseDouble(widthStr);

        double area = panjang * lebar;

        textViewHasil.setText(String.format("Luas: %s", area));
    }
}
