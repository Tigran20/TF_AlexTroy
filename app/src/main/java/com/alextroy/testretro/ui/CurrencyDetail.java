package com.alextroy.testretro.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.alextroy.testretro.R;

public class CurrencyDetail extends AppCompatActivity {

    private Button exchangeBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_detail);

        exchangeBtn = findViewById(R.id.exchange_btn);
        exchangeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
            startActivity(intent);
        });

    }
}
