package com.example.utssalman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private TextView[] textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViews = new TextView[]{
                findViewById(R.id.textView1),
                findViewById(R.id.textView2),
                findViewById(R.id.textView3),
                findViewById(R.id.textView4),
                findViewById(R.id.textView5),
                findViewById(R.id.textView6)
        };

        Button showButton = findViewById(R.id.showButton);
        Button hideButton = findViewById(R.id.hideButton);

        showButton.setOnClickListener(view -> {
            for (TextView textView : textViews) {
                textView.setVisibility(View.VISIBLE);
            }
        });

        hideButton.setOnClickListener(view -> {
            for (TextView textView : textViews) {
                textView.setVisibility(View.INVISIBLE);
            }
        });

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setSelectedItemId(R.id.home);

        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                return true;
            } else if (itemId == R.id.calculator) {
                startActivity(new Intent(getApplicationContext(), CalculatorActivity.class));
                finish();
                return true;
            }
            return false;
        });
    }
}